package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class InspectLaptopTests extends BaseTest{

	@Test
	@Description("Choose one laptop(HP LP3065)")
	@Severity(SeverityLevel.NORMAL)
	public void tc01_chooseLaptopToInspect() {
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.chooseLaptop("HP LP3065");
		//Validation
		String expected = "HP LP3065";
		String actual = laptopsAndNotebooksPage.laptopModelLable();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test
	@Description("See the photos of laptop(HP LP3065)")
	@Severity(SeverityLevel.NORMAL)
	public void tc02_seeThePhotosofLaptop() {
		laptopPage.seePhotosOfTheLaptop();
		AssertJUnit.assertTrue(laptopPage.checkIfPictureIsClickable());
	}

	@Test
	@Description("See specification of the laptop(HP LP3065)")
	@Severity(SeverityLevel.NORMAL)
	public void tc03_seeSpecificationOfLaptop() {
		laptopPage.seeSpecification();
		//Validation
		String expected = "Specification";
		String actual = laptopPage.specificationLable();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test
	@Description("Write review for laptop(HP LP3065)")
	@Severity(SeverityLevel.NORMAL)
	public void tc04_writeReviewForLaptop() {
		laptopPage.writeReview("Artyom Chernenko", "This is a very good computer!");
		//Validation
		String expected = "Thank you for your review. It has been submitted to the webmaster for approval.";
		String actual = laptopPage.sentReviewLable();
		AssertJUnit.assertEquals(actual, expected);
	}
}
