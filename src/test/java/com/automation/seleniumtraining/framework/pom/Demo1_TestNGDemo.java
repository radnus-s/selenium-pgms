package com.automation.seleniumtraining.framework.pom;

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
import org.testng.annotations.Test;

import com.automation.seleniumtraining.utils.Utils;

public class Demo1_TestNGDemo {
	private WebDriver driver;
	private String baseURL="http://newtours.demoaut.com/";
	
	RegisterPage regPage;
    HomePage homePage;
    RegistrationSuccessPage regSuccessPage;

  @BeforeMethod
  public void checkforHomePage() {
	  homePage =new HomePage(driver);
      homePage.verifyTitle();
      
  }
  @AfterMethod
  public void returnToHomePage() {
	  homePage.navigateToHomePage();      	
  }
  @Test(priority=1)
  public void testRegisterLink(){
	  regPage=homePage.navigateToRegisterPage();
	  regPage.verifyTitle();
  }
  @Test(priority=2)
  public void testRegistration(){
	 //regPage= new RegisterPage(driver);
	 homePage.navigateToHomePage().navigateToRegisterPage().verifyTitle();
	 regPage.setUserName("testuser2").setPassword("testpwd2").setConfirmPassword("testpwd2")
	 .createUser().verifyTitle();
	 /*regPage.setUserName("testuser2");
     regPage.setPassword("testpwd2");
     regPage.setConfirmPassword("testpwd2");
     regSuccessPage=regPage.createUser();
     regSuccessPage.verifyTitle();*/
  }
 
  @BeforeTest
  public void openBrowser() {
	  System.out.println("Before Test");
	 driver= Utils.getDriver();
	   driver.get(baseURL);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterTest
  public void closeBrowser() {
	  System.out.println("After Test");
	  driver.quit();
  }

}
