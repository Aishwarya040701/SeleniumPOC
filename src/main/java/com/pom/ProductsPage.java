package com.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage {

	public WebDriver driver;

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//select[@data-test='product_sort_container']")
	WebElement dropdown;

	@FindBy(xpath = "//div[@class='inventory_item']")
	List<WebElement> ListOfItems;

	@FindBy(xpath = "//div[@class='inventory_item_name']")
	List<WebElement> listOfProductsName;

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	WebElement product1;

	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
	WebElement product1Name;

	@FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
	WebElement product2;

	@FindBy(xpath = "//div[text()='Sauce Labs Bolt T-Shirt']")
	WebElement product2Name;

	@FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
	WebElement product3;

	@FindBy(id = "add-to-cart-sauce-labs-bike-light")
	WebElement product4;

	@FindBy(id = "remove-sauce-labs-bike-light")
	WebElement removeProduct3;

	@FindBy(id = "remove-sauce-labs-fleece-jacket")
	WebElement removeProduct4;

	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	WebElement cartValue;

	@FindBy(id = "shopping_cart_container")
	WebElement cartButton;

	// adding products to cart
	public void addToCart() {
		product1.click();
		product2.click();
		System.out.println("Products added");

	}

	// adding products to cart for checking cart value
	public void checkCartValue() {
		product1.click();
		product2.click();
		product3.click();
		product4.click();
		System.out.println("Products added");

	}

	// remove products from
	public void removeFromCart() {
		removeProduct3.click();
		removeProduct4.click();
		System.out.println("Products removed");

	}

	// click on cartButton
	public void clickCartButton() {
		cartButton.click();
	}

	// get cart value
	public String getCartValue() {
		return cartValue.getText();

	}

	public String getProduct1Name() {
		return product1Name.getText();

	}

	public String getProduct2Name() {
		return product2Name.getText();

	}

	public String getSortedProduct() {
		return listOfProductsName.get(0).getText();
	}

	// sorting operation
	public void sortProductsByValue(String Value) {
		new Select(dropdown).selectByValue(Value);
	}

	public void listOfitems() {
		System.out.println("Product counts: " + ListOfItems.size());
		System.out.println("Products Details:   ");
		for (WebElement element : ListOfItems) {
			System.out.println(element.getText());
		}
	}

}
