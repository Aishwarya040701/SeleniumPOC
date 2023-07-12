package com.pom;

import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SW_VerifyDifferentSortingTest extends BaseTest {

	@Test
	public void VerifySorting() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// LoginPage
		LoginPage login = new LoginPage(driver);
		login.login("standard_user", "secret_sauce");
		Assert.assertEquals(login.getproductsPageHeading(), "Products");
		System.out.println("Login successfull!!!");

		// products page
		ProductsPage product = new ProductsPage(driver);

		product.sortProductsByValue("za");
		Assert.assertEquals(product.getSortedProduct(), "Test.allTheThings() T-Shirt (Red)");
		System.out.println("Sorting z to a successfull!!");

		product.sortProductsByValue("lohi");
		Assert.assertEquals(product.getSortedProduct(), "Sauce Labs Onesie");
		System.out.println("Sorting low to high price successfull!!");

		product.sortProductsByValue("hilo");
		Assert.assertEquals(product.getSortedProduct(), "Sauce Labs Fleece Jacket");
		System.out.println("Sorting high to low price successfull!!");

		product.sortProductsByValue("az");
		Assert.assertEquals(product.getSortedProduct(), "Sauce Labs Backpack");
		System.out.println("Sorting a to z successfull!!");

	}

}
