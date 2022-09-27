package org.tyss.sales_and_inventory_Generic_script;

import org.openqa.selenium.WebDriver;
import org.sales_and_inventory_object_Repository.CommonPage;
import org.sales_and_inventory_object_Repository.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseClass 
{
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected FileUtility file;
	private String url;
	protected JavaUtility jv;
	private String browser;
	protected WebDriver driver;
	protected LoginPage login;
	protected CommonPage com;
	public static WebDriver sdriver;
	public static JavaUtility sjavaJavautility;

	/**
	 * intialize the all utility class
	 * open the excel, property file
	 * read the common data
	 * create the instance for browser(launch browser)
	 * maximize, implicit wait
	 * open the application
	 * intiallllllize jsexecutor, actions, webdriverwait
	 * create the instance for common object repo
	 */
	//@Parameters(value="browser")
	@BeforeClass(groups = "a")
	public void setupApp()
	{
		//create instance for the Generic Utility
		excel = new ExcelUtility();
		web = new WebDriverUtility();
		file = new FileUtility();
		jv = new JavaUtility();
		
		//intiallize the property file and excelfile
		file.intializePropertyFile(Iconstants.PROPERTY_FILE);
		excel.openExcelPage(Iconstants.EXCEL);
		
		//fetch the data from property file
		url=file.getDataFromPropertyAfterIntialize("Appurl");
		browser = file.getDataFromPropertyAfterIntialize("Browser");
		
		//launching the browser and doing some browser setting
		driver = web.openBrowserWithApplication(browser, 15, url);
		sdriver=driver;
		
		//create object for common pom repo
		login=new LoginPage(driver);
		com = new CommonPage(driver);
	}
	
	@AfterMethod(groups = "b")
	public void logoutSuccess()
	{
		//logout from the application
		com.profileImage();
		com.logoutButton();
		com.logoutConfirmButton();
		web.verifyWebPage(login.loginText(), "Login", driver, login.loginText());
	}
	
	@AfterClass(groups = "c")
	public void closeEntire()
	{
		web.closeTheApplication(driver);
		excel.closeExcelBook();	
	}
	
//	//login to the application 
//	/**
//	 * when ever we create the testscript class for module and test annotation method for testcase
//	 * create the instance for browser(launch browser)
//	 * maximize,implicit wait
//	 * intiallize jsexecutor, actions, webdriverwait
//	 * create the instance for common object repo(driver)
//	 * login to the app
//	 */
//	@BeforeMethod
//	public void methodsetup1()
//	{
//		//login if credentials are same for all the test cases.
//	}	
}
