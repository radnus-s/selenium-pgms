package com.automation.seleniumtraining.external.source;

public class User {
	private String user;
	private String password;
	private String expectedTitle;
	private String actualTitle;
	public String getUser() {
		return user;
	}
	public String getPassword() {
		return password;
	}
	public String getExpectedTitle() {
		return expectedTitle;
	}
	public String getActualTitle() {
		return actualTitle;
	}
	public void setActualTitle(String actualTitle) {
		this.actualTitle = actualTitle;
	}
	public User(String user, String password, String expectedTitle) {
		super();
		this.user = user;
		this.password = password;
		this.expectedTitle = expectedTitle;
	}
	@Override
	public String toString() {
		return "User [user=" + user + ", password=" + password + ", expectedTitle=" + expectedTitle + ", actualTitle="
				+ actualTitle + "]";
	}
	

}
