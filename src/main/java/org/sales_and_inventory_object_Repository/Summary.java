package org.sales_and_inventory_object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Summary {
	@FindBy(xpath="//h3[@class='font-weight-bold py-3 bg-light']")
	private WebElement Cost;
	
	@FindBy(xpath="//input[@id='txtNumber']")
	private WebElement EnterAmountTF;

	@FindBy(xpath="//button[.='PROCEED TO PAYMENT']")
	private WebElement ProceedPaymentButton;
	
	public Summary(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String costGetText()
	{
		String amount = Cost.getText();
		return amount;
	}
	public void enterAmountTF(String rate)
	{
		EnterAmountTF.sendKeys(rate);
	}
	public void proceedToPayment()
	{
		ProceedPaymentButton.click();
	}
	
	/* public void towaitUntilTextFetch()
	 {
		 while(count4<duration)
			{
				try {
			//cost=driver.findElement(By.xpath("//h3[@class='font-weight-bold py-3 bg-light']")).getText();
				cost=sum.costGetText();	
			if(cost.isEmpty()) 
				continue;
			break;
				}
				catch(Exception e)
				{
			Thread.sleep(1000);    //polling period
			count4++;
				}
			}
	 }*/
}
