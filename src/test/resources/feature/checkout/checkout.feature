@screen
Feature: Checkout Functionality

  Scenario: Verify that a guest is allowed to checkout a product (CO-01)
    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    And I click on link with text "Fuel3D Store"
    And I click on link with text "Add to cart"
    And I click on input button with text "Proceed to Checkout"
    When I place an order with valid details "0"
    And I click on link with text "Calculate Deposit"
    And I click on link with text "Pay Deposit + Shipping Now"
    Then I should see an element with text "Thank you. Your order has been received."
    And I should see my transaction in TradeGecko
    And I should see my transaction in Stripe


  Scenario: Verify that guest user is not allowed to checkout without entering his First Name (CO-25)
    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    And I click on link with text "Fuel3D Store"
    And I click on link with text "Add to cart"
    And I click on input button with text "Proceed to Checkout"
    When I place an order with valid details "1"
    And I click on link with text "Calculate Deposit"
    And I click on link with text "Pay Deposit + Shipping Now"
    Then I should see an element with text "First Name"
    And I should see an element with text " is a required field."


  Scenario: Verify that guest user is not allowed to checkout without entering his Last Name (CO-26)
    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    And I click on link with text "Fuel3D Store"
    And I click on link with text "Add to cart"
    And I click on input button with text "Proceed to Checkout"
    When I place an order with valid details "2"
    And I click on link with text "Calculate Deposit"
    And I click on link with text "Pay Deposit + Shipping Now"
    Then I should see an element with text "Last Name"
    And I should see an element with text " is a required field."


  Scenario: Verify that guest user is not allowed to checkout without entering his Address (CO-27)
    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    And I click on link with text "Fuel3D Store"
    And I click on link with text "Add to cart"
    And I click on input button with text "Proceed to Checkout"
    When I place an order with valid details "3"
    And I click on link with text "Calculate Deposit"
    And I click on link with text "Pay Deposit + Shipping Now"
    Then I should see an element with text "Address"
    And I should see an element with text " is a required field."


  Scenario: Verify that guest user is not allowed to checkout without entering his Town / City (CO-28)
    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    And I click on link with text "Fuel3D Store"
    And I click on link with text "Add to cart"
    And I click on input button with text "Proceed to Checkout"
    When I place an order with valid details "4"
    And I click on link with text "Calculate Deposit"
    And I click on link with text "Pay Deposit + Shipping Now"
    Then I should see an element with text "Town / City"
    And I should see an element with text " is a required field."


#  Scenario: Verify that guest user is not allowed to checkout without selecting any option from the State dropdown (CO-29)
#    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
#    And I mouse over on element with text "Store"
#    And  I click on link with text "US & Canada Store"
#    And I click on link with text "Add to cart"
#    When I place an order with valid details "5"
#    And I click on link with text "Calculate Deposit"
#    And I click on link with text "Pay Deposit + Shipping Now"


  Scenario: Verify that guest user is not allowed to checkout without entering his Postcode (CO-30)
    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    And I click on link with text "Fuel3D Store"
    And I click on link with text "Add to cart"
    And I click on input button with text "Proceed to Checkout"
    When I place an order with valid details "6"
    And I click on link with text "Calculate Deposit"
    And I click on link with text "Pay Deposit + Shipping Now"
  # Then I should see an element with text "Postcode"
    And I should see an element with text " is a required field."


  Scenario: Verify that guest user is not allowed to checkout when entering an invalid Postcode (CO-31)
    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    And I click on link with text "Fuel3D Store"
    And I click on link with text "Add to cart"
    And I click on input button with text "Proceed to Checkout"
    When I place an order with valid details "7"
    And I click on link with text "Calculate Deposit"
    And I click on link with text "Pay Deposit + Shipping Now"
    Then I should see an element with text "Please enter a valid postcode/ZIP."


