package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsedCarPage extends BasePage {

	public UsedCarPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Initialising list to store all popular car model name
	List<String> popularCarModels = new ArrayList<>();

	// Web elements for different functionality
	@FindBy(xpath = "//a[contains(text(), \'Used Cars\')]")
	WebElement usedcar;

	@FindBy(xpath = "//span[contains(text(), \'Chennai\')]")
	WebElement chennai;

	@FindBy(xpath = "//div[contains(text(), 'Popular Models')]")
	WebElement scroll;

	// Storing list of web elements for popular car model
	@FindBy(xpath = "//li[starts-with(@id, 'mmvLi')]//label")
	List<WebElement> popularcarmodel;

	public void hoverUsedCars() {
		explicitWait(usedcar);
		hoverOnElement(usedcar);
	}

	public void clickChennai() {
		chennai.click();
	}

	public void scrollToPopularModel() {
		scrollToElement(scroll);
	}

	public List<String> getPopularCarModels() {
		popularCarModels.clear();
		for (WebElement ele : popularcarmodel) {
			String model = ele.getText();
			popularCarModels.add(model);
		}
		return popularCarModels;
	}

	public void printPopularCarModels() {
		List<String> carModel = getPopularCarModels();

		System.out.println("\nAll popular car models are displayed below :");
		for (int i = 0; i < carModel.size(); i++) {
			System.out.println((i + 1) + ". " + carModel.get(i));
		}
	}
}
