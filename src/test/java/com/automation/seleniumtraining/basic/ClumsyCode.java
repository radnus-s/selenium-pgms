package com.automation.seleniumtraining.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ClumsyCode {
	
	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:/Users/reach/Downloads/chromedriver.exe");
	          driver= new ChromeDriver();
	     String baseURL="http://newtours.demoaut.com/";
	     driver.get(baseURL);
	     
	     String expectedTitle="Welcome: Mercury Tours";
			String actualTitle=driver.getTitle();
			if(expectedTitle.equals(actualTitle)){
				System.out.println("Home Title matches");
			}
			else{
				System.out.println("Home Title does not match");
				
			}
			
			
			WebElement userTextBox=driver.findElement(By.name("userName"));
			userTextBox.sendKeys("invalid");
			
			driver.findElement(By.name("password")).sendKeys("invalid");
		
			driver.findElement(By.name("login")).click();
			
			 actualTitle=driver.getTitle();
			 
			 expectedTitle="Sign-on";
			 
			if(actualTitle.contains(expectedTitle)){
				System.out.println("Tests Passed");
			}
			else{
				System.out.println("Tests Failed");
					
			}
			
			 userTextBox=driver.findElement(By.name("userName"));
			userTextBox.sendKeys("tutorial");
			
			driver.findElement(By.name("password")).sendKeys("tutorial");
		
			driver.findElement(By.name("login")).click();
			
			 actualTitle=driver.getTitle();
			 
			 expectedTitle="Flight";
			 
			if(actualTitle.contains(expectedTitle)){
				System.out.println("Tests Passed");
			}
			else{
				System.out.println("Tests Failed");
					
			}
			
			driver.quit();
				
	}

	

}
