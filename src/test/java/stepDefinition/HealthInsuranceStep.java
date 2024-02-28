package stepDefinition;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.Logger;
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
	Logger logger = BaseClass.getLogger();

	@When("user hover on More section")
	public void user_hover_on_more_section() {
		// Write code here that turns the phrase above into concrete actions
		health = new HealthInsurancePage(BaseClass.getDriver());
		health.hoverMore();
		logger.info("Hover More");
	}

	@When("user clicks on Health Insurance")
	public void user_clicks_on_health_insurance() {
		// Write code here that turns the phrase above into concrete actions
		health.clickHealthInsurance();
		logger.info("Clicked Health Insurance");
	}

	@Then("user fill details")
	public void user_fill_details() throws InterruptedException, IOException {
		// Write code here that turns the phrase above into concrete actions
		health.fillBasicDetails();
		logger.info("Filled Health Insurance basic details");
	}

	@Then("user display all health insurance brand name")
	public void user_display_all_health_insurance_brand_name() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		health.printHealthInsuranceBrandName();
		logger.info("Printed Health Insurance brand names");

		List<String> insuranceBrandName = health.getHealthInsuranceBrandName();
		WriteExcelData.writeHealthInsuranceBrandName(insuranceBrandName, filePath);
	}

	@Then("user display all health insurance plan")
	public void user_display_all_health_insurance_plan() {
		// Write code here that turns the phrase above into concrete actions
		health.printInsurancePlan();
		logger.info("Printed Health Insurance plan");

		List<String> insurancePlan = health.getInsurancePlan();
		WriteExcelData.writeHealthInsurancePlan(insurancePlan, filePath);
	}

}
