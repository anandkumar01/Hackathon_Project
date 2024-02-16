package stepDefinition;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BikeDetailsPage;
import utilities.WriteExcelData;

public class BikeDetailStep {

	WebDriver driver;
	BikeDetailsPage bike;
	String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.xlsx";

	@Given("user navigates to zigwheels website")
	public void user_navigates_to_zigwheels_website() {
		// Write code here that turns the phrase above into concrete actions
		bike = new BikeDetailsPage(BaseClass.getDriver());
	}

	@When("user hover on New Bikes")
	public void user_hover_on_new_bikes() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
//		Thread.sleep(10000);
		bike.hoverNewBikes();
	}

	@Then("user clicks on Upcoming Bikes")
	public void user_clicks_on_upcoming_bikes() {
		// Write code here that turns the phrase above into concrete actions
		bike.clickUpcomingBikes();
	}

	@When("user selects manufacturer name")
	public void user_selects_manufacturer_name() {
		// Write code here that turns the phrase above into concrete actions
		bike.selectManufacturer();
	}

	@Then("user display all upcoming boke details")
	public void user_display_all_upcoming_boke_details() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		bike.scrollToViewMore();
		bike.printUpcomingBikeDetails();

		LinkedHashMap<String, List<String>> bikeDetailsMap = bike.getUpcomingBikeDetails();
		WriteExcelData.writeBikeDetails(bikeDetailsMap, filePath);
	}

}
