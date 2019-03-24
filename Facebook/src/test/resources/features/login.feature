Feature: Login to Facebook
  This feature logs in to facebook

  Scenario: Login with invalid credentials
    Given user navigates to the login page
      And user enters an invalid email and an invalid password
    When user clicks on login button
    Then user should see an error message