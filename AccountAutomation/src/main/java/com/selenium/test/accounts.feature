Feature: Automate login of 1000 accounts

  Scenario:1000 accounts are log in to Traform
    Given User is on Traform login screen
    And Access to 1000 Traform accounts is acquired
    When Accounts are logged in
    Then No errors are reported