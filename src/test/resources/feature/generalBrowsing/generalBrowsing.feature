@screen
Feature: General Browsing

Scenario: Verify if the user is able to access all links displayed in the main menu
Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
And  I click on link with text "About"
Then I should see an element with text "Company Overview"
And I click on link with text "Scanify"
Then I should see an element with text "Meet SCANIFY"
And I click on link with text "News/Blog"
Then I should see an element with text "Posted on "
And I click on link with text "Support"
Then I should see an element with text "Fuel3D Support"
And I click on link with text "Fuel3D Store"
Then I should see an element with text "Fuel3D Store"

Scenario: Verify that user is redirected to the homepage when he clicks on the Home link

Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
And  I click on link with text "About"
And  I click on link with text "Home"
Then I should see an element with text "High resolution"