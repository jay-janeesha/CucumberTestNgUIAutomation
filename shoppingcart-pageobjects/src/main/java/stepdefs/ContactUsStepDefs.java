package stepdefs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ContactUsStepDefs {
	private static final Logger LOGGER = LoggerFactory.getLogger(ContactUsStepDefs.class);
	private SharedState sharedState;
	
	public ContactUsStepDefs(SharedState sharedState) {
		this.sharedState = sharedState;
	}
	

	@And("^Selects \"([^\"]*)\" from Subject Heading dropdown$")
	public void selectSubjectHeading(String strSubjectHeading)
	{
		sharedState.contactUsPage.selectSubjectHeading(strSubjectHeading);
	}
	
	@And("^Enters \"([^\"]*)\" as Email Address$")
	public void enterEmailAddress(String strEmail)
	{
		sharedState.contactUsPage.enterEmailAddress(strEmail);
	}
	
	@And("^Enters \"([^\"]*)\" as Order Reference$")
	public void enterOrderReference(String strOrderRef)
	{
		sharedState.contactUsPage.enterOrderReference(strOrderRef);
	}
	
	@And("^Enters \"([^\"]*)\" as Message$")
	public void enterMessage(String strMessage)
	{
		sharedState.contactUsPage.enterMessage(strMessage);
	}
	
	@And("^Clicks on Send button$")
	public void clickOnSendButton()
	{
		sharedState.contactUsPage.clickOnSubmitButton();
	}
	
	@Then("^User should navigate to Confirmation Page$")
	public void verifyContactUsConfirmationMessage()
	{
		Assert.assertTrue(sharedState.contactUsPage.isContactUsPageLoad());
		Assert.assertTrue(sharedState.contactUsPage.isContactUsConfirmationDisplayed());
	}
	
	@Then("^Clicks on Home button to navigate back to the Home page$")
	public void navigateBackToHomePage()
	{
		sharedState.contactUsPage.clickOnReturnToHomePage();

	}

}
