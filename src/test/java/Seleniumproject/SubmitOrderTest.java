package Seleniumproject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Seleniumproject.pageobjects.CartPage;
import Seleniumproject.pageobjects.CheckoutPage;
import Seleniumproject.pageobjects.ConfirmationPage;
import Seleniumproject.pageobjects.Landingpage;
import Seleniumproject.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     String productName= "ZARA COAT 3";
	 WebDriverManager.chromedriver().setup();
	 
	 WebDriver driver = new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.manage().window().maximize();
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	 driver.get("https://rahulshettyacademy.com/client");
	 Landingpage lpage= new Landingpage(driver);
	 lpage.goTo();
	 ProductCatalogue pc = lpage.loginApplication("vinitg@gmail.com", "Vinit@123");
	
	 List<WebElement> products = pc.getProductList();
	 pc.addProductToCart(productName);
	 CartPage cp = pc.goToCartPage();
	 
	 Boolean match = cp.verifyProductDisplay(productName);
	 Assert.assertTrue(match);
	CheckoutPage checkoutp = cp.goToCheckout(); 
	checkoutp.selectCountry("india");
	ConfirmationPage confirmpage= checkoutp.submitOrder();
	String message = confirmpage.getConfirmationMessage();
	Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
	driver.close();
		
		
		
		
	}

}
