Feature: Upcoming Car Details

  @sanity @regression
  Scenario: Extract all upcoming car details
    Given user navigates to zigwheels website
    When user hover on New Cars
    Then user clicks on Upcoming Cars
    When user select manufacturer name
    Then user display all upcoming car details
