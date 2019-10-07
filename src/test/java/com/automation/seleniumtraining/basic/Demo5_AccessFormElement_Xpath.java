package com.automation.seleniumtraining.basic;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Demo5_AccessFormElement_Xpath {
	
	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:/Users/reach/Downloads/chromedriver.exe");
		driver= new ChromeDriver();
		
		String baseURL="http://newtours.demoaut.com/";
		driver.get(baseURL);		
		String s= driver.findElement(By.xpath("//table[@width=\"270\"]/tbody/tr[1]/td[1]/font")).getText();
		System.out.println(s);
		//driver.quit();
		
	}

}
