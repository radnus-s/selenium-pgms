package com.automation.seleniumtraining.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Demo1_Actions {
	public static void main(String[] args) {
		String baseUrl = "http://newtours.demoaut.com/";
		
		// This code does not work with the Selenium 3.1 version/Firfox combination.
		// Geckodriver has recently implemented this and selenium client has to be updated for this
		// It may be fixed in future versions of Selenium
		System.setProperty("webdriver.chrome.driver","C:/training/selenium/chromedriver.exe");
		    WebDriver driver = new ChromeDriver();
	 
		        driver.get(baseUrl);           
		        WebElement link_Home = driver.findElement(By.linkText("Home"));
		         WebElement td_Home = driver
		                .findElement(By
		                .xpath("//html/body/div"
		                + "/table/tbody/tr/td"
		                + "/table/tbody/tr/td"
		                + "/table/tbody/tr/td"
		                + "/table/tbody/tr")); 
		         td_Home=driver
			                .findElement(By
					                .xpath("//table[@border=\"2\"]/tbody/tr[1]"));
		        Actions builder = new Actions(driver);
		        Action mouseOverHome = builder
		                .moveToElement(link_Home)
		                .build();
		     
		        String bgColor = td_Home.getCssValue("background-color");
		        System.out.println("Before hover: " + bgColor);        
		        mouseOverHome.perform();        
		        bgColor = td_Home.getCssValue("background-color");
		        System.out.println("After hover: " + bgColor);
		        //driver.quit();
		}
}
