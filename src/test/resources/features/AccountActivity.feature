Feature:

  Background: users login page
    Given users should be able to login to the application
    Then user logs in with valid credentials

  Scenario:Title Zero - Account activity
    Given goto Account Activity link
    Then page should have the title Zero - Account activity

#  @wip
  Scenario: default option should be Savings
    Given goto Account Activity link
    Then drop down default option should be "Savings"
    Then account drop down should have the following options
      | Savings | Checking | Savings | Loan | Credit Card | Brokerage |

#  @wip
  Scenario: default option should be Savings
    Given goto Account Activity link
    Then transactions table should have column names
      | Date | Description | Deposit | Withdrawal |
