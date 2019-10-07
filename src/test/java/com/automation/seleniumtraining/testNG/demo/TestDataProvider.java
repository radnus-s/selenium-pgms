package com.automation.seleniumtraining.testNG.demo;

import org.testng.ITestNGMethod;
import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	@DataProvider(name="CredentialsProvider")
	 public static Object[][] getDataFromDataprovider(ITestNGMethod m){
		Object[][] arr=null;
		for(String group:m.getGroups()){
		 if(group.equalsIgnoreCase("A")){
	      arr= new Object[][] {
	         { "Invalid_Id", "Invalid_Pwd","Sign-on:"},
	         { "tutorial", "tutorial","Flight" }
	       };
	       break;
		 }
		 else if(group.equalsIgnoreCase("B")){
			 arr= new Object[][] {
		         { "testUser1", "testUser1","testUser1"}
		         //,{ "testUser2", "testUser2","testUser2" }
		       };
		       break;
		 }
		}
		return arr;

	  }

}
