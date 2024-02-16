package stepDefinition;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	WebDriver driver;
	Properties p;

	@Before
	public void setup() throws IOException {
		p = BaseClass.getProperties();
		driver = BaseClass.initilizeBrowser();
		driver.get(p.getProperty("baseUrl"));
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
