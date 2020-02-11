Feature: REST API tests

Scenario: Get all the employee details for ABN AMRO TestApp
When I Get Employee Details for ABN AMRO
Then I shall get Status Code of 200

Scenario: Verify Single Employee Details
When I get Employee details for a particular Employee 
Then I shall get the correct details

 Scenario: Verify Post Failure on a non-existing record
 When I Call post method on a non existing URL
 Then I shall get Expected HTTP response
 

 