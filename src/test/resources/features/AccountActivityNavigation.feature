Feature: Navigating to specific accounts in Accounts Activity

  Background: users login page
    Given users should be able to login to the application
    And user logs in with valid credentials

#  @wip
  Scenario Outline: Savings account redirect
    Given the user clicks on "<Link>" link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have "<Link>" selected
    Examples:
      | Link        |
      | Savings     |
      | Brokerage   |
      | Checking    |
      | Credit Card |
      | Loan        |


