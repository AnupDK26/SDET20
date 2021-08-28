package com.vtiger.comcast.opportunitytest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vitiger.comcast.pomrepositorylib.CreateNewOpportunitiesPage;
import com.vitiger.comcast.pomrepositorylib.HomePage;
import com.vitiger.comcast.pomrepositorylib.Login;
import com.vitiger.comcast.pomrepositorylib.OpportunitiesPage;
import com.vitiger.comcast.pomrepositorylib.OpportunityInformationPage;
import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.JavaUtility;

public class TC_03_CreateOpportunityWithMappingOrganization {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

FileUtility filU = new FileUtility();
		
		String BROWSER = filU.propertyFile("browser");
		String URL = filU.propertyFile("url");
		String USERNAME = filU.propertyFile("username");
		String PASSWORD = filU.propertyFile("password");	
		
		ExcelUtility excelU = new ExcelUtility();
		String OPPORTUNITYNAME = excelU.getDataFromExcelSheet("Sheet1", 1, 2);
		String CONTACTS = excelU.getDataFromExcelSheet("Sheet1", 2, 2);
		String ORGANIZATION = excelU.getDataFromExcelSheet("Sheet1", 3, 2);
		String ADMINISTRATOR = excelU.getDataFromExcelSheet("Sheet1", 4, 2);
		String PROSPETING = excelU.getDataFromExcelSheet("Sheet1", 5, 2);
		String CLOSINGDATE = excelU.getDataFromExcelSheet("Sheet1", 6, 2);
		String EXPECTEDTEXT = excelU.getDataFromExcelSheet("Sheet1", 7, 2);
		
	    WebDriver driver = null;
	    if(BROWSER.equals("chrome"))
	    {
	    	driver = new ChromeDriver();
	    }
	    else if(BROWSER.equals("firefox"))
	    {
	    	driver = new FirefoxDriver();
	    }
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    
	    /*Step1 : Navigate to App*/
	    driver.get(URL);
	    System.out.println("Login Page is Displayed");
	    
		/*Step2 : Login to Application */
	    Login login = new Login(driver);
	    login.loginToApp(USERNAME, PASSWORD);
	    
	    System.out.println("Home Page is Displayed");
	    
	    /*Step 3 : Click on Opportunities*/
	    HomePage homePage = new HomePage(driver);
	    homePage.getOpportunitieslink().click();
	    
	    System.out.println("Opportunities ListPage is Displayed");
	    
	    /*Step 4 : Navigate to create new Opportunities page*/
	    OpportunitiesPage opportunitiesPage = new OpportunitiesPage(driver);
	    opportunitiesPage.getCreateOpportunitiesimg().click();
	    
	    System.out.println("Create new Opportunities is Displayed");
	    
	    /*Step 5 : Create a opportunity with Mandatory Field */
	    CreateNewOpportunitiesPage createNewOpportunitiesPage = new CreateNewOpportunitiesPage(driver);
	    createNewOpportunitiesPage.enterOpportunitesPagedataOrgName(OPPORTUNITYNAME, ORGANIZATION, ADMINISTRATOR, CLOSINGDATE , PROSPETING );
	    
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
	    
	    
	    homePage.logoutFromApp();
				
	}

}
