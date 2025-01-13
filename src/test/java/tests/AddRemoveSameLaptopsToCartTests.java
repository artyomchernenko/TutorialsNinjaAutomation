package tests;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

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

	@Test
	@Description("Choose laptop(MacBook Air)")
	@Severity(SeverityLevel.NORMAL)
	public void tc01_chooseLaptop() {
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.chooseLaptop("MacBook Air");
		//Validation
		String expected = "MacBook Air";
		String actual = laptopPage.checkLaptopName();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test
	@Description("Add one laptop(Macbook Air) to the cart")
	@Severity(SeverityLevel.NORMAL)
	public void tc02_addToCartLaptop() {
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.addToCart("MacBook Air");
		//Validation
		String expected = "1 item(s) - $1,202.00";
		String actual = laptopsAndNotebooksPage.oneLaptopWasAdded();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test
	@Description("Remove one laptop from cart")
	@Severity(SeverityLevel.NORMAL)
	public void tc03_removeLaptopFromCart() {
		laptopsAndNotebooksPage.removeFromCart();
		//Validation
		String expected = "0 item(s) - $0.00";
		String actual = laptopsAndNotebooksPage.oneLaptopWasRemoved();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test
	@Description("Add 3 same laptops(MacBook) to the cart")
	@Severity(SeverityLevel.NORMAL)
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

	@Test
	@Description("Remove all laptops from the cart")
	@Severity(SeverityLevel.NORMAL)
	public void tc05_removeAllSameFromCart() {
		laptopsAndNotebooksPage.removeFromCart();
		//Validation 
		String expected = "0 item(s) - $0.00";
		String actual = laptopsAndNotebooksPage.allLaptopsWereRemoved();
		AssertJUnit.assertEquals(actual, expected);
	}
}
