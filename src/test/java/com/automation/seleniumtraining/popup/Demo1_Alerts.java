package com.automation.seleniumtraining.popup;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1_Alerts {
	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:/training/selenium/chromedriver.exe");
		 driver = new ChromeDriver();
	 
		String baseURL="http://jsbin.com/usidix/1";
		driver.get(baseURL);
		driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
		Alert al=driver.switchTo().alert();
		String alertMessage = al.getText();
		//The following will be used if an alert has a text box to collect some value from user
		//driver.switchTo().alert().sendKeys("");
		System.out.println(alertMessage);
        al.accept();
      	//driver.quit();
	}

}
