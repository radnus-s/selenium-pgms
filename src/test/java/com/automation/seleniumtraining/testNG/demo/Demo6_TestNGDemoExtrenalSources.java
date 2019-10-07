package com.automation.seleniumtraining.testNG.demo;

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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.seleniumtraining.external.source.User;
import com.automation.seleniumtraining.utils.Utils;

public class Demo6_TestNGDemoExtrenalSources {
	private WebDriver driver;
	private String baseURL="http://newtours.demoaut.com/";
	WebDriverWait wt;
	private List<User> userList = new ArrayList<User>();

	public List<User> getUserList() {
		return userList;
	}
  @BeforeMethod
  public void checkforHomePage() {
	  System.out.println("Before Method");
	  String expectedTitle="Welcome";
	  wt.until(ExpectedConditions.titleContains(expectedTitle));
		
	  String actualTitle=driver.getTitle();
	  boolean b=actualTitle.contains(expectedTitle);
	  System.out.println(expectedTitle+"-"+actualTitle);
	 Assert.assertTrue(b);	
  }
  @AfterMethod
  public void returnToHomePage() {
	System.out.println("After Method");
	driver.findElement(By.linkText("Home")).click();	
  }
  
  @Test(dataProvider="CredentialProvider")
  public void testSignon(User u){
	  System.out.println("Test Method");
	  signon(u);
  }
  
  private void signon(User u) {
	  	WebElement userTextBox=driver.findElement(By.name("userName"));
		userTextBox.sendKeys(u.getUser());
		driver.findElement(By.name("password")).sendKeys(u.getPassword());
		driver.findElement(By.name("login")).click();
		wt.until(ExpectedConditions.titleContains(u.getExpectedTitle()));
		String actualTitle=driver.getTitle();
		u.setActualTitle(actualTitle);
		System.out.println(u.getExpectedTitle()+"-"+actualTitle);
		Assert.assertTrue(actualTitle.contains(u.getExpectedTitle()));
}
  @BeforeTest
  public void openBrowser() {
	  System.out.println("Before Test");
	  getUsersfromDB();
	  driver= Utils.getDriver();
	  wt= new WebDriverWait(driver,10);
	  driver.get(baseURL);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterTest
  public void closeBrowser() {
	  System.out.println("After Test");
	  driver.quit();
	  writeResultsToExcel();
  }
  
  
  @DataProvider(name="CredentialProvider")
  public Object[][] getDataFromDataprovider(){
      return convertListToArray(userList);
   }
  
  public static Object[][] convertListToArray(List<User> list){
	  Object[][] darr=new Object[list.size()][];
	  int i=0;
	  for (User u:list){
		  darr[i]=new Object[1];
		  darr[i][0]=u;
		  i++;
	  }
	  
	  return darr;
	  
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

			// Iterate the collection
			int r = 1;
			for (User u : userList) {
				row = sheet1.createRow((short)r);
				row.createCell(0).setCellValue(u.getUser());
				row.createCell(1).setCellValue(u.getPassword());
				row.createCell(2).setCellValue(u.getExpectedTitle());
				row.createCell(3).setCellValue(u.getActualTitle());

				r=r+1;
			}
			wb.write(fileOut);
			wb.close();
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
