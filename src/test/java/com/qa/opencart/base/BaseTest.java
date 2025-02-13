package com.qa.opencart.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {// driver should

	protected WebDriver driver;
	protected DriverFactory df;
	protected LoginPage loginPage;
	protected HomePage homePage;

	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		driver = df.initDriver("chrome");
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
