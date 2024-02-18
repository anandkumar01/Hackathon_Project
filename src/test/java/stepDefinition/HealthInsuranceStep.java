package stepDefinition;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HealthInsurancePage;

public class HealthInsuranceStep {
	WebDriver driver;
	HealthInsurancePage health;

	@When("user hover on More section")
	public void user_hover_on_more_section() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		health = new HealthInsurancePage(BaseClass.getDriver());
		health.hoverMore();
	}

	@When("user clicks on Health Insurance")
	public void user_clicks_on_health_insurance() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		health.clickHealthInsurance();
	}

	@Then("user fill details")
	public void user_fill_details() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		health.fillBasicDetails();
	}

	@Then("user store all health insurance plan")
	public void user_store_all_health_insurance_plan() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		health.printHealthInsuranceBrandName();
	}

}
