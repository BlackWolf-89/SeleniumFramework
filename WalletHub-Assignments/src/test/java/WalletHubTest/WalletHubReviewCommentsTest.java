package WalletHubTest;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import WalletHub.WalletHubHomePage;
import WalletHub.WalletHubLoginPage;
import WalletHub.WalletHubProfilePage;


public class WalletHubReviewCommentsTest {
	
	WebDriver driver;
	WalletHubLoginPage whLoginPO;
	WalletHubHomePage whHomePO;
	WalletHubProfilePage whProfilePO;
	
	//Test Data
	String url =  "https://wallethub.com/";
	String username = "Test";
	String password = "Test";
	String comments = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups";
	
	@BeforeTest
	public void setChromeDriver() {
		//To disable browser notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver",".\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver(options);
		whLoginPO = new WalletHubLoginPage(driver);
		whHomePO = new WalletHubHomePage(driver);
		whProfilePO = new WalletHubProfilePage(driver);
	}
	
	@Test
	public void loginToFacebookAndSetStatus() throws InterruptedException, AWTException {
		//Login to WalletHub
		whLoginPO.loadURL(url);
		whLoginPO.loginToWalletHub(username, password);
		whProfilePO.waitForEditProfile(30);
		Thread.sleep(2000);
		
		//Load Test Insurance Company Profie and add review comments
		driver.get("http://wallethub.com/profile/test_insurance_company/");
		Thread.sleep(2000);
		whHomePO.clickWriteReview();
		whHomePO.clickStarRating();
		whHomePO.selectInsuranceType();
		whHomePO.setReviewComments(comments);
		whHomePO.clickSubmitReview();
		whHomePO.clickContinue();
		Thread.sleep(1000);
		whHomePO.moveToTop();
		Thread.sleep(1000);
		
		//Navigate to Profile page and asset the review feed
		whProfilePO.hoverOnProfile();
		whProfilePO.clickProfile();
		Assert.assertEquals(whProfilePO.getReviewFeedTitle(), "Test Insurance Company");
		Assert.assertEquals(whProfilePO.getReviewFeedType(), "Insurance Company");
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
