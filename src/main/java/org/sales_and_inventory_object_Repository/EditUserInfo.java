package org.sales_and_inventory_object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditUserInfo
{
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement AdminFirstNameTF;
	
	@FindBy(xpath="//select[@name='gender']")
	private WebElement AdminGenderTF;
	
	@FindBy(xpath="//button[text()='Update']/preceding::div[@class='col-sm-9']/input[@placeholder='Password']")
	private WebElement AdminPasswordTF;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement UpdateButton;
	
	@FindBy(xpath="(//input[@placeholder='First Name'])[4]")
	private WebElement CashNameTF;
	
	@FindBy(xpath="(//select[@name='gender'])[2]")
	private WebElement CashgenderTF;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement cashPasswordTF;
	
	@FindBy(xpath="(//button[text()='Save'])[4]")
	private WebElement cashSaveButton;
	
	public EditUserInfo(WebDriver driver)
	{
PageFactory.initElements(driver, this);
	}
	
	public WebElement fetchAddressAdminFNTF()
	{
		return AdminFirstNameTF;
	}
	public void adminFirstNameTF(String firstname)
	{
		AdminFirstNameTF.sendKeys(firstname);
	}
	
	public WebElement fetchAdminGenderTF()
	{
		return AdminGenderTF;
	}
	
	public void adminPasswordTF(String password)
	{
		AdminPasswordTF.sendKeys(password);
	}
	
	public void clickUpdateButton()
	{
		UpdateButton.click();
	}
	
	public WebElement fetchCashFirstNameTF()
	{
		return CashNameTF;
	}
	public void cashFirstNameTF(String firstname)
	{
		CashNameTF.sendKeys(firstname);
	}
	public WebElement fetchCashGenderTF()
	{
		return CashgenderTF;
	}
	
	public void cashPasswordTF(String password)
	{
		cashPasswordTF.sendKeys(password);
	}
	public void clickCashSaveButton()
	{
		cashSaveButton.click();
	}
}
