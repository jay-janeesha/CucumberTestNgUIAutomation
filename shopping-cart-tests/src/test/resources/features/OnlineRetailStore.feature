@TestShoppingCart
Feature: Online Retail Store
Scenario: Send a message to Customer Service in the Contact us section
Given User navigates to Home page
When User clicks on Contact us link to navigate to Customer Service page
And Selects "Customer service" from Subject Heading dropdown
And Enters "test123@test.com" as Email Address
And Enters "123456" as Order Reference
And Enters "TestMessage" as Message
And Clicks on Send button
Then User should navigate to Confirmation Page
Then Clicks on Home button to navigate back to the Home page

Scenario: Create an account using already registered email Id
Given User navigates to Home page
When User clicks on Sign In link to  to navigate to Authentication page
And Enters Email Address as "test@test.com"
And Clicks on Create an Account button
Then System displays a validation message saying that the email already exists