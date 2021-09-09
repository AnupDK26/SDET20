package com.vtiger.comcast.opportunitytest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vitiger.comcast.pomrepositorylib.CreateNewOpportunitiesPage;
import com.vitiger.comcast.pomrepositorylib.HomePage;
import com.vitiger.comcast.pomrepositorylib.Login;
import com.vitiger.comcast.pomrepositorylib.OpportunitiesPage;
import com.vitiger.comcast.pomrepositorylib.OpportunityInformationPage;
import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.FileUtility;

public class TC_02_OpportunityTest extends BaseClass {

	
	    @Test(groups= "SmokeTest")
		public  void createOpportunityTest() throws Throwable
		{
			
	    	String OPPORTUNITYNAME = excelU.getDataFromExcelSheet("Sheet1", 1, 2);
	    	String CONTACTS = excelU.getDataFromExcelSheet("Sheet1", 2, 2);
	    	String ORGANIZATION = excelU.getDataFromExcelSheet("Sheet1", 3, 2);
	    	String ADMINISTRATOR = excelU.getDataFromExcelSheet("Sheet1", 4, 2);
	    	String PROSPETING = excelU.getDataFromExcelSheet("Sheet1", 5, 2);
	    	String CLOSINGDATE = excelU.getDataFromExcelSheet("Sheet1", 6, 2);
	    	String EXPECTEDTEXT = excelU.getDataFromExcelSheet("Sheet1", 7, 2);
	    	String FIRSTNAME = excelU.getDataFromExcelSheet("Sheet1", 8, 1);
	    	String LASTNAME = excelU.getDataFromExcelSheet("Sheet1", 8, 2);
		    
		    System.out.println("Home Page is Displayed");
		    System.out.println("=============2a=============");
		    
		    /*Step 3 : Click on Opportunities*/
		    HomePage homePage = new HomePage(driver);
//		    homePage.contactPageLinkClick();
		    homePage.getOpportunitieslink().click();
		    
//		    CreateNewContactPage createNewContactPage = new CreateNewContactPage(driver);
//		    createNewContactPage.getClickOnCreateContactImg().click();
//		    createNewContactPage.getContactNameDetails(FIRSTNAME, LASTNAME);
//		    createNewContactPage.getOpportunitieslink().click();
//		    System.out.println("Opportunities ListPage is Displayed");
		    
		    /*Step 4 : Navigate to create new Opportunities page*/
		    OpportunitiesPage opportunitiesPage = new OpportunitiesPage(driver);
		    opportunitiesPage.getCreateOpportunitiesimg().click();
		    
		    System.out.println("Create new Opportunities is Displayed");
		    
		    /*Step 5 : Create a opportunity with Mandatory Field */
		    CreateNewOpportunitiesPage createNewOpportunitiesPage = new CreateNewOpportunitiesPage(driver);
		    createNewOpportunitiesPage.enterOpportunitesPagedata(OPPORTUNITYNAME, CONTACTS, ADMINISTRATOR, CLOSINGDATE , PROSPETING );
		    
		    OpportunityInformationPage opportunityInformationPage = new OpportunityInformationPage(driver);
		    String actualText = opportunityInformationPage.getOpportunityInformationText().getText();
		    
		    if(actualText.contains(EXPECTEDTEXT))
		    {
		    	System.out.println("Pass : Opportunity Information Page is created");
		    }
		    else
		    {
		    	System.out.println("Fail : Opportunity Information Page is not created");
		    }
		    
		   System.out.println("==========Test1=================");
					
		}
	
		
//		@Test(groups="regressionTest")
//		/*Test script 02*/
//		public void createOpportunitywithMappingofExistingContactsTest() throws Throwable {
//			
//			String OPPORTUNITYNAME = excelU.getDataFromExcelSheet("Sheet1", 1, 2);
//			String CONTACTS = excelU.getDataFromExcelSheet("Sheet1", 2, 2);
//			System.out.println(CONTACTS);
//			String ORGANIZATION = excelU.getDataFromExcelSheet("Sheet1", 3, 2);
//			String ADMINISTRATOR = excelU.getDataFromExcelSheet("Sheet1", 4, 2);
//			String PROSPETING = excelU.getDataFromExcelSheet("Sheet1", 5, 2);
//			String CLOSINGDATE = excelU.getDataFromExcelSheet("Sheet1", 6, 2);
//			String EXPECTEDTEXT = excelU.getDataFromExcelSheet("Sheet1", 7, 2);
//			String FIRSTNAME = excelU.getDataFromExcelSheet("Sheet1", 8, 1);
//	    	String LASTNAME = excelU.getDataFromExcelSheet("Sheet1", 8, 2);
//		    
//		    System.out.println("Home Page is Displayed");
//		    
//		    /*Step 3 : Click on Opportunities*/
//		    HomePage homePage = new HomePage(driver);
////		    homePage.contactPageLinkClick();
////		    homePage.contactPageLinkClick();
//		    homePage.getOpportunitieslink().click();
//		    
//		    /*Step 4 : Navigate to create new Opportunities page*/
//		    OpportunitiesPage opportunitiesPage = new OpportunitiesPage(driver);
//		    opportunitiesPage.getCreateOpportunitiesimg().click();
//		    
//		    System.out.println("Create new Opportunities is Displayed");
//		    
//		    /*Step 5 : Create a opportunity with Mandatory Field */
//		    CreateNewOpportunitiesPage createNewOpportunitiesPage = new CreateNewOpportunitiesPage(driver);
//		    createNewOpportunitiesPage.enterOpportunitesPagedata(OPPORTUNITYNAME, CONTACTS, ADMINISTRATOR, CLOSINGDATE , PROSPETING );
//		    
//		    OpportunityInformationPage opportunityInformationPage = new OpportunityInformationPage(driver);
//		    String actualText = opportunityInformationPage.getOpportunityInformationText().getText();
//		    
//		    if(actualText.contains(EXPECTEDTEXT))
//		    {
//		    	System.out.println("Pass : Opportunity Information Page is created");
//		    }
//		    else
//		    {
//		    	System.out.println("Fail : Opportunity Information Page is not created");
//		    }
//		    
//		    System.out.println("==========Test2=================");
//		    
//	//   opportunityInformationPage.getContactLink().click();
////		    
////		    ContactPage contactPage1 = new ContactPage(driver);
////		    contactPage1.getDeleteContact().click();
////		    
//////		    homePage.logoutFromApp();
////				
////		    WebDriverUtility wbu = new WebDriverUtility();
////		    wbu.alertPopUp();
//
//		}
//
//		@Test(groups={"smokeTest","regressionTest"})
//		/*Test script 03*/
//		public void createOpportunityWithMappingOrganizationTest() throws Throwable {
//
//	 
//			String OPPORTUNITYNAME = excelU.getDataFromExcelSheet("Sheet1", 1, 2);
//			String CONTACTS = excelU.getDataFromExcelSheet("Sheet1", 2, 2);
//			String ORGANIZATION = excelU.getDataFromExcelSheet("Sheet1", 3, 2);
//			String ADMINISTRATOR = excelU.getDataFromExcelSheet("Sheet1", 4, 2);
//			String PROSPETING = excelU.getDataFromExcelSheet("Sheet1", 5, 2);
//			String CLOSINGDATE = excelU.getDataFromExcelSheet("Sheet1", 6, 2);
//			String EXPECTEDTEXT = excelU.getDataFromExcelSheet("Sheet1", 7, 2);
//			String FIRSTNAME = excelU.getDataFromExcelSheet("Sheet1", 8, 1);
//	    	String LASTNAME = excelU.getDataFromExcelSheet("Sheet1", 8, 2);
//		    
//		    System.out.println("Home Page is Displayed");
//		    
//		    /*Step 3 : Click on Opportunities*/
//		    HomePage homePage = new HomePage(driver);
//		    homePage.getOpportunitieslink().click();
//		    System.out.println("Opportunities ListPage is Displayed");
//		    
//		    OpportunitiesPage opportunitiesPage = new OpportunitiesPage(driver);
//		    opportunitiesPage.getCreateOpportunitiesimg().click();
//		    
//		    /*Step 5 : Create a opportunity with Mandatory Field */
//		    CreateNewOpportunitiesPage createNewOpportunitiesPage = new CreateNewOpportunitiesPage(driver);
//		    createNewOpportunitiesPage.enterOpportunitesPagedataOrgName(OPPORTUNITYNAME, ORGANIZATION, ADMINISTRATOR, CLOSINGDATE , PROSPETING );
//		    OpportunityInformationPage opportunityInformationPage = new OpportunityInformationPage(driver);
//		    String actualText = opportunityInformationPage.getOpportunityInformationText().getText();
//		    
//		    if(actualText.contains(EXPECTEDTEXT))
//		    {
//		    	System.out.println("Pass : Opportunity Information Page is created");
//		    }
//		    else
//		    {
//		    	System.out.println("Fail : Opportunity Information Page is not created");
//		    }
//		    
//		    System.out.println("==========Test3=================");
//
//		   
//		}
	
}

