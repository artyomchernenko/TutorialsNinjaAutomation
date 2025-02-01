package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageobjects.CheckOutPage;
import pageobjects.LaptopPage;
import pageobjects.LaptopsAndNotebooksPage;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.MyCartPage;
import pageobjects.ProductComparisonPage;
import utils.Utils;


public class BaseTest {
	WebDriver driver;
	LoginPage loginPage;
	LaptopsAndNotebooksPage laptopsAndNotebooksPage;
	MainPage mainPage;
	LaptopPage laptopPage;
	MyCartPage myCartPage;
	CheckOutPage checkOutPage;
	ProductComparisonPage productComparisonPage;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Utils.readProperty("url"));
		loginPage = new LoginPage(driver);
		laptopsAndNotebooksPage = new LaptopsAndNotebooksPage(driver);
		mainPage = new MainPage(driver);
		laptopPage = new LaptopPage(driver);
		myCartPage = new MyCartPage(driver);
		checkOutPage = new CheckOutPage(driver);
		productComparisonPage = new ProductComparisonPage(driver);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
   }
