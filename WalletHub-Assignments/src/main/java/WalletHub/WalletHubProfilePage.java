package WalletHub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WalletHubProfilePage extends BasePage{

	public WalletHubProfilePage(WebDriver driver) {
		super(driver);
		
	}
	
	//Locators
	By profileName = By.xpath("//span[text()='velukrishna89']");
	By profileLnk = By.linkText("Profile");
	By reviewFeedTitle = By.xpath("//*[@id='scroller']//*[contains(@class, 'first-row')]//a");
	By reviewFeedType = By.xpath("//*[@id='scroller']//*[contains(@class, 'first-row')]//p");
	By editProfile = By.xpath("//button[text()='Edit Profile']");
	
	
	//Getters/Setters
	public void hoverOnProfile() {
		this.HoverOnElement(profileName);
	}
	
	public void clickProfile() {
		this.clickElement(profileLnk);
	}
	
	public String getReviewFeedTitle() {
		return this.getElementText(reviewFeedTitle);
	}
	
	public String getReviewFeedType() {
		return this.getElementText(reviewFeedType);
	}
	
	public void waitForEditProfile(int seconds) {
		this.waitForAnElementTobeVisible(editProfile, seconds);
	}

}
