Feature: Login Functionality

  Scenario: Successful login with valid credentials
    Given user is on login page
    When user enters valid username and password
    And user clicks on login button
    Then user should be redirected to the dashboard