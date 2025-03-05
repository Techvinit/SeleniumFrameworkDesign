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

public class ErrorValidations extends BaseTest {

	//WebDriver driver;
	@Test
	public void submitOrder() throws IOException 
	
	  {
		// TODO Auto-generated method stub
     //String productName= "ZARA COAT 3";
    
	 lpage.loginApplication("vinitg@gmail.com", "Vinit@123");
	 Assert.assertEquals("Incorrect email or password.", lpage.getErrorMessage());
	 
	}

}
