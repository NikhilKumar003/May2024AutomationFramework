package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtils;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtils eleUtils;
	
	private HashMap <String, String>  productMap;
	private By productHeader = By.tagName("h1");
	private By productMetaData = By.xpath("(//div[@class='col-sm-4']//ul[@class='list-unstyled'])[1]/li");
	private By productMetaPrice = By.xpath("(//div[@class='col-sm-4']//ul[@class='list-unstyled'])[2]/li");
	private By productImages = By.cssSelector("ul.thumbnails img");

	
	public ProductInfoPage(WebDriver driver) {
		this.driver= driver;
		eleUtils = new ElementUtils(driver);
	}
	
	public String getProductHeader() {
		String productHeaderValue= eleUtils.waitforElementVisible(productHeader, AppConstants.DEFAULT_SHORT_TIME_OUT).getText();
		System.out.println("Product Header ===> "+ productHeaderValue);
		return productHeaderValue;
	}
////	Brand: Apple
//	Product Code: Product 17
//	Reward Points: 700
//	Availability: Out Of Stock
//	$1,202.00
//	Ex Tax: $1,000.00
	private void getProductMetaData() {
		List <WebElement> metaList= eleUtils.getFindElements(productMetaData);
		productMap = new HashMap<String, String>();
		for (WebElement meta : metaList) {
			String metaText = meta.getText();
			String metaData[]= metaText.split(":");
			String metaKey = metaData[0].trim();
			String metaValue = metaData[1].trim();
			productMap.put(metaKey, metaValue);
		  }
		}
	private void getProductMetaPrice() {
		List <WebElement> priceList= eleUtils.getFindElements(productMetaPrice);
			String price = priceList.get(0).getText();
			String exTaxPrice = priceList.get(1).getText().split(":")[1].trim();
			productMap.put("productprice", price);
			productMap.put("extaxprice", exTaxPrice);
		}
	public HashMap<String, String> getProductData() {
		productMap = new  HashMap<String, String>();
//		productMap = new  LinkedHashMap<String, String>();
//		productMap = new  TreeMap<String, String>();
		
			productMap.put("productHeader", getProductHeader());
			getProductMetaData();
			getProductMetaPrice();
			System.out.println(productMap);
			return productMap;
		}
	public int getProductImagesCount() {
		int imagesCount =eleUtils.waitForElementsVisible(productImages, AppConstants.DEFAULT_SHORT_TIME_OUT).size();
		System.out.println("images count ===> "+ imagesCount);
		return imagesCount; 
	}
}
