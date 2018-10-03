

#Author: yiweis@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template  
# As a student, I want to Launch dashboard of iMetaLab. 
 Feature: Scenario OttawaU.iMetaLab
  	 
	Scenario: Go to Dashboards
		Given I have open the browser
		Given I open iMetaLab website
		When I click Resource button
		And I click the DownloadMetaLab button
		Then The account page shows up
		When Welcome to iMetaLab shows up
		And  Create Session button shows up
		And  View Result button shows up
		And  Tutorial button shows up	
		Then I close the browser
		
