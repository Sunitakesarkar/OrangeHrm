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

	@Parameters({ "browser" })
	@BeforeTest
	public void beforesuite(String browser) throws InterruptedException {
		if (browser.equals("chrome")) {
			// WebDriver driver= staticBrowser.openBrowser(browser,
			// "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			// driver= new ChromeDriver();

			// this.driver= driver;
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// driver.get("https://www.policybazaar.com");

		}

		else if (browser.equals("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		logger.pass("Opening the browser...");
		System.out.println("Opening the browser...");
//	this.driver= driver;
		extent = new ExtentHtmlReporter("test-output/report/" + System.currentTimeMillis() + ".html");
		report = new ExtentReports();
		report.attachReporter(extent);

	}

	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String path = Screenshot.captureScreenshot(driver);
			logger.fail("Test case is failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		report.flush();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
