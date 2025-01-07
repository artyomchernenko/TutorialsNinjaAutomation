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

public class AddRemoveLaptopsToComparisonTests extends BaseTest{

	@Test(description = "Add one laptop (HP LP3065) to comparison")
	public void tc01_addOneLaptopToComparison() {
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.addToComparison("MacBook");
		//Validation
		String expected = "MacBook";
		String actual = laptopPage.checkLaptopName();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test(description = "Choose and remove laptop from the comparison")
	public void tc02_removeChosenLaptopFromCoparison() {
		laptopPage.enterComparisonPage();
		productComparisonPage.chooseAndRemoveFromComperation("MacBook");
		//Validation
		String expected = "You have not chosen any products to compare.";
		String actual = laptopPage.allLaptopsRemovedFromComparison();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test(description = "Add 2 different laptops to comparison")
	public void tc03_addTwoDifferentLaptopsToComparison() {
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.addDifferentItemsToComparison("HP LP3065");
		laptopsAndNotebooksPage.addDifferentItemsToComparison("MacBook");
		//Validation
		String expected = "Product Compare (2)";
		String actual = laptopsAndNotebooksPage.twoLaptopsWereAddedToComparison();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test(description = "Remove all laptops from comparation")
	public void tc04_removeAllLaptopsFromComparation() {
		laptopsAndNotebooksPage.enterComparisonPage();
		productComparisonPage.removeAllDifferentLaptopsFromComperation();
		//Validation
		String expected = "You have not chosen any products to compare.";
		String actual = laptopPage.allLaptopsRemovedFromComparison();
		AssertJUnit.assertEquals(actual, expected);
	}
}
