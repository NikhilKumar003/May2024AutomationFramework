package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtils;

public class RegisterSuccessPage {

	private WebDriver driver;
	private ElementUtils eleUtils;
	
	private By SuccessText = By.tagName("h1");
	
	public RegisterSuccessPage(WebDriver driver) {
		this.driver=driver;
		eleUtils = new ElementUtils(driver);
	}
	public String getRegisterPageTitle() {
		String title = eleUtils.waitforTitleContainsAndReturns(AppConstants.REGISTER_ACCOUNT_SUCCESS_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("Register success page title :"+ title);
		return title;
	}
	public boolean checkSuccessMsg() {
		return eleUtils.isElementDisplayed(SuccessText);
	}
}
