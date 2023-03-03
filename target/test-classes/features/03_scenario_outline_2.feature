@data_tables
Feature: data_tables

  Scenario Outline: TC_Create_And verify "<firstname>" the test data creation

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
    Then close the application

    Examples: test_data
      | firstname | lastname | position    | office  | extension | start_date | salary  |
      | john      | smith    | tester      | NYC     | 2134      | 2023-02-25 | 80000   |
      | sam       | walton   | businessman | LA      | 5262      | 2021-02-21 | 2000000 |
      | nancy     | brown    | developer   | Dallas  | 2346      | 2021-02-26 | 850000  |
      | george    | bush     | politician  | Dallas  | 9931      | 2021-02-24 | 9850000 |
      | barry     | allen    | unknown     | Central | 2103      | 2021-02-23 | 1000000 |