package com.automation.seleniumtraining.external.source;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo5_DBExcelOperation {
	private WebDriver driver;
	private String baseURL = "http://newtours.demoaut.com/";
	WebDriverWait wt;
	private List<User> userList = new ArrayList<User>();

	public List<User> getUserList() {
		return userList;
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
		userTextBox.sendKeys(u.getUser());
		driver.findElement(By.name("password")).sendKeys(u.getPassword());
		driver.findElement(By.name("login")).click();
		wt.until(ExpectedConditions.titleContains(u.getExpectedTitle()));
		String actualTitle = driver.getTitle();
		u.setActualTitle(actualTitle);
		System.out.println(u.getExpectedTitle() + "-" + actualTitle);
		// Assert.assertTrue(actualTitle.contains(expectedTitle));
	}

	public void openBrowser() {
		System.out.println("Before Test");
		System.setProperty("webdriver.chrome.driver","C:/Users/reach/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
	 	wt = new WebDriverWait(driver, 15);
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	public void closeBrowser() {
		System.out.println("After Test");
		driver.quit();
	}

	public void getUsersfromDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root", "admin");
			PreparedStatement st = con.prepareStatement("Select login,password,expectedTitle from users");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String user = rs.getString("login");
				String password = rs.getString("password");
				String title = rs.getString("expectedTitle");				
				User u = new User(user, password,title);
				userList.add(u);
			}
			System.out.println("Users from DB:"+userList);
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
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
				row.createCell(0).setCellValue(u.getUser());
				row.createCell(1).setCellValue(u.getPassword());
				row.createCell(2).setCellValue(u.getExpectedTitle());
				row.createCell(3).setCellValue(u.getActualTitle());
				String res="FAIL";
				if(u.getActualTitle().contains(u.getExpectedTitle())){
					res="PASS";
				}
				row.createCell(4).setCellValue(res);
				
				r=(short)(r+1);
			}
			wb.write(fileOut);
			wb.close();
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		Demo5_DBExcelOperation d = new Demo5_DBExcelOperation();
		d.getUsersfromDB();
		d.openBrowser();
		for(User u:d.getUserList()){
			d.checkforHomePage();
			d.signon(u);				
			d.returnToHomePage();			
		}
		d.closeBrowser();
		d.writeResultsToExcel();
	}

}
