package com.automation.seleniumtraining.testNG.basic;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.seleniumtraining.Util;


public class TestNgDemo {
	
	@Test(priority=1)
	public void testPrime(){
		Assert.assertEquals(Util.isPrime(10), false);
	}
	
	@Test(priority=2)
	public void testFactorial(){
		Assert.assertEquals(Util.factorial(4), 24);
	}

}
