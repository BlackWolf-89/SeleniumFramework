package WalletHubTest;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
	public static final String USERNAME = "BlackWolf89";
	public static final String ACCESS_KEY = "d6e226ef-2d16-4aa9-acf8-4c13abee8033";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	
	@BeforeTest
	public void setChromeDriver() throws MalformedURLException {
		//To disable browser notifications
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-notifications");
//		
//		System.setProperty("webdriver.chrome.driver",".\\src\\main\\resources\\chromedriver.exe");
//		driver = new ChromeDriver(options);
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 10");
	    caps.setCapability("version", "latest");
	    caps.setCapability("build", "build-1.2");
	    caps.setCapability("name", "Git Test");
		
		driver = new RemoteWebDriver(new URL(URL) , caps);
		
		fbLoginPO = new FacebookLogInPage(driver);
		fbHomePO = new FacebookHomePage(driver);
	}
	
	@Test
	public void loginToFacebookAndSetStatus() throws InterruptedException, AWTException, IOException, Exception {
		
		//Login to Facebook
		fbLoginPO.loadURL(url);
		System.out.println("Title is:"+ driver.getTitle());
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir")+"Result_"+System.currentTimeMillis()+".png");
		FileUtils.copyFile(srcFile, destFile);
		
		
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
