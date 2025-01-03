	Feature: Testing Demologin functionality

  Scenario Outline: Login with valid creditionals
    Given User navigates to login page
    When User enters valid email address <username> into email field
    And User has enetered valid password <password> into password field
    And User clicks on Login button
    Then User should get successfully logged in
    Examples:
    |username                        |password  |
    |shaalinisethumadhavan@gmail.com | 12345    |
    |shaalinisethumadhavan1@gmail.com| 12345    |
    
   Scenario: Login with invalid creditionals
    Given User navigates to login page
    When User enters invalid email address  into email field
    And User enters invalid password "1234567890" into password field
    And User clicks on Login button
    Then User should get a proper warning message about creditionals mismatch

  Scenario: Login with valid email and invalid password
    Given User navigates to login page
    When User enters valid email address "shaalinisethumadhavan1@gmail.com" into email field
    And User enters invalid password "1234567890" into password field
    And User clicks on Login button
    Then User should get a proper warning message about creditionals mismatch

  Scenario: Login with invalid email and valid password
    Given User navigates to login page
    When User enters invalid email address "asdasdadsshaalinisethumadhavan1@gmail.com" into email field
    And User has enetered valid password "12345" into password field
    And User clicks on Login button
    Then User should get a proper warning message about creditionals mismatch

  Scenario: Login without providing any creditionals
    Given User navigates to login page
    When User dont enter email address into email field
    And User dont enter password into password field
    And User clicks on Login button
    Then User should get a proper warning message about creditionals mismatch
