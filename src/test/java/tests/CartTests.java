package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

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
		Assert.assertTrue(myCartPage.isThisCouponePage());
	}

	@Test
	@Description("Estiminate Shipping & Taxes")
	@Severity(SeverityLevel.NORMAL)
	public void tc02_estiminateShipsTaxes() {
		myCartPage.estimateShippingTaxes("Israel", "Tel Aviv (Gosh Dan)", "0000");
		//Validation
		Assert.assertTrue(myCartPage.shippingEstimate());
	}

	@Test
	@Description("Enter Gift Certificate")
	@Severity(SeverityLevel.NORMAL)
	public void tc03_enterGiftCertificate() {
		myCartPage.useGiftCertificate("4567890");
		//Validation
		Assert.assertTrue(myCartPage.isThisGiftPage());
	}

	@Test
	@Description("Change quantity in the cart to 5")
	@Severity(SeverityLevel.NORMAL)
	public void tc04_changeQuantityInTheCart() {
		myCartPage.changeQuantityInTheCart("5");
		//Validation
		String expected = "5 item(s) - $500.00";
		String actual = myCartPage.itIsFiveLaptopsInCart();
		Assert.assertEquals(actual, expected);
	}

	@Test
	@Description("Remove laptop from the Cart")
	@Severity(SeverityLevel.NORMAL)
	public void tc05_emptyTheCart() {
		myCartPage.emptyTheCart();
		//Validation
		String expected = "Your shopping cart is empty!";
		String actual = myCartPage.theCartIsEmptyLable();
		Assert.assertEquals(actual, expected);
	}
}
