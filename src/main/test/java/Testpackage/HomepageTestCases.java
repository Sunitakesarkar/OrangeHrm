package Testpackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pompackage1.HomePage;
import Pompackage1.Loginpage;

public class HomepageTestCases {
	
	WebDriver driver;
	Loginpage login;
	HomePage Home;
	
	@BeforeClass
	public void beforeClass()
	{
		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\Driver\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		 driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
		 login = new Loginpage(driver);
		 
	}

@BeforeMethod
public void beforeMethod()
{
	System.out.println("beforeMethod of Class1");
}

 @Test
 public void VerifyHomepageFunctionality() throws InterruptedException
 {
	 login.sendUsername("Admin");
	 login.sendPassword("admin123");
	 login.ClickOnLoginButton();
	 Home = new HomePage(driver);
     Home.MoveToEleAdmin();
     
     Home.usrmanagementDisplay();
     
     Home.VerifyUsrNamebox("Abc Def Ghi");

     Home. verifyUsrRole();

     Home.VerifyEmployeeName("Paul  Collings");
     
     Home.VerifyPIM();
     
     Home.VerifyEmpID("EMP101");
     
     Home.VerifyLEAVE();
     
     Home.VerifyTIME("Rajanish Test 123");
 
}
}