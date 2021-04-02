package WalletHubTest;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import WalletHub.FacebookHomePage;
import WalletHub.FacebookLogInPage;

public class FacebookLoginTest {
	WebDriver driver;
	FacebookLogInPage fbLoginPO;
	FacebookHomePage fbHomePO;
	
	//Test Data
	String url =  "https://www.facebook.com/";
	String username = "Test";
	String password = "Test";
	
	@BeforeTest
	public void setChromeDriver() {
		//To disable browser notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver",".\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver(options);
		fbLoginPO = new FacebookLogInPage(driver);
		fbHomePO = new FacebookHomePage(driver);
	}
	
	@Test
	public void loginToFacebookAndSetStatus() throws InterruptedException, AWTException {
		//Login to Facebook
		fbLoginPO.loadURL(url);
		System.out.println("Title is:"+ driver.getTitle());
//		fbLoginPO.FacebookLogin(username, password);
		Thread.sleep(2000);
		
		//Post status messge
//		fbHomePO.clickHomePage();
//		fbHomePO.clickStatus();
//		Thread.sleep(1000);
//		fbHomePO.setStatusMessage("Hello World!");
//		fbHomePO.clickPostButton();
//		Thread.sleep(4000);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}