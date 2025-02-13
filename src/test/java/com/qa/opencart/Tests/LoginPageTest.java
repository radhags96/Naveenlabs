package com.qa.opencart.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest {

	@Test
	public void loginPageTitleTest() {
	 String actTitle =	loginPage.getLoginPageTitle();
	 Assert.assertEquals(actTitle, "Account Login" , "==Title is not matched==");
	}
	
	@Test
	public void loginPageURLTest() {
	 String actURL = loginPage.getLoginPageUrl();
	 Assert.assertTrue(actURL.contains("naveenautomationlabs.com/open"),"==Incorrect URL==");
	}
	
	@Test
	public void forgotPasswordExists() {
	Assert.assertTrue(loginPage.isForgotPwdLinkExists(),"==Forgot password link not present");
	}
	@Test(priority=1)
	public void loginTest() {
		loginPage.doLogin("septbatch2024@open.com", "Selenium@12345");
	}
	
	
}
