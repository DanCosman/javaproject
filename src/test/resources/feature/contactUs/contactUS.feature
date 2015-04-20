@screen
Feature: Contact us functionality

  Scenario: Contact us login successful
    Given I open url "https://dev:J4g^SqXtk%3@dev.fuel-3d.com"
    And I click on link with css "h6"
    And I type "John Smith" into field with name "your-name"
    And I click on input button with name "your-customer"
    And I select "Technical support" from dropdown menu with name "your-recipient"
    And I type "vescan.remus30@gmail.com" into field with name "your-email"
    And I type "any word" on textarea with name "your-message"
    And I click on input button with text "Send"
    Then I should see an element with text "Your message was sent successfully. Thanks."

  Scenario: Wrong Email address
    Given I open url "https://dev:J4g^SqXtk%3@dev.fuel-3d.com"
    And I click on link with css "h6"
    And I type "John Smith" into field with name "your-name"
    And I click on input button with name "your-customer"
    And I select "Technical support" from dropdown menu with name "your-recipient"
    And I type "wrong Email address" into field with name "your-email"
    And I type "any word" on textarea with name "your-message"
    And I click on input button with text "Send"
    Then I wait 45 seconds

  Scenario:  User forgot to write the name
    Given I open url "https://dev:J4g^SqXtk%3@dev.fuel-3d.com"
    And I click on link with css "h6"
    And I click on input button with name "your-customer"
    And I select "Technical support" from dropdown menu with name "your-recipient"
    And I type "wrong Email address" into field with name "your-email"
    And I type "any word" on textarea with name "your-message"
    And I click on input button with text "Send"
    Then I wait 20 seconds

  Scenario: User forgot to click on "Yes" or "No"
    Given I open url "https://dev:J4g^SqXtk%3@dev.fuel-3d.com"
    And I click on link with css "h6"
    And I type "John Smith" into field with name "your-name"
    And I select "Technical support" from dropdown menu with name "your-recipient"
    And I type "wrong Email address" into field with name "your-email"
    And I type "any word" on textarea with name "your-message"
    And I click on input button with text "Send"
    Then I wait 20 seconds

  Scenario: User forgot to write in "Details"
    Given I open url "https://dev:J4g^SqXtk%3@dev.fuel-3d.com"
    And I click on link with css "h6"
    And I type "John Smith" into field with name "your-name"
    And I click on input button with name "your-customer"
    And I select "Technical support" from dropdown menu with name "your-recipient"
    And I type "vescan.remus30@gmail.com" into field with name "your-email"
    And I click on input button with text "Send"
    Then I wait 20 seconds

  Scenario: Mandatory fields are not completed when the user clicks "Send"
    Given I open url "https://dev:J4g^SqXtk%3@dev.fuel-3d.com"
    And I click on link with css "h6"
    And I click on input button with text "Send"
    Then I wait 20 seconds

