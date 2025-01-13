package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class PurchaseConfirmationPage extends ProjectSpecificationMethods {

	public PurchaseConfirmationPage(WebDriver driver) {
		this.driver=driver;
	}
	public UserHomePage validatePurchase() {
		Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Thank you for your purchase!']")).isDisplayed());
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		return new UserHomePage(driver);
	}

}
