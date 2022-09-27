package alterrio_retro_project;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.sales_and_inventory_object_Repository.EditUserInfo;
import org.testng.annotations.Test;
import org.tyss.sales_and_inventory_Generic_script.BaseClass;

public class Tc_01_sales_and_inventory_Test extends BaseClass
{
	@Test
	//changes done by enginner1
	public void main() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Map<String, String> map = excel.getDataFromExcelByMap("commondata");
		System.out.println(map);
		String adminusername = file.getDataFromPropertyAfterIntialize("Adminusername");
		String adminpassword = file.getDataFromPropertyAfterIntialize("Adminpassword");
	EditUserInfo edit= new EditUserInfo(driver);
	login.loginIntoApplication(adminusername, adminpassword);
	web.alertinit();
	web.toHandleAlert();
	web.verifyWebPage(com.homebutton(), "Home", driver, com.homebutton());
	com.profileImage();
	com.profileButton();
	//code update
	//codechanges
	//codechange
	//codeup
	//CODE 340
	String r = com.getProfileText();
	com.clickOnProfileText();
	com.profileImage();
	com.settingButton();
	web.verifyWebPage(com.accountInfoValidation(), "Edit Account Info", driver, com.accountInfoValidation());
	WebElement ele = edit.fetchAddressAdminFNTF();
	web.toClearDataInTextBox(ele);
	edit.adminFirstNameTF(map.get("firstname"));
	WebElement d = edit.fetchAdminGenderTF();
	web.selectDropdown(d, map.get("gender"));
	edit.clickUpdateButton();
	com.profileImage();
	com.logoutButton();
	com.logoutConfirmButton();
	login.loginIntoApplication(adminusername, adminpassword);
	web.toHandleAlert();
	web.verifyWebPage(com.homebutton(), "Home", driver, com.homebutton());
	com.profileImage();
	com.profileButton();
	String g = com.getProfileText();
	com.clickOnProfileText();
	web.toperformVerificationByAssertNotEquals(r, g);
	}
}
