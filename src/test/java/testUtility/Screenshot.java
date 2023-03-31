package testUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot

{
	public static String capturePageScreenshot(WebDriver driver) throws IOException 
	{
       String r= System.getProperty("user.dir");
       System.out.println(r);	
		String path= System.getProperty("user.dir")+File.separator+"test-output"+File.separator+"Screenshot"+File.separator+System.currentTimeMillis()+".png";	
		File Source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File(path);
		FileHandler.copy(Source, Dest);
		return path;
	
	}
}
