package pages.contactus;

import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.Utilities;

public class ContactUsPage {
	private static final Logger LOGGER = LoggerFactory.getLogger(ContactUsPage.class);
	private String strHomePageTitle = "Your message has been successfully sent to our team.";

	public boolean isContactUsPageLoad() {
		try {
			return Utilities.waitForElementId("center_column", 20).isDisplayed();

		} catch (NoSuchElementException e) {
			return false;

		}

	}

	public void selectSubjectHeading(String strSubjectHeading) {

		Select listSubjectHeading = new Select(Utilities.waitForElementId("id_contact"));
		listSubjectHeading.selectByVisibleText(strSubjectHeading);

	}

	public void enterEmailAddress(String strEmail) {

		Utilities.waitForElementId("email").sendKeys(strEmail);

	}

	public void enterOrderReference(String strOrderRef) {

		Utilities.waitForElementId("id_order").sendKeys(strOrderRef);

	}

	public void enterMessage(String strMessage) {

		Utilities.waitForElementId("message").sendKeys(strMessage);

	}

	public void clickOnSubmitButton() {

		Utilities.waitForElementId("submitMessage").click();

	}

	public boolean isContactUsConfirmationDisplayed() {
		try {
			return Utilities.waitForElementXpath("//p[@class='alert alert-success']", 20).isDisplayed();

		} catch (NoSuchElementException e) {
			return false;

		}

	}

	public boolean verifyContactUsConfirmationMessage() {
		try {
			return Utilities.waitForElementXpath("//p[@class='alert alert-success']").getText()
					.contains(strHomePageTitle);

		} catch (NoSuchElementException e) {
			return false;

		}

	}

	public void clickOnReturnToHomePage() {

		Utilities.waitForElementXpath("//a[@href='http://automationpractice.com/']//span").click();

	}

}
