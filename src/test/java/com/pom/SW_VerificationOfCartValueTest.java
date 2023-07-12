package com.pom;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SW_VerificationOfCartValueTest extends BaseTest {

	// Cart Value verification
	@Test
	public void VerifiyCartValue() {

		// login page

		login.login("standard_user", "secret_sauce");
		Assert.assertEquals(login.getproductsPageHeading(), "Products");
		System.out.println("Login successfull!!!");

		// products page
		product.checkCartValue();
		product.removeFromCart();
		Assert.assertEquals(product.getCartValue(), "2");
		System.out.println("Cart value is correct");

	}

}
