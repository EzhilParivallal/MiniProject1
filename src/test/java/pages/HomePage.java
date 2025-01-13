package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class HomePage extends ProjectSpecificationMethods {
	//@FindBy(xpath="//a[text()='Sign up']")
	//WebElement signUp;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		//PageFactory.initElements(driver, this);
	}
	public SignUpPage signUpClick() {
		driver.findElement(By.xpath("//a[text()='Sign up']")).click();
		return new SignUpPage(driver);
	}
	public LogInPage logInClick() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		Thread.sleep(3000);
		return new LogInPage(driver);
	}
	public void validateLogOut() throws InterruptedException {
		// TODO Auto-generated method stub
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Log in']")).isDisplayed());
	}

	
}
