Feature: Feature to test the google search functionality
 
  Scenario: Validate google search is working
    Given Google browser is open
    And user is on google Search
    When user enters a text in search box
    And hits enter
    Then user is navigated to search results
