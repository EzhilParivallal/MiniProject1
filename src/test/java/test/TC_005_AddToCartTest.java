package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_005_AddToCartTest extends ProjectSpecificationMethods {
	@BeforeTest
	public void setup() throws IOException {
		readFromPropFile("LoginTestData");
		sheetName ="AddToCartTestData";
		testName="AddToCartTest";
		testDescription="Testing Add to Cart functionality";
		testAuthor="Ezhil Parivallal";
		testCategory="Smoke Testing";
	}
	@Test(dataProvider = "excelRead")
	public void AddToCartTest(String productNm,String Category,String testCase,String errorMessage) throws InterruptedException{
		// TODO Auto-generated method stub
		
		HomePage obj = new HomePage(driver);
		obj.logInClick()
		.UserName(prop.getProperty("userNm"))
		.Password(prop.getProperty("password"))
		.LogInButton(testCase,errorMessage)
		.ValidateLogIn(prop.getProperty("userNm"))
		.selectProduct(productNm, Category)
		.validateProductDetails()
		.addToCartClick()
		.validateAddToCart(testCase,errorMessage)
		.goToCart()
		.validateCart(productNm);
		
	}

}
