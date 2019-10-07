package com.automation.seleniumtraining.popup;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo4_WindowsAndWaits {
	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:/Users/reach/Downloads/chromedriver.exe");
         driver = new ChromeDriver();
	 //implicit wait - wait for an element to be visible - Applicable to all elements in the page
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);	
		
		//Explicit wait - Will be applied to sepecific elements
		WebDriverWait webwait = new WebDriverWait(driver,30);
		String baseURL="http://jsbin.com/ocinaj/1";
		driver.get(baseURL);
		driver.findElement(By.linkText("here")).click();
		//System.out.println(main);
		Set<String> handles;
		// Fluent Wait
		/*Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
				.withTimeout(30, TimeUnit.SECONDS) 			
				.pollingEvery(5, TimeUnit.SECONDS) 			
				.ignoring(NoSuchElementException.class);	
		
		 wait.until(new Function<WebDriver, WebElement>() {							
			public WebElement apply(WebDriver driver) { 
				return driver.findElement(By.xpath(""));					
				}		
			});*/
		
		//webwait.until(ExpectedConditions.numberOfWindowsToBe(2));
		// Special case
		/*while(driver.getWindowHandles().size()==1){
				// check for the number of handles
			
			// sleep for some time.. Try again
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			
		
		}*/
		handles= driver.getWindowHandles();
		
		System.out.println(handles);
		
		System.out.println(handles.size());
		String main=driver.getWindowHandle();
		
		for(String s:handles){
			if(!s.equals(main)){
				driver.switchTo().window(s);
				// This will wait for a certain expected conditions to happen within the webdriver wait period 
				//webwait.until(ExpectedConditions.titleContains("Facebook"));
				String title=driver.getTitle();
				if(title.contains("Facebook")){
					driver.findElement(By.linkText("Create a Page")).click();
					//webwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"facade_text\"]")));
					System.out.println(driver.getTitle());
					
				}
				driver.close();
			}
		}
		driver.switchTo().window(main);
		//driver.quit();
	}

}
