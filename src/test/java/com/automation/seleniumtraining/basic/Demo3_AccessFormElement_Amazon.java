package com.automation.seleniumtraining.basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo3_AccessFormElement_Amazon {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\training\\selenium\\Jars\\chromedriver.exe");
		driver= new ChromeDriver(); 
	    String searchText="Laptop";
		String baseURL="https://www.amazon.com/";
		driver.get(baseURL);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchText);
		driver.findElement(By.cssSelector("input.nav-input")).click();
		List<WebElement> laptopList=driver.findElements(By.cssSelector("h2[class=\"a-size-medium s-inline  s-access-title  a-text-normal\"]"));
		for(WebElement h2:laptopList){
			String s=h2.getText();
			//System.out.println(s);
			int pos=s.indexOf(",");
			if(pos>=0){
				s=s.substring(0, pos);
			}
			System.out.println(s);
		}

		//driver.quit();
	}

}
