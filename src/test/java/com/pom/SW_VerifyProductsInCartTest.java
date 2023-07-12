package com.pom;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SW_VerifyProductsInCartTest extends BaseTest {

	@Test
	public void ProductCheckOut() {

		// LoginPage
		LoginPage login = new LoginPage(driver);
		login.login("standard_user", "secret_sauce");
		Assert.assertEquals(login.getproductsPageHeading(), "Products");
		System.out.println("Login successfull!!!");

		// ProductsPage
		ProductsPage product = new ProductsPage(driver);
		product.addToCart();
		product.clickCartButton();

		// YourCartPage
		YourCartPage cart = new YourCartPage(driver);
		Assert.assertTrue(cart.checkProduct1Displayed());
		Assert.assertTrue(cart.checkProduct2Displayed());
		Assert.assertEquals(cart.getProduct1Name(), product.getProduct1Name());
		Assert.assertEquals(cart.getProduct2Name(), product.getProduct2Name());
		System.out.println("Products added to cart in product page and products in the cart page are same");
	}

}
