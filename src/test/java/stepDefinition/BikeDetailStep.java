package stepDefinition;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.logging.log4j.Logger;
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
	Logger logger = BaseClass.getLogger();

	@Given("user navigates to zigwheels website")
	public void user_navigates_to_zigwheels_website() {
		// Write code here that turns the phrase above into concrete actions
		bike = new BikeDetailsPage(BaseClass.getDriver());
	}

	@When("user hover on {string} as new bikes")
	public void user_hover_on_as_new_bikes(String newBikes) {
		// Write code here that turns the phrase above into concrete actions
		bike.hoverNewBikes(newBikes);
		logger.info("Hover on New Bikes");
	}

	@Then("user clicks on Upcoming Bikes")
	public void user_clicks_on_upcoming_bikes() {
		// Write code here that turns the phrase above into concrete actions
		bike.clickUpcomingBikes();
		logger.info("Clicked upcomming bikes");
	}

	@When("user selects manufacturer name as {string}")
	public void user_selects_manufacturer_name_as(String manufacturer) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		bike.selectManufacturer(manufacturer);
		logger.info("Selected manufacturer name");
	}

	@Then("user display all upcoming bike details")
	public void user_display_all_upcoming_boke_details() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		bike.clickToViewMore();
		logger.info("Clicked to view more");

		bike.printUpcomingBikeDetails();
		logger.info("Printed upcomming bike details");

		LinkedHashMap<String, List<String>> bikeDetailsMap = bike.getUpcomingBikeDetails();
		WriteExcelData.writeBikeDetails(bikeDetailsMap, filePath);
	}

}
