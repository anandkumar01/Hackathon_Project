Feature: Upcoming Bike Details

  Scenario: Extract all upcoming bike details under four lacks
    Given user navigates to zigwheels website
    When user hover on New Bikes
    Then user clicks on Upcoming Bikes
    When user selects manufacturer name
    Then user display all upcoming boke details
