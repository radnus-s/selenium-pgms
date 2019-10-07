package com.automation.seleniumtraining.basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Demo4_AccessFormElement_Xpath {
	
	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:/training/selenium/chromedriver.exe");
		  driver= new ChromeDriver();
			
		String baseURL="file://C:/training/selenium/seleniumtraining/src/test/resources/test_xpath.html";
		driver.get(baseURL);	
		WebElement elt=driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
		System.out.println(elt.getText());
		List<WebElement> list=driver.findElements(By.xpath("//table/tbody/tr[2]/td"));
		for (WebElement element:list){
			System.out.println(element.getText());
			
		}
			
		//driver.quit();
	}

}
