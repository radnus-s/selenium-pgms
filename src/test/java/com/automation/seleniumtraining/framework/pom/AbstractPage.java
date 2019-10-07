package com.automation.seleniumtraining.framework.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

// All common functions
public class AbstractPage {


    protected WebDriver driver;

    AbstractPage(WebDriver driver){
        this.driver=driver;
    }

    public WebDriver getDriver(){
        return driver;
    }

    public HomePage navigateToHomePage(){
        driver.get("http://newtours.demoaut.com");
        return new HomePage(driver);
    }
    public RegisterPage navigateToRegisterPage(){
        driver.findElement(By.linkText("REGISTER")).click();
        return new RegisterPage(driver);
    }
    public WebElement fluentWait(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return  foo; };
}
