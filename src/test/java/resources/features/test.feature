@smoketest
Feature: Investigating communication between frontend client and backend server

  Scenario: Play with anonymous player to win money
    Given Logs in into system as anonymous player
    Then  send spin request until player win any money