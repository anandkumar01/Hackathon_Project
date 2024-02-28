package stepDefinition;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CarDetailsPage;
import utilities.WriteExcelData;

public class CarDetailStep {

	WebDriver driver;
	CarDetailsPage car;
	String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.xlsx";
	Logger logger = BaseClass.getLogger();

	@When("user hover on {string} as new cars")
	public void user_hover_on_as_new_cars(String newCars) {
		// Write code here that turns the phrase above into concrete actions
		car = new CarDetailsPage(BaseClass.getDriver());
		car.hoverNewCars(newCars);
		logger.info("Hover on New Cars");
	}

	@Then("user clicks on Upcoming Cars")
	public void user_clicks_on_upcoming_cars() {
		// Write code here that turns the phrase above into concrete actions
		car.clickUpcomingCars();
		logger.info("Clicked upcomming cars");
	}

	@When("user select manufacturer name as {string}")
	public void user_select_manufacturer_name_as(String manufacturer) {
		// Write code here that turns the phrase above into concrete actions
		car.selectManufacturer(manufacturer);
		logger.info("Selected manufacturer name");
	}

	@Then("user display all upcoming car details")
	public void user_display_all_upcoming_car_details() {
		// Write code here that turns the phrase above into concrete actions
		car.clickToViewMore();
		logger.info("Clicked view more option");

		car.printUpcomingCarDetails();
		logger.info("Printed upcomming car details");

		LinkedHashMap<String, List<String>> carDetailsMap = car.getUpcomingCarDetails();
		WriteExcelData.writeCarDetails(carDetailsMap, filePath);
	}
}
