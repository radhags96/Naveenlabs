package com.qa.opencart.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.constants.AppError;

public class LoginPageTest extends BaseTest {

	@Test
	public void loginPageTitleTest() {
	 String actTitle =	loginPage.getLoginPageTitle();
	 Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE , AppError.TITLE_NOT_FOUND_ERROR);
	}
	
	@Test
	public void loginPageURLTest() {
	 String actURL = loginPage.getLoginPageUrl();
	 Assert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION), AppError.URL_NOT_FOUND_ERROR);
	}
	
	@Test //to run code
	public void forgotPasswordExists() {
	Assert.assertTrue(loginPage.isForgotPwdLinkExists(),AppError.ELEMENT_NOT_FOUND_ERROR);
	}
	
	@Test(priority=Integer.MAX_VALUE)//always set to 1
	public void loginTest() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(homePage.getHomePageTitle(), AppConstants.HOME_PAGE_TITLE,AppError.TITLE_NOT_FOUND_ERROR);
	}
	
	
}
