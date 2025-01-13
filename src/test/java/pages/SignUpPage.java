package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class SignUpPage extends ProjectSpecificationMethods{
	public String AlertText;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
	}
	public SignUpPage UserName(String userNm) {
		if(userNm.isBlank()==false) {
		driver.findElement(By.id("sign-username")).sendKeys(userNm);
		}
		return this;
	}
	public SignUpPage Password(String pass) {
		if(pass.isBlank()==false) {
		driver.findElement(By.id("sign-password")).sendKeys(pass);
		}
		return this;
	}
	public SignUpPage SignUpButton() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Sign up']")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		AlertText = alert.getText();
		System.out.println(AlertText);
		alert.accept();	
		return this;
		
	}
	public void ValidateSignUp(String testCase, String errorMessage) {
		Assert.assertTrue(AlertText.equals(errorMessage));
	}
}
