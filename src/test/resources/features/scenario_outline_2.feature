@data_tables
Feature: data_tables

  Scenario Outline: TC_Create_And verify the test data creation

#    Creating a reusable step that accept url and goes to that url
    Given user is on "https://editor.datatables.net" page
    And user clicks on the New button
    And user enters the first name "<firstname>"
    And user enters the last name "<lastname>"
    And user enters the position "<position>"
    And user enters the office "<office>"
    And user enters the extension "<extension>"
    And user enters the start date "<start_date>"
    And user enters the salary "<salary>"
    And click on create button
    And search for the first name "<firstname>"
    Then verify the name field contains the first name "<firstname>"

    Examples: test_data
      | firstname | lastname | position | office  | extension | start_date | salary |
      | john      | smith    | tester   | NYC     | 2134      | 2023-02-13 | 80000  |
      | barry     | allen    | flash    | Central | 1234      | 2021-03-21 | 100000 |