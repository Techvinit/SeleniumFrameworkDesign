package Seleniumproject.tests;

import java.io.IOException;
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
import org.testng.annotations.Test;

import Seleniumproject.TestComponents.BaseTest;
import Seleniumproject.pageobjects.CartPage;
import Seleniumproject.pageobjects.CheckoutPage;
import Seleniumproject.pageobjects.ConfirmationPage;
import Seleniumproject.pageobjects.Landingpage;
import Seleniumproject.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {

	//WebDriver driver;
	@Test
	public void submitOrder() throws IOException 
	
	  {
		// TODO Auto-generated method stub
     String productName= "ZARA COAT 3";
     Landingpage lpage = launchApplication();
	
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
	//driver.close();
			
	}

}
