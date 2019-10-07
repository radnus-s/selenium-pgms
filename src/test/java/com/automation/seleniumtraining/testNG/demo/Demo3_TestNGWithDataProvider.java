package com.automation.seleniumtraining.testNG.demo;

import java.util.concurrent.TimeUnit;

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

import com.automation.seleniumtraining.utils.Utils;

public class Demo3_TestNGWithDataProvider {
	private WebDriver driver;
	private String baseURL="http://newtours.demoaut.com/";
	WebDriverWait wt;
	
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
  @Test( dataProvider="CredentialProvider")
  public void testSignon(String userName, String passwd,String expectedTitle){
	  System.out.println("Test Method");
	  signon(userName, passwd, expectedTitle);
  }

 
  private void signon(String userName, String passwd, String expectedTitle) {
	  	WebElement userTextBox=driver.findElement(By.name("userName"));
		userTextBox.sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(passwd);
		driver.findElement(By.name("login")).click();
		wt.until(ExpectedConditions.titleContains(expectedTitle));
		String actualTitle=driver.getTitle();
		System.out.println(expectedTitle+"-"+actualTitle);
		Assert.assertTrue(actualTitle.contains(expectedTitle));
}
  @BeforeTest
  public void openBrowser() {
	  System.out.println("Before Test");
	  driver= Utils.getDriver();
	  wt= new WebDriverWait(driver,10);
	  driver.get(baseURL);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterTest
  public void closeBrowser() {
	  System.out.println("After Test");
	  driver.quit();
  }
  
 @DataProvider(name="CredentialProvider")
 public Object[][] getDataFromDataprovider(){

      return new Object[][] {
         { "Invalid_Id", "Invalid_Pwd","Sign-on:"},
         { "tutorial", "tutorial","Flight" }
       };

  }
}
