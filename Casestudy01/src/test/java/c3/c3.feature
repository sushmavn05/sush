
Feature: Adding product scenario

  Scenario: Adding product scenario
    Given opens the browser and enter the testme app url
    And 	admin enters login credential 
    			| username | password  |
    			| admin    |password456|
    Then 	click on add to category and enter category and subcategory names
      		| category 		| subcategory | 
      		| Electronics	| Headphone  | 
    And enter the product name and price  
     			| product | price | 
     			|Jabra 11 | 300   | 	
    And enter the quantity and brand  
     			| Quantity | brand |
    			| 10     	| Jabra |
    And enter the decsription for the product 
      			 |       description					 |
      			 |Headphone suitable for office|
    Then close the application and browser