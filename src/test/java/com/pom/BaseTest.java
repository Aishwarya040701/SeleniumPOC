package com.pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.data.ReadPropertiesFile;

public class BaseTest {
	WebDriver driver;
	ReadPropertiesFile read;
	LoginPage login;
	ProductsPage product;
	YourCartPage cart;
	YourInformationPage information;
	OverviewPage overview;

	@BeforeMethod
	public WebDriver setUp() {
		read = new ReadPropertiesFile();
		System.setProperty("webdriver.chrome.driver", read.getProperties("driverLocation"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(read.getProperties("sauceUrl"));
		
		Assert.assertEquals(driver.getCurrentUrl(), read.getProperties("sauceUrl"));
		Assert.assertEquals(driver.getTitle(), "Swag Labs");

		DriverManager manager = new DriverManager(driver);
		login = manager.getLoginPage();
		product = manager.getProductPage();
		cart = manager.getYourCartPage();
		information = manager.getOurInformationPage();
		overview = manager.getOverviewPage();
		return driver;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
