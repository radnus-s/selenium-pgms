package com.automation.seleniumtraining.basic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automation.seleniumtraining.utils.Utils;


public class Demo7_AccessTitleWIthConfigurableBrowser {
	private WebDriver driver;
	
	public void setDriver(String browser){
		driver=Utils.getDriver(browser);
	}
	
	public void verifyTitle(){
		String baseURL="https://www.amazon.com/";
		String expectedTitle="Welcome: Mercury Tours";
		driver.get(baseURL);
		String actualTitle=driver.getTitle();
		
		if(expectedTitle.equals(actualTitle)){
			System.out.println("Tests Passed");
		}
		else{
			System.out.println("Tests Failed");
		}
	}
	
	public void closeBrowser(){
		//driver.quit();
	}
	
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the browser that you would like to test:");
		String browser=s.nextLine();
		Demo7_AccessTitleWIthConfigurableBrowser d= new Demo7_AccessTitleWIthConfigurableBrowser();
		d.setDriver(browser);
		d.verifyTitle();
		d.closeBrowser();
		s.close();
	}

}
