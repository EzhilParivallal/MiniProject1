package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class LogInPage extends ProjectSpecificationMethods{
    public String AlertText;
	public LogInPage(WebDriver driver) {
		this.driver=driver;
	}
	public LogInPage UserName(String userNm) {
		if(userNm.isBlank()==false) {
		driver.findElement(By.id("loginusername")).sendKeys(userNm);
		}
		return this;
	}
	public LogInPage Password(String pass) {
		if(pass.isBlank()==false) {
		driver.findElement(By.id("loginpassword")).sendKeys(pass);
		}
		return this;
	}
	public UserHomePage LogInButton(String testCase,String errorMessage) throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Thread.sleep(2000);
		if(testCase.equals("negative_login")) {
		Alert alert = driver.switchTo().alert();
		AlertText = alert.getText();
		System.out.println(AlertText);
		alert.accept();	
		Assert.assertEquals(AlertText, errorMessage);
		}
		return new UserHomePage(driver);
		
	}
	


}
