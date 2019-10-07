package com.automation.seleniumtraining.framework.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterPage extends AbstractPage {
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
        driver.findElement(By.id("email")).sendKeys(userName);
        return this;
    }

    public RegisterPage setPassword(String password){
        driver.findElement(By.name("password")).sendKeys(password);
        return this;
    }

    public RegisterPage setConfirmPassword(String password){
        driver.findElement(By.name("confirmPassword")).sendKeys(password);
        return this;
    }

    public RegistrationSuccessPage createUser(){
        driver.findElement(By.name("register")).click();
        return new RegistrationSuccessPage(driver);
    }
}
