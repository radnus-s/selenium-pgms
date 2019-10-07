package com.automation.seleniumtraining.popup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo5 {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:/Users/reach/Downloads/chromedriver.exe");
         driver = new ChromeDriver();
         driver.get("https://finance.yahoo.com/quote/EOS-USD?p=EOS-USD");
         String cssSelector="Fz(s) M(0) P(0) Tt(u) Bd(0)  C($c-fuji-blue-1-a) Fw(b)";
     	

	}

}
