package pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage extends BasePage{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = ".radio [value='new']")
	private WebElement newAddressBtn;
	@FindBy(css = "#input-payment-firstname")
	private WebElement firstNameField;
	@FindBy(css = "#input-payment-lastname")
	private WebElement lastNameField;
	@FindBy(css = "#input-payment-address-1")
	private WebElement addressField;
	@FindBy(css = "#input-payment-city")
	private WebElement cityField;
	@FindBy(css = "#input-payment-postcode")
	private WebElement postCodeField;
	@FindBy(css = "#input-payment-country")
	private WebElement countryField;
	@FindBy(css = "#input-payment-zone")
	private WebElement regionField;
	@FindBy(css = ".btn.btn-primary")
	private WebElement continueBtn;
	@FindBy(css = "#input-shipping-firstname")
	private WebElement deliveryFirstNameField;
	@FindBy(css = "#input-shipping-lastname")
	private WebElement deliveryLastNameField;
	@FindBy(css = "#input-shipping-address-1")
	private WebElement deliveryAdressField;
	@FindBy(css = "#input-shipping-city")
	private WebElement deliveryCityField;
	@FindBy(css = "#input-shipping-postcode")
	private WebElement deliveryPostCodeField;
	@FindBy(css = "#input-shipping-country")
	private WebElement deliveryCountryField;
	@FindBy(css = "#input-shipping-zone")
	private WebElement deliveryRegionField;
	@FindBy(css = "#button-shipping-address")
	private WebElement continueBtnDelivery;
	@FindBy(css = ".panel-body  textarea")
	private WebElement deliveryMessageField;
	@FindBy(css = ".pull-right #button-shipping-method")
	private WebElement deliveryMessageBtn;
	@FindBy(css = "[name='agree']")
	private WebElement agreeCheckBox;
	@FindBy(css = "  .pull-right #button-payment-method")
	private WebElement continuePaymentBtn;
	@FindBy(css = ".pull-right #button-confirm")
	private WebElement confirmOrderBtn;
	@FindBy(css = "#collapse-shipping-address > div > form > div:nth-child(3) > label")
	private WebElement newDeliveryBtn;
	@FindBy(css = "#content > h1")
	private WebElement sanitySucsessLable;

	//Fill the billing details
	public void fillBillingDetails(String firstName, String lastName, String address,
			String city, String postCode, String country, String region) {
		click(newAddressBtn);
		fillText(firstNameField, firstName);
		fillText(lastNameField, lastName);
		fillText(addressField, address);
		fillText(cityField, city);
		fillText(postCodeField, postCode);
		selectByVisibleText(countryField, country);
		wait.until(ExpectedConditions.textToBePresentInElement(regionField, region));
		selectByVisibleText(regionField, region);
		click(continueBtn);
	}
	
	//Fill the delivery details
	public void fillDeliveryDetails(String firstName, String lastName, String address,
			String city, String postCode, String country, String region) {
		click(newDeliveryBtn);
		fillText(deliveryFirstNameField, firstName);
		fillText(deliveryLastNameField, lastName);
		fillText(deliveryAdressField, address);
		fillText(deliveryCityField, city);
		fillText(deliveryPostCodeField, postCode);
		selectByVisibleText(deliveryCountryField, country);
		wait.until(ExpectedConditions.textToBePresentInElement(deliveryRegionField, region));
		selectByVisibleText(deliveryRegionField, region);
		click(continueBtnDelivery);
	}
	
	//Fill the message for delivery
	public void fillMesageDeliveryField(String text) {
		waitForElementToBeVisible(deliveryMessageField);
		fillText(deliveryMessageField, text);
		click(deliveryMessageBtn);
	}
	
	//Agree to the Terms and Conditions
	public void agreeToTheTermsAndConditions() {
		click(agreeCheckBox);
		click(continuePaymentBtn);
	}
	
	//Confirm Order
	public void confirmOrder() {
		click(confirmOrderBtn);
	}
	
	//Validation
	public String getSanitySucsessLable() {
		sleep(500);
		return getText(sanitySucsessLable);
	}
}
