package Testpackage;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import testUtility.Screenshot;
import testUtility.staticBrowser;

public class BaseClass {
	public static ExtentReports report;
	public static ExtentHtmlReporter extent;
	public static ExtentTest logger;
	static WebDriver driver;
	@Parameters({"browser"})
	@BeforeTest
	public void beforesuite(String browser) throws InterruptedException
	{
    	WebDriver driver= staticBrowser.openBrowser(browser, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		this.driver= driver;
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    extent= new ExtentHtmlReporter("test-output/report/"+System.currentTimeMillis()+".html");
		report= new ExtentReports();
		report.attachReporter(extent);
		
		}
		
		
 @AfterMethod
 public void aftermethod(ITestResult  result) throws IOException
 {
	 if(result.getStatus()==ITestResult.FAILURE)
	 {
		String path= Screenshot.capturePageScreenshot(driver);
		 logger.fail("Test case is failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	 }
	 report.flush();
 }
 
 @AfterTest
 public void afterTest()
 {
	 driver.quit();
 }
}
