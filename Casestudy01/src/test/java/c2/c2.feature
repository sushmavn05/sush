
Feature: Add to cart

  Scenario: Add to cart
    Given open the browser and url
    And enter the login credentials
    When Larry added a headphone to the cart
    And checkout for the payment
    And fills transaction details
    Then the product is successfully ordered
    And close the app

  
