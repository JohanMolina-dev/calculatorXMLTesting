Feature: Sum
  Scenario: Successful addition
  Given a "user" wants to sum two numbers
  When the application performs the sum of the two numbers
  Then the application returns the result of the sum, responds with status "200"
