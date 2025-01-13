package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_002_LogInTest extends ProjectSpecificationMethods {
	@BeforeTest
	public void setup() throws IOException {
		sheetName ="LogInTestData";
		testName="LogInTest";
		testDescription="Testing Log In functionality";
		testAuthor="Ezhil Parivallal";
		testCategory="Smoke Testing";
	}
	@Test(dataProvider = "excelRead")
	public void LogInTest(String userNm, String password, String testCase, String errorMessage) throws InterruptedException{
		// TODO Auto-generated method stub
		
		HomePage obj = new HomePage(driver);
		if(testCase.equals("positive")) {
		obj.logInClick()
		.UserName(userNm)
		.Password(password)
		.LogInButton(testCase,errorMessage)
		.ValidateLogIn(userNm);
		}
		else {
			obj.logInClick()
			.UserName(userNm)
			.Password(password)
			.LogInButton(testCase,errorMessage);	
		}
	}


}
