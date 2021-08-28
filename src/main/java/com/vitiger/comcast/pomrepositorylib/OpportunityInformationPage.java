package com.vitiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.ExcelUtility;

public class OpportunityInformationPage {
	
	
	public WebDriver driver;
	
	
	public OpportunityInformationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement opportunityInformationText;
	
	@FindBy(xpath="//a[@href=\"index.php?module=Contacts&action=index\"]")
	private WebElement contactLink;
	


	public WebElement getContactLink() {
		return contactLink;
	}



	public WebElement getOpportunityInformationText() {
		return opportunityInformationText;
	}
	
}
