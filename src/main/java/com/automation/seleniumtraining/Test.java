package com.automation.seleniumtraining;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
public static void main(String args[]) throws Exception{
	WebDriver driver;
	System.setProperty("webdriver.chrome.driver","C:/training/jars/chromedriver.exe");
	
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	// Explicit wait - Will be applied to sepecific elements
	
	WebDriverWait webwait = new WebDriverWait(driver, 30);

	String baseURL = "https://www.yahoo.com/";
	String expSignonTitle = "Yahoo";

	String username = "contactalsr@yahoo.com";

	driver.get(baseURL);
	driver.findElement(By.linkText("Sign in")).click();
	//Thread.sleep(500);
	
	webwait.until(ExpectedConditions.titleContains("login"));
	WebElement userTextBox = driver.findElement(By.id("login-username" ));
	userTextBox.sendKeys(username);

	driver.findElement(By.name("signin")).click();
	
	String actualTitle=driver.getTitle();
	System.out.print(actualTitle);


	if (expSignonTitle.equals(actualTitle)) {
		System.out.println("Tests Passed");
	} else {
		System.out.println("Tests Failed");

	}

}
}
