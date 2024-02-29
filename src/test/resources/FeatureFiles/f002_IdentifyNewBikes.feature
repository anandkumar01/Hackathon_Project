Feature: Extracting details of new bikes, cars and helth insurance from Zigwheels website

  @sanity
  Scenario: Google login with invalid account
    Given user navigates to zigwheels website
    When user clicks to signup button
    Then user clicks to the google option
    When user enter invalid account details
    Then user captures error message

  @sanity
  Scenario: Extract all upcoming bike details under four lacks
    Given user navigates to zigwheels website
    When user hover on "New Bikes" as new bikes
    Then user clicks on Upcoming Bikes
    When user selects manufacturer name as "Honda"
    Then user display all upcoming bike details

  @sanity
  Scenario: Extract all upcoming car details
    Given user navigates to zigwheels website
    When user hover on "New Cars" as new cars
    Then user clicks on Upcoming Cars
    When user select manufacturer name as "Tata"
    Then user display all upcoming car details

  @sanity @regression
  Scenario: Extract all popular model of used cars in Chennai
    Given user navigates to zigwheels website
    When user hover on Used Cars
    Then user clicks on Chennai
    When user scroll to Popular Models
    Then user extracts all popular models name
    And user extracts all popular model details

  @sanity @regression
  Scenario: Extracting all health insurance plan
    Given user navigates to zigwheels website
    When user hover on More section
    And user clicks on Health Insurance
    Then user fill details
    And user display all health insurance brand name
    And user display all health insurance plan
