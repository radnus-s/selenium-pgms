package com.automation.seleniumtraining;

public class User {
	private String login;
	private String password;
	private String expectedTitle;
	private String actualTitle;
	private String result="Fail";
	
	public User() {
		super();
	}
	public User(String login, String password, String expectedTitle) {
		super();
		this.login = login;
		this.password = password;
		this.expectedTitle = expectedTitle;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getExpectedTitle() {
		return expectedTitle;
	}
	public void setExpectedTitle(String expectedTitle) {
		this.expectedTitle = expectedTitle;
	}
	public String getActualTitle() {
		return actualTitle;
	}
	public void setActualTitle(String actualTitle) {
		this.actualTitle = actualTitle;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", expectedTitle=" + expectedTitle + ", actualTitle="
				+ actualTitle + ", result=" + result + "]";
	}
	
	
}
