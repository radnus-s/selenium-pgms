package com.automation.seleniumtraining.utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class Utils {
	public static void takeScreenShot(WebDriver driver, String filePath) {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File f= ts.getScreenshotAs(OutputType.FILE);
		
		try {
		 // now copy the  screenshot to desired location using copyFile method
		FileUtils.copyFile(f, new File(filePath));
		}
		 
		catch (IOException e)
		 {
		  System.out.println(e.getMessage());
		 
		 }
	}
		// Fluent Wait
	 public static WebElement fluentWait(final WebDriver driver, final By locator) {
	        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	                .withTimeout(20, TimeUnit.SECONDS)
	                .pollingEvery(5, TimeUnit.SECONDS)
	                .ignoring(NoSuchElementException.class);

	        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
	            public WebElement apply(WebDriver driver) {
	                return driver.findElement(locator);
	            }
	        });

	        return  foo; 
	  }
	 
	 public static WebDriver getDriver(String browser){
		 WebDriver driver=null;
		 if(browser.equals("chrome")){
		   System.setProperty("webdriver.chrome.driver","C:/Users/reach/Downloads/chromedriver.exe");
		   driver= new ChromeDriver();
		 }
		 else  if(browser.equals("firefox")){
		   System.setProperty("webdriver.gecko.driver", "C:\\Sundar\\soft\\lib\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		   driver= new FirefoxDriver();
			  
		 }
		 else{
				throw new IllegalArgumentException(browser +" not supported");
			}
		 return driver;
	 }
	 public static WebDriver getDriver(){
		return  getDriver("chrome");
	 }	
}
