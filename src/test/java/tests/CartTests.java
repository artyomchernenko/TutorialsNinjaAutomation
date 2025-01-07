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

public class CartTests extends BaseTest{

	@Test(description = "Enter coupone number")
	public void tc01_enterCouponNumber() {
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.chooseLaptop("HP LP3065");
		laptopPage.addToCart();
		laptopPage.openCart();
		myCartPage.useCouponCode("12234576");
		//Validation
		AssertJUnit.assertTrue(myCartPage.isThisCouponePage());
	}

	@Test(description = "Estiminate Shipping & Taxes")
	public void tc02_estiminateShipsTaxes() {
		myCartPage.estimateShippingTaxes("Israel", "Tel Aviv (Gosh Dan)", "0000");
		//Validation
		AssertJUnit.assertTrue(myCartPage.shippingEstimate());
	}

	@Test(description = "Enter Gift Certificate")
	public void tc03_enterGiftCertificate() {
		myCartPage.useGiftCertificate("4567890");
		//Validation
		AssertJUnit.assertTrue(myCartPage.isThisGiftPage());
		
	}

	@Test(description = "Change quantity in the cart to 5")
	public void tc04_changeQuantityInTheCart() {
		myCartPage.changeQuantityInTheCart("5");
		//Validation
		String expected = "5 item(s) - $500.00";
		String actual = myCartPage.itIsFiveLaptopsInCart();
		AssertJUnit.assertEquals(actual, expected);
	
		
	}
		@Test(description = "Remove laptop from the Cart")
	public void tc05_remptyTheCart() {
		myCartPage.emptyTheCart();
		//Validation
		String expected = "Your shopping cart is empty!";
		String actual = myCartPage.theCartIsEmptyLable();
		AssertJUnit.assertEquals(actual, expected);
	}
}
