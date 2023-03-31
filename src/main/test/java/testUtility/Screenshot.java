package testUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot

{/*
	public static void capturePageScreenshot(WebDriver driver) throws IOException 
	{
		String path= "test-output"+File.separator+"Screenshot"+File.separator+System.currentTimeMillis()+".png";	
		File Source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File(path);
		FileHandler.copy(Source, Dest);
		
	}
	*/
	public static String captureScreenshot(WebDriver driver) throws IOException 
	{
		String path= "C:\\Users\\91913\\eclipse-workspace\\HRMOrange\\test-output\\Screenshot\\"+System.currentTimeMillis()+".png";	
		String Src =((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		File Dest = new File(path);
	//	FileHandler.copy(Src, Dest);
		return Src;
		
	}
}
