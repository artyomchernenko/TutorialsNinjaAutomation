package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class FooterTests extends BaseTest{

	@Test
	@Description("Click on About Us")
	@Severity(SeverityLevel.NORMAL)
	public void tc01_choseAboutUs() {
		mainPage.choseAboutUs();
		//Validation
		String expected = "About Us";
		String actual = mainPage.aboutUsLable();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test
	@Description("Click on Choose Delivery Information")
	@Severity(SeverityLevel.NORMAL)
	public void tc02_choseDeliveryInformation() {
		mainPage.choseDeliveryInformation();
		//Validation
		String expected = "Delivery Information";
		String actual = mainPage.chooseDeliveryInfoLable();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test
	@Description("Click on Privacy Policy")
	@Severity(SeverityLevel.NORMAL)
	public void tc03_chosePrivacyPolicy() {
		mainPage.chosePrivacyPolicy();
		//Validation
		String expected = "Privacy Policy";
		String actual = mainPage.privacyPolicyLable();
		AssertJUnit.assertEquals(actual, expected);
	}

	@Test
	@Description("Click on Term Conditions")
	@Severity(SeverityLevel.NORMAL)
	public void tc04_choseTermConditions() {
		mainPage.choseTermsConditions();
		//Validation
		String expected = "Terms & Conditions";
		String actual = mainPage.termConditionsLable();
		AssertJUnit.assertEquals(actual, expected);
	}
}
