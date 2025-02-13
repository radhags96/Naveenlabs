package com.qa.opencart.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.opencart.exeception.FrameworkExecption;

public class DriverFactory {
	WebDriver driver;

	public WebDriver initDriver(String browserName) {
		System.out.println("browser name is: " + browserName);
		switch (browserName.trim().toLowerCase()) {
		case "chrome": 
       driver = new ChromeDriver();
       break;
		default:
			System.out.println("plz pass valid browser name is: " + browserName);
			throw new FrameworkExecption("===Invalid browser name===");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		return driver;
}

}