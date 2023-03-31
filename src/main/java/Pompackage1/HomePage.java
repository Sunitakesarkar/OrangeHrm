package Pompackage1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	WebDriver driver;
	WebDriverWait wait;
	
 @FindBy(xpath="(//*[text()='Admin'])[1]")  
 private WebElement admin;
 
 @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]")
 private WebElement usrManagement;
 
 @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
 private WebElement usrNameBox;

 //"(//input[@class='oxd-input oxd-input--active'])[2]"
 
 @FindBy(xpath="//div[@class='oxd-table-filter-area']//div[2]//div[1]//div[2]//div[1]//div[1]//div[1]")
 private WebElement UserRole;
 
 @FindBy(xpath="//input[@placeholder='Type for hints...']")
 private WebElement Employeenm;
 
 @FindBy(xpath="(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[2]")
 private WebElement pim;
 
 @FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
 private WebElement EmpID;
 
 @FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Leave']")
 private WebElement Leave;
 
 @FindBy(xpath="//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
 private WebElement FromDate;
 
 @FindBy(xpath="//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/input[1]")
 private WebElement ToDate;
 
 @FindBy(xpath="//div[@class='oxd-select-text-input'][normalize-space()='Select']")
 private WebElement LeaveStatus;
 
 @FindBy(xpath="//span[normalize-space()='Rejected']")
 private WebElement RejectedStatus;
 
 @FindBy(xpath="//a[@class='oxd-main-menu-item active']//span[1]")
 private WebElement Time;
 
 @FindBy(xpath="//input[@placeholder='Type for hints...']")
 private WebElement EmplNm;
 

 
 //
 public HomePage(WebDriver driver) 
 {
	    this.driver=driver;
    	PageFactory.initElements(driver, this);
	   wait= new WebDriverWait(driver, Duration.ofSeconds(20));
 }
 
 public void MoveToEleAdmin()
 {   Actions act= new Actions(driver);
	 act.moveToElement(admin).perform();
	 admin.click();
	 
 }

 
 public void usrmanagementDisplay() 
	{
	 boolean result = usrManagement.isDisplayed();
	 System.out.println(result);
	}
 
 public void VerifyUsrNamebox(String name) throws InterruptedException 
	{
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")));
	 usrNameBox.sendKeys(name);
	 Thread.sleep(5000);
	}
 
 public void verifyUsrRole(String name) throws InterruptedException
	{
	 Actions act= new Actions(driver);
	 act.moveToElement(UserRole).perform();
	 UserRole.click();
	 UserRole.sendKeys(name);

	}
 
 public void VerifyEmployeeName(String nm) throws InterruptedException
	{
	 
	 Actions act= new Actions(driver);
	 act.moveToElement(Employeenm).perform();
	 Employeenm.click();
	 Employeenm.sendKeys(nm);
	 Thread.sleep(5000);
	}
 
 public void VerifyPIM() throws InterruptedException
	{
	 
	 Actions act= new Actions(driver);
	 act.moveToElement(pim).perform();
	 pim.click();
	 
	 Thread.sleep(5000);
	}
 
 public void VerifyEmpID(String empID) throws InterruptedException
	{
	 Actions act= new Actions(driver);
	 act.moveToElement(EmpID).perform();
	 EmpID.sendKeys(empID);
	 Thread.sleep(5000);
	}
 
 public void VerifyLEAVE() throws InterruptedException
	{
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]/span[1]")));
	 Actions act= new Actions(driver);
	 act.moveToElement(Leave).perform();
	 Leave.click();
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")));
	 act.moveToElement(FromDate).perform();
	 FromDate.sendKeys("2023-03-18");
	 String Date=FromDate.getText();
	 System.out.println(Date);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]")));
	 act.moveToElement(LeaveStatus).perform();
	 LeaveStatus.click();
	 act.moveToElement(RejectedStatus).perform();
	 RejectedStatus.click();
	 String Sta=RejectedStatus.getText();
	 System.out.println(Sta);
	
	}
 
 public void VerifyTIME(String EmpNM) throws InterruptedException
	{ wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='oxd-main-menu-item active']//span[1]")));
	 
	 Actions act= new Actions(driver);
	 act.moveToElement(Time).perform();
	 Time.click();
	 act.moveToElement(EmplNm).perform();
	 EmpID.sendKeys(EmpNM);

	}
 
}

