package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//1. maintain by locator
	private By logoutLink = By.linkText("Logout");
	private By headers = By.cssSelector("div#content > h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");

	//2. maintain public page methods
	 public String getHomePageTitle() {
	    	String title = driver.getTitle();
	    	System.out.println("login page title==>" + title);
	    	return title;
	    }
	    public String getHomePageUrl() {
	    	String url = driver.getCurrentUrl();
	    	System.out.println("login page title==>" + url);
	    	return url;
	    }
	    public boolean isLogoutLinkEsist() {
	    	return driver.findElement(logoutLink).isDisplayed();
	    }
	    public void logout() {
	    	if(isLogoutLinkEsist()) {
	    		driver.findElement(logoutLink).click();
	    	}
	    }
	    
	    public List<String> getHeadersList() {
	    List<WebElement> headersList = driver.findElements(headers);
	    List<String> headersValList = new ArrayList<String>();
	    for(WebElement e : headersList) {
	    	String text = e.getText();
	    	headersValList.add(text);
	    }
	    return headersValList;
	    }
	    
	    public void doSearch(String searchKey) {
	    	System.out.println("search key: "+searchKey);
	    	driver.findElement(search).sendKeys(searchKey);
	    	driver.findElement(searchIcon).click();	    	
	    }
}
