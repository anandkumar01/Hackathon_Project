package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
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
	List<List<String>> carDetails = new ArrayList<>();

	// Web elements for different functionality
	@FindBy(xpath = "//a[contains(text(), \'Used Cars\')]")
	WebElement usedcar;

	@FindBy(xpath = "//span[contains(text(), \'Chennai\')]")
	WebElement chennai;

	@FindBy(xpath = "//span[contains(text(), 'Brand and Model')]")
	WebElement scroll;

	// Storing list of web elements for popular car model
	@FindBy(xpath = "//li[starts-with(@id, 'mmvLi')]//label")
	List<WebElement> popularcarmodel;

	@FindBy(xpath = "(//div[@class=\"gsc_thin_scroll\"]//input)[1]")
	WebElement checkbox;

	@FindBy(xpath = "//div[@class=\"gsc_thin_scroll\"]//input")
	List<WebElement> allCheckbox;

	@FindBy(xpath = "//div[@id=\"thatsAllFolks\"]")
	WebElement lastscroll;

	@FindBy(xpath = "//a[@data-track-label=\"Car-name\"]")
	List<WebElement> carNames;

	@FindBy(xpath = "//span[starts-with(@class,'zw-cmn-price')]")
	List<WebElement> carPrices;

	@FindBy(xpath = "//li[@itemprop='fuelType']")
	List<WebElement> fuelTypes;

	@FindBy(xpath = "//li[@itemprop='fuelType']/following-sibling::li[1]")
	List<WebElement> kilometers;

	@FindBy(xpath = "//li[@itemprop='fuelType']/following-sibling::li[2]")
	List<WebElement> modelYears;

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

	public void clickCheckBox(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public List<List<List<String>>> getAllPopularCarModelDetails() throws InterruptedException {
		List<List<List<String>>> allCarDetails = new ArrayList<>();

		for (int i = 0; i < allCheckbox.size(); i++) {
			List<List<String>> carDetails = getPopularCarModelDetails(i);
			allCarDetails.add(carDetails);
		}
		return allCarDetails;
	}

	public List<List<String>> getPopularCarModelDetails(int checkboxIndex) throws InterruptedException {
		WebElement checkbox = allCheckbox.get(checkboxIndex);
		clickCheckBox(checkbox);

		Thread.sleep(5000);
		scrollToElement(lastscroll);

		List<String> carDetail = new ArrayList<>();
		List<List<String>> carDetails = new ArrayList<>();

		for (int i = 0; i < carNames.size(); i++) {
			carDetail.clear();
			String carName = carNames.get(i).getText();
			carDetail.add(carName);

			String carPrice = carPrices.get(i).getText();
			carDetail.add(carPrice);

			String fuelPrice = fuelTypes.get(i).getText();
			carDetail.add(fuelPrice);

			String km = kilometers.get(i).getText();
			carDetail.add(km);

			String modelYear = modelYears.get(i).getText();
			carDetail.add(modelYear);

			carDetails.add(new ArrayList<>(carDetail));
		}

		// Uncheck the checkbox after processing
		clickCheckBox(checkbox);
		Thread.sleep(5000);

		return carDetails;
	}

	public void printAllPopularCarModelDetails() throws InterruptedException {
		List<List<List<String>>> allCarDetails = getAllPopularCarModelDetails();

		for (int i = 0; i < allCarDetails.size(); i++) {
			List<List<String>> carDetails = allCarDetails.get(i);

			for (int j = 0; j < carDetails.size(); j++) {
				System.out.println(
						"\nCarDetails for Checkbox " + (i + 1) + ", Set " + (j + 1) + ": " + carDetails.get(j));
			}
		}
	}

}
