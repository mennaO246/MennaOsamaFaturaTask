package pages;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	public static WebDriver driver;
	
	public PageBase (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickbutton(WebElement button) {
		WaitForElementVsisibility(button);
		WaitForElementToBeclickable(button);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",button);	
	}
	public void SetTextElement(WebElement txtelement , String value ) {
		WaitForElementVsisibility(txtelement);
		boolean success = false;
		while (!success) {
			try {
				txtelement.clear();
				txtelement.sendKeys(value);
				WebDriverWait wait = new WebDriverWait(driver, 50);

				ExpectedCondition<Boolean> Expected = arg0->txtelement.getAttribute("value").contains(value);
				wait.until(Expected); 
				success =true;


			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println("Sorry, Cannot insert the value in the Textbox."+e);
			}
		}
	}
	
	public void WaitForElementVsisibility(WebElement elem) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(elem));
	}
		public void WaitForElementToBeclickable(WebElement elem ) {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(elem));
		}
		
		public  void WaitUntilPageIsLoaded()  {	
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(driver -> "complete".equals(((JavascriptExecutor) driver)
			    .executeScript("return document.readyState")));		
	}
}
