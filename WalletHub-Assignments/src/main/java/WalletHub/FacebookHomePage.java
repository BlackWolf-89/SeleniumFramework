package WalletHub;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FacebookHomePage extends BasePage{

	public FacebookHomePage(WebDriver driver) {
		super(driver);
		
	}
	
	//Locators:
	By homeIcon = By.xpath("//a[@aria-label='Home' and @role='link']");
	By status = By.xpath("//span[ contains(text(), 'on your mind,')]");
	By postTxt = By.xpath("//div[contains(@aria-describedby, 'placeholder') and @role='textbox']");
	By postBtn = By.xpath("//div[@aria-label = 'Post' and @role='button']");
	
	//Getters/Setters
	public void clickHomePage() throws AWTException {
		this.waitForAnElementTobeVisible(homeIcon, 30);
		this.clickElement(homeIcon);
	}
	
	public void clickStatus() {
		this.clickElement(status);
	}
	
	public void setStatusMessage(String message) {
		this.clickElement(postTxt);
		this.setFieldText(postTxt, message);
	}
	
	public void clickPostButton() {
		this.clickElement(postBtn);
	}

}
