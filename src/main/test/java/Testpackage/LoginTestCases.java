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

@Test
public void VerifyLoginFunctionalityWithInCorrectData() throws InterruptedException, EncryptedDocumentException, IOException
{   
	logger= report.createTest("Verify login functionality with incorrect data");
   SoftAssert s= new SoftAssert();
	//login.sendUsername("Admin");
	login.sendUsername(r.fetchDataFromExcel(1, 0));
	// login.sendPassword("admin123");
	login.sendPassword(r.fetchDataFromExcel(1,1));
	 login.ClickOnLoginButton();
	 String ExpectedURL ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	 Thread.sleep(2000);
	 String CurrentURL=driver.getCurrentUrl();
	 login.ClickOnLogoutButton();
//	 Assert.assertEquals(CurrentURL, ExpectedURL);
//	 login.VerifyErrorMsg();
	
}

/*
@Test(priority=1)
public void VerifyLoginFunctionalityWithBlnkData() throws InterruptedException
{   
	SoftAssert s= new SoftAssert();
	login.sendUsername("");
	 login.sendPassword("");
	 login.ClickOnLoginButton();
	 String ExpectedURL ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	 Thread.sleep(2000);
	 String CurrentURL=driver.getCurrentUrl();
	 Assert.assertEquals(CurrentURL, ExpectedURL);
	 Assert.fail();
}
 */
@Test
public void VerifyLoginFunctionalityWithCorrectData() throws InterruptedException, EncryptedDocumentException, IOException
{   logger= report.createTest("Verify login functionality with correct data");
    SoftAssert s= new SoftAssert();
	login.sendUsername("Admin");
	 login.sendPassword("admin123");
	 login.ClickOnLoginButton();
	 String ExpectedURL ="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	 Thread.sleep(2000);
	 String CurrentURL=driver.getCurrentUrl();
	 Assert.assertEquals(CurrentURL, ExpectedURL);
	 s.assertAll();
	 logger.pass("Test case is pass");
	
}	 
	 

	 
	 
	 
	 
	 
	 
	 
	 
	//Hard Assert
	//Assert.assertEquals(CurrentURL, ExpectedURL);
//	Assert.assertNotEquals(CurrentURL, ExpectedURL); 
//	Assert.assertTrue(true);
//	Assert.assertFalse(false); 
//	Assert.fail();
	 
	//Soft Assert
//	SoftAssert s= new SoftAssert();
//	s.assertEquals(CurrentURL, ExpectedURL);
//	s.assertNotEquals(CurrentURL, ExpectedURL); 
//	s.assertTrue(false);  
//	s.assertFalse(false);  
//  s.assertAll(); 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}

