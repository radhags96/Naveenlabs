package com.qa.opencart.Tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.constants.AppError;
import com.qa.opencart.pages.ProductInfoPage;

public class HomePageTest extends BaseTest{
	@BeforeTest
	public void homePageSetUp() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void homePageTitleTest() {
		Assert.assertEquals(homePage.getHomePageTitle(), AppConstants.HOME_PAGE_TITLE,AppError.TITLE_NOT_FOUND_ERROR);
	}
	
	@Test
	public void homePageURLTest() {
		Assert.assertTrue(homePage.getHomePageUrl().contains(AppConstants.HOME_PAGE_URL_FRACTION), AppError.URL_NOT_FOUND_ERROR);
	}
	@Test
	public void logoutLinkExistTest() {
		Assert.assertTrue(homePage.isLogoutLinkExist(),AppError.ELEMENT_NOT_FOUND_ERROR);  
    }
	@Test
	public void headerTest() {
	List<String> actHeaders =	homePage.getHeadersList();
	System.out.println("home page headers: ==>"+ actHeaders);
	}
	
	@DataProvider
	public Object[] [] getSearchData() {
		return new Object[] [] {
			{"macbook", 3},
			{"imac", 1},
			{"samsung", 2},
			{"canon", 1},
			{"airtel", 0}
		};
	}
	
	@Test(dataProvider = "getSearchData")
	public void searchTest(String searchKey, int resultCount) {
	 searchResultsPage = homePage.doSearch(searchKey);
	Assert.assertEquals(searchResultsPage.getProductResultsCount(), resultCount); 		
	}	
	
}
