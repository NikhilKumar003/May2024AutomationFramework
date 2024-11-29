package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
			
	}
	@Test
	public void accPageTitleTest() {
		String actTitle= accPage.getAccPageTitle();
		Assert.assertEquals(actTitle, AppConstants.ACCOUNTS_PAGE_TITLE);// constants
	}
	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accPage.logoutLink());
	}
	@Test
	public void accPageHeaderCountTest() {
		Assert.assertEquals(accPage.getTotalAccountsPageHeader(), AppConstants.ACCOUNT_PAGE_HEADERS_COUNT);
	}
	
	@Test
	public void accPageHeaderTest() {
		List<String> actheaderList =	accPage.getHeadersList();
		Assert.assertEquals(actheaderList, AppConstants.EXPECTED_ACC_PAGE_HEADERS_LIST);
	}
	@DataProvider
	public Object[][] getSearchKey() {
		return new Object[][] {
			{"macbook",3},
			{"imac",1},
			{"samsung", 2}
		};
	}
	
	@Test(dataProvider = "getSearchKey")
	public void searchCountTest(String searchKey, int searchCount) {
		resultsPage= accPage.doSearch(searchKey);
		Assert.assertEquals(resultsPage.getSearchResultCount(), searchCount);
	}
	@DataProvider
	public Object[][] getSearchData() {
		return new Object[][] {
			{"macbook","MacBook"},
			{"macbook","MacBook Pro"},
			{"imac","iMac"},
			{"samsung", "Samsung SyncMaster 941BW"},
			{"samsung", "Samsung Galaxy Tab 10.1"}
		};
	}
	
	@Test(dataProvider = "getSearchData")
	public void searchTest(String searchKey, String productName) {
		resultsPage= accPage.doSearch(searchKey);
		productInfoPage= resultsPage.selectProduct(productName);
		Assert.assertEquals(productInfoPage.getProductHeader(), productName);
	}
	
}

