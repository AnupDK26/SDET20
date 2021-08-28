package com.vitiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {

	public WebDriver driver;
	
    public CreateNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="firstname")
	private WebElement firstName;
	
	@FindBy(name="lastname")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement clickOnCreateContactImg;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitieslink;

	

	public WebElement getOpportunitieslink() {
		return opportunitieslink;
	}

	public WebElement getClickOnCreateContactImg() {
		return clickOnCreateContactImg;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void getContactNameDetails(String firstName, String lastName)
	{
		getFirstName().sendKeys(firstName);
		getLastName().sendKeys(lastName);
		saveButton.click();
	}
	
}
