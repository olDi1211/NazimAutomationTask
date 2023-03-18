@UPG10-286
Feature: Upgenix log in feature
  User Story : As a user, I should be able to log in so that I can land on homepage.

  AC1-Users can log in with valid credentials (We have 5 types of users but will test only 2 user: PosManager, SalesManager)
  AC2- "Wrong login/password" message should be displayed for invalid credentials (valid username-invalid password and invalid username-valid password)
  AC3- "Please fill out this field" message should be displayed if the password or username is empty
  AC4- User should see the password in bullet signs by default while typing (like ****)
  AC5- Verify if the ‘Enter’ key of the keyboard is working correctly on the login page


  Background: For the scenarios in the feature file, user is expected to be on login page
    Given user is on the upgenix log in page

  @logInFunctionality @AC1-TC1 @UPG10-287
  Scenario Outline: Log in with valid credentials
    When user enter "<valid name>" and "<valid password>"
    And click on the log in button
    Then user should be logged
    Examples:
      | valid name               | valid password |
      | salesmanager20@info.com  | salesmanager   |
      | salesmanager100@info.com | salesmanager   |
      | posmanager20@info.com    | posmanager     |
      | posmanager100@info.com   | posmanager     |

  @logInFunctionality @AC2-TC1 @UPG10-288
  Scenario: "Wrong login/password" message should be displayed for invalid userName
    When user enter invalid userName
    And click on the log in button
    Then "Wrong login/password" message should be displayed

  @logInFunctionality @AC2-TC2 @UPG10-289
  Scenario: "Wrong login/password" message should be displayed for invalid userPassword
    When user enter invalid userPassword
    And click on the log in button
    Then "Wrong login/password" message should be displayed

  @logInFunctionality @AC2-TC3 @UPG10-290
  Scenario: "Wrong login/password" message should be displayed for invalid userName and invalid userPassword
    When user enter invalid userName and invalid userPassword
    And click on the log in button
    Then "Wrong login/password" message should be displayed

  @logInFunctionality @AC3-TC1 @UPG10-291
  Scenario: "Please fill out this field" message should be displayed if the password is empty
    When user enter only userName
    And click on the log in button
    Then "Please fill out this field." message should be displayed near password

  @logInFunctionality @AC3-TC2 @UPG10-292
  Scenario: "Please fill out this field" message should be displayed if the username is empty
    When user enter only userPassword
    And click on the log in button
    Then "Please fill out this field." message should be displayed near user name

  @logInFunctionality @AC4-TC1 @UPG10-293
  Scenario: User should see the password in bullet signs by default while typing (like ****)
    When user enter password
    Then user see the password in bullet signs by default while typing

  @logInFunctionality @AC5-TC1 @UPG10-294
  Scenario: Verify if the ‘Enter’ key of the keyboard is working correctly on the login page
    When user enter name and password
    And user push the Enter button
    Then user should be logged