package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {

	public WebDriver driver;

	public YourCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
	WebElement product1;

	@FindBy(xpath = "//div[text()='Sauce Labs Bolt T-Shirt']")
	WebElement product2;

	@FindBy(id = "checkout")
	WebElement checkoutButton;

	public void clickCheckoutButton() {
		checkoutButton.click();
	}

	public boolean checkProduct1Displayed() {
		return product1.isDisplayed();
	}

	public boolean checkProduct2Displayed() {
		return product2.isDisplayed();

	}

	public String getProduct1Name() {
		return product1.getText();

	}

	public String getProduct2Name() {
		return product2.getText();

	}

}
