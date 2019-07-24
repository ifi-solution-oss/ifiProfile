Feature: Profile edit

  Scenario Outline: edit or remove factor in available user profile
    Given user in local host
    When press edit button
    Then  edit <elements> 
    Then input <data>
    And choosing the right label
    Then press save and check list for the new profile
    
   Examples:
    | elements              | data  |
    | birthday    		    | 1975  |
    | id       		        | IFSID0004  |
    | name		            | William Ngan  |
    | join                  | 2014   |
    | title                 | Project Leader |
    | status                | Working  |