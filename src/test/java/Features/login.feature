Feature: Login Functionality

  Scenario: Successful login with valid credentials
    Given User is on the login page
    When User enters "testuser" and "password123"
    And User clicks the login button
    Then User should be logged in successfully

