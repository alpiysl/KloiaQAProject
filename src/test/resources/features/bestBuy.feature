Feature: Best Buy Task

  @task1
  Scenario: User should be able to search expected item
    Given user should be on the "https://www.bestbuy.com" page
    Then the title should be "Best Buy | Official Online Store | Shop Now & Save"
    When user searches "Drone" item
    Then user should get "Drone" items as a result

  @task2
  Scenario: User should be able to sign in with valid credentials
    Given user should be on the "https://www.bestbuy.com" page
    And user navigates to sign in page
    When user signs in with "alp_5191@hotmail.com" email and "test_user112**01" password
    Then user should be signed in

  @task3
  Scenario: User should be able to login with Google account
    Given user should be on the "https://www.bestbuy.com" page
    And user navigates to sign in page
    When user clicks on sign in with Google
    And user signs in with "edmontDanteCristoCont@gmail.com" email and "w8shVWCXTMtUxvM" password with Google
    Then user should be signed in

  @task4
  Scenario: User should be able to navigate expected item
    Given user should be on the "https://www.bestbuy.com" page
    And user navigates to expected item under menu option
      | Department | Audio               |
      | Type       | Headphones          |
      | item Type  | Wireless Headphones |
    And user searches "Philips" brand and selects
    When user saves second item
    And navigates to saved items tab
    Then user ensures that saved item is shown expected