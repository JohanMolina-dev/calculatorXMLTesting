Feature: mathematical subtraction
  Scenario: successful subtraction
    Given a "user" wants to subtraction two numbers
    When the application performs the subtraction of the two numbers
    Then the application returns the result of the subtraction, responds with status "200"