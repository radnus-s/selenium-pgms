package com.automation.seleniumtraining.testNG.basic;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 extends BaseTest {
/*	@BeforeMethod
	  public void btest1() {
		  System.out.println("Before test method 1");
	  }*/
	@Test
  public void test1_1() {
	  System.out.println("class test1-test method 1");
  }
  @Test
  public void test1_2() {
	  System.out.println("class test1-test method 2");
  }
}
