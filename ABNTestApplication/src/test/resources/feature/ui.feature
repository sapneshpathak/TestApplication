Feature: UI tests

 Scenario: Login with valid credentials
 Given I visit herokuapp
 And I click on Basic Auth
 When I login with valid username "admin" password "admin"
 Then I shall get logged in 
 
 #Scenario: Login with invalid credentials
 #Given I visit herokuapp
 #And I click on Basic Auth
 #When I login with invalid username {username} password {password}
 #Then I shall be shown login dialogue again
 
 Scenario: Clicking Home page on disappearing elements link
 Given I am on herokuapp disappearing elements page
 When I click on Home link
 Then I shall be redirected to herokuapp home page
 
 Scenario: Selecting drop downs on herokuapp
 Given I am on herokuapp dropdwon page
 Then I shall be able to click and select the specified dropdown values

Scenario: Writing in the iFrame
Given I am on herokuapp iFrame page
When I open new file in the frame
Then I shall be able to write text in it
 