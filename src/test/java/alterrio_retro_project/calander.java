package alterrio_retro_project;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calander {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException, AWTException
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("http://testleaf.herokuapp.com/pages/Calendar.html");
	driver.findElement(By.xpath("//input[@class='hasDatepicker']")).click();
	 String date = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
	 System.out.println(date);
	
	 
	}

}
