Feature: Smoke Test Suite

  @smoke
  Scenario: Verify Zig wheels Homepage
    Given user navigates to zigwheels website
    Then user should see a well-rendered homepage

  @smoke
  Scenario: Verify Search Functionality for New Bikes
    Given user is currently on the zigwheels website
    Then check whether New Bikes is present in the header section
    When user hovers the mouse over the New Bikes
    Then check whether upcoming bikes is present in dropdown
    Then user should see relevant search results for Honda bikes

  @smoke
  Scenario: Verify Search Functionality for New Cars
    Given user is currently on the zigwheels website
    Then check whether New Cars is present in the header section
    When user hovers the mouse over the New Cars
    Then check whether upcoming cars is present in dropdown
    Then user should see relevant search results for Tata Cars

  @smoke
  Scenario: Navigate to the Used cars page
    Given user is currently on the zigwheels website
    When user hovers on Used Cars
    Then check whether Chennai city is present in the list
    When user click at Chennai option
    Then user should see relevant search results for Used Cars in Chennai

  @smoke
  Scenario: Verify the Health Insurance
    Given user is currently on the zigwheels website
    When user hovers the mouse over the More section
    Then check whether Health Insurance is present in the list

  @smoke
  Scenario: Verify Login Functionality
    Given user is currently on the zigwheels website
    Then checks whether login or signup is present in the zigwheels tab
    When user click the login or signup button in homepage
    Then user should be directed to the login or register tab

