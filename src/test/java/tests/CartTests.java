package tests;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

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

	@Test
	@Description("Enter coupone number")
	@Severity(SeverityLevel.NORMAL)
	public void tc01_enterCouponNumber() {
		mainPage.enterProductsPage("Laptops & Notebooks");
		laptopsAndNotebooksPage.chooseLaptop("HP LP3065");
		laptopPage.addToCart();
		laptopPage.openCart();
		myCartPage.useCouponCode("12234576");
		//Validation
		AssertJUnit.assertTrue(myCartPage.isThisCouponePage());
	}

	@Test
	@Description("Estiminate Shipping & Taxes")
	@Severity(SeverityLevel.NORMAL)
	public void tc02_estiminateShipsTaxes() {
		myCartPage.estimateShippingTaxes("Israel", "Tel Aviv (Gosh Dan)", "0000");
		//Validation
		AssertJUnit.assertTrue(myCartPage.shippingEstimate());
	}

	@Test
	@Description("Enter Gift Certificate")
	@Severity(SeverityLevel.NORMAL)
	public void tc03_enterGiftCertificate() {
		myCartPage.useGiftCertificate("4567890");
		//Validation
		AssertJUnit.assertTrue(myCartPage.isThisGiftPage());

	}

	@Test
	@Description("Change quantity in the cart to 5")
	@Severity(SeverityLevel.NORMAL)
	public void tc04_changeQuantityInTheCart() {
		myCartPage.changeQuantityInTheCart("5");
		//Validation
		String expected = "5 item(s) - $500.00";
		String actual = myCartPage.itIsFiveLaptopsInCart();
		AssertJUnit.assertEquals(actual, expected);


	}
	@Test
	@Description("Remove laptop from the Cart")
	@Severity(SeverityLevel.NORMAL)
	public void tc05_remptyTheCart() {
		myCartPage.emptyTheCart();
		//Validation
		String expected = "Your shopping cart is empty!";
		String actual = myCartPage.theCartIsEmptyLable();
		AssertJUnit.assertEquals(actual, expected);
	}
}
