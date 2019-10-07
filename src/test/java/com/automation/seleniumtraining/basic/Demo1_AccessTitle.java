package com.automation.seleniumtraining.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

// Class to demonstrate how to get a title of a given web page
public class Demo1_AccessTitle {
	
	public static void main(String[] args) {
		WebDriver driver;
		// For firefox versions 47 and above we have to use Selenium 3.* jars
		// Selenium 3.* jars does not have a Firefox driver implementation by default
		// So we have to use gecko driver. Below statement is used to tell where to look out for gecko driver
		System.setProperty("webdriver.chrome.driver","C:/training/jars/chromedriver.exe");
	     driver= new ChromeDriver(); 
	     String baseURL="http://newtours.demoaut.com/";
		String expectedTitle="Welcome: Mercury Tours";
		driver.get(baseURL);
		String actualTitle=driver.getTitle();
		
		if(expectedTitle.equals(actualTitle)){
			System.out.println("Tests Passed");
		}
		else{
			System.out.println("Tests Failed");
		}
		driver.quit();
	}

}
