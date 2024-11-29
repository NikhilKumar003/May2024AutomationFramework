package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtils;

public class LoginPage {
	private WebDriver driver;
	private ElementUtils eleUtils;
	
	//1.By locators this r also page objects
	 private By username = By.id("input-email");
	 private By password = By.id("input-password");
	 private By loginBtn = By.xpath("//input[@value='Login']");
	 private By forgotPwdLink = By.linkText("Forgotten Password");
	 private By logoImg = By.cssSelector("img.img-responsive");
	 private By registerBtn = By.linkText("Register");
	//2. public page constructors
	 
	public LoginPage(WebDriver driver) {
	this.driver= driver;	
	eleUtils = new ElementUtils(driver);
	}
	//3. public page actions / methods
	
	public String getPageTitle() {
		String title = eleUtils.waitforTitleContainsAndReturns(AppConstants.LOGIN_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("login page title :"+ title);
		return title;
	}
	public String getPageURL() {
		String url= eleUtils.waitforURLContainsAndReturns(AppConstants.LOGIN_PAGE_FRACTION_URL, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("login page title :"+ url);
		return url;
	}
	public boolean isForgotPwdLinkExist() {
		return eleUtils.isElementDisplayed(forgotPwdLink);
		}
	public boolean isLogoExist() {
		return eleUtils.isElementDisplayed(logoImg);
	}
	public RegisterPage doRegister() {
		eleUtils.doClick(registerBtn);
		
		return new RegisterPage(driver);
	}
	
	public AccountsPage doLogin(String userName, String passWord) {
		System.out.println("creds are  :"+ username + " : " + password);
		eleUtils.waitforElementVisible(username, AppConstants.DEFAULT_SHORT_TIME_OUT).sendKeys(userName);
		eleUtils.doSendKeys(password, passWord);
		eleUtils.doClick(loginBtn);
		
		return new AccountsPage(driver);
	}
	
	
}
