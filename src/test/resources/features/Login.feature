Feature: Login Page
#  @wip
  Scenario: Login and/or password are wrong
    Given users should be able to login to the application
    When user logs in with valid credentials
    Then Account summary page should display
#  @wip
  Scenario Outline: Login with wrong credentials
    Given users should be able to login to the application
    When users with wrong "<username>" and "<password>" should not be able to login
    Then error message should displayed
    Examples:
    |username|password|
    |user    |password|
    |username|pass    |
    |        |        |
