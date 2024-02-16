package pageObjects;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InvalidGoogleLoginPage extends BasePage {

	public InvalidGoogleLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//div[@id='des_lIcon']")
	WebElement loginbutton;

	@FindBy(xpath = "//span[contains(text(), 'Google')]")
	WebElement google;

	@FindBy(xpath = "//input[@type='email']")
	WebElement emailinput;

	@FindBy(xpath = "//div[@jsname='B34EJ']/div")
	WebElement errormessage;

	public void clickLoginButton() {
		loginbutton.click();
	}

	public void clickGoogleAccount() {
		google.click();
	}

	public void enterRandomEmail() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		emailinput.sendKeys("username" + randomInt + "@gmail.com");
	}

	public void printErrorMessage() {
		String message = errormessage.getText();
		System.out.println("\n" + message);
	}
}
