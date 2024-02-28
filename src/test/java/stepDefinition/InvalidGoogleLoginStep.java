package stepDefinition;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.InvalidGoogleLoginPage;

public class InvalidGoogleLoginStep {
	WebDriver driver;
	InvalidGoogleLoginPage login;
	Logger logger = BaseClass.getLogger();

	@When("user clicks to signup button")
	public void user_clicks_to_signup_button() {
		// Write code here that turns the phrase above into concrete actions
		login = new InvalidGoogleLoginPage(BaseClass.getDriver());
		login.clickLoginButton();
		logger.info("Clicked Login button");
	}

	@Then("user clicks to the google option")
	public void user_clicks_to_the_google_option() {
		// Write code here that turns the phrase above into concrete actions
		login.clickGoogleAccount();
		logger.info("Clicked Google Account");
	}

	@When("user enter invalid account details")
	public void user_enter_invalid_account_details() {
		// Write code here that turns the phrase above into concrete actions
		login.enterRandomEmail();
		logger.info("Entered random email");
	}

	@Then("user captures error message")
	public void user_captures_error_message() {
		// Write code here that turns the phrase above into concrete actions
		login.printErrorMessage();
		logger.info("Error message printed");
	}
}
