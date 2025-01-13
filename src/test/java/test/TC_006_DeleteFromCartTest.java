package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_006_DeleteFromCartTest extends ProjectSpecificationMethods {
	@BeforeTest
	public void setup() throws IOException {
		readFromPropFile("LoginTestData");
		testName="DeleteFromCartTest";
		testDescription="Testing Delete From Cart functionality";
		testAuthor="Ezhil Parivallal";
		testCategory="Smoke Testing";
	}
	@Test
	public void DeleteFromCartTest() throws InterruptedException{
		// TODO Auto-generated method stub
		
		HomePage obj = new HomePage(driver);
		String testCase="positive";
		String errorMessage="";
		obj.logInClick()
		.UserName(prop.getProperty("userNm"))
		.Password(prop.getProperty("password"))
		.LogInButton(testCase,errorMessage)
		.ValidateLogIn(prop.getProperty("userNm"))
		.cartClick(prop.getProperty("productNm"))
		.deleteProduct(prop.getProperty("productNm"))
		.validateDelete(prop.getProperty("productNm"));
		
	}


}
