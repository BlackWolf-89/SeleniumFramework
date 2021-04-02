package WalletHub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookLogInPage extends BasePage{
	
	public FacebookLogInPage(WebDriver driver) {
		super(driver);
		
	}


	//pageobjects
	By usernameTxt = By.id("email");
	By passwordTxt = By.id("pass");
	By loginBtn = By.id("u_0_b");
	
	
	//Getter/Setters
	public void setUsername(String  username) {
		this.setFieldText(usernameTxt, username);
	}
	
	public void setPassword(String password) {
		this.setFieldText(passwordTxt, password);
	}

	
	public void clickLogInButton() {
		this.clickElement(loginBtn);
	}
	
	
	
	//Helper Methods
	public void FacebookLogin(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
		this.clickLogInButton();
	}

}
