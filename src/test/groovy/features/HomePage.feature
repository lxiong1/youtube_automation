Feature: HomePage

  Background:
    Given I navigate to the Youtube website

  Scenario: Verify Youtube Logo
    Then I see the Youtube logo

  Scenario: Verify Main Menu
    Then I see the main menu options including home, trending, and subscriptions

  Scenario: Verify Top Bar Menu
    Then I see create/post and youtube apps in the top bar menu options are "24" by "24" svg images

  Scenario: Verify Login
    When I log in
    Then I see an avatar

  Scenario: Verify Top Bar Menu When Logged In
    When I log in
    Then I see messages and notifications in the top bar menu options are "24" by "24" svg images

  Scenario: Verify Search Result
    When I search for "Joker Heath Ledger"
    Then I see the first search result as "Batman - The Dark Knight | The Joker Compilation (All Scenes)"