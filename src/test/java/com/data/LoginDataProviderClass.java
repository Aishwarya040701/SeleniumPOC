package com.data;

import org.testng.annotations.DataProvider;

public class LoginDataProviderClass {

	@DataProvider(name = "invalidData")
	public Object[][] loginDetails() {
		Object[][] logindata = new Object[][] { { "standard", "secret_" }, { "", "" }, { "standard_user", "" },
				{ "standard_user", "wrong" }, { "locked_out_user", "secret_sauce" } };
		return logindata;

	}

}
