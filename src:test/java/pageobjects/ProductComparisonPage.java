package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductComparisonPage extends BasePage{

	public ProductComparisonPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = ".btn.btn-danger.btn-block")
	private WebElement removeFromComperationBtn;

	//Remove all laptops from comperation one by one
	public void removeAllDifferentLaptopsFromComperation() {
		List <WebElement> list = driver.findElements(By.cssSelector(".img-thumbnail"));
		for (WebElement el : list) {
			while (el != null) {
				click(removeFromComperationBtn);
				break;
			}
		}
	}
	
	//Remove laptop from comperation by model name
	public void chooseAndRemoveFromComperation(String name){
		List <WebElement> list = driver.findElements(By.cssSelector("td:nth-child(2) > a"));
		for (WebElement el : list) {
			if (el.getText().equalsIgnoreCase(name)) {
				click(removeFromComperationBtn);
				break;
			}
		}
	}
}
