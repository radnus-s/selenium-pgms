package com.automation.seleniumtraining.external.source;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automation.seleniumtraining.utils.Utils;

public class Signon {
	WebDriver driver;

	public void openBrowser() {
		driver = Utils.getDriver();
	}

	public void accessHomePage() {
		driver.get("http://newtours.demoaut.com/");
	}
	
	public void gotoHomePage() {
		driver.findElement(By.linkText("Home")).click();
	}

	public boolean verifyTitle() {
		String expectedTitle = "Welcome: Mercury Tours";
		return driver.getTitle().equals(expectedTitle);

	}

	public String signOn(String userName, String password, String expectedTitle) {
		WebElement userNameTxtBox = driver.findElement(By.name("userName"));
		userNameTxtBox.sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		return driver.getTitle();
	}

	public void closeBrowser() {
		driver.close();
	}

	private void process() {
		// open browser
		openBrowser();
		// access the home page
		accessHomePage();
		// verify the title
		if(verifyTitle()){
			// signon with invaid data
			signOn("test1","test","Sign-on:");
			gotoHomePage();
			// sigon with valid data
			signOn("tutorial","tutorial","Flight");
		}
		// close the browser
		closeBrowser();
	}

	public static void main(String[] args) {
		Signon d = new Signon();
		d.process();

	}

}
