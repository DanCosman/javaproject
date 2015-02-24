@screen
Feature: Checkout Functionality

  Scenario: Verify that a guest is allowed to checkout a product (CO-01)
    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    And I click on link with text "Store"
    And I click on link with text "Add to cart"
    And I click on input button with text "Proceed to Checkout"
    When I place the order with valid details "1"
    And I click on link with text "Calculate Deposit"
    And I click on link with text "Pay Deposit + Shipping Now"
    Then I wait 10 seconds

#  Scenario: Verify that a user can checkout a product from US & Canada Store (CO-02)
#    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
#    And I mouse over on element with text "Store"
#    And  I click on link with text "US & Canada Store"
#    And I click on link with text "Add to cart"
#    And I click on input button with text "Proceed to Checkout"
#    When I place the order with valid details
#    Then I wait 3 seconds
#    And I click on input button with text "Calculate Deposit"
#    Then I wait 3 seconds
#    And I click on input button with text "Pay Deposit Now"

  Scenario: Verify if the user is able to access all links displayed in the main menu
    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    And  I click on link with text "About"
    Then I should see an element with text "Company Overview"
    And I click on link with text "Product"
    Then I should see an element with text "Meet SCANIFY"
    And I click on link with text "News/Blog"
    Then I should see an element with text "Posted on "
    And I click on link with text "Support"
    Then I should see an element with text "Fuel3D Support"
    And I click on link with text "Store"
    Then I should see an element with text "Fuel3D Store"

  Scenario: Verify that user is redirected to the homepage when he clicks on the Home link
    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    And  I click on link with text "About"
    And  I click on link with text "Home"
    Then I should see an element with text "High resolution"

