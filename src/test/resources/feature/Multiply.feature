Feature: multiplication
  Scenario: successful multiplication
    Given a "user" wants to multiplication two numbers
    When the application performs the multiplication of the two numbers
    Then the application returns the result of the multiplication, responds with status "200"