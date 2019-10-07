package com.automation.seleniumtraining.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automation.seleniumtraining.utils.Utils;


public class Demo6_AccessFormElement_CodeReorganization {
	private WebDriver driver;
	private String baseURL="http://newtours.demoaut.com/";
	
	public void openBrowser(){
		driver=Utils.getDriver();
		driver.get(baseURL);
	}
	public void goHomePage(){
		driver.findElement(By.linkText("Home")).click();
	}
	
	public void testHomePage(){
		String expectedTitle="Welcome: Mercury Tours";
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)){
			System.out.println("Home Title matches");
		}
		else{
			System.out.println("Home Title does not match");
		
		}
		
	}
	
	public void testSignOn(String userName,String passwd, String expectedTitle){
		WebElement userTextBox=driver.findElement(By.name("userName"));
		userTextBox.sendKeys(userName);
		
		driver.findElement(By.name("password")).sendKeys(passwd);
	
		driver.findElement(By.name("login")).click();
		
		String actualTitle=driver.getTitle();
		if(actualTitle.contains(expectedTitle)){
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
		Demo6_AccessFormElement_CodeReorganization t= new Demo6_AccessFormElement_CodeReorganization();
		t.openBrowser();  //beforeTest
		
		t.testHomePage();//beforeMethod
		t.testSignOn("invalid", "invalid", "Sign-on: Mercury Tours");
		t.goHomePage();//afterMethod
		
		t.testHomePage();
		t.testSignOn("tutorial", "tutorial", "Flight");
		t.goHomePage();
		
		t.closeBrowser();//afterTest
	}

	

}
