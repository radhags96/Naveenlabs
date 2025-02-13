package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {// we will maintain only xpath and driver instance

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

//1. By Locator: Page objects
	private By emailId = By.id("input-email");//by default all the locators should be private to encapsulate
	private By password = By.id("input-password");
    private By loginBtn = By.xpath("//input[@value='Login']");
    private By forgotPwdLink = By.linkText("Forgotten Password");
    
//2. Public page actions -- methods(features)
    public String getLoginPageTitle() {
    	String title = driver.getTitle();
    	System.out.println("login page title==>" + title);
    	return title;
    }
    public String getLoginPageUrl() {
    	String url = driver.getCurrentUrl();
    	System.out.println("login page title==>" + url);
    	return url;
    }
    public boolean isForgotPwdLinkExists() {
    	return driver.findElement(forgotPwdLink).isDisplayed();
 
    }
    public void doLogin(String userName, String pwd) {
    	System.out.println("App creds are: ==>" + userName + ":"+pwd);
    	driver.findElement(emailId).sendKeys(userName);
    	driver.findElement(password).sendKeys(pwd);
    	driver.findElement(loginBtn).click();
    }
    
}
