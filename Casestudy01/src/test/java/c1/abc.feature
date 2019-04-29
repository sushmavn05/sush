Feature: Add product scenario

  Scenario: Add product scenario
    Given opens the browser url
    And admin enters login credentials
    And add new product
    When admin click on add product
    Then product is added
