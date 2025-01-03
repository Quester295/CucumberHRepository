Feature: Registration Functionality

  Scenario: User creates an account only with mandatory fields
    Given user navigates to Register Account Page
    When user enters the details into below fields
      | firstname | Shaalini                        |
      | Lastname  | Sethumadhavan                   |
       | telephone |                      1234567890 |
      | Password  |                           12345 |
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully

  Scenario: User creates an account only with all fields
    Given user navigates to Register Account Page
    When user enters the details into below fields
      | firstname | Shaalini                        |
      | Lastname  | Sethumadhavan                   |
      | telephone |                      1234567890 |
      | Password  |                           12345 |
    And User selects Yes for Newsletter
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully

  Scenario: User creates an duplicate account
    Given user navigates to Register Account Page
    When user enters the details into below fields with duplicate email
      | firstname | Shaalini                        |
      | Lastname  | Sethumadhavan                   |
      | email     | shaalinisethumadhavan@gmail.com |
      | telephone |                      1234567890 |
      | Password  |                           12345 |
    And User selects Yes for Newsletter
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User should get proper warning about duplicate email

  Scenario: User creates an account without filling any details
    Given user navigates to Register Account Page
    When user dont enter any details into field
    And User clicks on Continue button
    Then User should get proper warning message for every mandatory field
