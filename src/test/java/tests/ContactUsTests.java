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

public class ContactUsTests extends BaseTest{


	@Test(description = "Fill the Contact Us Form")
	public void tc01_fillTheContuctUsForm() {
		mainPage.fillContactUsForm("Artyom", "aptem1986@mail.ru", "Your Site Is good!!!");
		//Validation
		String expected = "Contact Us";
		String actual = mainPage.contactUsLable();
		AssertJUnit.assertEquals(actual, expected);
	}
}
