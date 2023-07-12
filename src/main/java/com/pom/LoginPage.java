package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "user-name")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(id = "login-button")
	WebElement loginButton;

	@FindBy(xpath = "//span[text()='Products']")
	WebElement productsPageHeading;

	@FindBy(xpath = "//div[@class='error-message-container error']")
	WebElement errorMessage;

	public void login(String usernameData, String passwordData) {
		username.clear();
		username.sendKeys(usernameData);
		password.clear();
		password.sendKeys(passwordData);
		loginButton.click();

	}

	public String getproductsPageHeading() {
		return productsPageHeading.getText();
	}

	public String getErrorMessage() {
		return errorMessage.getText();
	}

}
