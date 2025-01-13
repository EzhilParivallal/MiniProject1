package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class CartPage extends ProjectSpecificationMethods{

	public String productPrice,ProductPrice;
	public int CartValue,CartValueFinal,expCartValue;
	public WebElement cell;
	//public String ProductPri;
	public CartPage(WebDriver driver, String productPrice) {
		this.driver=driver;
		this.productPrice=productPrice;
	}
    public CartPage validateCart(String ProductNm) throws InterruptedException {
    	WebElement table = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-striped']"));
		List<WebElement> rows = table.findElements(By.xpath("//tr"));
		List<WebElement> cols = table.findElements(By.xpath("//th"));
		int row_size = rows.size();
		int col_size = cols.size();
		String ProductPrice = null,Product = null;
		for(int i=1;i<row_size;i++) {
			WebElement cell = table.findElement(By.xpath("//tr["+i+"]//td[2]"));
			String cell_val = cell.getText();
			if(cell_val.equals(ProductNm)) {
				//cell.click();
				Product=cell_val;
				ProductPrice=table.findElement(By.xpath("//tr["+i+"]//td[3]")).getText();
				Thread.sleep(5000);
				}
	   }
		Assert.assertEquals(Product, ProductNm);
		ProductPrice="$"+ProductPrice;
		Assert.assertEquals(ProductPrice, productPrice);
    	return this;
    }
    public CartPage deleteProduct(String ProductNm) throws InterruptedException {
    	WebElement table = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-striped']"));
		List<WebElement> rows = table.findElements(By.xpath("//tr"));
		List<WebElement> cols = table.findElements(By.xpath("//th"));
		int row_size = rows.size();
		String Product = null;
		String CartTotal=driver.findElement(By.xpath("//h3[@id='totalp']")).getText();
		if(CartTotal.isEmpty()) {
			CartValue=0;
		}else {
		CartValue=Integer.parseInt(CartTotal);
		expCartValue=CartValue;}
		for(int i=1;i<row_size;i++) {
			cell = table.findElement(By.xpath("//tr["+i+"]//td[2]"));
			String cell_val = cell.getText();
			if(cell_val.equals(ProductNm)) {
				//cell.click();
				Product=cell_val;
				ProductPrice=table.findElement(By.xpath("//tr["+i+"]//td[3]")).getText();
				table.findElement(By.xpath("//tr["+i+"]//td[4]//a[text()='Delete']")).click();
				Thread.sleep(5000);
				expCartValue=expCartValue-Integer.parseInt(ProductPrice);
				}
	   }
		String CartTotalFinal=driver.findElement(By.xpath("//h3[@id='totalp']")).getText();
		if(CartTotalFinal.isEmpty()) {
			CartValueFinal=0;
		}else {
		CartValueFinal=Integer.parseInt(CartTotalFinal);}
		return this;
    }
    public CartPage validateDelete(String ProductNm) {
    	Assert.assertEquals(CartValueFinal,expCartValue);
    	return this;
    }
    public PurchasePage placeOrderClick() throws InterruptedException {
    	driver.findElement(By.xpath("//button[text()='Place Order']")).click();
    	Thread.sleep(2000);
    	return new PurchasePage(driver);
    }
}
