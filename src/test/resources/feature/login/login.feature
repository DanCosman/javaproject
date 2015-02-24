#@screen
#Feature: Login / Forgot Password functionality
#
#  Scenario: Fail login detailed using email
#    Given I open url "http://www.fuel3d.org/"
#    When I click on link with text "Log In"
#    And I type "book" into field with id "s"
#    And I type "no@login.eu" into "Username or email address" field
#    And I click on fake Password field
#    And I type "badpass" into "Password" field
#    And I click on input button with text "Login"
#    Then I should see an element with text " A user could not be found with this email address."
#
#  Scenario: failed login using username
#    Given I open url "http://www.fuel3d.org/my-account/"
#    When I login using "wronguser"/"pass"
#    Then I should see following elements with texts ": Invalid username. ,Lost your password"
#
#  Scenario: Password is required
#    Given I open url "http://www.fuel3d.org/OnlineLibrary/"
#    When I login using "wronguser"/""
#    Then I should see following elements with texts " Password is required."
#
#  Scenario: Fail login
#    Given I open url "http://www.fuel3d.org/"
#    When I click on Login button from top navigation menu
#    And I login using "no@login.eu"/"badpass"
#    Then login should fail
#
#
#  Scenario: Successfully login detailed
#    Given I open url "http://www.fuel3d.org/"
#    When I click on link with text "Log In"
#    And I type "admin" into "Username or email address" field
#    And I click on fake Password field
#    And I type "library" into "Password" field
#    And I click on input button with text "Login"
#    Then I should see an element with text "Log Out"
#    And I should see following elements with texts "Recent Orders, My Addresses, Billing Address, Shipping Address"
#    And I click on link with text "Log Out"
#
#  Scenario: Successfully login
#    Given I open url "http://www.fuel3d.org/"
#    When I login using "admin"/"library"
#
#  Scenario: Force logout
#    Then I click on link with text "Log Out"
#
#  Scenario: HomePage-About Fuel
#    Given I open url "http://dev:J4g^SqXtk%3@staging.fuel-3d.com/"
#    When I move to an element with text "About" and click on subMenu "Meet the team"
#    Then I should see an element with text "Meet The Team"
#    And I should be on url "http://staging.fuel-3d.com/about-us/meet-the-team/"
#
