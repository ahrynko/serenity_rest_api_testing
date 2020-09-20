Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Check the ability to search by quotes on the site https://ru.weltrade.com/tools/quotes/ (modify)

Given user opened 'Currency Quotes Page' by url: 'WELTRADE_BASE_URL'
When user retrieved quotes to list with site
And user executed Rest Request with the same quotes.json