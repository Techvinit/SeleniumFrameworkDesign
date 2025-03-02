package Seleniumproject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Seleniumproject.AbstractComponets.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(xpath="//div[@class='cartSection']//h3")
	List <WebElement> productTitles;
	
	public CartPage(WebDriver driver) {
		
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public Boolean verifyProductDisplay(String productName){
		
	Boolean match = productTitles.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(productName));
	return match;
	}
	
	public CheckoutPage goToCheckout(){
		checkoutEle.click();
		return new CheckoutPage(driver);
	}

}
