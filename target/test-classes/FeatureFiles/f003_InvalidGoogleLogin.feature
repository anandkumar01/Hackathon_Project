Feature: Invalid Google Login

  @sanity
  Scenario: Google login with invalid account
    Given user navigates to zigwheels website
    When user clicks to signup button
    Then user clicks to the google option
    When user enter invalid account details
    Then user captures error message
