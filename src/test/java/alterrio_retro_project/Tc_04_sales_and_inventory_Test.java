package alterrio_retro_project;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.sales_and_inventory_object_Repository.ProductPage;
import org.sales_and_inventory_object_Repository.Summary;
import org.sales_and_inventory_object_Repository.TablesNames;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tyss.sales_and_inventory_Generic_script.BaseClass;

public class Tc_04_sales_and_inventory_Test  extends BaseClass{
	@Test
	public void main() throws InterruptedException {
		Map<String, String> map = excel.getDataFromExcelByMap("Sheet3");
		String cashierun = file.getDataFromPropertyAfterIntialize("Cashierusername");
		System.out.println(cashierun);
		String cashierpwd = file.getDataFromPropertyAfterIntialize("Cashierpassword");
		System.out.println(cashierpwd);
		String adminun = file.getDataFromPropertyAfterIntialize("Adminusername");
		System.out.println(adminun);
		String adminpwd = file.getDataFromPropertyAfterIntialize("Adminpassword");
		System.out.println(adminpwd);
		Summary sum = new Summary(driver);
		ProductPage product = new ProductPage(driver);
		login.loginIntoApplication(cashierun, cashierpwd);
		web.alertinit();
		web.toHandleAlert();
		web.verifyWebPage(com.pos(), "Point of Sale", driver,com.pos());
		com.clickHeadsetCategoryTab();
		WebElement add = com.addQuantity();
		web.toClearDataInTextBox(add);
		add.sendKeys(map.get("add"));
		com.clickAddButton();
		WebElement customer = com.selectCustomer();
		web.selectDropdown(customer, map.get("customer"));
		com.clickSubmitButton();
		String cost=null;
		int count4=0;
		int duration=10;
		while(count4<duration)
		{
			try {
			cost=sum.costGetText();	
		if(cost.isEmpty()) 
			continue;
		break;
			}
			catch(Exception e)
			{
		Thread.sleep(1000);    
		count4++;
			}
		}
		System.out.println(cost);
		sum.enterAmountTF(cost);
		sum.proceedToPayment();
		web.toHandleAlert();
		com.profileImage();
		com.logoutButton();
		com.logoutConfirmButton();
		login.loginIntoApplication(adminun, adminpwd);
		web.toHandleAlert();
		com.specifyCondition(TablesNames.Transaction);
		web.verifyWebPage(com.transactionText(), "Transaction", driver, com.transactionText());
		String cstring = product.nextButton();
int c = Integer.parseInt(cstring);
System.out.println(c);
int count=0;
for(int i=1;i<c;i++)
{
	List<WebElement> ele = product.fetchTableData();
	for(WebElement r:ele)
	{
		if(r.getText().equalsIgnoreCase(map.get("customer")))
		{
			System.out.println("Tc is pass");
			count++;
			break;
		}
	}
	if(count==1)
	{
		break;
	}
	com.specifyprodcat(TablesNames.Next);
}
if(count==0)
{
	Assert.fail("Customer name is not present in the table");
}
	}

}
