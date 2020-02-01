Feature:Pay Bills Page
  Background: users login page
    Given users should be able to login to the application
    And user logs in with valid credentials
    Then goto Account PayBill link

  Scenario:Title Zero - Pay Bills
    Given page should have the title Zero - Pay Bills
#  @wip
  Scenario: Successful Pay Operation
    Given user inputs some amount in to Amount field "200"
    When select a date for the Date field "2020-02-02"
    Then message The payment was successfully submitted should be displayed.

  Scenario:Failing Pay Operation in Amount
    Given user inputs some amount in to Amount field ""
    When select a date for the Date field "2020-02-02"
    Then message Please fill out this field message should be displayed in the Amount field

  Scenario:Failing Pay Operation in Date
    Given user inputs some amount in to Amount field "200"
    When select a date for the Date field ""
    Then message Please fill out this field message should be displayed in the Date field
#  @wip
  Scenario: Alphabetical and special characters not accepted.
    Given amount field should not accept alphabetical or special characters.
#  @wip
  Scenario: Alphabetical characters not accepted.
    Given date field should not accept alphabetical characters.