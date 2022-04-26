package modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.HomePage;
import tests.TestBase;

public class LinksVerificationAction extends TestBase {

	HomePage homeObj;
	
	public boolean VerifyLinks(WebElement webElement, String Link, WebDriver driver)
	{
		boolean flag = true;
		homeObj = new HomePage(driver);
		homeObj.clickbutton(webElement);
		String WebElementLink = webElement.getAttribute("href");
		if (Link!= WebElementLink)
			flag = false;
		return flag;
	}
}
