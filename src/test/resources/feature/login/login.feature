@screen
Feature: Login / Forgot Password functionality

  Scenario: Register your device
    Given I open url "https://dev:J4g^SqXtk%3@dev.fuel-3d.com/register/"
    And I type "vescanremus30" into "Username *" field
    And I type "vescan.remus30@gmail.com" into field with name "user_email"
    And I type "vescan" into field with name "first_name"
    And I type "remus" into field with name "last_name"
    And I type "test-dev1" into field with name "invitation_code"
    And I click on input button with text "Submit"
    And I wait 10 seconds
    Then I should see an element with text "Register your device"

  Scenario: Sign in as a user
    Given I open url "https://dev:J4g^SqXtk%3@dev.fuel-3d.com"
    And I click on submit button with xpath "(//a[contains(text(),'Sign in')])[2]"
    And I click on link with text "Please click here to login"
    And I type "vescanremus30" into field with id "user_login"
    And I type "123456" into field with id "user_pass"
    And I click on input button with text "Log In"
    Then I should see an element with text "Hello remus"

  Scenario: Forgot / don't know your password?
    Given I open url "https://dev:J4g^SqXtk%3@dev.fuel-3d.com"
    And I click on submit button with xpath "(//a[contains(text(),'Sign in')])[2]"
    And I click on link with text "Please click here to login"
    And I click on link with text "Forgot / don't know your password?"
    And I type "vescan.remus30+1@gmail.com" into field with id "user_login"
    And I click on input button with text "Get New Password"