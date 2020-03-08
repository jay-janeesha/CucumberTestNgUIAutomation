package stepdefs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class RegisterStepDefs {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterStepDefs.class);
	private SharedState sharedState;
	
	public RegisterStepDefs(SharedState sharedState) {
		this.sharedState = sharedState;
	}
	
	@And("^Enters Email Address as \"([^\"]*)\"$")
	public void enterEmailAddress(String strEmail)
	{
		sharedState.createAnAccountPage.enterEmailAddress(strEmail);
	}
	
	@And("^Clicks on Create an Account button$")
	public void clickOnCreateAnAccountButton()
	{
		sharedState.createAnAccountPage.clickOnSubmitButton();
	}

	@Then("^System displays a validation message saying that the email already exists$")
	public void verifyDuplicateEmailValidationMessage()
	{
		Assert.assertTrue(sharedState.createAnAccountPage.isDuplicateEmailValidationDisplayed());
		Assert.assertTrue(sharedState.createAnAccountPage.verifyEmailValidationError());
	}
	
}
