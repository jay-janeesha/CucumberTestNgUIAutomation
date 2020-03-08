package stepdefs;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cucumber.api.java.After;

import cucumber.api.java8.En;
import selenium.BaseTest;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;

public class CommonSteps implements En {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonSteps.class);
	private SharedState sharedState;
	
	public CommonSteps(SharedState sharedState) {
		this.sharedState = sharedState;
	}
	
	@Given("^User navigates to Home page$")
	public void userNatigatesToHomePage()
	{
		BaseTest.getInstance().openBrowser();
		BaseTest.getInstance().navigateToURL();
	}

	@After(order = 0)
	public void tearDown(Scenario scenario)
	{
		try {
			BaseTest.getInstance().closeBrowser();
			
		} catch (Exception e) {
			LOGGER.warn("Exception Occured when shutting down browser. " + e.getLocalizedMessage());
		}
	}
}
