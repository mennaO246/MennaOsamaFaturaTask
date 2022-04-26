package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy (id = "full-name")
	public WebElement nameTxtBox;
	
	@FindBy (id = "e-mail")
	public WebElement emailTxtBox;
	
	@FindBy (xpath = "//*[@id=\"contact-section\"]/div/div[2]/form/div[4]/app-button")
	public WebElement letsWorkTogetherBtn;
	
	@FindBy (id = "landing-page-btn")
	public WebElement landingPageBtn;
	
	@FindBy (id = "phone-number")
	public WebElement phoneNoTxtBox;
	
	@FindBy (css = "div.sub-wrapper")
	public WebElement errormsg;
}
