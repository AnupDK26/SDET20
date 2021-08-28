package com.vitiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitieslink;
	
	@FindBy(xpath="//a[@href=\"index.php?module=Contacts&action=index\"]")
	private WebElement contactLink;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutButton;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOut;

//	public WebDriver getDriver() {
//		return driver;
//	}

	public WebElement getOpportunitieslink() {
		return opportunitieslink;
	}
	
	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public WebElement getSignOut() {
		return signOut;
	}
	
	public void contactPageLinkClick()
	{
		contactLink.click();
	}
	
	public void logoutFromApp()
	{
		Actions action = new Actions(driver);
		action.moveToElement(logoutButton).perform();
		signOut.click();
	}
	
	
}
