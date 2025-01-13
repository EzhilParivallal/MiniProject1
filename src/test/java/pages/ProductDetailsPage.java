package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class ProductDetailsPage extends ProjectSpecificationMethods {

	public String ProductPrice,AlertText;
	public ProductDetailsPage(WebDriver driver,String ProductPrice) {
		this.driver=driver;
		this.ProductPrice=ProductPrice;
	}
	public ProductDetailsPage validateProductDetails() {
		Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='"+ProductPrice+"']")).isDisplayed());
		return this;
	}
	public ProductDetailsPage addToCartClick() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		AlertText = alert.getText();
		//System.out.println(AlertText);
		alert.accept();	
		return this;
	}
	public ProductDetailsPage validateAddToCart(String testCase,String errorMessage) {
		Assert.assertTrue(AlertText.equals(errorMessage));
		return this;
	}
	public CartPage goToCart() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Cart']")).click();
		Thread.sleep(4000);
		return new CartPage(driver,ProductPrice);
	}
	

}
