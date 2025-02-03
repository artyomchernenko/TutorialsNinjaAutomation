package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AddRemoveSameLaptopsToCartTests extends BaseTest{

	@Test
	@Description("Choose laptop(MacBook Air)")
	@Severity(SeverityLevel.NORMAL)
	public void tc01_chooseLaptop() {
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.chooseLaptop("MacBook Air");
		//Validation
		String expected = "MacBook Air";
		String actual = laptopPage.checkLaptopName();
		Assert.assertEquals(actual, expected);
	}

	@Test
	@Description("Add one laptop(Macbook Air) to the cart")
	@Severity(SeverityLevel.NORMAL)
	public void tc02_addToCartLaptop() {
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.removeAllLaptopsFromTheCart();
		laptopsAndNotebooksPage.addToCart("MacBook Air");
		//Validation
		int expected = 1;
		int actual = laptopsAndNotebooksPage.numberOfLaptopsInTheCart();
		Assert.assertEquals(actual, expected);
	}

	@Test
	@Description("Add one laptop(HP LP3065) to the cart")
	@Severity(SeverityLevel.NORMAL)
	public void tc03_addToCartLaptop() {
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.addToCart("HP LP3065");
		//Validation
		int expected = 2;
		int actual = laptopsAndNotebooksPage.numberOfLaptopsInTheCart();
		Assert.assertEquals(actual, expected);
	}

	@Test
	@Description("Remove one laptop from cart")
	@Severity(SeverityLevel.NORMAL)
	public void tc04_removeLaptopFromCart() {
		laptopsAndNotebooksPage.removeFromCart();
		//Validation
		int expected = 1;
		int actual = laptopsAndNotebooksPage.numberOfLaptopsInTheCart();
		Assert.assertEquals(actual, expected);
	}

	@Test
	@Description("Add 3 same laptops(MacBook) to the cart")
	@Severity(SeverityLevel.NORMAL)
	public void tc05_add3SameLaptopsToCart() {
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.chooseLaptop("MacBook");
		laptopPage.chooseQuantityOfLaptops("3");
		laptopPage.addToCart();
		//Validation
		int expected = 4;
		int actual = laptopsAndNotebooksPage.numberOfLaptopsInTheCart();
		Assert.assertEquals(actual, expected);
	}

	@Test
	@Description("Remove all laptops from the cart")
	@Severity(SeverityLevel.NORMAL)
	public void tc06_removeAllSameFromCart() {
		laptopsAndNotebooksPage.removeAllLaptopsFromTheCart();
		//Validation 
		int expected = 0;
		int actual = laptopsAndNotebooksPage.numberOfLaptopsInTheCart();
		Assert.assertEquals(actual, expected);
	}
}
