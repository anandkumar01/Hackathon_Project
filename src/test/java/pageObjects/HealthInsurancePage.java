package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;

public class HealthInsurancePage extends BasePage {
	Properties p;

	public HealthInsurancePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	List<String> brandName = new ArrayList<>();
	List<String> insurancePlan = new ArrayList<>();

	@FindBy(xpath = "//div[@id=\"headerNewNavWrap\"]//li[9]/a")
	WebElement moresection;

	@FindBy(xpath = "//span[contains(text(), 'Health Insurance')]")
	WebElement healthinsurance;

	@FindBy(xpath = "//div[starts-with(@class, 'home_formSection')]")
	WebElement scroll;

	@FindBy(xpath = "(//ul[starts-with(@class, 'malefemalewrap')]//i)[1]")
	WebElement checkmale;

	@FindBy(xpath = "(//input[@name='name'])[1]")
	WebElement inputname;

	@FindBy(xpath = "(//input[@name='mobile'])[1]")
	WebElement inputphone;

	@FindBy(xpath = "(//button[@name='submitBtn'])[1]")
	WebElement viewplan;

	@FindBy(xpath = "(//span[@class='memberIcon']/following-sibling::label)[1]")
	WebElement checkyou;

	@FindBy(xpath = "//button[@class='button']")
	WebElement continuebtn;

	@FindBy(xpath = "//input[@id='age_primary']")
	WebElement clickage;

	@FindBy(xpath = "//li[@data-value='22']")
	WebElement selectage;

	@FindBy(xpath = "//input[@id='city']")
	WebElement inputpincode;

	@FindBy(xpath = "//button[@title='Continue']")
	WebElement continueBtn;

	@FindBy(xpath = "//div[@class='diseYesNo']//span")
	WebElement checkbox;

	@FindBy(xpath = "//button[@class='button  ']")
	WebElement continuebtnn;

	@FindBy(xpath = "//div[starts-with(@class, 'quotesListWrapper')]/div/div/div[2]/div/div/h2/../div[1]")
	List<WebElement> brandname;

	@FindBy(xpath = "//div[starts-with(@class, 'quotesListWrapper')]/div/div/div[2]/div/div[2]/div[2]/div//button/span")
	List<WebElement> insuranceplan;

	@FindBy(xpath = "//div[@class='viewMorePlan']")
	List<WebElement> allscroll;

	public void hoverMore() throws InterruptedException {
		Thread.sleep(10000);
		Actions action = new Actions(driver);
		action.moveToElement(moresection).build().perform();
	}

	public void clickHealthInsurance() throws InterruptedException {
		Thread.sleep(2000);
		healthinsurance.click();
	}

	public void scrollToViewMore() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scroll);
	}

	public void fillBasicDetails() throws InterruptedException, IOException {
		p = BaseClass.getProperties();
		scrollToViewMore();
		checkmale.click();
		inputname.sendKeys(p.getProperty("name"));
		inputphone.sendKeys(p.getProperty("phone"));
		Thread.sleep(3000);
		viewplan.click();

		Thread.sleep(3000);
		checkyou.click();
		continuebtn.click();

		clickage.click();
		selectage.click();
		inputpincode.sendKeys(p.getProperty("pincode"));
		Thread.sleep(1000);
		continueBtn.click();

		Thread.sleep(3000);
		if (checkbox.isEnabled()) {
			continuebtnn.click();
		} else {
			checkbox.click();
		}
	}

	public List<String> getHealthInsuranceBrandName() throws InterruptedException {
		brandName.clear();
		Thread.sleep(25000);
		for (WebElement ele : brandname) {
			String brand = ele.getText();
			brandName.add(brand);
		}
		return brandName;
	}

	public void printHealthInsuranceBrandName() throws InterruptedException {
		List<String> brandName = getHealthInsuranceBrandName();
		for (int i = 0; i < brandName.size(); i++) {
			System.out.println((i + 1) + ". " + brandName.get(i));
		}
	}

	public List<String> getInsurancePlan() {
		insurancePlan.clear();
		for (WebElement ele : insuranceplan) {
			String plan = ele.getText();
			insurancePlan.add(plan);
		}
		return insurancePlan;
	}

	public void printInsurancePlan() {
		List<String> insurancePlan = getInsurancePlan();
		for (int i = 0; i < insurancePlan.size(); i++) {
			System.out.println((i + 1) + ". " + insurancePlan.get(i));
		}
	}

}
