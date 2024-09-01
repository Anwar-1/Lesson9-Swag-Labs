package lesson9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCase {

	WebDriver driver = new ChromeDriver();
	String URL = "https://www.saucedemo.com/";
	String UserName = "standard_user";
	String Password = "secret_sauce";
	
	
	
	@BeforeTest
	public void mySetup() {
		driver.get(URL);
		driver.manage().window().maximize();
	}
	
	
	@Test(priority = 1)
	public void myLoginTest() {
		WebElement inputName = driver.findElement(By.id("user-name"));
		inputName.sendKeys(UserName);
		
		WebElement inputPass = driver.findElement(By.id("password"));
		inputPass.sendKeys(Password);
		
		WebElement Button = driver.findElement(By.id("login-button"));
		Button.click();
	}
	
	@Test(priority = 2,enabled = false)
	public void myAddItem() {
		List <WebElement> myitem = 	driver.findElements(By.className("btn"));
		for(int i =0;i<myitem.size();i++) {
			myitem.get(i).click();
		}
	}
	
	@Test(priority = 3,enabled = false)
	public void addOneAndSkipTheNextOne() {
		List <WebElement> myitem = 	driver.findElements(By.className("btn"));
		for(int i =0;i<myitem.size();i=i+2) {
			myitem.get(i).click();
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void SkipAndAddOneTheNext() {
		List <WebElement> myitem = 	driver.findElements(By.className("btn"));
		for(int i =1;i<myitem.size();i=i+2) {
			myitem.get(i).click();
		}
	}
	
	@Test(priority = 5,enabled = false)
	public void AddOneFoureAndSkipThem() {
		List <WebElement> myitem = 	driver.findElements(By.className("btn"));
		for(int i =0;i<myitem.size();i++) {
			myitem.get(i).click();
			
			if(i==3) {
				break;
			}
		}
	}
	
	
	@Test(priority = 6,enabled = false)
	public void AddAllItemAndSkipTheThree() {
		List <WebElement> myitem = 	driver.findElements(By.className("btn"));
		for(int i =0;i<myitem.size();i++) {
			
			
			if(i==2) {
				continue;
			}
			
			myitem.get(i).click();
		}
	}
	
	@Test(priority = 7,enabled = false)
	public void AddAllItemContainsLabs() {
		List <WebElement> myitemname = 	driver.findElements(By.className("inventory_item_name"));
		List <WebElement> myitem = 	driver.findElements(By.className("btn"));
		
		for(int i =0;i< myitemname.size();i++) {
			
		String myname = myitemname.get(i).getText();
		
		if(myname.contains("Labs")) {
			myitem.get(i).click();
		}
		
		}
	}
	
	@Test(priority = 8,enabled = false)
	public void AddAllItemContainsnotLabs() {
		List <WebElement> myitemname = 	driver.findElements(By.className("inventory_item_name"));
		List <WebElement> myitem = 	driver.findElements(By.className("btn"));
		
		for(int i =0;i< myitemname.size();i++) {
			
		String myname = myitemname.get(i).getText();
		
		if(myname.contains("Labs")) {
			continue;
			//break; not add the item 
		}
		
		myitem.get(i).click();
		
		}
	}
	
	@Test(priority = 9)
	public void addItemPriceAbove15() {
		List <WebElement> price = driver.findElements(By.className("inventory_item_price"));
		List <WebElement> myitem = 	driver.findElements(By.className("btn"));
		
		for(int i = 0; i<price.size();i++) {
			
		String priceAsString = 	price.get(i).getText().replace("$", "");
		
		double priceAsDouble = Double.parseDouble(priceAsString);
		
		if(priceAsDouble>15) {
			myitem.get(i).click();
		}
		
		}
	}
}
