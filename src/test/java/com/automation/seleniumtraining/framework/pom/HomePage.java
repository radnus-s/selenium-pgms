package com.automation.seleniumtraining.framework.pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends AbstractPage{
    public HomePage(WebDriver driver){
        super(driver);
    }
    public HomePage verifyTitle(){
        Assert.assertEquals("Welcome: Mercury Tours",driver.getTitle());
        return this;
    }
   

}
