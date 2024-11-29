package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtils;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtils eleUtils;
	
	private By logoutLink = By.linkText("Logout");
	private By headers = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	
	
	public AccountsPage(WebDriver driver) {
		this.driver =driver;
		eleUtils = new ElementUtils(driver);
		}
	
	public String getAccPageTitle() {
		String title = eleUtils.waitforTitleContainsAndReturns(AppConstants.ACCOUNTS_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("Account page title :"+ title);
		return title;
		
		
	}
	public boolean logoutLink() {
		return  eleUtils.isElementDisplayed(logoutLink);
	}
	
	public int getTotalAccountsPageHeader() {
		return eleUtils.waitForElementsVisible(headers, AppConstants.DEFAULT_SHORT_TIME_OUT).size();
	}
	
	
	public List<String> getHeadersList() {
		List<WebElement> HeadersList= eleUtils.waitForElementsVisible(headers, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
		List<String> HeadersValueList= new ArrayList<String>();
		for (WebElement e: HeadersList) {
			String header= e.getText();
			HeadersValueList.add(header);
			}
		return HeadersValueList;
	}

	public ResultsPage doSearch(String searchKey) {
		System.out.println("Search key ==> "+ searchKey);
		WebElement searchElement = eleUtils.waitforElementVisible(search, AppConstants.DEFAULT_SHORT_TIME_OUT);
		eleUtils.doSendKeysWithClear(searchElement, searchKey);
		eleUtils.doClick(searchIcon);
			
		return new ResultsPage(driver);
	}
	
}
