package org.tyss.sales_and_inventory_Generic_script;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility
{
	private JavascriptExecutor js;
	private WebDriver driver;
	private Actions act;
	private Alert alert;
	SoftAssert soft;
	//changes done by enginner1
	public WebDriver openBrowser(String browser) 
	{
		
		switch (browser) {
		case "firefox":WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
			break;
		case "chrome":WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		break;
		default:System.out.println("Please Enter Valid Browser Key");
			break;
		}
		return driver;
	}
	
	/**
	 * This method is to maximize the browser
	 * @param driver
	 */
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is use to wait till page gets load.
	 * @param driver
	 * @param time
	 */
	public void pageWaitTillLoad(WebDriver driver, long time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	/**
	 * this method is used to navigate to the application by passing url
	 * @param driver
	 * @param url
	 */
	public void navigateToApplication(WebDriver driver, String url)
	{
		driver.get(url);
	}
	
	/**
	 * This  method is used to close the application.
	 * @param driver
	 */
	public void closeTheApplication(WebDriver driver)
	{
		driver.quit();
	}
	/**
	 * This method is used to launch the browser, maximize, wait till the page gets load, then open application with the help of url.
	 * @param browser
	 * @param time
	 * @param url
	 * @return
	 */
	public WebDriver openBrowserWithApplication(String browser,long time,String url)
	{
		WebDriver driver = openBrowser(browser);
		maximizeBrowser(driver);
		pageWaitTillLoad(driver,time);
		navigateToApplication(driver,url);
		return driver;
		
	}
	
	/**
	 * This method is used to perform mousehover action on Element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverActionForWebelement(WebDriver driver,WebElement element) 
	{
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method is used to double click on element
	 * @param driver
	 * @param element
	 */
	 public void doubleClickOnElement(WebDriver driver, WebElement element)
	 {
		 act.doubleClick(element).perform();
	 }
	 
	 /**
	  * This method is used to double click on webpage
	  * @param driver
	  */
	 public void doubleClickOnWebpage(WebDriver driver)
	 {
		 act.doubleClick().perform();
	 }
	 
	 /**
	  * This method used to select the option on dropdown
	  * @param element1
	  * @param data1
	  */
	 public void selectDropdown(WebElement element1, String data1)
	 {
		 Select s1 = new Select(element1);
		 s1.selectByVisibleText(data1);
	 }
	 
	 /**
	  * this method is used to handle disabled Element
	  * @param driver
	  * @param x
	  * @param y
	  */
	 public void javaScriptExecutor(WebDriver driver,int x, int y)
	 {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy("+x+","+y+")");
	 }
	 
	 /**
	  * this is used to handle Alert pop-up
	  * @param driver
	  */
	 public void toHandleAlert()
	 {
		alert.accept();
	 }
	 
	 /**
	  * This is used to clear the data in a Text field
	  * @param element2
	  */
	 public void toClearDataInTextBox(WebElement element2)
	 {
		element2.sendKeys(Keys.CONTROL+"a"); 
	 }
	 
	 /**
	  * this method is used to wait till the element is visible and then it will continue further statement
	  * @param driver
	  * @param time1
	  * @param element2
	  */
	 public void waitTillElementVisible(WebDriver driver, long time1, WebElement element2)
	 {
		 WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(time1));
		 wait.until(ExpectedConditions.visibilityOf(element2));
	 }
	 
	 /**
	  * this method is used in child browser to switch to particular browser
	  * @param driver
	  * @param partialurl
	  */
	 public void switchTowindow(WebDriver driver,String partialurl)
	 {
		 Set<String> ids = driver.getWindowHandles();
		 for(String id:ids)
		 {
			 driver.switchTo().window(id);
			 if(driver.getCurrentUrl().equalsIgnoreCase(partialurl))
			 {
				 break;
			 }
		 }
	 }
	 
	 
	 /**
	  * This method is used to intialize the JavaScript executor
	  * @param driver
	  */
	 public void intializeJavascriptExecutor(WebDriver driver)
	 {
		 js=(JavascriptExecutor) driver;
	 }
	 
	 /**
	  * This method is used to launch the application from by javascriptExecutor
	  * @param url
	  */
	 public void launchApplication(String url)
	 {
		 js.executeScript("window.location=arguments[0]", url);
	 }
	 
	 /**
	  * this method is used to send the data into webelement by javascriptexecutor
	  * @param element
	  * @param data
	  */
	 public void sendKeysUsingJS(WebElement element, String data)
	 {
		 js.executeScript("arguments[0].value=arguments[1]", element, data);
	 }
	 
	 /**
	  * this method is used to click on the element by javascriptexecutor
	  * @param element
	  */
	 public void clickUsingJS(WebElement element)
	 {
		 js.executeScript("arguments[0].click()", element);
	 }
	 
	 /**
	  * this method is used to scroll to the particular element by javascriptexecutor
	  * @param element
	  */
	 public void scrollTillElementUsingJS(WebElement element)
	 {
		 js.executeScript("arguments[0].scrollIntoView()", element);
	 }
	 
	 /**
	  * this method is used to switch the control to alert and click on cancel
	  * @param driver
	  */
	 public void handleAlertAndCancelIt(WebDriver driver)
	 {
		 alert.dismiss();
	 } 
	 
	 public Actions actioninit()
	 {
		 act = new Actions(driver);
		 return act;
	 }
	 
	 public Alert alertinit()
	 {
		 alert = driver.switchTo().alert();
		 return alert;
	 }
	 public void toCloseChildBrowser()
	 {
		 driver.close();
	 }
	 
	 public void toPerformVerficationByAssertEquals(String r,String g)
	 {
		 Assert.assertEquals(r, g);
	 }
	 
	 public void toperformVerificationByAssertNotEquals(String d, String e)
	 {
		 Assert.assertNotEquals(d, e);
	 }
	 
	 public void verifyWebPage(WebElement element, String expectedText, WebDriver driver,WebElement element1)
	 {
		 for(;;)
		 {
			 try {
				 Assert.assertEquals(element.getText(), expectedText);
				 break;
			 }
			 catch(Exception e)
			 {
				 WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
						 wait.until(ExpectedConditions.visibilityOf(element1));
			 }
			 
		 }
	 }
	 
	 public void softAssertIntiallize()
	 {
		 soft = new SoftAssert();	 
	 }
	 
	 public void compareBySoftAssert(String e,String f)
	 {
		 soft.assertEquals(e, f);
	 }
	 
	 public void softAssertAll()
	 {
		 soft.assertAll();
	 }
	 public void Screenshot(WebDriver driver,JavaUtility javautility,String classname) throws IOException
	 {
	 String currentTime= javautility.currentTime();
	 TakesScreenshot ts = (TakesScreenshot)driver;
	 File src = ts.getScreenshotAs(OutputType.FILE);
	 File dst = new File("./screenshot/"+classname+"+currentTime");
	 FileUtils.copyFile(src, dst);
	 }
	 
	 public String Screenshot(WebDriver driver)
	 {
		 TakesScreenshot ts = (TakesScreenshot)driver;
		 String src = ts.getScreenshotAs(OutputType.BASE64);
		 return src;
	 }
}
