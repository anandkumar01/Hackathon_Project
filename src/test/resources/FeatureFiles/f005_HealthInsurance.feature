Feature: Health Insurance

  Scenario: Extracting all health insurance plan
    Given user navigates to zigwheels website
    When user hover on More section
    And user clicks on Health Insurance
    Then user fill details
    And user store all health insurance plan
