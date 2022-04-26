package tests;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;

import com.google.common.collect.ImmutableMap;
import data.Loadproperties;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class TestBase {

	
	public static WebDriver driver;



	String URL=Loadproperties.userData.getProperty("URL");

	@BeforeSuite
	@org.testng.annotations.Parameters({"browser"})
	public void startdriver(@Optional("chrome")String browsername) {

		if(browsername.equalsIgnoreCase("chrome"))
		{
			String chromepath=System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",chromepath) ;
			driver = new ChromeDriver();
		}
		// in else section add another browsers
		driver.manage().window().maximize();

		driver.get(URL);
	}
	@AfterSuite
	public void stopdriver() {
		driver.close();
		driver.quit();
	}
	@AfterSuite
	@Attachment
	public void generateAllure() throws IOException {  

		Runtime rt = Runtime.getRuntime();

		rt.exec("cmd.exe /c start allure serve \""+System.getProperty("user.dir")+"\\allure-results\"");
	}  
	
	@Attachment
	public void setAllureEnvironment() {
		allureEnvironmentWriter(
				ImmutableMap.<String, String>builder()
				.put("Website", "Fatura")
				.build(), System.getProperty("user.dir")
				+ "/allure-results/");
	}
	@BeforeSuite
	@Attachment
	public void delAllureRes()
	{
		File file = new File(System.getProperty("user.dir")+"\\allure-results");
		if(file.exists())
		{
			deleteDirectory(file);
			file.delete();	  
		}
	}
	
	public static void deleteDirectory(File file)
	{
		if(file.listFiles().length!=0)
		{
			for (File subfile : file.listFiles()) {
				if (subfile.isDirectory()) {
					deleteDirectory(subfile);
				}
				subfile.delete();
			}
		}

	}
	@AfterMethod
	@Attachment
	public  byte[] takeScreenshot(ITestResult iTestResult) {
		byte[] screenshotAs = null;
		Object currentClass = iTestResult.getInstance();
		WebDriver webDriver = ((TestBase) currentClass).driver;
		if (webDriver != null){
			screenshotAs = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment( "Screenshot for " + iTestResult.getMethod().getMethodName(), new ByteArrayInputStream(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES)));

		}
		return screenshotAs;

	}
	

}
