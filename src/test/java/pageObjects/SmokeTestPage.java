package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SmokeTestPage extends BasePage {

	public SmokeTestPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "forum_login_wrap_lg")
	WebElement signin;

	@FindBy(xpath = "(//div[@class='newgf-login'])[2]")
	WebElement google;

	@FindBy(xpath = "//a[contains(text(), 'New Bikes')]")
	WebElement newbikes;

	@FindBy(xpath = "//span[contains(text(), 'Upcoming Bikes')]")
	WebElement upcomingbikes;

	@FindBy(xpath = "(//a[@class='c-p'])[4]")
	WebElement usedcars;

//	public void zigwheelspage() {
//		String title = driver.getTitle();
//		Assert.assertEquals(title, "New Cars & Bikes, Prices, News, Reviews, Buy & Sell Used Cars - ZigWheels.com");
//		System.out.println("Zigwheels Page is Opened without any errors");
//	}
// 
//	public void signinbuttonverification() {
//		Boolean k = driver.findElement(By.id("forum_login_title_lg")).isDisplayed();
//		Assert.assertEquals(true, k);
//		System.out.println("Login/Signin button is present");
//	}
// 
//	public void clickingonsignin() {
//		signin.click();
//	}
// 
//	public void verifyingsiginpage() {
//		Boolean o = google.isDisplayed();
//		Assert.assertEquals(true, o);
//		System.out.println("Login/Register page is opened");
//		driver.findElement(By.id("report_submit_close_login")).click();
//	}
// 
//	public void searchbutton() {
//		driver.findElement(By.id("headerSearch")).sendKeys("Honda Bikes");
//		driver.findElement(By.xpath("//span[@class='h-s-v1 h-srh-i abs i-b c-p']")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//	}
// 
//	public void checkingforhondabikes() {
//		Boolean e = driver.findElement(By.xpath("//h1[@class='pl-15 pr-15']")).isDisplayed();
//		Assert.assertEquals(true, e);
//		System.out.println("Honda Bikes are present");
//	}
// 
//	public void newbikeschecking() {
//		Boolean h = newbikes.isDisplayed();
//		Assert.assertEquals(true, h);
//		System.out.println("New Bikes is present");
//	}
// 
//	public void Newbikes() {
//		act.moveToElement(newbikes).perform();
//	}
// 
//	public void upcomingbikes() {
//		wait.until(ExpectedConditions.elementToBeClickable(upcomingbikes));
//		Assert.assertEquals(true, upcomingbikes.isDisplayed());
//		System.out.println("Upcoming bikes option is there");
//	}
// 
//	public void Usedcars2() {
//		usedcars.click();
//	}
// 
//	public void usedcarschecking() {
//		String u = driver.getTitle();
//		Assert.assertEquals(u, "Used Cars for Sale, Buy Second Hand Cars in India @ Zigwheels");
//		System.out.println("Succesfully navigated to used cars");
//	}

}
