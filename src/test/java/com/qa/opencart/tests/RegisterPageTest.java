package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class RegisterPageTest extends BaseTest {

	@BeforeClass
	public void registerSetup() {
		regPage= loginPage.doRegister();
	}
	@Test
	public void accPageTitleTest() {
		String actTitle= regPage.getRegisterPageTitle();
		Assert.assertEquals(actTitle, AppConstants.REGISTER_ACCOUNT_PAGE_TITLE);// constants
	}
	@Test
	public void isLoginLinkExistTest() {
		Assert.assertTrue(regPage.loginLink());
	}
	public String getRandomEmailTd() {
		return "uiAutomation"+System.currentTimeMillis()+"@open.com";
	}
	
	@Test(priority=Integer.MAX_VALUE)
	public void CreateAccountDetailsTest() {
		Assert.assertTrue(regPage.CreateAccountDetails("nikhil", "Test", getRandomEmailTd(), "7844965400", "qwerty@1234", "qwerty@1234", "yes"));

	}
}
