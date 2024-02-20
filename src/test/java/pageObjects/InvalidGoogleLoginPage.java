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

	String winHandleBefore;

	// Web elements for different functionality
	@FindBy(xpath = "//div[@id='des_lIcon']")
	WebElement loginbutton;

	@FindBy(xpath = "//span[contains(text(), 'Google')]")
	WebElement google;

	@FindBy(xpath = "//input[@type='email']")
	WebElement emailinput;

	@FindBy(xpath = "//span[contains(text(), 'Next')]")
	WebElement nextbutton;

	@FindBy(xpath = "//div[@jsname='B34EJ']/div")
	WebElement errormessage;

	public void clickLoginButton() {
		loginbutton.click();
	}

	public void clickGoogleAccount() throws InterruptedException {
		Thread.sleep(5000);
		google.click();
	}

	public void enterRandomEmail() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);

		// Store the current window handle
		winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		emailinput.sendKeys("username" + randomInt + "@gmail,com");
		nextbutton.click();
	}

	public void printErrorMessage() {
		String message = errormessage.getText();
		System.out.println("\nError message displayed : " + message);

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
	}
}
