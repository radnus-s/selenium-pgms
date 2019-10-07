package com.automation.seleniumtraining.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo8_Navigation {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:/training/selenium/chromedriver.exe");		
		driver = new ChromeDriver();
		
		//WebDriver driver=Utils.getDriver("chrome");
		
		String baseURL = "https://www.facebook.com/";
		driver.get(baseURL);
		
		//maximize window
		driver.manage().window().maximize();
		
		
		System.out.println("Title First Page: "+driver.getTitle());
		
		driver.findElement(By.linkText("Create Page")).click();
		//driver.navigate().to("https://www.facebook.com/pages/create/?ref_type=registration_form");
		
		System.out.println("Title After Navigation: "+driver.getTitle());
		
		driver.navigate().back();
		
		
		/*try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		// The following title may show the previous title.. Hint : use waits
		System.out.println("Title after pressing back button: "+driver.getTitle());
		
		
		//driver.quit();
	}

}
