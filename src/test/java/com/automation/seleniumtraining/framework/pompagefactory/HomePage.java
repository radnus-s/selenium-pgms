package com.automation.seleniumtraining.framework.pompagefactory;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends AbstractPage{
	
	@FindBy(linkText="REGISTER")
	WebElement registerLink;
	
    public HomePage(WebDriver driver){
        super(driver);
    }
    public HomePage verifyTitle(){
        Assert.assertEquals("Welcome: Mercury Tours",driver.getTitle());
        return this;
    }
    public RegisterPage navigateToRegisterPage(){
        registerLink.click();
        return new RegisterPage(driver);
    }

}
