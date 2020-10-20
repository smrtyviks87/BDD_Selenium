Feature: Countdown Functionality

  This feature would be able to provide countdown timer for period specified
  @web
  Scenario Outline: Countdown Positive Flow
    Given I am on the eggtimer application
    And I See Input field for period
    And I see a button "<Gobtn>"
    When I Enter valid period "<period>"
    And I Click Go Button
    Then I should see the timer is started "<period>"
    Examples:
      |  Gobtn | period |
      |  GO!  | 25 seconds  |
  @web
 Scenario Outline: Countdown Negative Flow
    Given I am on the eggtimer application
    And I See Input field for period
    And I see a button "<Gobtn>"
    When I Enter invalid period "<period>"
    And I Click Go Button
    Then I should be asked to enter valid period
    Examples:
      | Gobtn | period |
      | GO!  | 1,25 seconds  |
