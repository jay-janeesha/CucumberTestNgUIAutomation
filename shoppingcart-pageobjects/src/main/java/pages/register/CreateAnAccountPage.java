package pages.register;

import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pages.contactus.ContactUsPage;
import util.Utilities;

public class CreateAnAccountPage {
	private static final Logger LOGGER = LoggerFactory.getLogger(ContactUsPage.class);
	private String strDuplicateEmailError = "An account using this email address has already been registered";

	public boolean isCreateAnAccountPageLoad()

	{
		try {
			return Utilities.waitForElementId("SubmitCreate", 20).isDisplayed();

		} catch (NoSuchElementException e) {
			return false;

		}

	}
	
	public void enterEmailAddress(String strEmail)
	{
		
		Utilities.waitForElementId("email_create").sendKeys(strEmail);
	}
	
	public void clickOnSubmitButton()
	{
		
		Utilities.waitForElementId("SubmitCreate").click();

	}
	
	public boolean isDuplicateEmailValidationDisplayed()
	{ 
		try {
			return Utilities.waitForElementXpath("//div[@id = 'create_account_error']//li", 20).isDisplayed();
			
		} catch (NoSuchElementException e) {
			return false;
			
		}
		
	}
	
	public boolean verifyEmailValidationError()
	{ 
		try {
			return Utilities.waitForElementXpath("//div[@id = 'create_account_error']//li").getText().contains(strDuplicateEmailError);

			
		} catch (NoSuchElementException e) {
			return false;
			
		}
		
	}


}
