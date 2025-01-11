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

public class EndToEndTest extends BaseTest{

	@Test(description = "Login system, add product to the cart, fill your personal information, make an order.")
	public void tc01_endToEnd() {
		mainPage.EnterLoginPage();
		loginPage.login("aptem1986@mail.ru", "Onlyforproject");
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.sortLaptops("Rating (Highest)");
		laptopsAndNotebooksPage.switchToList();
		laptopsAndNotebooksPage.chooseLaptop("HP LP3065");
		laptopPage.seePhotosOfTheLaptop();
		laptopPage.seeSpecification();
		laptopPage.writeReview("Artyom Chernenko", "This is a very good computer!!!");
		laptopPage.chooseDeliveryDate("2025-04-11");
		laptopPage.chooseQuantityOfLaptops("3");
		laptopPage.addToCart();
		laptopPage.openCart();
		myCartPage.checkOut();
		checkOutPage.fillBillingDetails("Artyom", "Chernenko", "Atsmaut", "Bat-Yam", "0000", "Israel", "Tel Aviv (Gosh Dan)");
		checkOutPage.fillDeliveryDetails("Artyom", "Chernenko", "Atsmaut", "Bat-Yam", "0000", "Israel", "Tel Aviv (Gosh Dan)");
		checkOutPage.fillMesageDeliveryField("Please deliver faster!!!");
		checkOutPage.agreeToTheTermsAndConditions();
		checkOutPage.confirmOrder();
		//Validation
		String expected = "Your order has been placed!";
		String actual = checkOutPage.getSanitySucsessLable();
		AssertJUnit.assertEquals(actual, expected);
	}
}
