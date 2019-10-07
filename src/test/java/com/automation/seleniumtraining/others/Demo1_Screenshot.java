package com.automation.seleniumtraining.others;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automation.seleniumtraining.utils.Utils;

public class Demo1_Screenshot {
	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:/training/selenium/chromedriver.exe");
		    driver= new ChromeDriver();
		
		String baseURL="http://www.facebook.com/";
		String expectedTitle="Welcome: Mercury Tour";
		driver.get(baseURL);
		String actualTitle=driver.getTitle();
		
		if(expectedTitle.equals(actualTitle)){
			System.out.println("Tests Passed");
		}
		else{
			System.out.println("Tests Failed");
			Utils.takeScreenShot(driver,"C:/training/selenium/error.png");
		
		}
		driver.quit();
	}

	
}
