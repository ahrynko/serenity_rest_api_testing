Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal


Scenario: Verify one author of the post (different 'GET' operations using REST-assured)

Given I perform 'GET' operation for new post, using API:
Then I should see the author name as 'Hrynko A'

Scenario: Verify collection of authors in the post

Given I perform 'GET' operation for new post, using API:
Then I should see the author names
Then I should see the author name as 'Hrynko A'

Scenario: Verify collection of authors in the post

Given I perform 'GET' operation for new post, using API:
Then I should see the author names