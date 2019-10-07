package com.automation.seleniumtraining.testNG.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automation.seleniumtraining.utils.Utils;

public class Demo3 {
	private WebDriver driver;
	private String baseURL="https://www.amazon.com/";
	
  @Test(dataProvider="test")
  public void searchProducts(String searchTxt) {
	 Assert.assertTrue(driver.getTitle().contains("Amazon"));
	 driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchTxt);
	 driver.findElement(By.cssSelector("input.nav-input[tabindex=\"20\"]")).click();
	 driver.findElement(By.id("twotabsearchtextbox")).clear();
  }
 
  @BeforeTest
  @Parameters({"browser"})
   public void beforeTest(String browser) {
	  System.out.println("Before Test");
	 driver= Utils.getDriver(browser);
	  driver.get(baseURL);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  
  @DataProvider(name="test")
  public Object[][] getDataFromDataprovider(){
	  return new Object[][] {
		  {"Laptop"},{"Dvd"},{"Mobile"}
	  
	  };
	  }
  }


