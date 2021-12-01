Feature: Login page feature

Scenario: Login page title
Given user is on login page
When user fetched the title of the page
Then page title should be "Login - My Store"

Scenario: Forgot Password link
Given user is on login page
Then forgot your password link should be displayed

Scenario: Login with correct credentials
Given user is on login page
When user enters username "sabyasachi_nag@epam.com"
And user enters password "Sabya@1234nag"
And user clicks on Login button
And user fetched the title of the page
Then page title should be "My account - My Store"