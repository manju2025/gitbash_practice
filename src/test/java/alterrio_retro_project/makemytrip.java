package alterrio_retro_project;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class makemytrip {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.makemytrip.com/flights/?cmp=SEM|M|DF|B|Brand|B_M_Makemytrip_Search_Exact|Brand_Top_5_Exact|Expanded|&s_kwcid=AL!1631!3!!e!!o!!makemytrip&ef_id=4a4f7bb37e1f105dd23f18b6806824b7:G:s");
	driver.findElement(By.xpath("//span[@class='lbl_input latoBold  appendBottom5'][contains(.,'From')]")).click();
	driver.findElement(By.xpath("//p[contains(.,'Chhatrapati Shivaji International Airport')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();
}

}
