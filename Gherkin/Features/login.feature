Feature: Node adding


 Scenario Outline: Search from the node option
    Given a node at local api
    When user type <name> in the database
    Then user input <tuoi> in the database
    Then user input1 <birthday> in the database
    Then user input2 <id> in the database
    Then user input3 <join> in the database
    Then user input4 <title> in the database
    Then user input5 <status> in the database
    And user info compare in the list
    
    Examples:
    |name       |tuoi |birthday|id|join|title         |status     |
    |Tuan Anh   |30   |1985    |18|2013|Project Leader|WORKING    |
    |Giang Pham |44   |1995    |19|2014|Team Member   |WORKING    |
    |Vu Hien    |36   |1996    |20|2014|Team Member   |TRANSFERING|
    |Thu Nguyen |25   |1984    |21|2013|Facilitator   |VACATION   | 
    |Khoi Do    |22   |1998    |22|2018|Technician    |IN ACTIVE  | 
    
    
 