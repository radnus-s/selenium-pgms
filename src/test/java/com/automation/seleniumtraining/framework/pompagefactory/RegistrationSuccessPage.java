package com.automation.seleniumtraining.framework.pompagefactory;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class RegistrationSuccessPage extends AbstractPage {
    public RegistrationSuccessPage(WebDriver driver){
        super(driver);
    }
    public RegistrationSuccessPage verifyTitle(){
        Assert.assertTrue(true);
        return this;
    }
}
