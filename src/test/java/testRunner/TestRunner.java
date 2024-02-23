package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { ".\\src\\test\\resources\\FeatureFiles" }, glue = { "stepDefinition" }, plugin = {
		"pretty", "html:reports/myreport.html", "json:target/report.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, dryRun = false, monochrome = true, publish = true, tags = "@sanity")

public class TestRunner extends AbstractTestNGCucumberTests {

}