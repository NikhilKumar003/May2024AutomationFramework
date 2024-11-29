package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.RegisterSuccessPage;
import com.qa.opencart.pages.ResultsPage;

public class BaseTest {
		WebDriver driver;
		DriverFactory df;
		protected Properties prop;
		protected LoginPage loginPage;
	protected AccountsPage accPage;
	protected RegisterPage regPage;
	protected RegisterSuccessPage successPage;
	protected ResultsPage resultsPage;
	protected ProductInfoPage productInfoPage;
	protected SoftAssert softAssert;
	
	@Parameters({"browser"})
	@BeforeTest
	public void setup(@Optional("chrome") String browserName) {
		df= new DriverFactory();
		prop= df.initProp();
		
//		check if browser parameter coming from testng xml file
		if(browserName!=null) {
			prop.setProperty("browser", browserName);
		}
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);//due to this driver constructor will be happy
		softAssert = new SoftAssert();
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
