package stepDefinition;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BikeDetailsPage;
import pageObjects.CarDetailsPage;
import pageObjects.HealthInsurancePage;
import pageObjects.InvalidGoogleLoginPage;
import pageObjects.UsedCarPage;

public class SmokeTestingSteps {
	WebDriver driver;
	BikeDetailsPage bike;
	CarDetailsPage car;
	UsedCarPage usedcar;
	HealthInsurancePage health;
	InvalidGoogleLoginPage google;
	Logger logger = BaseClass.getLogger();

	@Given("user navigates to the zigwheels website")
	public void user_navigates_to_the_zigwheels_website() {
		// Write code here that turns the phrase above into concrete actions
		bike = new BikeDetailsPage(BaseClass.getDriver());
	}

	@Then("user should see a well-rendered homepage")
	public void user_should_see_a_well_rendered_homepage() {
		// Write code here that turns the phrase above into concrete actions
		bike = new BikeDetailsPage(BaseClass.getDriver());
		bike.zigwheelspage();
		logger.info("Zigwheels website launched");
	}

	@Given("user is currently on the zigwheels website")
	public void user_is_currently_on_the_zigwheels_website() {
		// Write code here that turns the phrase above into concrete actions
		google = new InvalidGoogleLoginPage(BaseClass.getDriver());
	}

	@Then("checks whether login or signup is present in the zigwheels tab")
	public void checks_whether_login_signup_is_present_in_the_zigwheels_tab() {
		// Write code here that turns the phrase above into concrete actions
		google.checkLoginButton();
	}

	@When("user click the login or signup button in homepage")
	public void user_click_the_login_signup_button_in_homepage() {
		// Write code here that turns the phrase above into concrete actions
		google.clickLoginButton();
	}

	@Then("user should be directed to the login or register tab")
	public void user_should_be_directed_to_the_login_register_tab() {
		// Write code here that turns the phrase above into concrete actions
		google.checkGoogleOption();
	}

	@Then("check whether New Bikes is present in the header section")
	public void check_whether_new_bikes_is_present_in_the_header_section() {
		// Write code here that turns the phrase above into concrete actions
		bike = new BikeDetailsPage(BaseClass.getDriver());
		bike.checkNewBikes();
		logger.info("New Bikes displayed");
	}

	@When("user hovers the mouse over the {string}")
	public void user_hovers_the_mouse_over_the_as(String newBikes) {
		// Write code here that turns the phrase above into concrete actions
		bike.hoverNewBikes(newBikes);
		logger.info("Hover on New Bikes");
	}

	@Then("check whether upcoming bikes is present in dropdown")
	public void check_whether_upcoming_bikes_is_present_in_dropdown() {
		// Write code here that turns the phrase above into concrete actions
		bike.checkUpcomingBikes();
		logger.info("Upcoming Bikes displayed");
	}

	@Then("user should see relevant search results for Honda bikes")
	public void user_should_see_relevant_search_results_for_honda_bikes() {
		// Write code here that turns the phrase above into concrete actions
		bike.clickUpcomingBikes();
		logger.info("Clicked upcomming bikes");

		bike.validateAllBikes();
		logger.info("All Bikes displayed");
	}

	@Then("check whether New Cars is present in the header section")
	public void check_whether_new_cars_is_present_in_the_header_section() {
		// Write code here that turns the phrase above into concrete actions
		car = new CarDetailsPage(BaseClass.getDriver());
		car.checkNewCars();
		logger.info("New Cars displayed");
	}

	@When("user hovers the mouse over the {string} as new cars")
	public void user_hovers_the_mouse_over_the_as_new_cars(String newCars) {
		// Write code here that turns the phrase above into concrete actions
		car.hoverNewCars(newCars);
		logger.info("Hover on New Cars");
	}

	@Then("check whether upcoming cars is present in dropdown")
	public void check_whether_upcoming_cars_is_present_in_dropdown() {
		// Write code here that turns the phrase above into concrete actions
		car.checkUpcomingCars();
		logger.info("Upcoming Bikes displayed");
	}

	@Then("user should see relevant search results for Tata Cars")
	public void user_should_see_relevant_search_results_for_tata_cars() {
		// Write code here that turns the phrase above into concrete actions
		car.clickUpcomingCars();
		logger.info("Clicked upcomming cars");

		car.validateAllCars();
		logger.info("All Cars displayed");
	}

	@When("user hovers on Used Cars")
	public void user_hovers_on_used_cars() {
		// Write code here that turns the phrase above into concrete actions
		usedcar = new UsedCarPage(BaseClass.getDriver());
		usedcar.hoverUsedCars();
		logger.info("Hover on Used Cars");

	}

	@Then("check whether Chennai city is present in the list")
	public void check_whether_chennai_city_is_present_in_the_list() {
		// Write code here that turns the phrase above into concrete actions
		usedcar.checkChennaiCity();
		logger.info("Chennai city displayed");
	}

	@When("user click at Chennai option")
	public void user_click_at_chennai_option() {
		// Write code here that turns the phrase above into concrete actions
		usedcar.clickChennai();
		logger.info("Clicked Chennai city");
	}

	@Then("user should see relevant search results for Used Cars in Chennai")
	public void user_should_see_relevant_search_results_for_used_cars_in_chennai() {
		// Write code here that turns the phrase above into concrete actions
		usedcar.validateUsedCarsForChennai();
		logger.info("All used cars displayed");
	}

	@When("user hovers the mouse over the More section")
	public void user_hovers_the_mouse_over_the_more_section() {
		// Write code here that turns the phrase above into concrete actions
		health = new HealthInsurancePage(BaseClass.getDriver());
		health.hoverMore();
		logger.info("Hover on More");
	}

	@Then("check whether Health Insurance is present in the list")
	public void check_whether_health_insurance_is_present_in_the_list() {
		// Write code here that turns the phrase above into concrete actions
		health.checkHealthInsurance();
		logger.info("Health Insurance displayed");
	}

}
