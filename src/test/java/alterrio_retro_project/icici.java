package alterrio_retro_project;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class icici {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException, AWTException
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.icc-cricket.com/");
	
	
	}

}
