package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#input-email")
	private WebElement userNameField;
	@FindBy(css = "#input-password")
	private WebElement passwordField;
	@FindBy(css = "[value='Login']")
	private WebElement submitBtn;
	@FindBy(css = ".fa.fa-user")
	private WebElement accountBtn;
	@FindBy(css = "#top-links > ul > li.dropdown.open > ul > li:nth-child(5) > a")
	private WebElement logoutBtn;
	@FindBy(css = ".alert.alert-danger.alert-dismissible")
	private WebElement LoginErrorMsg;
	@FindBy(css = "#content > h2:nth-child(1)")
	private WebElement validLoginLable;
	@FindBy(css = "#content h1")
	private WebElement validLogoutLable;
	@FindBy(css = ".alert.alert-danger.alert-dismissible")
	private WebElement loginErrorLable;

	//Login the system
	public void login(String username, String password) {
		fillText(userNameField, username);
		fillText(passwordField, password);
		click(submitBtn);
	}
	
	//Logout the system
	public void logout() {
		click(accountBtn);
		click(logoutBtn);
	}
	
	//Validation
	public  String getValidLginLable() {
		return getText(validLoginLable);
	}
	
	//Validation
	public String getValidLogoutLable() {
		return getText(validLogoutLable);
	}
	
	//Validation
	public String getInvalidErrorLable() {
		return getText(loginErrorLable);
	}
}
