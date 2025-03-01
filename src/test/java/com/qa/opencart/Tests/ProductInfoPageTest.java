package com.qa.opencart.Tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class ProductInfoPageTest extends BaseTest {

	@BeforeClass
	public void productInfoSetUp() {
		homePage = loginPage.doLogin("septbatch2024@open.com", "Selenium@12345");
	}
	@DataProvider
	public Object[] [] getProductData() {
		return new Object[] [] {
			{"macbook", "MacBook Pro"},
			{"imac", "iMac"},
			{"samsung","Samsung SyncMaster 941BW"},
		};
	} 
	@Test(dataProvider = "getProductData")
	public void productSearchHeaderTest(String searchKey, String productName) {
		searchResultsPage = homePage.doSearch(searchKey);
		productInfoPage = searchResultsPage.selectProduct(productName);
		String actualProductHeader = productInfoPage.getProductHeader();
		Assert.assertEquals(actualProductHeader, productName);
	}
	
	@DataProvider
	public Object[] [] getProductImageData() {
		return new Object[] [] {
			{"macbook", "MacBook Pro", 4},
			{"macbook", "MacBook Air", 4},
			{"imac", "iMac", 3},
			{"samsung","Samsung SyncMaster 941BW", 1},
			{"samsung","Samsung Galaxy Tab 10.1", 7}
		};
	}
	/*@DataProvider
	public Object[][] getProductImageSheetData() {
		Object productData[][] = ExcelUtil.getTestData(AppConstants.PRODUCT_SHEET_NAME);
		return productData;
	}
	
	@Test(dataProvider = "getProductImageSheetData")
	public void productImagesCountTest(String searchKey, String productName, String expectedImagesCount) {
		searchResultsPage = homePage.doSearch(searchKey);
		productInfoPage = searchResultsPage.selectProduct(productName);
		int actutalProductImagesCount = productInfoPage.getProductImagesCount();
		Assert.assertEquals(actutalProductImagesCount, Integer.parseInt(expectedImagesCount));
	}*/
	
	
	@Test
	public void productInfoTest() {
		searchResultsPage = homePage.doSearch("macbook");
		productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
		
		Map<String, String> productInfoMap = productInfoPage.getProductInfo();
		productInfoMap.forEach((k,v) -> System.out.println(k +":"+v));
		
		SoftAssert softAssert = new SoftAssert();	//this is to execute multiple asserts it's non static method from TestNG	
		softAssert.assertEquals(productInfoMap.get("header"), "MacBook Pro");

		softAssert.assertEquals(productInfoMap.get("Brand"), "Apple");
		softAssert.assertEquals(productInfoMap.get("Availability"), "In Stock");
		softAssert.assertEquals(productInfoMap.get("Product Code"), "Product 18");
		softAssert.assertEquals(productInfoMap.get("Reward Points"), "800");
		
		softAssert.assertEquals(productInfoMap.get("price"), "$2,000.00");
		softAssert.assertEquals(productInfoMap.get("extax"), "$2,000.00");
		
		softAssert.assertAll();
		
	}	

	@AfterClass
	public void logoutTest() {
		homePage.logout();
		System.out.println("you logged out");
	}

}
