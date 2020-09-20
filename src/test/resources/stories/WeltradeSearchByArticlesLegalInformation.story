Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Check the ability to search by articles in legal informations (modify)

Given user opened site 'https://ru.weltrade.com/legal/'
When user retrieved all articles to list with site
And user executed Rest Request with all articles
Then compared two List with site and Rest Request