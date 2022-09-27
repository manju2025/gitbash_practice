package org.sales_and_inventory_object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.Tables;

public class CommonPage 
{
WebDriver driver;
	
	private String DynamicXpath="//span[.='%s']";
	private String procat="//a[.='%s']";
	private String Productselect="//div[@id='%s']//following::h6[.='%s']";
	
	@FindBy(xpath="//img[@class='img-profile rounded-circle']")
	private WebElement ProfileImage;
	
	/*@FindBy(xpath="//span[.='Product']")
	private WebElement ProductButtonTab;*/
	
	@FindBy(xpath="//i[@class='fas fa-user fa-sm fa-fw mr-2 text-gray-400']")
	private WebElement ProfileButton;
	
	@FindBy(xpath="//div[@id='text']")
	private WebElement GetProfileText;
	
	@FindBy(xpath="//i[@class='fas fa-cogs fa-sm fa-fw mr-2 text-gray-400']")
	private WebElement SettingButton;

	@FindBy(xpath="//i[@class='fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400']")
	private WebElement LogoutButton;
	
	@FindBy(xpath="//a[.='Logout']")
	private WebElement LogoutConfirm;
	
	@FindBy(xpath="//span[text()='Customer']")
	private WebElement CustomerButtonTab;
	
	@FindBy(xpath="//a[.='Headset']")
	private WebElement HeadsetCategoryTab;
	
	@FindBy(xpath="//div[@id='headset']//div[@class='col-sm-4 col-md-2']//h6[text()='Rpee15']/following-sibling::input[@name='quantity']")
	private WebElement AddQuantityButton;
	
	@FindBy(xpath="//div[@id='headset']//div[@class='col-sm-4 col-md-2']//h6[text()='Rpee15']/following-sibling::input[@name='quantity']/following-sibling::input[@value='Add']")
	private WebElement AddButton;
	
	@FindBy(xpath="//select[@name='customer']")
	private WebElement SelectCustomer;
	
	@FindBy(xpath="//button[.='SUBMIT']")
	private WebElement SubmitButton;
	
	@FindBy(xpath="//span[text()='Transaction']")
	private WebElement TransactionTab;
	
	@FindBy(xpath="//a[text()='Mouse']")
	private WebElement MouseCategoryTab;
	
	@FindBy(xpath="//a[text()='Next']")
	private WebElement NextButton;
	
	@FindBy(xpath="//span[text()='Home']")
	private WebElement HomeButton;

	@FindBy(xpath="//h4[text()='Point of Sale']")
	private WebElement POS;
	
	@FindBy(xpath="//h4[text()='Edit Account Info']")
	private WebElement AccountInfo;
	
	@FindBy(xpath="//i[@class='fas fa-fw fa-plus']")
	private WebElement customerAddButton;
	
	@FindBy(xpath="//h4[text()='Transaction']")
	private WebElement TransactionText;
	
	@FindBy(xpath="//h4[contains(.,'Product')]")
	private WebElement ProductText;
	
	@FindBy(xpath="//h5[text()='Edit User Info']")
	private WebElement CashUserInfo;
	
	public CommonPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;		
	}
	
	public void profileImage()
	{
		ProfileImage.click();
	}
	
	/*public void productButton()
	{
		ProductButtonTab.click();
	}*/
	
	public void profileButton()
	{
		ProfileButton.click();
	}
	
	public void clickOnProfileText()
	{
		GetProfileText.click();
	}
	
	public String getProfileText()
	{
		String text = GetProfileText.getText();
		return text;
	}
	
	public void settingButton()
	{
		SettingButton.click();
	}
	
	public void logoutButton()
	{
		LogoutButton.click();
	}
	
	public void customerButtonTab()
	{
		CustomerButtonTab.click();
	}
	
	public void logoutConfirmButton()
	{
		LogoutConfirm.click();
	}
	public void clickHeadsetCategoryTab()
	{
		HeadsetCategoryTab.click();
	}
	public WebElement addQuantity()
	{
		return AddQuantityButton;
	}
	public void clickAddButton()
	{
		AddButton.click();
	}
	public WebElement selectCustomer()
	{
		return SelectCustomer;
	}
	public void clickSubmitButton()
	{
		SubmitButton.click();
	}
	public void clickTransaction()
	{
		TransactionTab.click();	
	}
	public void ClickMouseCategoryTab()
	{
		MouseCategoryTab.click();
	}
	
	private WebElement convertStringIntoCategoryWebelement(String required)
	{
		String actualvalue = String.format(DynamicXpath, required);
		WebElement element = driver.findElement(By.xpath(actualvalue));
		return element;
	}
	 public  void specifyCondition(TablesNames condition)
	 {
		 convertStringIntoCategoryWebelement(condition.toString()).click();
	 }
	 
	 public WebElement convertStringIntoProductWebelement(String value1, String value2)
	 {
		String actualvalue1 = String.format(Productselect, value1, value2);
		WebElement element1 = driver.findElement(By.xpath(actualvalue1));
		return element1;
	 }
	 
	 public String specifyCondition1(String value1, String value2)
	 {
		 String text = convertStringIntoProductWebelement(value1, value2).getText();
		 return text;
	 }
	 
	 public WebElement convertStringIntoProdcat(String value1)
	 {
		 String actualvalue2 = String.format(procat, value1);
		 WebElement element2 = driver.findElement(By.xpath(actualvalue2));
		 return element2;
	 }
	 
	 public void specifyprodcat(TablesNames pro)
	 {
		 convertStringIntoProdcat(pro.toString()).click();
	 }
	 
	 public void clickOnNextButton()
	 {
		 NextButton.click();
	 }
	 
	 public WebElement homebutton()
	 {
		return HomeButton; 
	 }
	 
	 public WebElement pos()
	 {
		return POS;
	 }
	 
	 public WebElement accountInfoValidation()
	 {
		return AccountInfo;
	
	 }
	 
	 public void customerAddButton()
	 {
		 customerAddButton.click();
	 }
	 
	 public WebElement transactionText()
	 {
		  return TransactionText;
	 }
	 
	 public WebElement productText()
	 {
		return ProductText;
	 }
	 
	 public WebElement cashUserInfo()
	 {
		return CashUserInfo;
	 }
}
