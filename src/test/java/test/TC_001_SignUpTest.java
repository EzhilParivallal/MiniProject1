package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_001_SignUpTest extends ProjectSpecificationMethods{
	@BeforeTest
	public void setup() throws IOException {
		sheetName ="SignUpTestData";
		testName="SignUpTest";
		testDescription="Testing Sign up functionality";
		testAuthor="Ezhil Parivallal";
		testCategory="Smoke Testing";
	}
	@Test(dataProvider = "excelRead")
	public void SignUpTest(String userNm, String password, String testCase, String errorMessage) throws InterruptedException{
		// TODO Auto-generated method stub
		
		HomePage obj = new HomePage(driver);
		obj.signUpClick()
		.UserName(userNm)
		.Password(password)
		.SignUpButton()
		.ValidateSignUp(testCase,errorMessage);
	}


}

