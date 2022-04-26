package tests;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import data.Loadproperties;
import pages.HomePage;

public class GetADemoTest extends TestBase {

	//WebDriver driver;
	HomePage homeObj;
	
	String URL = Loadproperties.userData.getProperty("URL");
	String FullName = Loadproperties.userData.getProperty("fullName");
	String Email = Loadproperties.userData.getProperty("email");
	String PhoneNo = Loadproperties.userData.getProperty("phoneNo");
	
	@Test
	public void GetADemo() throws InterruptedException
	{
		driver.get(URL);
		homeObj = new HomePage(driver);
		homeObj.WaitUntilPageIsLoaded();
		homeObj.clickbutton(homeObj.landingPageBtn);
		homeObj.SetTextElement(homeObj.nameTxtBox, FullName);
		homeObj.SetTextElement(homeObj.emailTxtBox, Email);
		homeObj.SetTextElement(homeObj.phoneNoTxtBox, PhoneNo);
		homeObj.clickbutton(homeObj.letsWorkTogetherBtn);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(homeObj.errormsg));
		assertFalse(homeObj.errormsg.isDisplayed());
	}
}