#  Scenario: Verify that guest user is not allowed to checkout without selecting an option from the Province dropdown(CO-32)
#    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
#    And I click on link with text "Store"
#    And I click on link with text "Add to cart"
#    And I click on input button with text "Proceed to Checkout"
#    When I place an order with valid details "8"
#    And I click on link with text "Calculate Deposit"
#    And I click on link with text "Pay Deposit + Shipping Now"#
#    Then I should see an element with text "Province"
#    And I should see an element with text " is a required field."


  Scenario: Verify that guest user is not allowed to checkout without entering an email address (CO-33)
    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    And I click on link with text "Fuel3D Store"
    And I click on link with text "Add to cart"
    And I click on input button with text "Proceed to Checkout"
    When I place an order with valid details "9"
    And I click on link with text "Calculate Deposit"
    And I click on link with text "Pay Deposit + Shipping Now"
    Then I should see an element with text "Email Address"
    And I should see an element with text " is a required field."


  Scenario: Verify that guest user is not allowed to checkout when entering an invalid email address (CO-34)
    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    And I click on link with text "Fuel3D Store"
    And I click on link with text "Add to cart"
    And I click on input button with text "Proceed to Checkout"
    When I place an order with valid details "10"
    And I click on link with text "Calculate Deposit"
    And I click on link with text "Pay Deposit + Shipping Now"
    Then I should see an element with text "Email Address"
    And I should see an element with text " is not a valid email address."


  Scenario: Verify that guest user is not allowed to checkout without entering the telephone number (CO-35)
    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    And I click on link with text "Fuel3D Store"
    And I click on link with text "Add to cart"
    And I click on input button with text "Proceed to Checkout"
    When I place an order with valid details "11"
    And I click on link with text "Calculate Deposit"
    And I click on link with text "Pay Deposit + Shipping Now"
    Then I should see an element with text "Phone"
    And I should see an element with text " is a required field."


  Scenario: Verify that guest user is not allowed to checkout when entering invalid characters in the Phone field (CO-36)
    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    And I click on link with text "Fuel3D Store"
    And I click on link with text "Add to cart"
    And I click on input button with text "Proceed to Checkout"
    When I place an order with valid details "12"
    And I click on link with text "Calculate Deposit"
    And I click on link with text "Pay Deposit + Shipping Now"
    Then I should see an element with text "Phone"
    And I should see an element with text " is not a valid phone number."


  Scenario: Verify that guest user is not allowed to checkout without entering the Account Password (CO-37)
    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    And I click on link with text "Fuel3D Store"
    And I click on link with text "Add to cart"
    And I click on input button with text "Proceed to Checkout"
    When I place an order with valid details "13"
    And I click on link with text "Calculate Deposit"
    And I click on link with text "Pay Deposit + Shipping Now"
    Then I should see an element with text "Account password"
    And I should see an element with text " is a required field."


  Scenario: Verify that guest user is not allowed to checkout without checking the Terms and Conditions checkbox (CO-38)
    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    And I click on link with text "Fuel3D Store"
    And I click on link with text "Add to cart"
    And I click on input button with text "Proceed to Checkout"
    When I place an order with valid details "14"
    And I click on link with text "Calculate Deposit"
    And I click on link with text "Pay Deposit + Shipping Now"
    Then I should see an element with text "You must accept our Terms & Conditions."


  Scenario: Verify that user is not allowed to checkout without entering the card details (CO-39)
    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    And I click on link with text "Fuel3D Store"
    And I click on link with text "Add to cart"
    And I click on input button with text "Proceed to Checkout"
    When I place an order with valid details "15"
    And I click on link with text "Calculate Deposit"
    And I click on link with text "Pay Deposit + Shipping Now"
    Then I wait 10 seconds
    Then I should see an element with text "This card number looks invalid."


  Scenario: Verify that user is not allowed to checkout without entering the Card Number (CO-40)
    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    And I click on link with text "Fuel3D Store"
    And I click on link with text "Add to cart"
    And I click on input button with text "Proceed to Checkout"
    When I place an order with valid details "16"
    And I click on link with text "Calculate Deposit"
    And I click on link with text "Pay Deposit + Shipping Now"
    Then I should see an element with text "This card number looks invalid."


  Scenario: Verify that user is not allowed to checkout with an invalid Card Number(CO-41)
    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    And I click on link with text "Fuel3D Store"
    And I click on link with text "Add to cart"
    And I click on input button with text "Proceed to Checkout"
    When I place an order with valid details "17"
    And I click on link with text "Calculate Deposit"
    And I click on link with text "Pay Deposit + Shipping Now"
    Then I should see an element with text "This card number looks invalid."

  Scenario: Verify that user is not allowed to checkout without entering the Expiry Date (CO-42)
    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    And I click on link with text "Fuel3D Store"
    And I click on link with text "Add to cart"
    And I click on input button with text "Proceed to Checkout"
    When I place an order with valid details "18"
    And I click on link with text "Calculate Deposit"
    And I click on link with text "Pay Deposit + Shipping Now"
    Then I should see an element with text "Your card's expiration year is invalid."

  Scenario: Verify that user is not allowed to checkout with an Expiry date set in the past (CO-43)
    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    And I click on link with text "Fuel3D Store"
    And I click on link with text "Add to cart"
    And I click on input button with text "Proceed to Checkout"
    When I place an order with valid details "19"
    And I click on link with text "Calculate Deposit"
    And I click on link with text "Pay Deposit + Shipping Now"
    Then I should see an element with text "Your card's expiration year is invalid."

  Scenario: Verify that user is not allowed to checkout without entering the Card Code (CO-44)
    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    And I click on link with text "Fuel3D Store"
    And I click on link with text "Add to cart"
    And I click on input button with text "Proceed to Checkout"
    When I place an order with valid details "20"
    And I click on link with text "Calculate Deposit"
    And I click on link with text "Pay Deposit + Shipping Now"
    Then I should see an element with text "Your card's security code is invalid."


#  Scenario: Verify that a user can checkout a product from US & Canada Store (CO-02)
#    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
#    And I mouse over on element with text "Store"
#    And  I click on link with text "US & Canada Store"
#    And I click on link with text "Add to cart"
#    And I click on input button with text "Proceed to Checkout"
#    When I place an order with valid details
#    Then I wait 3 seconds
#    And I click on input button with text "Calculate Deposit"
#    Then I wait 3 seconds
#    And I click on input button with text "Pay Deposit Now"
  #    And I click on input button with text "Pay Deposit Now"

  Scenario: Distributor portal
    Given I open url "https://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
    And I mouse over on element with text "Fuel3D Store"
    And I click on link with text "Distributor portal"
    When I type "Distributor" into "Email Address *" field
    When I type "123456" into "Password *" field
    And I click on button with text "Login"

    
  Scenario: NumGuess
    Given I open url "http://54.93.82.48:8080/NumGuess/"
    Then I enter number until I guess
    #And I type into field the value "1"
    #And I click on link with text "It could be 1"
    #And I click on input button with text "guessButton"
    #Then I should see an element with text "WRONG, Try a Higher one!"

  Scenario: UploadImages
    Given I open url "http://deplastic.ro/wp-admin"
    And I type "admin" into field with id "user_login"
    And I type "myRcW93X6JNY%" into field with id "user_pass"
    And I click on input button with text "Log In"
    And I open url "http://deplastic.ro/wp-admin/post-new.php?post_type=product"
    And I click on link with text "Set featured image"
And I click on