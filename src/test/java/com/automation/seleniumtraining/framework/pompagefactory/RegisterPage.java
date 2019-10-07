package com.automation.seleniumtraining.framework.pompagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegisterPage extends AbstractPage {
	//driver.findElement(By.id("email"))
	@FindBy(id="email")
	WebElement userNameTextBox;
	
	@FindBy(name="password")
	WebElement passwordTextBox;
	
	
	@FindBy(name="confirmPassword")
	WebElement confirmPasswordTextBox;
	
	@FindBy(name="register")
	WebElement registerButton;
	
	
    public RegisterPage(WebDriver driver){
        super(driver);
    }
    public RegisterPage verifyTitle(){
        fluentWait(By.name("firstName"));
        String title=driver.getTitle();
        Assert.assertEquals("Register: Mercury Tours",title);
        return this;
    }
    public RegisterPage setUserName(String userName){
    	userNameTextBox.sendKeys(userName);
        return this;
    }

    public RegisterPage setPassword(String password){
    	passwordTextBox.sendKeys(password);
        return this;
    }

    public RegisterPage setConfirmPassword(String password){
    	confirmPasswordTextBox.sendKeys(password);
        return this;
    }

    public RegistrationSuccessPage createUser(){
    	registerButton.click();
        return new RegistrationSuccessPage(driver);
    }
}
