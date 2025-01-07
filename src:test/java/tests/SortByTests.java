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

public class SortByTests extends BaseTest{

	@Test(description = "Sort laptops by price")
	public void tc01_sortByPrice() {
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.sortLaptops("Price (Low > High)");
		laptopsAndNotebooksPage.sortLaptops("Price (High > Low)");
		//Validation
		String expected = "Price (High > Low)";
		String actual = laptopsAndNotebooksPage.sortedByPrice();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test(description = "Sort laptops by name")
	public void tc02_sortByName() {
		laptopsAndNotebooksPage.sortLaptops("Name (A - Z)");
		laptopsAndNotebooksPage.sortLaptops("Name (Z - A)");
		//Validation
		String expected = "Name (Z - A)";
		String actual = laptopsAndNotebooksPage.sortedByName();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test(description = "Sort laptops by raiting")
	public void tc03_sortByRaiting() {
		laptopsAndNotebooksPage.sortLaptops("Rating (Highest)");
		laptopsAndNotebooksPage.sortLaptops("Rating (Lowest)");
		//Validation
		String expected = "Rating (Lowest)";
		String actual = laptopsAndNotebooksPage.sortedByRating();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test(description = "Sort laptops by model")
	public void tc04_sortByModel() {
		laptopsAndNotebooksPage.sortLaptops("Model (A - Z)");
		laptopsAndNotebooksPage.sortLaptops("Model (Z - A)");
		//Validation
		String expected = "Model (Z - A)";
		String actual = laptopsAndNotebooksPage.sortedByModel();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test(description = "Sort laptops by default")
	public void tc05_sortByDefault() {
		laptopsAndNotebooksPage.sortLaptops("Default");
		//Validation
		String expected = "Default";
		String actual = laptopsAndNotebooksPage.sortedByDefaultl();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test(description = "Switch to list/grid")
	public void tc06_switchToListGrid() {
		laptopsAndNotebooksPage.switchToList();
		sleep(600);
		laptopsAndNotebooksPage.switchToGrid();
		//Validation
		AssertJUnit.assertTrue(laptopsAndNotebooksPage.isItGrid());
	}
}