package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest {
	
	
	@Test
	public void loginPageTitleTest() {
		String actTitle= loginPage.getPageTitle();
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE);// constants
	}

	@Test
	public void loginPageURLTest() {
		String actUrl= loginPage.getPageURL();
		Assert.assertTrue(actUrl.contains(AppConstants.LOGIN_PAGE_FRACTION_URL));
	}
	@Test
	public void forgotPasswordLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	@Test
	public void LogoExistTest() {
		Assert.assertTrue(loginPage.isLogoExist());
	}
	@Test(priority=Integer.MAX_VALUE)
	public void loginTest() {
		accPage= loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accPage.getAccPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE);
	}
}
