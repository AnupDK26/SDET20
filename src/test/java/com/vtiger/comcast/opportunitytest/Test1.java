package com.vtiger.comcast.opportunitytest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.comcast.genericUtility.BaseClass;

@Listeners(com.vtiger.comcast.genericUtility.LisImpClass.class)
public class Test1 extends BaseClass{

	@Test
	public void Page1()
	{
		
		
		driver.get("https://www.google.com/");
		System.out.println("Google Page Loaded");
		String actualTitle = driver.getTitle();
		
//		Assert.assertEquals(actualTitle, "Googl");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualTitle, "Googl");
		
		
		System.out.println("Pass page1");
		sa.assertAll();
	}
}
