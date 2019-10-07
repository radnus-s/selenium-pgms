package com.automation.seleniumtraining;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.seleniumtraining.User;

public class DemoExternalSource {
	private List<User> userList= new ArrayList<User>();
	private WebDriver driver;
	private String baseURL = "http://newtours.demoaut.com/";
	WebDriverWait wt;
	
	public static void main(String[] args) {
		DemoExternalSource d= new DemoExternalSource();
		
		//get the data from database
		d.getUsersFromDB();
		// with the data got from Db , access the demouat page and supply the values
		d.openBrowser();
		for (User u:d.userList){
			d.checkforHomePage();
			//User u= new User("invalid","invalid","Sign-on:");
			System.out.println("Before:"+u);
			d.signon(u);
			System.out.println("After:"+u);
			d.returnToHomePage();
		}
		d.closeBrowser();
		//get the actual title and write all the info to excel sheet
		d.writeResultsToExcel();
	}
	
	private void getUsersFromDB(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root", "admin");
			PreparedStatement st = con.prepareStatement("Select login,password,expectedTitle from users");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String login = rs.getString("login");
				String password = rs.getString("password");
				String title = rs.getString("expectedTitle");
				/*User u= new User();
				u.setExpectedTitle(title);
				u.setPassword(password);
				u.setLogin(login);*/
				
				User u = new User(login, password,title);
				userList.add(u);
			}
			System.out.println("Users from DB:"+userList);
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	public void checkforHomePage() {
		System.out.println("Before Method");
		String expectedTitle = "Welcome";
		wt.until(ExpectedConditions.titleContains(expectedTitle));

		String actualTitle = driver.getTitle();
		boolean b = actualTitle.contains(expectedTitle);
		System.out.println(expectedTitle + "-" + actualTitle);
		// Assert.assertTrue(b);
	}

	public void returnToHomePage() {
		System.out.println("After Method");
		driver.findElement(By.linkText("Home")).click();
	}

	private void signon(User u) {
		WebElement userTextBox = driver.findElement(By.name("userName"));
		userTextBox.sendKeys(u.getLogin());
		//userTextBox.sendKeys("invalid");
		driver.findElement(By.name("password")).sendKeys(u.getPassword());
		//driver.findElement(By.name("password")).sendKeys("invalid");
		driver.findElement(By.name("login")).click();
		wt.until(ExpectedConditions.titleContains(u.getExpectedTitle()));
		//wt.until(ExpectedConditions.titleContains("Sign-on:"));
		String actualTitle = driver.getTitle();
		u.setActualTitle(actualTitle);
		if(actualTitle.contains(u.getExpectedTitle())){
			u.setResult("Pass");
		}
		System.out.println(u.getExpectedTitle() + "-" + actualTitle);
		// Assert.assertTrue(actualTitle.contains(expectedTitle));
	}

	public void openBrowser() {
		System.out.println("Before Test");
		System.setProperty("webdriver.chrome.driver","C:/Sundar/sundar/selenium/drivers/chromedriver.exe");
        driver = new ChromeDriver();
	 	wt = new WebDriverWait(driver, 15);
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void closeBrowser() {
		System.out.println("After Test");
		driver.quit();
	}
	public void writeResultsToExcel() {
		try {

			Workbook wb = new XSSFWorkbook();// new HSSFWorkbook();
			FileOutputStream fileOut = new FileOutputStream("sample.xlsx");
			Sheet sheet1 = wb.createSheet("Details");
			
			Row row = sheet1.createRow((short) 0);
			row.createCell(0).setCellValue("Login");
			row.createCell(1).setCellValue("Password");
			row.createCell(2).setCellValue("Expected Title");
			row.createCell(3).setCellValue("Actual Title");
			row.createCell(4).setCellValue("Result");
			// Iterate the collection
			short r = 1;
			for (User u : userList) {
				row = sheet1.createRow(r);
				row.createCell(0).setCellValue(u.getLogin());
				row.createCell(1).setCellValue(u.getPassword());
				row.createCell(2).setCellValue(u.getExpectedTitle());
				row.createCell(3).setCellValue(u.getActualTitle());
				row.createCell(4).setCellValue(u.getResult());
				r=(short)(r+1);
			}
			wb.write(fileOut);
			wb.close();
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
