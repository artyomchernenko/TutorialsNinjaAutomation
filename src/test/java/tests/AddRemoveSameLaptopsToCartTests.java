package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRemoveSameLaptopsToCartTests extends BaseTest{

	@Test(description = "Choose laptop(MacBook Air)")
	public void tc01_chooseLaptop() {
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.chooseLaptop("MacBook Air");
		//Validation
		String expected = "MacBook Air";
		String actual = laptopPage.checkLaptopName();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test(description = "Add one laptop(Macbook Air) to the cart")
	public void tc02_addToCartLaptop() {
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.addToCart("MacBook Air");
		//Validation
		String expected = "1 item(s) - $1,202.00";
		String actual = laptopsAndNotebooksPage.oneLaptopWasAdded();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test(description = "Remove one laptop from cart")
	public void tc03_removeLaptopFromCart() {
		laptopsAndNotebooksPage.removeFromCart();
		//Validation
		String expected = "0 item(s) - $0.00";
		String actual = laptopsAndNotebooksPage.oneLaptopWasRemoved();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test(description = "Add 3 same laptops(MacBook) to the cart")
	public void tc04_add3SameLaptopsToCart() {
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.chooseLaptop("MacBook");
		laptopPage.chooseQuantityOfLaptops("3");
		laptopPage.addToCart();
		//Validation
		String expected = "3 item(s) - $1,806.00";
		String actual = laptopsAndNotebooksPage.threeLaptopWasAdded();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test(description = "Remove all laptops from the cart")
	public void tc05_removeAllSameFromCart() {
		laptopsAndNotebooksPage.removeFromCart();
		//Validation 
		String expected = "0 item(s) - $0.00";
		String actual = laptopsAndNotebooksPage.allLaptopsWereRemoved();
		AssertJUnit.assertEquals(actual, expected);
	}
}
