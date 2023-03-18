@UPG10-295
Feature: Upgenix log out feature
  User Story: As a user, I should be able to log out.

  AC1- User can log out and ends up in login page.
  AC2- The user can not go to the home page again by clicking the step back button after successfully logged out.
  AC3- The user must be logged out if the user closes the open tab (all tabs if there are multiple open tabs)
  AC3- Is not working correctly. Its not ready for test.

  Background: For the scenarios in the feature file, user is expected to be on already logged
    Given user is logged

  @logOutFunctionality @AC1-TC1 @UPG10-296
  Scenario: User can log out and ends up in login page.
    When user click on the log out button
    Then user is again on the upgenix log in page

  @logOutFunctionality @AC2-TC1 @UPG10-297
  Scenario: The user can not go to the home page again by clicking the step back button after successfully logged out.
    When user click on the log out button
    And user is again on the upgenix log in page
    And user click on the step back button
    Then user is again on the upgenix log in page

