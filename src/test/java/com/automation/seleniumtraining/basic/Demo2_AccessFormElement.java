package com.automation.seleniumtraining.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo2_AccessFormElement {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\training\\selenium\\Jars\\chromedriver.exe");
		   driver= new ChromeDriver(); 
	    
		String baseURL = "http://newtours.demoaut.com/";
		String userName = "some";
		String passwd = "some";
		String expSignonTitle = "Sign-on: Mercury Tours";

		driver.get(baseURL);

		WebElement userTextBox = driver.findElement(By.name("userName"));
		userTextBox.sendKeys(userName);

		driver.findElement(By.name("password")).sendKeys(passwd);

		driver.findElement(By.name("login")).click();

		String actualTitle = driver.getTitle();

		if (expSignonTitle.equals(actualTitle)) {
			System.out.println("Tests Passed");
		} else {
			System.out.println("Tests Failed");

		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}
