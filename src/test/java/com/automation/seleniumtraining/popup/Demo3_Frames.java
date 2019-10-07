package com.automation.seleniumtraining.popup;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo3_Frames {
	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:/training/selenium/chromedriver.exe");
		   driver = new ChromeDriver();
	 
		String baseURL="http://toolsqa.com/iframe-practice-page/";
		driver.get(baseURL);
		driver.switchTo().frame("IF1");
		driver.findElement(By.linkText("HOME")).click();
		//driver.switchTo().frame(1);
		
		//driver.quit();
	}

}
