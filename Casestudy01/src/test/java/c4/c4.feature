Feature: Implement Data driven approach

  @tag1
  Scenario: Adding a new product to TestMe app
    Given open the browser and enter the url of the app
    And 	give the login credentials of the admin 
    Then 	click on the add category 
    |  subcategory  |  Product   |
    | balls005      | Basketball |
    | balls005      | Volleyball | 
    And execute next scenario
    

  @tag2
  Scenario Outline: to check if the login is from admin or not
    Given User should be logged in 
    Then check the "<title>" of the page
  Examples: 
      | title       |
      | Admin Home  |
      | Home        |    
