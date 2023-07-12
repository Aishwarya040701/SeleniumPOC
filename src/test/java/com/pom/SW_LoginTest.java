package com.pom;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.data.LoginDataProviderClass;

public class SW_LoginTest extends BaseTest {

	@Test(dataProvider = "invalidData", dataProviderClass = LoginDataProviderClass.class)
	public void verifyErrorMeassageForInvalidUser(String username, String password) {

		// login page
		login.login(username, password);

		switch (login.getErrorMessage()) {
		case "Epic sadface: Username and password do not match any user in this service":
			Assert.assertEquals(login.getErrorMessage(),
					"Epic sadface: Username and password do not match any user in this service");
			System.out.println("Error Message " + login.getErrorMessage());
			break;

		case "Epic sadface: Username is required":
			Assert.assertEquals(login.getErrorMessage(), "Epic sadface: Username is required");
			System.out.println("Error Message " + login.getErrorMessage());
			break;

		case "Epic sadface: Password is required":
			Assert.assertEquals(login.getErrorMessage(), "Epic sadface: Password is required");
			System.out.println("Error Message " + login.getErrorMessage());
			break;

		case "Epic sadface: Sorry, this user has been locked out.":
//			Assert.assertTrue(login.errorMessage.isDisplayed(), "error message is displayed");
			Assert.assertEquals(login.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.");
			System.out.println("Error Message " + login.getErrorMessage());
			break;

		}

	}

}
