Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Check the ability to search by last current Winners Draw in trade2win contest

Given user opened 'promotions/trade2win' by url: 'WELTRADE_BASE_URL'
When user retrieved last current winners to list with site
And user executed Rest Request with the same last current winners
Then compared two List of last winners with site and Rest Api Request