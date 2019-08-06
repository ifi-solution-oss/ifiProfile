Feature: Node checking


  Scenario Outline: Search from the node option2
    Given enter relationship
    When choose dropdown label 1
    When choose dropdown label 2
    Then user enter relationship and <Technology>
    Then press search
    Then check relationship box
    Examples:
    |Technology |
    |Gherkin    |
    |Cucumber   |
    |Selenium   |
    |Java       |
    |JavaScript |
    |Python     | 
    |C++        |
    |CSS        |
    |HTML5      |
    |CSS3       |
    |Tosca      |
    |Jasmine    |
    |C#         |
    |.Net Core  |
    |Neo4j      |
    |NodeJS     |
    |Gitlab     |
    |Github     |
    |Jira       |
    |Trello     |
    |Redmine    |
    |SVN        |
    |Protractor |
    |Genkins    |
    |C          |
    |PHP        |
    |Spring     |
    |Spring boot|
    |Camunda    |
    |REST       |
    |SOAP       |
    |SOAPUI     |
    |Swift      |
    |Android    |
    |Oracle     |
    |MySQL      |
    |SQL Server |
    |SharePoint |
    |Xamarin    |
    |Hibernate  |
    
    
    