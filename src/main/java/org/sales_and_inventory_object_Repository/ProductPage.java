package org.sales_and_inventory_object_Repository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	@FindBy(xpath="//i[@class='fas fa-fw fa-plus']" )
	private WebElement ProductAddButton;
	
	@FindBy(xpath="//li[@class='paginate_button page-item '][last()]/a")
	private WebElement NextButton;
	
	@FindBy(xpath="//table//th[text()='Customer']/ancestor::thead/following-sibling::tbody//td[2]")
	private List<WebElement> TablesData;
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickProductAddButton()
	{
		ProductAddButton.click();
	}
	public String nextButton()
	{
		String value = NextButton.getText();
		return value;	
	}
	
	public List<WebElement> fetchTableData()
	{
		return TablesData;
	}
}
