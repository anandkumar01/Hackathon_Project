package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	public void explicitWait(WebElement element) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(d -> element.isDisplayed());
	}

	public void hoverOnElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void hoverUsedCars() {
		explicitWait(usedcar);
		hoverOnElement(usedcar);
	}

	public void clickChennai() {
		chennai.click();
	}

	public void scrollToPopularModel() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scroll);
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
