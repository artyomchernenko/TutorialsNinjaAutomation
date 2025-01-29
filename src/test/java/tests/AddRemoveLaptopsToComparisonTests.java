package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AddRemoveLaptopsToComparisonTests extends BaseTest{

	@Test
	@Description("Add one laptop (HP LP3065) to comparison")
	@Severity(SeverityLevel.NORMAL)
	public void tc01_addOneLaptopToComparison() {
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.addLaptopToComparison("MacBook");
		//Validation
		String expected = "MacBook";
		String actual = laptopPage.checkLaptopName();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test
	@Description("Choose and remove laptop from the comparison")
	@Severity(SeverityLevel.NORMAL)
	public void tc02_removeChosenLaptopFromCoparison() {
		laptopPage.enterComparisonPage();
		productComparisonPage.chooseAndRemoveFromComperation("MacBook");
		//Validation
		String expected = "You have not chosen any products to compare.";
		String actual = laptopPage.allLaptopsRemovedFromComparison();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test
	@Description("Choose and remove laptop from the comparison")
	@Severity(SeverityLevel.NORMAL)
	public void tc03_addTwoDifferentLaptopsToComparison() {
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.addDifferentLaptopsToComparison("HP LP3065");
		laptopsAndNotebooksPage.addDifferentLaptopsToComparison("MacBook");
		//Validation
		int expected = 2;
		int actual = laptopsAndNotebooksPage.NumberOfLaptopsInComparison();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test
	@Description("Remove all laptops from comparation")
	@Severity(SeverityLevel.NORMAL)
	public void tc04_removeAllLaptopsFromComparation() {
		laptopsAndNotebooksPage.enterComparisonPage();
		productComparisonPage.removeAllDifferentLaptopsFromComperation();
		//Validation
		String expected = "You have not chosen any products to compare.";
		String actual = laptopPage.allLaptopsRemovedFromComparison();
		AssertJUnit.assertEquals(actual, expected);
	}
}
