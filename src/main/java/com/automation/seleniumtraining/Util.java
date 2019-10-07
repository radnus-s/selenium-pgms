package com.automation.seleniumtraining;

public class Util {

	public static int factorial(int n){
		int fact = n;
		n = n - 1;
		while (n > 0) {

			fact = fact * n;
			n = n - 1;
		}
		return fact;

	}

	public static boolean isPrime(int n){
		boolean prime=true;
		for(int i=2;i<n;i++){
			if(n%i==0){
				System.out.println(i);
				prime=false;
				break;
			}
			
		}
		return prime;	
	}
	
	public static int reverse(int n){
		int sum=0;
		while(n>0){
			int rem=n%10;
			sum=sum*10+rem;
			n=n/10;
		}
		return sum;
		
	}
	
}
