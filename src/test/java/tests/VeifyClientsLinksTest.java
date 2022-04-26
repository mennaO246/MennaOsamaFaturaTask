package tests;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;

import javax.management.ListenerNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import antlr.collections.List;
import data.Loadproperties;
import modules.LinksVerificationAction;
import pages.HomePage;

public class VeifyClientsLinksTest extends TestBase {

	HomePage homeObj;
	
	String XPathFirst = "//*[@id=\"clients-logos-container\"]/div[1";
	String XPAthSec = "]/div[";
	
	String LinoLink=Loadproperties.userData.getProperty("LinoLink");
	String KelloggsLink=Loadproperties.userData.getProperty("KelloggsLink");
	String belLink=Loadproperties.userData.getProperty("belLink");
	String ChefymixLink=Loadproperties.userData.getProperty("ChefymixLink");
	String RichBake=Loadproperties.userData.getProperty("RichBake");
	String ZeinaLink=Loadproperties.userData.getProperty("ZeinaLink");
	String holwelshamlink=Loadproperties.userData.getProperty("holwelshamlink");
	String miroLink=Loadproperties.userData.getProperty("miroLink");
	String elrashidyLink=Loadproperties.userData.getProperty("elrashidyLink");
	
	String[] Links = {
			LinoLink=Loadproperties.userData.getProperty("LinoLink"),
			KelloggsLink=Loadproperties.userData.getProperty("KelloggsLink"),
			belLink=Loadproperties.userData.getProperty("belLink"),
			ChefymixLink=Loadproperties.userData.getProperty("ChefymixLink"),
			RichBake=Loadproperties.userData.getProperty("RichBake"),
			ZeinaLink=Loadproperties.userData.getProperty("ZeinaLink"),
			holwelshamlink=Loadproperties.userData.getProperty("holwelshamlink"),
			miroLink=Loadproperties.userData.getProperty("miroLink"),
			elrashidyLink=Loadproperties.userData.getProperty("elrashidyLink"),
			};
	
	java.util.List<WebElement> links=null;
	@Test
	public void VeifyClientsLinks()
	{
		LinksVerificationAction LVAObj = new LinksVerificationAction();
		for (int a = 0; a < Links.length; a++) {
			for (int i = 1; i <= 3; i++) {
				for (int j = 1; j <= 3; j++) {
					java.util.List<WebElement> links = driver.findElements(By.xpath(XPathFirst+i+XPAthSec+j+"]"));
					for (WebElement webElement : links) {
						assertTrue(LVAObj.VerifyLinks(webElement, Links[a], driver));
					}
				}
			}
			
		}
	}
	}
