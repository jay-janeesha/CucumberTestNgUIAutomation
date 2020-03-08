package pages.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import selenium.BaseTest;
import util.Utilities;

public class HomePage {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);
	
	private String strHomePageTitle = "My Store";
	

	
	public void clickContactus()
	{
		Utilities.waitForElementId("contact-link").click();
	}

	public boolean isHomePageLoaded()
	{ 
		try {
			return Utilities.waitForElement(By.id("contact-link"), 10).isDisplayed();
			
		} catch (NoSuchElementException e) {
			return false;
			
		}
		
	}
	

	public boolean verifyHomePageTitle()
	{ 
		try {
			return BaseTest.getDriver().getTitle().equals(strHomePageTitle);
			
		} catch (Exception e) {
			return false;
			
		}
		
	}
	
	public void clickSignIn()
	{
		Utilities.waitForElementXpath("//a[contains(text(), 'Sign in')]").click();
	}
}
