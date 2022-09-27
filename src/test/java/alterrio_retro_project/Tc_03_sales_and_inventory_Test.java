package alterrio_retro_project;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.sales_and_inventory_object_Repository.EditUserInfo;
import org.testng.annotations.Test;
import org.tyss.sales_and_inventory_Generic_script.BaseClass;

public class Tc_03_sales_and_inventory_Test extends BaseClass
 {
	@Test
	public void main()
	{
		String cashun = file.getDataFromPropertyAfterIntialize("Cashierusername");
		System.out.println(cashun);
		String cashpwd = file.getDataFromPropertyAfterIntialize("Cashierpassword");
		System.out.println(cashpwd);
		Map<String, String> data = excel.getDataFromExcelByMap("Cashier");
		System.out.println(data);
		EditUserInfo edit = new EditUserInfo(driver);
		login.loginIntoApplication(cashun, cashpwd);
		web.alertinit();
		web.toHandleAlert();
		web.verifyWebPage(com.pos(), "Point of Sale", driver,com.pos());
		com.profileImage();
		com.profileButton();
		String r = com.getProfileText();
		com.clickOnProfileText();
		com.profileImage();
		com.settingButton();
		WebElement ele = edit.fetchCashFirstNameTF();
		web.toClearDataInTextBox(ele);
		edit.cashFirstNameTF(data.get("Firstname"));
		WebElement d = edit.fetchCashGenderTF();
		web.selectDropdown(d, data.get("Gender"));
		edit.cashPasswordTF(data.get("Password"));
		edit.clickCashSaveButton();
		web.toHandleAlert();
		com.profileImage();
		com.logoutButton();
		com.logoutConfirmButton();
		login.loginIntoApplication(cashun, cashpwd);
		web.toHandleAlert();
		web.verifyWebPage(com.pos(), "Point of Sale", driver,com.pos());
		com.profileImage();
		com.profileButton();
		String g = com.getProfileText();
		com.clickOnProfileText();
		web.toperformVerificationByAssertNotEquals(r, g);
			}
}
