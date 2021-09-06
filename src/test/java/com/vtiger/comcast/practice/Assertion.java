package com.vtiger.comcast.practice;

import org.testng.asserts.SoftAssert;

import com.vtiger.comcast.genericUtility.BaseClass;

public class Assertion extends BaseClass {

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
