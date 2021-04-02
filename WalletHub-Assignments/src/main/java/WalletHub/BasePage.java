package WalletHub;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

	WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void loadURL(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public void setFieldText(By element, String text) {
		driver.findElement(element).clear();
		driver.findElement(element).sendKeys(text);
		
	}
	
	public void clickElement(By element) {
		driver.findElement(element).click();
	}
	
	public String getElementText(By element) {
		return driver.findElement(element).getText();
	}
	
	public void HoverOnElement(By element) {
		WebElement svgObj = driver.findElement(element);
		Actions action = new Actions(driver);
		action.moveToElement(svgObj).build().perform();
	}
	
	public void HoverAndClick(By element) {
		WebElement svgObj = driver.findElement(element);
		Actions action = new Actions(driver);
		action.moveToElement(svgObj).click().build().perform();
	}
	
	public void moveToTop() {
		
		try {
			Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_HOME);
			
			rb.keyRelease(KeyEvent.VK_HOME);
			rb.keyRelease(KeyEvent.VK_CONTROL);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void waitForAnElementTobeVisible(By element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
}
