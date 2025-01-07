package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyCartPage extends BasePage{

	public MyCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".buttons.clearfix .pull-right")
	private WebElement checkoutBtn;
	@FindBy(css = "div.panel-heading a")
	private WebElement couponBtn;
	@FindBy(css = "#input-coupon")
	private WebElement couponField;
	@FindBy(css = ".input-group-btn #button-coupon")
	private WebElement applyCouponBtn;
	@FindBy(css = "div:nth-child(2) > div.panel-heading > h4 > a")
	private WebElement estimateShippingBtn;
	@FindBy(css = "#input-country")
	private WebElement countryField;
	@FindBy(css = "#input-zone")
	private WebElement regionField;
	@FindBy(css = "#input-postcode")
	private WebElement postCodeField;
	@FindBy(css = "[id='button-quote']")
	private WebElement getQuotesBtn;
	@FindBy(css = "[value='flat.flat']")
	private WebElement selectShippingRateBtn;
	@FindBy(css = "[id='button-shipping']")
	private WebElement applyShippingBtn;
	@FindBy(css = ".input-group.btn-block .form-control")
	private WebElement quantityField;
	@FindBy(css = "[data-original-title='Update']")
	private WebElement updateQuantityBtn;
	@FindBy(css = "div:nth-child(3) > div.panel-heading > h4 > a")
	private WebElement useGiftBtn;
	@FindBy(css = "#input-voucher")
	private WebElement giftSertificateField;
	@FindBy(css = ".input-group-btn #button-voucher")
	private WebElement applyGiftBtn;
	@FindBy(css = "td:nth-child(4) > div > span > button.btn.btn-danger")
	private WebElement removeFromCartBtn;
	@FindBy(css = ".alert.alert-success.alert-dismissible")
	private WebElement shippingEstimateLable;
	@FindBy(css = "#content > form > div > table > tbody > tr > td:nth-child(4) > div > input")
	private WebElement laptopsQuantity;
	@FindBy(css = "#cart-total")
	private WebElement numberOfLaptopsInCart;
	@FindBy(css = "#content > p")
	private WebElement theCartIsEmptyLable;


	//Click on "Check out" button
	public void checkOut() {
		waitForElementToBeVisible(checkoutBtn);
		click(checkoutBtn);
	}

	//Fill the coupon number
	public void useCouponCode(String couponeCode) {
		click(couponBtn);
		fillText(couponField, couponeCode);
		click(applyCouponBtn);
	}

	//Estimate shipping taxes
	public void estimateShippingTaxes(String country,String region, String postCode) {
		click(estimateShippingBtn);
		wait.until(ExpectedConditions.textToBePresentInElement(countryField, country));
		selectByVisibleText(countryField, country);
		wait.until(ExpectedConditions.textToBePresentInElement(regionField, region));
		selectByVisibleText(regionField, region);
		fillText(postCodeField, postCode);
		click(getQuotesBtn);
		click(selectShippingRateBtn);
		click(applyShippingBtn);
	}

	//Fill the gift certificate
	public void useGiftCertificate(String giftCertificateCode) {
		sleep(500);
		click(useGiftBtn);
		fillText(giftSertificateField, giftCertificateCode);
		click(applyGiftBtn);
	}

	//Change quantity from the cart
	public void changeQuantityInTheCart(String quantity) {
		sleep(500);
		fillText(quantityField, quantity);
		click(updateQuantityBtn);
	}

	//Empty the cart
	public void emptyTheCart() {
		click(removeFromCartBtn);
	}

	//Validation
	public boolean isThisCouponePage() {
		if (applyCouponBtn.isDisplayed()) {
			return true;	
		} else {
			return false;
		}
	}

	//Validation
	public boolean shippingEstimate() {
		waitForElementToBeVisible(shippingEstimateLable);
		if (getText(shippingEstimateLable).toLowerCase().contains("Success: Your shipping estimate has been applied!")) {
		}
		return true;
	}

	//Validation
	public boolean isThisGiftPage() {
		if (applyGiftBtn.isDisplayed()) {
			return true;	
		} else {
			return false;
		}
	}
	
	//Validation
	public String itIsFiveLaptopsInCart() {
		sleep(700);
		return getText(numberOfLaptopsInCart);
	}
	
	//Validation
	public String theCartIsEmptyLable() {
	sleep(700);
	return getText(theCartIsEmptyLable);
	}
}
