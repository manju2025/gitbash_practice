package alterrio_retro_project;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ajio_data_fetch {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException, AWTException
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.ajio.com");
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_ESCAPE);
	r.keyRelease(KeyEvent.VK_ESCAPE);
	driver.findElement(By.xpath("//a[text()='KIDS']")).click();
	driver.findElement(By.xpath("//a[@style='position: absolute; left: 0%; top: 0%; width: 100%; height: 100%;'and@href='/s/0-to-2-years-3767-54091']")).click();
	WebElement ele1 = driver.findElement(By.xpath("//div[text()='Graphic Print Hooded T-shirt']"));
	String text1 = ele1.getText();
	System.out.println(text1);
	WebElement ele = driver.findElement(By.xpath("//div[text()='Graphic Print Hooded T-shirt']/following-sibling::div/span[@class='price  ']"));
	String text = ele.getText();
	System.out.println(text);
	FileInputStream fis=new FileInputStream("./src/test/resources/exceldata.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet Sheet = wb.getSheet("sales and inventory");
	Row row = Sheet.createRow(4);
	row.createCell(0).setCellValue(text1);
	row.createCell(1).setCellValue(text);
	FileOutputStream fileout=new FileOutputStream("./src/test/resources/exceldata.xlsx");
	wb.write(fileout);
	System.out.println("data upload sucess");
	}
}
