Feature: Upcoming Bike Details

  @sanity
  Scenario: Extract all upcoming bike details under four lacks
    Given user navigates to zigwheels website
    When user hover on New Bikes
    Then user clicks on Upcoming Bikes
    When user selects "Honda" manufacturer name
    Then user display all upcoming bike details
