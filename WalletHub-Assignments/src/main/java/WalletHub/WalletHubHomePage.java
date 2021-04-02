package WalletHub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WalletHubHomePage extends BasePage{

	public WalletHubHomePage(WebDriver driver) {
		super(driver);
		
	}
	
	//Locators
	By searchTxt = By.name("s");
	By submitBtn = By.xpath("//button[text()='Search']");
	By writeReviewBtn = By.xpath("//button[text()='Write a Review']");
	By firstStar = By.xpath("//*[@id='reviews-section']//modal-dialog//review-star//*[name()='svg'][1]//*[name()='path']");
	By secondStar = By.xpath("//*[@id='reviews-section']//modal-dialog//review-star//*[name()='svg'][2]//*[name()='path']");
	By thirdStar = By.xpath("//*[@id='reviews-section']//modal-dialog//review-star//*[name()='svg'][3]//*[name()='path']");
	By fourthStar = By.xpath("//*[@id='reviews-section']//modal-dialog//review-star//*[name()='svg'][4]//*[name()='path']");
	By typeDrpDwn = By.xpath("//div[@class='dropdown second']");
	By healthInsuranceOption = By.xpath("//li[text()='Health Insurance']");
	By reviewTxtArea = By.xpath("//textarea[contains(@class, 'wrev-user-input')]");
	By submitReviewBtn = By.xpath("//div[text()='Submit']");
	By conitnueBtn = By.xpath("//div[text()='Continue']");
	
	//Getters/Setters
	public void clickWriteReview() {
		this.clickElement(writeReviewBtn);
	}
	
	public void clickStarRating() {
		this.HoverOnElement(firstStar);
		this.HoverOnElement(secondStar);
		this.HoverOnElement(thirdStar);
		this.HoverAndClick(fourthStar);
		
	}
	
	public void selectInsuranceType() {
		this.clickElement(typeDrpDwn);
		this.clickElement(healthInsuranceOption);
	}
	
	public void setReviewComments(String comments) {
		this.setFieldText(reviewTxtArea, comments);
	}
	
	public void clickSubmitReview() {
		this.clickElement(submitReviewBtn);
	}
	
	public void clickContinue() {
		this.waitForAnElementTobeVisible(conitnueBtn, 30);
		this.clickElement(conitnueBtn);
	}
	
	

}
