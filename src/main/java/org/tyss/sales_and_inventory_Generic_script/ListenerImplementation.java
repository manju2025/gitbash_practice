package org.tyss.sales_and_inventory_Generic_script;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener              {
private ExtentReports reports;
public static ExtentTest stest;
private ExtentTest test;
	@Override  //BM
	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getMethod().getMethodName());
		ExtentTest stest = test;
	}

	@Override  //AM
	public void onTestSuccess(ITestResult result) {
	test.pass(result.getMethod().getMethodName()+" pass");
		
	}

	@Override   //AM
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		/*try {
			new WebDriverUtility().Screenshot(BaseClass.sdriver,BaseClass.sjavaJavautility, result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		String address = new WebDriverUtility().Screenshot(BaseClass.sdriver);
		test.addScreenCaptureFromBase64String(address);
		}
	@Override  //AM
	public void onTestSkipped(ITestResult result) {
	test.skip("test1 skip");
		
	}

	@Override  //AM
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		
	}

	@Override //BT
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./extentReport/extentreport.html");
		spark.config().setDocumentTitle("Document title_sales and inventory");
		spark.config().setReportName("report name Sales And inventory");
		spark.config().setTheme(Theme.DARK);
		
		reports=new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("author","manjesh");
		reports.setSystemInfo("OS","win 11");
		reports.setSystemInfo("Browser","Chrome");
		
	}

	@Override //AT
	public void onFinish(ITestContext context) {
reports.flush();
		
	}

}
