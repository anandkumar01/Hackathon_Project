package testRunner;

//import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features = { ".\\src\\test\\resources\\FeatureFiles" }, glue = { "stepDefinition" }, plugin = {
		"pretty", "html:reports/myreport.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, dryRun = false, monochrome = true, publish = true, tags = "@sanity")

public class TestRunner extends AbstractTestNGCucumberTests {

}