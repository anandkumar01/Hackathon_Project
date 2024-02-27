Feature: Used Cars in Chennai

  @sanity 
  Scenario: Extract all popular model of used cars in Chennai
    Given user navigates to zigwheels website
    When user hover on Used Cars
    Then user clicks on Chennai
    When user scroll to Popular Models
    Then user extracts all popular models name
    And user extracts all popular model details
