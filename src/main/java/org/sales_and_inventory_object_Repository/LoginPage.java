package org.sales_and_inventory_object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	//declaration
		@FindBy(xpath="//input[@type='text']")
		private WebElement UserNameTextfield;
		
		@FindBy(xpath="//input[@type='password']")
		private WebElement PasswordTextfield;
		
		@FindBy(xpath="//button[@type='submit']")
		private WebElement LoginButton;
		
		//intialization 
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		
		//Business Directory
		public void loginIntoApplication(String username, String password)
		{
			UserNameTextfield.sendKeys(username);
			PasswordTextfield.sendKeys(password);
			LoginButton.click();
		}

		public WebElement loginText()
		{
			return LoginButton;
		}	
}
