package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AddRemoveDifferrentLaptopsToCartTests extends BaseTest{

	@Test
	@Description("Add 2 different laptops(Sony VAIO and MacBook Air)at the same time to the cart")
	@Severity(SeverityLevel.NORMAL)
	public void tc01_addFewLaptops(){
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.removeAllLaptopsFromTheCart();
		laptopsAndNotebooksPage.addDifferentLaptopsToCart("Sony VAIO");
		laptopsAndNotebooksPage.addDifferentLaptopsToCart("MacBook Air");
		//Validation
		int expected =  2;
		int actual = laptopsAndNotebooksPage.numberOfLaptopsInTheCart();
		Assert.assertEquals(actual, expected);
	}

	@Test
	@Description("Remove one chosen laptop(MacBook Air) from the cart")
	@Severity(SeverityLevel.NORMAL)
	public void tc02_removeChosenLaptopFromCart() {
		laptopsAndNotebooksPage.chooseAndRemoveFromCart("MacBook Air");
		//Validation
		int expected = 1;
		int actual = laptopsAndNotebooksPage.numberOfLaptopsInTheCart();
		Assert.assertEquals(actual, expected);
	}
	@Test
	@Description("Add 1 laptop(HP LP3065)to the cart")
	@Severity(SeverityLevel.NORMAL)
	public void tc03_addLaptopToTheCart() {
		laptopsAndNotebooksPage.addDifferentLaptopsToCart("HP LP3065");
		//Validation
		int expected =  2;
		int actual = laptopsAndNotebooksPage.numberOfLaptopsInTheCart();
		Assert.assertEquals(actual, expected);
	}

	@Test
	@Description("Add all laptops the cart(at the same time)")
	@Severity(SeverityLevel.NORMAL)
	public void tc04_addAllDifferentLaptops() {
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.removeAllLaptopsFromTheCart();
		laptopsAndNotebooksPage.addDifferentLaptopsToCart("HP LP3065");
		laptopsAndNotebooksPage.addDifferentLaptopsToCart("MacBook");
		laptopsAndNotebooksPage.addDifferentLaptopsToCart("MacBook Air");
		laptopsAndNotebooksPage.addDifferentLaptopsToCart("MacBook Pro");
		laptopsAndNotebooksPage.addDifferentLaptopsToCart("Sony VAIO");
		//Validation 
		int expected = 5;
		int actual = laptopsAndNotebooksPage.numberOfLaptopsInTheCart();
		Assert.assertEquals(actual, expected);
	}

	@Test
	@Description("Remove all different laptops")
	@Severity(SeverityLevel.NORMAL)
	public void tc05_removeAllDifferentLaptopsFromCart() {
		laptopsAndNotebooksPage.removeAllLaptopsFromTheCart();
		//Validation 
		int expected = 0;
		int actual = laptopsAndNotebooksPage.numberOfLaptopsInTheCart();
		Assert.assertEquals(actual, expected);
	}
}
