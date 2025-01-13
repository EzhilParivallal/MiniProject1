package pages;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class UserHomePage extends ProjectSpecificationMethods {
	public String ProductPrice;
    public UserHomePage(WebDriver driver) {
		this.driver=driver;
	}

	public UserHomePage ValidateLogIn(String userNm) {
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Welcome "+userNm+"']")).isDisplayed());
	    return this;
	}
	public void ValidateDisplay() {
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Home ']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Contact']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='About us']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Cart']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Log out']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Cart']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='CATEGORIES']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Phones']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Laptops']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Monitors']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[@id='nava']//img")).isDisplayed());
	    
	}
	public ProductDetailsPage selectProduct(String productNm,String Category) throws InterruptedException {
		WebElement Cat = null;
		if(Category.equals("Phones")) {
			Cat=driver.findElement(By.xpath("//a[text()='Phones']"));
			Cat.click();
			Thread.sleep(4000);
		}
		else if(Category.equals("Laptops")) {
			Cat=driver.findElement(By.xpath("//a[text()='Laptops']"));
			Cat.click();
			Thread.sleep(4000);
		}
		else if(Category.equals("Monitors")) {
			Cat=driver.findElement(By.xpath("//a[text()='Monitors']"));
			Cat.click();
			Thread.sleep(4000);
		}
		WebElement Product=driver.findElement(By.xpath("//a[normalize-space()='"+productNm+"']"));
		List<WebElement> ProductClass=Cat.findElements(By.xpath("//div[@class='card-block']"));
		int noOfElements=ProductClass.size();
		//System.out.println(noOfElements);
		for(int i=1;i<=noOfElements;i++) {
			WebElement cell = Cat.findElement(By.xpath("(//h4[@class='card-title'])["+i+"]"));
			String cell_val = cell.getText();
			if(cell_val.equals(productNm)) {
				//cell.click();
				WebElement proDiv=ProductClass.get(i-1);
				ProductPrice=proDiv.findElement(By.tagName("h5")).getText();
				Thread.sleep(5000);
				}
	   }
		Product.click();
		Thread.sleep(2000);
		return new ProductDetailsPage(driver, ProductPrice);
	}
	public CartPage cartClick(String productNm) throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Cart']")).click();
		Thread.sleep(4000);
		return new CartPage(driver,productNm);
	}
	public HomePage logoutClick() throws InterruptedException {
		driver.findElement(By.id("logout2")).click();
		Thread.sleep(3000);
		return new HomePage(driver);
	}

}
