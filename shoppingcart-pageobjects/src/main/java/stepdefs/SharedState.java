package stepdefs;

import pages.contactus.ContactUsPage;
import pages.homepage.HomePage;
import pages.register.CreateAnAccountPage;

public class SharedState {
	public ContactUsPage contactUsPage;
	public HomePage homePage;
	public CreateAnAccountPage createAnAccountPage;

	public SharedState()
	{
		contactUsPage = new ContactUsPage();
		homePage = new HomePage();
		createAnAccountPage = new CreateAnAccountPage();
	}
}
