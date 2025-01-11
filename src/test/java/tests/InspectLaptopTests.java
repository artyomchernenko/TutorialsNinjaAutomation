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

public class InspectLaptopTests extends BaseTest{

	@Test(description = "Choose one laptop(HP LP3065)")
	public void tc01_chooseLaptopToInspect() {
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.chooseLaptop("HP LP3065");
		//Validation
		String expected = "HP LP3065";
		String actual = laptopsAndNotebooksPage.laptopModelLable();
		AssertJUnit.assertEquals(actual, expected);
	}
	
	@Test(description = "See the photos of laptop(HP LP3065)")
	public void tc02_seeThePhotosofLaptop() {
		laptopPage.seePhotosOfTheLaptop();
		AssertJUnit.assertTrue(laptopPage.checkIfPictureIsClickable());
	}
	
	@Test(description = "See specification of the laptop(HP LP3065)")
	public void tc03_seeSpecificationOfLaptop() {
		laptopPage.seeSpecification();
		//Validation
		String expected = "Specification";
		String actual = laptopPage.specificationLable();
		AssertJUnit.assertEquals(actual, expected);
	}
	
	@Test(description = "Write review for laptop(HP LP3065)")
	public void tc04_writeReviewForLaptop() {
		laptopPage.writeReview("Artyom Chernenko", "This is a very good computer!");
		//Validation
		String expected = "Thank you for your review. It has been submitted to the webmaster for approval.";
		String actual = laptopPage.sentReviewLable();
		AssertJUnit.assertEquals(actual, expected);
	}
}
