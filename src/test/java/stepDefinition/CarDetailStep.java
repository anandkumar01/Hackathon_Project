package stepDefinition;

import java.util.LinkedHashMap;
import java.util.List;

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

	@When("user hover on New Cars")
	public void user_hover_on_new_cars() {
		// Write code here that turns the phrase above into concrete actions
		car = new CarDetailsPage(BaseClass.getDriver());
		car.hoverNewCars();
	}

	@Then("user clicks on Upcoming Cars")
	public void user_clicks_on_upcoming_cars() {
		// Write code here that turns the phrase above into concrete actions
		car.clickUpcomingCars();
	}

	@When("user select {string} manufacturer name")
	public void user_select_manufacturer_name(String manufacturer) {
		// Write code here that turns the phrase above into concrete actions
		car.selectManufacturer(manufacturer);
	}

	@Then("user display all upcoming car details")
	public void user_display_all_upcoming_car_details() {
		// Write code here that turns the phrase above into concrete actions
		car.clickToViewMore();
		car.printUpcomingCarDetails();

		LinkedHashMap<String, List<String>> carDetailsMap = car.getUpcomingCarDetails();
		WriteExcelData.writeCarDetails(carDetailsMap, filePath);
	}
}
