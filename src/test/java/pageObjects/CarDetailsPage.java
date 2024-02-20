package pageObjects;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CarDetailsPage extends BasePage {

	public CarDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Initialising LinkedHashMap to store car details in ordered way
	LinkedHashMap<String, List<String>> carDetailsMap = new LinkedHashMap<>();

	// Web elements for different functionality
	@FindBy(xpath = "//a[contains(text(), \"New Cars\")]")
	WebElement newcars;

	@FindBy(xpath = "//span[contains(text(), \"Upcoming Cars\")]")
	WebElement upcomingcar;

	@FindBy(xpath = "//select[@id='makeId']")
	WebElement selectmanufacturer;

	@FindBy(xpath = "//span[@data-track-label='view-more-models-button']")
	WebElement scroll;

	@FindBy(xpath = "//span[@class='zw-cmn-loadMore']")
	WebElement viewmore;

	// Storing list of web elements for car name
	@FindBy(xpath = "//a[@data-track-label='model-name']")
	List<WebElement> carnames;

	// Storing list of web elements for car price
	@FindBy(xpath = "//a[@data-track-label='model-name']/following-sibling::div[1]")
	List<WebElement> carprices;

	// Storing list of web elements for car launch date
	@FindBy(xpath = "//a[@data-track-label='model-name']/following-sibling::div[2]")
	List<WebElement> carlaunchdate;

	public void hoverOnElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void hoverNewCars() throws InterruptedException {
		Thread.sleep(10000);
		hoverOnElement(newcars);
	}

	public void clickUpcomingCars() {
		upcomingcar.click();
	}

	public void selectManufacturer() {
		Select select = new Select(selectmanufacturer);
		select.selectByVisibleText("Tata");
	}

	public void scrollToViewMore() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", viewmore);
	}

	public LinkedHashMap<String, List<String>> getUpcomingCarDetails() {
		for (int i = 0; i < carnames.size(); i++) {
			String carname = carnames.get(i).getText();
			String carprice = carprices.get(i).getText();
			String launchdate = carlaunchdate.get(i).getText();

			// Create a list to store details
			List<String> detailsList = new ArrayList<>();
			detailsList.add(carname);
			detailsList.add(carprice);
			detailsList.add(launchdate);

			// Use 'Cardetails' as the key and the list of details as the value
			String carDetailsKey = "CarDetails" + (i + 1);
			carDetailsMap.put(carDetailsKey, detailsList);

		}
		return carDetailsMap;
	}

	public void printUpcomingCarDetails() {
		LinkedHashMap<String, List<String>> carDetails = getUpcomingCarDetails();

		System.out.println("\nAll upcoming car details are displayed below :");
		int i = 1;
		for (String key : carDetails.keySet()) {
			List<String> detailsList = carDetails.get(key);
			System.out.println("\nCar Details" + (i) + ": " + detailsList);
			i++;
		}
	}
}