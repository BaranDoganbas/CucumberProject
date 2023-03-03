@amazon_search
Feature: amazon feature file

  Background: user_goes_to_amazon_page
    Given User is on the amazon home page

  Scenario: TC01_amazon_search
    When user searches for "iPhone" on amazon
    Then verify page title contains "iPhone"
    Then close the application