Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Check the ability to search data by instruments in IB Payouts

Given user opened 'Partner Remuneration' by url: 'WELTRADE_BASE_URL'
When user retrieved instruments to list with site
And user executed Rest Request with the same instruments
Then compared two List of GBPUSD Instruments with site and Rest Request