package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtils;

public class ResultsPage {

	private WebDriver driver;
	private ElementUtils eleUtils;
	
	private By searchHeader = By.cssSelector("div#content h2");
	private By Results = By.cssSelector("div.product-thumb");
	
	public ResultsPage(WebDriver driver) {
		this.driver= driver;
		eleUtils = new ElementUtils(driver);
	}
	public String getSearchHeader() {
		String searchHeaderValue = eleUtils.waitforElementVisible(searchHeader, AppConstants.DEFAULT_SHORT_TIME_OUT).getText();
		return searchHeaderValue;
	}
	public int getSearchResultCount() {
		int searchCount = eleUtils.waitForElementsVisible(Results, AppConstants.DEFAULT_SHORT_TIME_OUT).size();
		return searchCount;
	}
	public ProductInfoPage selectProduct(String ProductName) {
		System.out.println("selecting the product :"+ ProductName);
		eleUtils.doClick(By.linkText(ProductName));
		return new ProductInfoPage(driver);
		}
	}
	

