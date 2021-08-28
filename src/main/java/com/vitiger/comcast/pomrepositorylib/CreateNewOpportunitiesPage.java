package com.vitiger.comcast.pomrepositorylib;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.comcast.genericUtility.JavaUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class CreateNewOpportunitiesPage {
	
	
	public WebDriver driver;
	
	public CreateNewOpportunitiesPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="potentialname")
	private WebElement opportunityName;
	
	@FindBy(id="related_to_type")
    private WebElement relatedTo;

    @FindBy(xpath="//select[@id='related_to_type']/../following-sibling::td//img")
    private WebElement contactLookUpPage;

	@FindBy(xpath="//a[text()='Arun A']")
    private WebElement selectContactName;
	
	@FindBy(linkText="BigBasket")
	private WebElement selectOrganizationName;
	
	@FindBy(name="assigntype")
	private WebElement assignTypeRadioButton;
	
	@FindBy(name="assigned_user_id")
	private WebElement assignedToDropDownList;
	
	@FindBy(id="jscal_field_closingdate")
	private WebElement closeDate;
	
	@FindBy(name="sales_stage")
	private WebElement salesStageDropDownList;
	
	@FindBy(xpath="//b[text()='Opportunity Information:']/parent::td/parent::tr/preceding-sibling::tr//input[@title='Save [Alt+S]']")
	private WebElement save;

	public WebElement getOpportunityName() {
		return opportunityName;
	}

	public WebElement getRelatedTo() {
		return relatedTo;
	}

	public WebElement getContactLookUpPage() {
		return contactLookUpPage;
	}

	public WebElement getSelectContactName() {
		return selectContactName;
	}

	public WebElement getAssignTypeRadioButton() {
		return assignTypeRadioButton;
	}

	public WebElement getAssignedToDropDownList() {
		return assignedToDropDownList;
	}

	public WebElement getCloseDate() {
		return closeDate;
	}

	public WebElement getSalesStageDropDownList() {
		return salesStageDropDownList;
	}

	public WebElement getSave() {
		return save;
	}
    

	WebDriverUtility wbu = new WebDriverUtility();	
	 
	  
	public void enterOpportunitesPagedata(String OpportunityName, String RelatedTo, String AssignedToDropDownList,String date, String SalesStageDropDownList) 
	{
		opportunityName.sendKeys(OpportunityName);
		wbu.select(relatedTo, RelatedTo);
		String parentWindowId = driver.getWindowHandle();
    	contactLookUpPage.click();
    	Set<String> childWindowId = driver.getWindowHandles();
    	childWindowId.remove(parentWindowId);
    	for(String ele:childWindowId)
    	{
    		driver.switchTo().window(ele);
    		selectContactName.click();
    	}
    	driver.switchTo().window(parentWindowId);
    	
    	wbu.select(assignedToDropDownList, AssignedToDropDownList);
    	
    	closeDate.clear();
    	closeDate.sendKeys(date);
    	
    	wbu.select(salesStageDropDownList, SalesStageDropDownList);
    	save.click();
    	
	}
	
	public void enterOpportunitesPagedataOrgName(String OpportunityName, String RelatedTo, String AssignedToDropDownList,String date, String SalesStageDropDownList) 
	{
		opportunityName.sendKeys(OpportunityName);
		wbu.select(relatedTo, RelatedTo);
		String parentWindowId = driver.getWindowHandle();
    	contactLookUpPage.click();
    	Set<String> childWindowId = driver.getWindowHandles();
    	childWindowId.remove(parentWindowId);
    	for(String ele:childWindowId)
    	{
    		driver.switchTo().window(ele);
    		selectOrganizationName.click();
    	}
    	driver.switchTo().window(parentWindowId);
    	
    	wbu.select(assignedToDropDownList, AssignedToDropDownList);
    	
    	closeDate.clear();
    	closeDate.sendKeys(date);
    	
    	wbu.select(salesStageDropDownList, SalesStageDropDownList);
    	save.click();
    	
	}
    
	
	
	
	
//    public void contactLookUp()
//    {
//    	String parentWindowId = driver.getWindowHandle();
//    	contactLookUpPage.click();
//    	Set<String> childWindowId = driver.getWindowHandles();
//    	childWindowId.remove(parentWindowId);
//    	for(String ele:childWindowId)
//    	{
//    		driver.switchTo().window(ele);
//    		selectContactName.click();
//    	}
//    	driver.switchTo().window(parentWindowId);
//    	
//    }
//   
//  
//    
//    public void OrganizationsLookUp(String data)
//    {
//    	
//        Select s = new Select(relatedTo);
//    	s.selectByVisibleText(data);
//    	
//        String parentWindowId = driver.getWindowHandle();
//    	contactLookUpPage.click();
//    	Set<String> childWindowId = driver.getWindowHandles();
//    	childWindowId.remove(parentWindowId);
//    	for(String ele:childWindowId)
//    	{
//    		driver.switchTo().window(ele);
//    		selectOrganizationName.click();
//    	}
//    	driver.switchTo().window(parentWindowId);
//    	
//    }
    
    
//    public void OrganizationsLookUp()
//    {
//    	
//    	String parentWindowId = driver.getWindowHandle();
//    	contactLookUpPage.click();
//    	Set<String> childWindowId = driver.getWindowHandles();
//    	childWindowId.remove(parentWindowId);
//    	for(String ele:childWindowId)
//    	{
//    		driver.switchTo().window(ele);
//    		selectOrganizationName.click();
//    	}
//    	driver.switchTo().window(parentWindowId);
//    	
//    }
    
//    public void OrganizationsLookUp()
//    {
//    	String parentWindowId = driver.getWindowHandle();
//    	contactLookUpPage.click();
//    	List<String> childWindowID = new ArrayList<String>(driver.getWindowHandles());
//    	driver.switchTo().window(childWindowID.get(1));
//    	selectOrganizationName.click();
//    	driver.switchTo().window(parentWindowId);
//    }
    




	
    
	
}
