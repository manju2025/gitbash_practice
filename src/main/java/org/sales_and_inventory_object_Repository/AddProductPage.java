package org.sales_and_inventory_object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductPage {

	@FindBy(xpath="//input[@placeholder='Product Code']")
	private WebElement ProductCodeTextField;
	
	@FindBy(xpath="//input[@placeholder='Name']")
	private WebElement ProductNameTextField;
	
	@FindBy(xpath="//textarea[@placeholder='Description']")
	private WebElement DescriptionTextField;
	
	@FindBy(xpath="//input[@placeholder='Quantity']")
	private WebElement QuantityTextField;
	
	@FindBy(xpath="//input[@placeholder='On Hand']")
	private WebElement OnHandTextField;
	
	@FindBy(xpath="//input[@placeholder='Price']")
	private WebElement PriceTextField;
	
	@FindBy(xpath="//select[@name='category']")
	private WebElement CategoryDropDown;
	
	@FindBy(xpath="//select[@name='supplier']")
	private WebElement SupplierDropDown;
	
	@FindBy(name="datestock")
	private WebElement DateTextField;
	
	@FindBy(xpath="//input[@placeholder='Date Stock In']/parent::div/following-sibling::button[@class='btn btn-success']")
	private WebElement ProductSaveButton;
	
	public AddProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Bussiness directory
	public void sendProductCode(String productcode)
	{
		ProductCodeTextField.sendKeys(productcode);
	}
	
	public void sendProductName(String productname)
	{
		ProductNameTextField.sendKeys(productname);
	}
	
	public void sendDescription(String description)
	{
		DescriptionTextField.sendKeys(description);
	}
	
	public void sendQuantity(String quantity)
	{
		QuantityTextField.sendKeys(quantity);
	}
	
	public void sendOnHand(String onhand)
	{
	OnHandTextField.sendKeys(onhand);
	}
	
	public void sendPrice(String price)
	{
		PriceTextField.sendKeys(price);
	}
	
	public WebElement fetchCategoryAddress()
	{
		return CategoryDropDown;
	}
	
	public void clickCategory()
	{
		CategoryDropDown.click();
	}
	
	public WebElement fetchSupplierAddress()
	{
		return SupplierDropDown;
	}
	
	public void clickSupplier()
	{
		SupplierDropDown.click();
	}
	
	public WebElement fetchDateAddress()
	{
		return DateTextField;
	}
	
	public void clickDate()
	{
		DateTextField.click();
	}
	
	 public void sendDate(String date)
	 {
		 DateTextField.sendKeys(date);
	 }
	
	public void clickSaveButton()
	{
		ProductSaveButton.click();
	}
}
