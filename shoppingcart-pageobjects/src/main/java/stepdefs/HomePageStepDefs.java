package stepdefs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import cucumber.api.java.en.When;


public class HomePageStepDefs {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomePageStepDefs.class);
	private SharedState sharedState;
	
	public HomePageStepDefs(SharedState sharedState) {
		this.sharedState = sharedState;
	}

	@When("^User clicks on Contact us link to navigate to Customer Service page$")
	public void userNatigatesToContactUsPage()
	{

		Assert.assertTrue(sharedState.homePage.isHomePageLoaded());
		Assert.assertTrue(sharedState.homePage.verifyHomePageTitle());
		sharedState.homePage.clickContactus();
		Assert.assertTrue(sharedState.contactUsPage.isContactUsPageLoad());

	}
	
	@When("^User clicks on Sign In link to  to navigate to Authentication page$")
	public void userNatigatesToSignInPage()
	{

		Assert.assertTrue(sharedState.homePage.isHomePageLoaded());
		Assert.assertTrue(sharedState.homePage.verifyHomePageTitle());
		sharedState.homePage.clickSignIn();
		Assert.assertTrue(sharedState.createAnAccountPage.isCreateAnAccountPageLoad());

	}

}
