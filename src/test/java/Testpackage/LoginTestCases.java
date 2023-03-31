package Testpackage;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pompackage1.HomePage;
import Pompackage1.Loginpage;
import testUtility.readFileData;

public class LoginTestCases extends BaseClass{

	Loginpage login;
	readFileData r;

@BeforeMethod
public void beforeMethod()
{
	
	System.out.println("beforeMethod of Class1");
	 login = new Loginpage(driver);
	
}

@Test(priority=0)
public void VerifyLoginFunctionalityWithInCorrectData() throws InterruptedException, EncryptedDocumentException, IOException
{ logger=report.createTest("VerifyLoginFunctionalityWithInCorrectData");
	login.sendUsername(r.fetchDataFromExcel(1, 0));
	 login.sendPassword(r.fetchDataFromExcel(1, 1));
	 login.ClickOnLoginButton();
	 String ExpectedURL ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
//	 String CurrentURL=driver.getCurrentUrl();
	 Assert.assertEquals(ExpectedURL,ExpectedURL);
	 Thread.sleep(5000);
	 login.VerifyErrorMsg();
	
}

@Test(priority=1)
public void VerifyLoginFunctionalityWithBlnkData() throws InterruptedException
{  logger=report.createTest("VerifyLoginFunctionalityWithBlnkData");
	login.sendUsername("");
	 login.sendPassword("");
	 login.ClickOnLoginButton();
	 String ExpectedURL ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	 Thread.sleep(3000);
	 String CurrentURL=driver.getCurrentUrl();
	 Assert.assertEquals(CurrentURL, ExpectedURL);
	// Assert.fail();
}

@Test(priority=2)
public void VerifyLoginFunctionalityWithCorrectData() throws InterruptedException, EncryptedDocumentException, IOException
{   logger=report.createTest("VerifyLoginFunctionalityWithCorrectData");
	login.sendUsername(r.fetchDataFromExcel(2, 0));
	 login.sendPassword(r.fetchDataFromExcel(2, 1));
	 login.ClickOnLoginButton();
	 String ExpectedURL ="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	 Thread.sleep(3000);
	 String CurrentURL=driver.getCurrentUrl();
	 Assert.assertEquals(CurrentURL, ExpectedURL);
	 login.ClickOnLogoutButton();
	// s.assertAll();
	 
	
}	 
	 

	 
	 
	 
	 
	 
	 
	 
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
}

