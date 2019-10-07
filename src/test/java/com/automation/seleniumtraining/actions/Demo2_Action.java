package com.automation.seleniumtraining.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Demo2_Action {
	public static void main(String[] args) {
		String baseUrl = "https://www.facebook.com/";
		System.setProperty("webdriver.chrome.driver","C:/training/selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(baseUrl);
		WebElement txtBox = driver.findElement(By.name("email"));

		Actions actions = new Actions(driver);
		
		actions.keyDown(txtBox,Keys.SHIFT);
		actions.sendKeys(txtBox,"hello");
		actions.keyUp(txtBox,Keys.SHIFT);
		actions.doubleClick(txtBox);
		actions.contextClick();
		Action action=actions.build();
		action.perform();
		
		//Action sendKeyAction = actions.keyDown(txtBox, Keys.SHIFT).sendKeys(txtBox, "hello").keyUp(Keys.SHIFT)
			//	.doubleClick(txtBox).contextClick().build();

		//sendKeyAction.perform();
		// driver.close();

	}
}
