package Seleniumproject.TestComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Seleniumproject.pageobjects.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	
	public WebDriver driver;
	public Landingpage lpage;
	
	public WebDriver initializeDriver() throws IOException {
		
		  Properties prop = new Properties();
		  FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Seleniumproject//resources//GlobalData.properties");
		  prop.load(fis);
		  String browserName = prop.getProperty("browser");
		  
		  if(browserName.equalsIgnoreCase("chrome")) {
		
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
		  }
		  else if(browserName.equalsIgnoreCase("firefox")) {
			  
			  //firefox
		  }
		  
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().window().maximize();
		 return driver;
		  
	}
	
	@BeforeMethod
	public Landingpage launchApplication() throws IOException {
		
		driver = initializeDriver();
	    lpage= new Landingpage(driver);
		lpage.goTo();
		return lpage;
		
	}
	@AfterMethod
	public void teardown() {
		
		driver.close();
	}
	
}
