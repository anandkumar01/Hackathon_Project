Feature: Upcoming Car Details

  @sanity
  Scenario: Extract all upcoming car details
    Given user navigates to zigwheels website
    When user hover on "New Cars" as new cars
    Then user clicks on Upcoming Cars
    When user select "Tata" manufacturer name
    Then user display all upcoming car details
