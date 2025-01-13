package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class PurchasePage extends ProjectSpecificationMethods{
    public String AlertText;
	public PurchasePage(WebDriver driver) {
		this.driver=driver;
	}
	public PurchasePage name(String name) {
		if(name.isBlank()==false) {
		driver.findElement(By.id("name")).sendKeys(name);
		}
		return this;
	}
	public PurchasePage country(String country) {
		if(country.isBlank()==false) {
		driver.findElement(By.id("country")).sendKeys(country);
		}
		return this;
	}
	public PurchasePage city(String city) {
		if(city.isBlank()==false) {
		driver.findElement(By.id("city")).sendKeys(city);
		}
		return this;
	}
	public PurchasePage creditCard(String card) {
		if(card.isBlank()==false) {
		driver.findElement(By.id("card")).sendKeys(card);
		}
		return this;
	}
	public PurchasePage expMonth(String month) {
		if(month.isBlank()==false) {
		driver.findElement(By.id("month")).sendKeys(month);
		}
		return this;
	}
	public PurchasePage expYear(String year) {
		if(year.isBlank()==false) {
		driver.findElement(By.id("year")).sendKeys(year);
		}
		return this;
	}
	public PurchaseConfirmationPage purchaseClick(String testCase,String errorMessage) {
		driver.findElement(By.xpath("//button[text()='Purchase']")).click();
	    if(testCase.equals("negative")) {
	    	Alert alert = driver.switchTo().alert();
			AlertText = alert.getText();
			//System.out.println(AlertText);
			alert.accept();	
	    	Assert.assertEquals(errorMessage,AlertText);
	    }
		return new PurchaseConfirmationPage(driver);
	}
	
	

}
