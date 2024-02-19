package stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HealthInsurancePage;
import utilities.WriteExcelData;

public class HealthInsuranceStep {
	WebDriver driver;
	HealthInsurancePage health;
	String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.xlsx";

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
	public void user_fill_details() throws InterruptedException, IOException {
		// Write code here that turns the phrase above into concrete actions
		health.fillBasicDetails();
	}

	@Then("user display all health insurance brand name")
	public void user_display_all_health_insurance_brand_name() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		health.printHealthInsuranceBrandName();
		List<String> insuranceBrandName = health.getHealthInsuranceBrandName();
		WriteExcelData.writeHealthInsuranceBrandName(insuranceBrandName, filePath);
	}

	@Then("user display all health insurance plan")
	public void user_display_all_health_insurance_plan() {
		// Write code here that turns the phrase above into concrete actions
		health.printInsurancePlan();
		List<String> insurancePlan = health.getInsurancePlan();
		WriteExcelData.writeHealthInsurancePlan(insurancePlan, filePath);
	}

}
