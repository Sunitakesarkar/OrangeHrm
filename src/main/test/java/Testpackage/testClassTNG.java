package Testpackage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

    public class testClassTNG {
    @BeforeClass
    public void beforeClass()
    {
	System.out.println("beforeClass");
    }

    @BeforeMethod
    public void beforeMethod()
    {
  	System.out.println("beforeMethod");
    }

    @Test(priority=0,timeOut=2000)
    
    public void verifyLogin()
    {
    //	Assert.fail();
	System.out.println("verifyLogin");
    }

    @Test(priority=1,dependsOnMethods= {"verifyLogin"})
    public void verifyHome()
    {
	System.out.println("verifyHome");
    }
    

    @Test(priority=2)
    public void verifyAdmin()
    {
	System.out.println("verifyAdmin");
    }

    @AfterMethod
    public void afterMethod()
    {
	System.out.println("afterMethod");
    }

    @AfterClass
    public void afterClass()
    {
	System.out.println("afterClass");
    }
    }
