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

public class AddRemoveDifferrentLaptopsToCartTests extends BaseTest{

	@Test(description = "Add 2 different laptops(Sony VAIO and MacBook Air)at the same time to the cart")
	public void tc01_addFewLaptops(){
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.addDifferentLaptopsToCart("Sony VAIO");
		laptopsAndNotebooksPage.addDifferentLaptopsToCart("MacBook Air");
		//Validation
		String expected =  "2 item(s) - $2,404.00";
		String actual = laptopsAndNotebooksPage.twoLaptopsWereAdded();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test(description = "Remove one chosen laptop(MacBook Air) from the cart")
	public void tc02_removeChosenLaptopFromCart() {
		laptopsAndNotebooksPage.chooseAndRemoveFromCart("MacBook Air");
		//Validation
		String expected = "1 item(s) - $1,202.00";
		String actual = laptopsAndNotebooksPage.oneLaptopWasRemoved();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test(description = "Add all laptops the cart(at the same time)")
	public void tc03_addAllDifferentLaptops() {
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.addDifferentLaptopsToCart("HP LP3065");
		laptopsAndNotebooksPage.addDifferentLaptopsToCart("MacBook");
		laptopsAndNotebooksPage.addDifferentLaptopsToCart("MacBook Air");
		laptopsAndNotebooksPage.addDifferentLaptopsToCart("MacBook Pro");
		laptopsAndNotebooksPage.addDifferentLaptopsToCart("Sony VAIO");
		//Validation 
		String expected = "5 item(s) - $6,208.00";
		String actual = laptopsAndNotebooksPage.allLaptopsWereAdded();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test(description = "Remove all different laptops")
	public void tc04_removeAllDifferentLaptopsFromCart() {
		laptopsAndNotebooksPage.removeAllDifferentLaptops();
		//Validation 
		String expected = "0 item(s) - $0.00";
		String actual = laptopsAndNotebooksPage.allLaptopsWereRemoved();
		AssertJUnit.assertEquals(actual, expected);
	}

}
