package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.util.ElementUtil;

public class LoginPage {// we will maintain only xpath and driver instance

	private WebDriver driver;
	private ElementUtil eleUtil;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

//1. By Locator: Page objects
	private By emailId = By.id("input-email");//by default all the locators should be private to encapsulate
	private By password = By.id("input-password");
    private By loginBtn = By.xpath("//input[@value='Login']");
    private By forgotPwdLink = By.linkText("Forgotten Password");
    
//2. Public page actions -- methods(features)
    public String getLoginPageTitle() {
    	String title = eleUtil.waitForTitleContains(AppConstants.LOGIN_PAGE_TITLE, AppConstants.DEFAULT_TIME_OUT);
    	System.out.println("login page title==>" + title);
    	return title;
    }
    public String getLoginPageUrl() {
    	String url = eleUtil.waitForURLContains(AppConstants.LOGIN_PAGE_URL_FRACTION, AppConstants.DEFAULT_TIME_OUT);
    	System.out.println("login page url==>" + url);
    	return url;
    }
    public boolean isForgotPwdLinkExists() {
    	return eleUtil.doIsElementDisplayed(forgotPwdLink); 
    }
    public HomePage doLogin(String userName, String pwd) {
    	System.out.println("App creds are: ==>" + userName + ":"+pwd);
    	eleUtil.waitForElementVisible(emailId, AppConstants.SHORT_TIME_OUT).sendKeys(userName);
    	eleUtil.doSendKeys(password, pwd);
    	eleUtil.doClick(loginBtn);
    	return new HomePage(driver);
    }
    
}
