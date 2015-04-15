@screen
Feature: General Browsing

  Scenario: About
    Given I open url "https://dev:J4g^SqXtk%3@dev.fuel-3d.com"
    And I mouse over on element with text "About"
    And I click on link with text "Meet the team"
    And I mouse over on element with text "About"
    And I click on link with text "Company Background"
    And I mouse over on element with text "About"
    And I click on link with text "Fuel3D Labs"
    And I mouse over on element with text "About"
    And I click on link with text "Medical"
    And I mouse over on element with text "About"
    And I click on link with text "Video"
    And I mouse over on element with text "About"
    And I click on link with text "Careers"
    And I mouse over on element with text "About"
    And I click on link with text "Fuel3D Events List"
    And I click on link with text "Home"


  Scenario: Scanify
    Given I open url "https://dev:J4g^SqXtk%3@dev.fuel-3d.com"
    And I mouse over on element with text "Scanify"
    And I click on link with text "Meet Scanify"
    And I mouse over on element with text "Scanify"
    And I click on link with text "Sample Scans"
    And I mouse over on element with text "Scanify"
    And I click on link with text "Technical Whitepaper"
    And I mouse over on element with text "Scanify"
    And I click on link with text "Compare"
    And I mouse over on element with text "Scanify"
    And I click on link with text "Distributors and Resellers"
    And I mouse over on element with text "Scanify"
    And I click on link with text "FAQ"
    And I wait 30 seconds

  Scenario: News/Blog
    Given I open url "https://dev:J4g^SqXtk%3@dev.fuel-3d.com"
    And I mouse over on element with text "News/Blog"
    And I click on link with text "Image Gallery"

  Scenario:Support
    Given I open url "https://dev:J4g^SqXtk%3@dev.fuel-3d.com"
    And I click on link with text "Support"

  Scenario: Fuel3D Store
    Given I open url "https://dev:J4g^SqXtk%3@dev.fuel-3d.com"
    And I mouse over on element with text "Fuel3D Store"
    And I click on link with text "Fuel3D Store"
    And I mouse over on element with text "Fuel3D Store"
    And I click on link with text "Distributor portal"
    And I mouse over on element with text "Fuel3D Store"
    And I click on link with text "US & Canada Store"
    And I click on link with text "Back to Main Site"
    And I mouse over on element with text "Fuel3D Store"
    And I click on link with text "Cart"
    And I mouse over on element with text "Fuel3D Store"
    And I click on link with text "Checkout"

  Scenario: Distributor
    Given I open url "https://dev:J4g^SqXtk%3@dev.fuel-3d.com"
    And I mouse over on element with text "Fuel3D Store"
    And I click on link with text "Distributor portal"
    When I type "distributor" on textarea with id "email"
    When I type "123456" on textarea with id "password"
    And I click on button with text "Login"
    And I click on link with deep text "Place an order"
    And I click on link with deep text "Help & support"
    And I click on link with deep text "Share information"
    And I click on link with deep text "Media & assets"