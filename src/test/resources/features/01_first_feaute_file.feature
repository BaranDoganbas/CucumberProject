@google_search
Feature: first feature file

  Background: user_goes_to_google_page
    Given User is on the google home page

  @iphone_search
  Scenario: TC_01_iphone_search
    When User searches for iPhone
    Then verify page title contains iPhone
    Then close the application

  @teapot_search
  Scenario: TC_02_teapot_search
    When User searches for TeaPot
    Then verify page title contains TeaPot
    Then close the application





#  All feature files must begin with "Feature:" keyword
#  Feature: To declare the file as a Cucumber feature file. Mandatory. There can be ONLY one Feature: keyword
#  Scenario: To create test case. In a feature file there may be more than one Scenario:
#  Runner: To run the feature files.
#  Background: Used to run Before each Scenario. This is used for repeated pre-conditions
#  CUCUMBER STEPS:
#  1. Create feature file and test scenarios
#  2. Run the feature file and generate step definitions. dryRun = true
#  3. Use the step definitions to complete the Java code
#  4. dryRun = false -> to execute test cases