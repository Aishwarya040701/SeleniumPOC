package com.pom;

import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.data.ReadExcelFile;

public class SW_ProductCheckoutTest extends BaseTest {

	String username, password, firstname, lastname, postalCode;

	@Test
	public void ProductCheckOut() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ReadExcelFile.ExcelConnection("Sheet1");

		int rowCount = ReadExcelFile.workSheet.getPhysicalNumberOfRows();

		for (int i = 1; i < rowCount - 1; i++) {
			username = ReadExcelFile.ExcelReadDataFromCell(i, 0);
			password = ReadExcelFile.ExcelReadDataFromCell(i, 1);
			firstname = ReadExcelFile.ExcelReadDataFromCell(i, 2);
			lastname = ReadExcelFile.ExcelReadDataFromCell(i, 3);
			postalCode = ReadExcelFile.ExcelReadDataFromCell(i, 4);

			// LoginPage

			login.login(username, password);
			Assert.assertEquals(login.getproductsPageHeading(), "Products");
			System.out.println("Login successfull!!!");

			// ProductsPage

			product.addToCart();
			Assert.assertEquals(product.getCartValue(), "2");
			System.out.println("Cart value is correct");
			product.clickCartButton();

			// YourCartPage

			Assert.assertTrue(cart.checkProduct1Displayed());
			Assert.assertTrue(cart.checkProduct1Displayed());
			Assert.assertEquals(cart.getProduct1Name(), product.getProduct1Name());
			Assert.assertEquals(cart.getProduct2Name(), product.getProduct2Name());
			System.out.println("Products added to cart in product page and products in the cart page are same");
			cart.clickCheckoutButton();

			// YourInformationPage

			information.enterDetails(firstname, lastname, postalCode);
			information.clickOnContinueButton();

			// OverviewPage

			overview.ClickFinishButton();
			Assert.assertEquals(overview.getThankyouMessage(), "Thank you for your order!");
			System.out.println("Product checkout successfull!!!");
			overview.logout();
			Assert.assertEquals(driver.getCurrentUrl(), read.getProperties("sauceUrl"));
			System.out.println("Logout successfull!!!");

		}

	}

}
