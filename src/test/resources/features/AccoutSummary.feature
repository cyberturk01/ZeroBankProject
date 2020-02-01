Feature:

  Background:users login page
    Given users should be able to login to the application

  Scenario:Title Account Summary
    Given user logs in with valid credentials
    Then page should have the title Zero - Account summary

  Scenario: Account types
    Given user logs in with valid credentials
    Then page should have the titles
      | Cash Accounts | Investment Accounts | Credit Accounts | Loan Accounts |

#  @wip
  Scenario: Credit Accounts Table
    Given user logs in with valid credentials
    Then credit accounts should  have columns
      | Account | Credit Card | Balance |