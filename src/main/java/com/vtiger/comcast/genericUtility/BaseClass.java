package com.vtiger.comcast.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.vitiger.comcast.pomrepositorylib.HomePage;
import com.vitiger.comcast.pomrepositorylib.Login;

public class BaseClass {
	
    public static WebDriver driver;
   	
    public WebDriverUtility wdu = new WebDriverUtility();
    public FileUtility filU = new FileUtility();
    public  ExcelUtility excelU = new ExcelUtility();
    
    
//  @Parameters("Browser")
    
	@BeforeClass (groups= {"SmokeTest", "RegressionTest"})
	public void beforeClassConfiguration() throws IOException
	{
    	System.out.println("==============Launch the Browser=============");
		//String Browser1 = filU.propertyFile("browser");
    	String Browser1 = System.getProperty("browser");
		if(Browser1.equals("chrome"))
	    {
	    	driver = new ChromeDriver();
	    }
	    else if(Browser1.equals("firefox"))
	    {
	    	driver = new FirefoxDriver();
	    }
	    else if(Browser1.equals("microsoftedge"))
	    {
	    	driver = new EdgeDriver();
	    }
//     	wdu.getBrowserSettings(driver);
	}
	
	
	@BeforeMethod  (groups= {"SmokeTest", "RegressionTest"})
	public void beforeMethodConfiguration() throws Throwable
	{
      
		
		String URL = filU.propertyFile("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		
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
	
}
