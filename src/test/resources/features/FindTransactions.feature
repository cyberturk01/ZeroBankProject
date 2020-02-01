Feature: Find Transactions in Account Activity

  Background: users login page
    Given users should be able to login to the application
    And user logs in with valid credentials


  Scenario: Search date range
    Given the user accesses the Find Transactions tab
    When the user enters date range from "2012-09-01" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-01" to "2012-09-06"
    And the results should be sorted by most recent date

  Scenario: Search date range exclude 01
    Given the user accesses the Find Transactions tab
    When the user enters date range from "2012-09-02" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-02" to "2012-09-06"
    And the results table should only not contain transactions dated "2012-09-01"

  Scenario Outline: Search description
    Given the user accesses the Find Transactions tab
    When the user enters description "<description>"
    And clicks search
    Then results table should only show descriptions containing "<description>"
    Examples:
      | description |
      | ONLINE      |
      | OFFICE      |

  Scenario: Search description case insensitive
    Given the user accesses the Find Transactions tab
    When the user enters description "online"
    And clicks search
    Then results table should only show descriptions containing "ONLINE"
#  @wip
  Scenario: Type
    Given the user accesses the Find Transactions tab
    And clicks search
    Then results table should show at least one result under Deposit
    Then results table should show at least one result under Withdrawal
    When user selects type "Deposit"
    Then results table should show at least one result under Deposit
    But results table should show no result under Withdrawal
    When user selects type "Withdrawal"
    Then results table should show at least one result under Withdrawal
    But results table should show no result under Deposit