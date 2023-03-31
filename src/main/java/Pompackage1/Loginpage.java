package Pompackage1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Loginpage {
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement logInButton;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/p[1]")
	private WebElement errorMsg;
	
	@FindBy(xpath="//img[@class='oxd-userdropdown-img']")
	private WebElement logOutDropDown;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")
	private WebElement logOutButton;
	
	
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	  wait=	new WebDriverWait(driver, Duration.ofSeconds(20));
	  
	}
	
	public void sendUsername(String Uname) 
	{
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
		username.sendKeys(Uname);
	}
	
	public void sendPassword(String paswrd)
	{
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
		password.sendKeys(paswrd);
	}
	
	public void ClickOnLoginButton()
	{
		logInButton.click();
	}
	
	
	public void VerifyErrorMsg()
	{ wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/p[1]")));
		Actions act= new Actions(driver);
		act.moveToElement(errorMsg).perform();
		String ErrorMsg=errorMsg.getText();
		System.out.println(ErrorMsg);
		
	}
	public void ClickOnLogoutButton()
	{  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='oxd-userdropdown-img']")));
		
		Actions act= new Actions(driver);
	    act.moveToElement(logOutDropDown).perform();
	    logOutDropDown.click();
	    act.moveToElement(logOutButton).perform();
		logOutButton.click();
	}
	
	
	

}
