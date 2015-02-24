@screen
Feature: Checkout on Fuel-3d

  Scenario: Verify that a guest is allowed to checkout a product (CO-01)
    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    And I click on link with text "Store"
    And I click on link with text "Add to cart"
    And I click on input button with text "Proceed to Checkout"
    When I place the order with valid details
    And I click on input button with text "Calculate Deposit"