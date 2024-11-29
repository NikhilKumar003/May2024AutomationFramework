package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtils;

public class RegisterPage  {

	private WebDriver driver;
	private ElementUtils eleUtils;
	
	private By firstName = By.xpath("//input[@id='input-firstname']");
	private By lastName = By.xpath("//input[@id='input-lastname']");
	private By email = By.xpath("//input[@id='input-email']");
	private By telephone= By.xpath("//input[@id='input-telephone']");
	private By password = By.xpath("//input[@id='input-password']");
	private By confirmPassword = By.xpath("//input[@id='input-confirm']");
	private By loginBtn = By.linkText("Login");
	private By confirmCheckBox = By.xpath("//input[@name='agree']");
	private By continueBtn = By.xpath("//input[@value='Continue']");
	
	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input[@type='radio']");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input[@type='radio']");
	
	private By SuccessText = By.tagName("h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	
	
	public RegisterPage(WebDriver driver) {
		this.driver= driver;
		eleUtils = new ElementUtils(driver);
	}
	
	public String getRegisterPageTitle() {
		String title = eleUtils.waitforTitleContainsAndReturns(AppConstants.REGISTER_ACCOUNT_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("Account page title :"+ title);
		return title;
	}
	public boolean loginLink() {
		return  eleUtils.isElementDisplayed(loginBtn);
	}
	public boolean CreateAccountDetails(String fName, String lName, String mail, 
			String mobile, String passCode, String confirmCode, String Subscribe) {
		eleUtils.waitforElementVisible(firstName, AppConstants.DEFAULT_SHORT_TIME_OUT).sendKeys(fName);
		eleUtils.doSendKeys(lastName, lName);
		eleUtils.doSendKeys(email, mail);
		eleUtils.doSendKeys(telephone, mobile);
		eleUtils.doSendKeys(password, passCode);
		eleUtils.doSendKeys(confirmPassword, confirmCode);
	
		if(Subscribe.equalsIgnoreCase("yes")) {
			eleUtils.doActionsClick(subscribeYes);
			}else  {
			eleUtils.doActionsClick(subscribeNo);
		}
		eleUtils.waitForElementAndClick(confirmCheckBox, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
		eleUtils.doClick(continueBtn);
			String successMesg =eleUtils.waitforElementVisible(SuccessText, AppConstants.DEFAULT_SHORT_TIME_OUT).getText();
			
			if(successMesg.contains(AppConstants.REGISTER_ACCOUNT_SUCCESS_PAGE_TITLE)) {
				eleUtils.doActionsClick(logoutLink);
				eleUtils.doActionsClick(registerLink);
				return true;
			}else {
				return false;
			}
		
//		return new RegisterSuccessPage(driver);// need to add new success page 
		}
}
