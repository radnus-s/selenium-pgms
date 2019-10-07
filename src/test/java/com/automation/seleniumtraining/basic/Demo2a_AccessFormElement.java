package com.automation.seleniumtraining.basic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo2a_AccessFormElement {

	public static void main(String[] args) throws Exception {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\training\\selenium\\Jars\\chromedriver.exe");
		   driver= new ChromeDriver();
	
		String baseURL = "http://newtours.demoaut.com/mercuryregister.php";
		
		driver.get(baseURL);
		WebElement we= driver.findElement(By.name("country"));
		Select dropDown = new Select(we);
		//dropDown.selectByVisibleText("ANTARCTICA");
		//dropDown.selectByIndex(4);
		// the following will choose from <option value="">
        dropDown.selectByValue("14");
    
		
        WebElement option=dropDown.getFirstSelectedOption();
        System.out.println(option.getText());
        
        List<WebElement> list=dropDown.getOptions();
       
        List<String> retrievedList=new ArrayList<String>();
        for (WebElement opt:list){
        	retrievedList.add(opt.getText());
        }
        System.out.println(retrievedList);
        
        //Fetch the values from DB
        List<String> databaseList=getDatabaseValues();
        
        for(String country:databaseList){
        	if(!retrievedList.contains(country)){
        		throw new Exception(country+" Country in Database is not availabel in Browser");
            	
        	}
        }
       // boolean contains=retrievedList.containsAll(myList);
        //System.out.println(contains);*/
        
       		//driver.quit();
	}

	//TODO: the implemenation should get the database
	private static List<String> getDatabaseValues(){
		List<String> dbValues=new ArrayList<String>();
        dbValues.add(" INDIA");
        dbValues.add(" PAKISTAN");
        return dbValues;
	}
}
