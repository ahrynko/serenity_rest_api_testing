Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Scenario: Verify user is able to create new 2 Post to posts (DELETE + 2 POST)

Given user removes id users to API Resources
And user creates new 'POST' using API:
| title    | author   | age |
| Serenity | Hrynko A | 30  |
And user creates new 'POST' using API:
| title    | author   | age |
| Serenity | Hrynko Y | 35  |
Then new 'POST' should be created to posts


!-- Scenario: Verify one author of the post (different 'GET' operations using REST-assured)
!--
!-- Given I perform 'GET' operation for new post, using API:
!-- Then I should see the author name as 'Hrynko A'
!--
!-- Scenario: Verify collection of authors in the post
!--
!-- Given I perform 'GET' operation for new post, using API:
!-- Then I should see the author names
!-- Then I should see the author name as 'Hrynko A'
!--
!-- Scenario: Verify collection of authors in the post
!--
!-- Given I perform 'GET' operation for new post, using API:
!-- Then I should see the author names