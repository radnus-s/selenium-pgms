package com.automation.seleniumtraining.popup;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo2_Confirmation {
	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:/Sundar/sundar/selenium/drivers/chromedriver.exe");
        driver = new ChromeDriver();
	 
		String baseURL="http://jsbin.com/enifaf/1";
		driver.get(baseURL);
		driver.findElement(By.cssSelector("button")).click();
		Alert al=driver.switchTo().alert();
		System.out.println(al.getText());
		//al.accept();
        al.dismiss();
        System.out.println(driver.findElement(By.id("chosenButton")).getText());
		//driver.quit();
	}

}
