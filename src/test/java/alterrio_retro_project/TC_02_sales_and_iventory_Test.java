package alterrio_retro_project;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.sales_and_inventory_object_Repository.AddProductPage;
import org.sales_and_inventory_object_Repository.ProductPage;
import org.sales_and_inventory_object_Repository.TablesNames;
import org.testng.annotations.Test;
import org.tyss.sales_and_inventory_Generic_script.BaseClass;

public class TC_02_sales_and_iventory_Test extends BaseClass 
{
	@Test
	public void main() throws InterruptedException {
		Map<String, String> value = excel.getDataFromExcelByMap("product create");
		System.out.println(value);
		int productcode = jv.getRandomNumber(1000);
		String productcode1=jv.convertIntTostring(productcode);
		System.out.println(productcode1);
		String pname = value.get("Product Name")+jv.getRandomNumber(100);
		int quantity = jv.getRandomNumber(100);
		String quantity1 = jv.convertIntTostring(quantity);
		System.out.println(quantity1);
		int onhand = jv.getRandomNumber(10);
		String onhand1 = jv.convertIntTostring(onhand);
		System.out.println(onhand1);
		int price = jv.getRandomNumber(1000);
		String price1 = jv.convertIntTostring(price);
		System.out.println(price1);
		String adminun = file.getDataFromPropertyAfterIntialize("Adminusername");
		System.out.println(adminun);
		String adminpwd = file.getDataFromPropertyAfterIntialize("Adminpassword");
		ProductPage product = new ProductPage(driver);
		AddProductPage productadd = new AddProductPage(driver);
		login.loginIntoApplication(adminun, adminpwd);
		web.alertinit();
		web.toHandleAlert();
		web.verifyWebPage(com.homebutton(),"Home", driver, com.homebutton());
		com.specifyCondition(TablesNames.Product);
		web.verifyWebPage(com.productText(),"Product ", driver, com.productText());
		product.clickProductAddButton();
		productadd.sendProductCode(productcode1);
		productadd.sendProductName(pname);
		productadd.sendDescription(value.get("Description")+jv.getRandomNumber(1000));
		productadd.sendQuantity(quantity1);
		productadd.sendOnHand(onhand1);
		productadd.sendPrice(price1);
		@SuppressWarnings("unused")
		WebElement category = productadd.fetchCategoryAddress();
		productadd.clickCategory();
		WebElement supplier = productadd.fetchSupplierAddress();
		productadd.clickSupplier();
		web.selectDropdown(supplier, value.get("supplier"));
		@SuppressWarnings("unused")
		WebElement dateclick = productadd.fetchDateAddress();
		productadd.clickDate();
		productadd.sendDate(value.get("datestock"));
		productadd.clickSaveButton();
		com.profileImage();
		com.logoutButton();
		com.logoutConfirmButton();
		String cashun = file.getDataFromPropertyAfterIntialize("Cashierusername");
		System.out.println(cashun);
		String cashpwd = file.getDataFromPropertyAfterIntialize("Cashierpassword");
		System.out.println(cashpwd);
		login.loginIntoApplication(cashun, cashpwd);
		web.toHandleAlert();
		web.verifyWebPage(com.pos(), "Point of Sale", driver,com.pos());
		String productnm = com.specifyCondition1(value.get("Product id"), pname);
		System.out.println(productnm);
		web.toPerformVerficationByAssertEquals(pname, productnm);
	}	

}
