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

public class FooterTests extends BaseTest{

	@Test(description = "Click on About Us")
	public void tc01_choseAboutUs() {
		mainPage.choseAboutUs();
		//Validation
		String expected = "About Us";
		String actual = mainPage.aboutUsLable();
		AssertJUnit.assertEquals(actual, expected);
	}
	
	@Test(description = "Click on Choose Delivery Information")
	public void tc02_choseDeliveryInformation() {
		mainPage.choseDeliveryInformation();
		//Validation
		String expected = "Delivery Information";
		String actual = mainPage.chooseDeliveryInfoLable();
		AssertJUnit.assertEquals(actual, expected);
	}
	
	@Test(description = "Click on Privacy Policy")
	public void tc03_chosePrivacyPolicy() {
		mainPage.chosePrivacyPolicy();
		//Validation
		String expected = "Privacy Policy";
		String actual = mainPage.privacyPolicyLable();
		AssertJUnit.assertEquals(actual, expected);
	}
	
	@Test(description = "Click on Term Conditions")
	public void tc04_coseTermConditions() {
		mainPage.choseTermsConditions();
		//Validation
		String expected = "Terms & Conditions";
		String actual = mainPage.termConditionsLable();
		AssertJUnit.assertEquals(actual, expected);
	}
}
