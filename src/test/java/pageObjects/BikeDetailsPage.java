package pageObjects;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BikeDetailsPage extends BasePage {

	Properties p;

	public BikeDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	LinkedHashMap<String, List<String>> bikeDetailsMap = new LinkedHashMap<>();

	@FindBy(xpath = "//a[contains(text(), \"New Bikes\")]")
	WebElement newbikes;

	@FindBy(xpath = "//span[contains(text(), \"Upcoming Bikes\")]")
	WebElement upcomingbike;

	@FindBy(xpath = "//select[@id='makeId']")
	WebElement selectmanufacturer;

	@FindBy(xpath = "//span[@data-track-label='view-more-models-button']")
	WebElement scroll;

	@FindBy(xpath = "//span[@class='zw-cmn-loadMore']")
	WebElement viewmore;

	@FindBy(xpath = "//a[@data-track-label='model-name']")
	List<WebElement> bikenames;

	@FindBy(xpath = "//a[@data-track-label='model-name']/following-sibling::div[1]")
	List<WebElement> bikeprices;

	@FindBy(xpath = "//a[@data-track-label='model-name']/following-sibling::div[2]")
	List<WebElement> bikelaunchdate;

	public void hoverNewBikes() {
		Actions action = new Actions(driver);
		action.moveToElement(newbikes).build().perform();
	}

	public void clickUpcomingBikes() {
		upcomingbike.click();
	}

	public void selectManufacturer() {
		Select select = new Select(selectmanufacturer);
		select.selectByVisibleText("Honda");

	}

	public void scrollToViewMore() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", viewmore);
	}

	public LinkedHashMap<String, List<String>> getUpcomingBikeDetails() {
		for (int i = 0; i < bikenames.size(); i++) {
			String bikename = bikenames.get(i).getText();
			String bikeprice = bikeprices.get(i).getText();
			String launchdate = bikelaunchdate.get(i).getText();

			// Convert bikeprice to a numeric value for comparison
			String price = bikeprice.replaceAll("[^\\d.]", "").replaceFirst("\\.(?=.*\\.)", "");
			double priceValue = Double.parseDouble(price);

			// Check if the price is less than 4 lakhs
			if (priceValue < 4) {

				// Create a list to store details
				List<String> detailsList = new ArrayList<>();
				detailsList.add(bikename);
				detailsList.add(bikeprice);
				detailsList.add(launchdate);

				// Use 'Bikedetails' as the key and the list of details as the value
				String bikeDetailsKey = "BikeDetails" + (i + 1);
				bikeDetailsMap.put(bikeDetailsKey, detailsList);
			}
		}
		return bikeDetailsMap;
	}

	public void printUpcomingBikeDetails() {
		LinkedHashMap<String, List<String>> bikeDetails = getUpcomingBikeDetails();

		System.out.println("All upcoming bike details under 4 Lacks :");
		int i = 1;
		for (String key : bikeDetails.keySet()) {
			List<String> detailsList = bikeDetails.get(key);
			System.out.println("\nBike Details" + (i) + ": " + detailsList);
			i++;
		}
	}

}
