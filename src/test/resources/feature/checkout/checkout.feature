@screen
Feature: Checkout on Fuel-3d

  Scenario: Checkout
    Given I open url "http://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    When I move to an element with text "Store" and click on subMenu "US & Canada Store"
    And I click on link with text "Add to cart"
    And I click on input button with text "Proceed to Checkout"
    When I place the order with valid details
  #  And I type "First Name" into "First Name" field
  #  And I type "4242424242424242" into "Card Number" field

