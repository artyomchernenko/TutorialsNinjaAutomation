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
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

	@Test
	@Description("Login with valid user name and password")
	@Severity(SeverityLevel.CRITICAL)
	public void tc01_loginValid(){
		mainPage.EnterLoginPage();
		loginPage.login("aptem1986@mail.ru", "Onlyforproject");
		//Validation
		String expected = "My Account";
		String actual = loginPage.getValidLoginLable();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test
	@Description("Logout the system")
	@Severity(SeverityLevel.NORMAL)
	public void tc02_logout() {
		loginPage.logout();
		//Validation
		String expected = "Account Logout";
		String actual = loginPage.getValidLogoutLable();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test
	@Description("Login with invalid username and password")
	@Severity(SeverityLevel.NORMAL)
	public void tc03_loginInvalid() {
		mainPage.EnterLoginPage();
		loginPage.login("ApTeM", "12345678");
		//Validation
		String expected = "Warning: No match for E-Mail Address and/or Password.";
		String actual = loginPage.getInvalidErrorLable();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test(dataProvider = "getData")
	@Description("Login with 4 different usernames and passwords (1 Valid and 3 invalid)")
	@Severity(SeverityLevel.CRITICAL)
	public void tc04_fourDifferentLogins(String username, String password) {
		mainPage.EnterLoginPage();
		loginPage.login(username, password);
		//Validation
		if (username.equals("aptem1986@mail.ru") && password.equals("Onlyforproject")) {
			String expected = "My Account";
			String actual = loginPage.getValidLoginLable();
			AssertJUnit.assertEquals(actual, expected);
		} else {
			String expectedError1 = "Warning: No match for E-Mail Address and/or Password.";
			String expectedError2 = "Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
			String actualError = loginPage.getInvalidErrorLable();
			// Check if the error message contains at least one or both expected messages
			boolean containsError1 = actualError.contains(expectedError1);
			boolean containsError2 = actualError.contains(expectedError2);
			boolean isErrorValid = containsError1 || containsError2;
			AssertJUnit.assertTrue(isErrorValid);
		}
	}

	@DataProvider
	public Object[][] getData(){
		Object[][] myData = {
				{"Moshe", "123"},
				{"Shaul", "qwer"},
				{"Alex", "jwhdfkewgf89"},
				{"aptem1986@mail.ru","Onlyforproject"},

		};
		return myData;
	}
}
