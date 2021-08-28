package com.vitiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	 public WebDriver driver;
	   public ContactPage(WebDriver driver)
	   {   
		   this.driver=driver;
		   PageFactory.initElements(driver, this);
	   }

	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createNewContactLinkImg;
	
	@FindBy(xpath="//a[text()='Ashok']/parent::td[contains(@onmouseover,'vtlib')]/following-sibling::td/a[text()='del']")
    private WebElement deleteContact;

	public WebElement getCreateNewContactLinkImg() {
		return createNewContactLinkImg;
	}

	public WebElement getDeleteContact() {
		return deleteContact;
	}
	
}
