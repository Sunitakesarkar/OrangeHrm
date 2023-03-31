package Testpackage;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pompackage1.HomePage;
import Pompackage1.Loginpage;
import testUtility.readFileData;

public class HomepageTestCases extends BaseClass {
	
	
	Loginpage login;
	HomePage Home;
	readFileData r;
	@BeforeMethod
	public void beforemethod()
	{   System.out.println("beforeMethod of Class1");
	     login = new Loginpage(driver);
	     Home = new HomePage(driver); 
	}

 @Test(priority=0)
	 public void VerifyLoginFunctionalityWithCorrectData() throws InterruptedException, EncryptedDocumentException, IOException
	 {   logger=report.createTest("VerifyLoginFunctionalityWithCorrectData");
	 	 login.sendUsername(r.fetchDataFromExcel(2, 0));
	 	 login.sendPassword(r.fetchDataFromExcel(2, 1));
	 	 login.ClickOnLoginButton();
	 	 String ExpectedURL ="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	 	 String CurrentURL=driver.getCurrentUrl();
		 Assert.assertEquals(CurrentURL, ExpectedURL);
	 }	 
	 	 
@Test(priority=1)
public void VerifyHomePageFunctionality() {
	logger=report.createTest("VerifyHomePageFunctionality");
     Home.MoveToEleAdmin();
     
     Home.usrmanagementDisplay();
}
@Test(priority=2)
public void VerifyHomePageFunctionalities() throws InterruptedException {
	logger=report.createTest("VerifyHomePageFunctionalities");
     Home.VerifyUsrNamebox("Abc Def Ghi");

     Home.VerifyEmployeeName("Paul  Collings");
     
     Home.verifyUsrRole("Admin");
     
     Home.VerifyPIM();
     
     Home.VerifyEmpID("EMP101");
}

@Test(priority=3)
public void VerifyhomepageFuncionality() throws InterruptedException {
	
     Home.VerifyLEAVE();
     Home.VerifyTIME("paul");
}
}