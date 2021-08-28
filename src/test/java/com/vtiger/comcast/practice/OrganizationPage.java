package com.vtiger.comcast.practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vitiger.comcast.pomrepositorylib.HomePage;
import com.vitiger.comcast.pomrepositorylib.Login;
import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class OrganizationPage {

    public WebDriver driver;
   	
    public WebDriverUtility wdu = new WebDriverUtility();
    public FileUtility filU = new FileUtility();
    public  ExcelUtility excelU = new ExcelUtility();
	ExtentHtmlReporter reporter;
	ExtentReports reports;
	ExtentTest test;
    
    
    @BeforeSuite
    public void beforeSuit()
    {
    	System.out.println("==========Before Suit===============");
    	
    	reporter = new ExtentHtmlReporter("../SeleniumFramework/ExtentReports20/SDET20.html");
        reporter.config().setDocumentTitle("SDET");
        reporter.config().setTheme(Theme.DARK);
        reports = new ExtentReports();
        reports.attachReporter(reporter);
    	
    }
    

	@BeforeClass (groups= {"SmokeTest", "RegressionTest"})
	public void beforeClassConfiguration()
	{
//    	System.out.println("==============Launch the Browser=============");
//		String Browser1 = filU.propertyFile("browser");
//		if(Browser1.equals("chrome"))
//	    {
//	    	driver = new ChromeDriver();
//	    }
//	    else if(Browser1.equals("firefox"))
//	    {
//	    	driver = new FirefoxDriver();
//	    }
//	    else if(Browser1.equals("microsoftedge"))
//	    {
//	    	driver = new EdgeDriver();
//	    }
		driver = new ChromeDriver();
     	wdu.getBrowserSettings(driver);
	}
	
	
	@BeforeMethod  (groups= {"SmokeTest", "RegressionTest"})
	public void beforeMethodConfiguration() throws Throwable
	{
      
		
		String URL = filU.propertyFile("url");
		String USERNAME = filU.propertyFile("username");
		String PASSWORD = filU.propertyFile("password");
		
		 /*Step1 : Navigate to App*/
	    driver.get(URL);
	    System.out.println("Login Page is Displayed");
	    
		/*Step2 : Login to Application */
	    Login login = new Login(driver);
	    login.loginToApp(USERNAME, PASSWORD);	
	}
	
	
	@AfterMethod  (groups= {"SmokeTest", "RegressionTest"})
	public void afterMethodConfiguration() throws InterruptedException
	{
		Thread.sleep(2000);
		new HomePage(driver).logoutFromApp();
	}
	
	
	@AfterClass  (groups= {"SmokeTest", "RegressionTest"})
	public void afterClassConfiguration()
	{
		driver.quit();
	}
	
	@AfterSuite
    public void afterSuit()
    {
    	System.out.println("==========After Suit===============");
    	reports.flush();
    }
    
    @Test
   public void organizationPage()
   {
    	test = reports.createTest("organizationPage");
       
	   driver.findElement(By.linkText("Organizations")).click();
	  String orgPageHeaderText = driver.findElement(By.xpath("//td[@class='moduleName']")).getText();
	  System.out.println(orgPageHeaderText);
	  
	  if(orgPageHeaderText.equals("Organizations"))
	  {
		  System.out.println("Pass : Organizations HeaderText is verrified");
	  }
	  else
		  System.out.println("Fail: Organizations HeaderText is not verrified");
    }
    
    @Test
    public void homePage()
    {
    	test = reports.createTest("homePage");
 	  String homePageHeaderText = driver.findElement(By.xpath("//td[@class='moduleName']")).getText();
 	  System.out.println(homePageHeaderText);
 	  
 	  if(homePageHeaderText.equals("Home"))
 	  {
 		  System.out.println("Pass : HomePage HeaderText is verrified");
 	  }
 	  else
 		  System.out.println("Fail: HiomePage HeaderText is not verrified");
     }
    
    

}
