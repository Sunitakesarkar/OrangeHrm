package Testpackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClassTNG2 {
	@BeforeSuite
	 public void beforeSuite()
    {
	System.out.println("beforeSuite of Class2");
    }
	
	@BeforeTest
	 public void beforeTest()
   {
	System.err.println("beforeTest of Class2");
   }
	
	 @BeforeClass
	    public void beforeClass()
	    {
		System.out.println("beforeClass of Class2");
	    }

	    @BeforeMethod
	    public void beforeMethod()
	    {
	  	System.out.println("beforeMethod of Class2");
	    }

	    @Test
	    public void test1() 
	    {
		System.out.println("test1 of Class2");
	    }

	    @Test
	    public void test2() 
	    {
		System.out.println("test2 of Class2");
	    }
	    
	    @Test
	    public void test3() 
	    {
		System.out.println("test3 of Class2");
	    }
	    
	    @AfterMethod
	    public void afterMethod()
	    {
		System.out.println("afterMethod of Class2");
	    }

	    @AfterClass
	    public void afterClass()
	    {
		System.out.println("afterClass of Class2");
	    }
	    
	    @AfterTest
		 public void afterTest()
	   {
		System.err.println("afterTest of Class2");
	   }
	    
	    @AfterSuite
		 public void afterSuite()
	    {
		System.out.println("afterSuite of Class2");
	    }
}
