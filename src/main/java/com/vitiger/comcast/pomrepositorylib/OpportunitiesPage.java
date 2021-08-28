package com.vitiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	
	   public WebDriver driver;
	   public OpportunitiesPage(WebDriver driver)
	   {   
		   this.driver=driver;
		   PageFactory.initElements(driver, this);
	   }

		@FindBy(xpath="//img[@alt=\"Create Opportunity...\"]")
		private WebElement createOpportunitiesimg;

		public WebElement getCreateOpportunitiesimg() {
			return createOpportunitiesimg;
		}
		
	    

}
