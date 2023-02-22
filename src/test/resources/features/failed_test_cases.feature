@failed_tests
Feature: hooks_test
  Scenario: TC_01_
    Given user is on "https://bluerentalcars.com/login" page
    And user enters customer_email and customer_password
      | username       | password |
      | jack@gmail.com | 12345    |
    Then verify the next page url contains login keyword