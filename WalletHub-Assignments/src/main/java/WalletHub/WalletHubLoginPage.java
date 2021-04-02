package WalletHub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WalletHubLoginPage  extends BasePage{

	public WalletHubLoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	//Locators
	By loginLnk = By.linkText("Login");
	By emailTxt = By.name("em");
	By passwordTxt = By.name("pw");
	By loginBtn = By.xpath("//button[span[text()='Login']]");
	
	
	//Getters/Setters
	public void clickLogin() {
		this.clickElement(loginLnk);
	}
	
	public void setEmail(String email) {
		this.setFieldText(emailTxt, email);
	}
	
	public void setPassword(String password) {
		this.setFieldText(passwordTxt, password);
	}
	
	public void clickLoginButton() {
		this.clickElement(loginBtn);
	}
	
	
	//helperMethods
	public void loginToWalletHub(String email, String password) {
		try {
			this.clickLogin();
			Thread.sleep(2000);
			this.setEmail(email);
			this.setPassword(password);
			this.clickLoginButton();
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}

}
