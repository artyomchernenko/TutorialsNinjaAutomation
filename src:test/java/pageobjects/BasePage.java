package pageobjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	String mainWindow;
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Fill Text
	public void fillText(WebElement el, String text) {
		wait.until(ExpectedConditions.visibilityOf(el));
		highlightElement(el, "lime");
		el.clear();
		el.sendKeys(text);
	}
	
	//Click
	public void click(WebElement el) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
		highlightElement(el, "lime");
		el.click();
	}
	
	//Wait until element is visible
	public void waitForElementToBeVisible(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el));
	}
	
	//Sleep for few mills
	public void sleep(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Get text
	public String getText(WebElement el) {
		highlightElement(el, "orange");
		return el.getText();
	}
	
	//Change element colour
	protected void highlightElement(WebElement element, String color) {
		//keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "border: 1px solid " + color + ";background-color:" + color +";"+ originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change the style
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
				element);

		// Change the style back after few miliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);
	}
	
	//Move to new window
	public void moveToNewWindow() {
		mainWindow = driver.getWindowHandle();
		Set <String> list = driver.getWindowHandles();
		for (String win : list) {
			driver.switchTo().window(win);
		}
	}
	
	//Back to main window
	public void backToMainWindow() {
		driver.close();
		driver.switchTo().window(mainWindow);
	}
	
	//Select from dropdown(visible Text)
	public void selectByVisibleText(WebElement el, String visibleText) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
		highlightElement(el, "orange");
		Select select = new Select(el);
		select.selectByVisibleText(visibleText);
	}
	
	//Select from dropdown(value)
	public void selectByValue(WebElement el, String value) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
		highlightElement(el, "orange");
		Select select = new Select(el);
		select.selectByValue(value);
	}
}
