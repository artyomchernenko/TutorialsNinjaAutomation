package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class SortByTests extends BaseTest{

	@Test
	@Description("Sort laptops by price")
	@Severity(SeverityLevel.NORMAL)
	public void tc01_sortByPrice() {
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.sortLaptops("Price (Low > High)");
		laptopsAndNotebooksPage.sortLaptops("Price (High > Low)");
		//Validation
		String expected = "Price (High > Low)";
		String actual = laptopsAndNotebooksPage.sortedByPrice();
		Assert.assertEquals(actual, expected);
	}

	@Test
	@Description("Sort laptops by name")
	@Severity(SeverityLevel.NORMAL)
	public void tc02_sortByName() {
		laptopsAndNotebooksPage.sortLaptops("Name (A - Z)");
		laptopsAndNotebooksPage.sortLaptops("Name (Z - A)");
		//Validation
		String expected = "Name (Z - A)";
		String actual = laptopsAndNotebooksPage.sortedByName();
		Assert.assertEquals(actual, expected);
	}

	@Test
	@Description("Sort laptops by raiting")
	@Severity(SeverityLevel.NORMAL)
	public void tc03_sortByRaiting() {
		laptopsAndNotebooksPage.sortLaptops("Rating (Highest)");
		laptopsAndNotebooksPage.sortLaptops("Rating (Lowest)");
		//Validation
		String expected = "Rating (Lowest)";
		String actual = laptopsAndNotebooksPage.sortedByRating();
		Assert.assertEquals(actual, expected);
	}

	@Test
	@Description("Sort laptops by model")
	@Severity(SeverityLevel.NORMAL)
	public void tc04_sortByModel() {
		laptopsAndNotebooksPage.sortLaptops("Model (A - Z)");
		laptopsAndNotebooksPage.sortLaptops("Model (Z - A)");
		//Validation
		String expected = "Model (Z - A)";
		String actual = laptopsAndNotebooksPage.sortedByModel();
		Assert.assertEquals(actual, expected);
	}

	@Test
	@Description("Sort laptops by default")
	@Severity(SeverityLevel.NORMAL)
	public void tc05_sortByDefault() {
		laptopsAndNotebooksPage.sortLaptops("Default");
		//Validation
		String expected = "Default";
		String actual = laptopsAndNotebooksPage.sortedByDefaultl();
		Assert.assertEquals(actual, expected);
	}

	@Test
	@Description("Switch to list/grid(mouse actions)")
	@Severity(SeverityLevel.NORMAL)
	public void switchToListMouse() {
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.switchListGridMouse();
		//Validation
		Assert.assertTrue(laptopsAndNotebooksPage.isItGrid());
	}
}
