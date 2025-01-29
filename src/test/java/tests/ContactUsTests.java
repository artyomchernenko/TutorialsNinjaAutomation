package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ContactUsTests extends BaseTest{

	@Test
	@Description("Fill the Contact Us Form")
	@Severity(SeverityLevel.NORMAL)
	public void tc01_fillTheContuctUsForm() {
		mainPage.fillContactUsForm("Artyom", "aptem1986@mail.ru", "Your Site Is good!!!");
		//Validation
		String expected = "Contact Us";
		String actual = mainPage.contactUsLable();
		AssertJUnit.assertEquals(actual, expected);
	}
}
