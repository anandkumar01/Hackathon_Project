Feature: Upcoming Bike Details

  @sanity
  Scenario: Extract all upcoming bike details under four lacks
    Given user navigates to zigwheels website
    When user hover on "New Bikes" as new bikes
    Then user clicks on Upcoming Bikes
    When user selects manufacturer name as "Honda"
    Then user display all upcoming bike details
