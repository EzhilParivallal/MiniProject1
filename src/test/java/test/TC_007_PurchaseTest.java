package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_007_PurchaseTest extends ProjectSpecificationMethods{
	@BeforeTest
	public void setup() throws IOException {
		readFromPropFile("LoginTestData");
		sheetName ="PurchaseTestData";
		testName="PurchaseTest";
		testDescription="Testing Place order functionality";
		testAuthor="Ezhil Parivallal";
		testCategory="Smoke Testing";
	}
	@Test(dataProvider = "excelRead")
	public void AddToCartTest(String name,String country,String city,String card,String month,String year,String testCase,String errorMessage) throws InterruptedException{
		// TODO Auto-generated method stub
		
		HomePage obj = new HomePage(driver);
		if(testCase.equals("positive")) {
		obj.logInClick()
		.UserName(prop.getProperty("userNm"))
		.Password(prop.getProperty("password"))
		.LogInButton(testCase,errorMessage)
		.ValidateLogIn(prop.getProperty("userNm"))
		.selectProduct(prop.getProperty("productNm"), prop.getProperty("category"))
		.addToCartClick()
		.goToCart()
		.placeOrderClick()
		.name(name)
		.country(country)
		.city(city)
		.creditCard(card)
		.expMonth(month)
		.expYear(year)
		.purchaseClick(testCase,errorMessage)
		.validatePurchase();}
		else {
			obj.logInClick()
			.UserName(prop.getProperty("userNm"))
			.Password(prop.getProperty("password"))
			.LogInButton(testCase,errorMessage)
			.ValidateLogIn(prop.getProperty("userNm"))
			.selectProduct(prop.getProperty("productNm"), prop.getProperty("category"))
			.addToCartClick()
			.goToCart()
			.placeOrderClick()
			.name(name)
			.country(country)
			.city(city)
			.creditCard(card)
			.expMonth(month)
			.expYear(year)
			.purchaseClick(testCase,errorMessage);
		}
		
	}
}
