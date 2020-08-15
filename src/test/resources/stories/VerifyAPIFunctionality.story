Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Scenario: Verify user is able to create new 2 Post to posts (DELETE + 2 POST)

Given user removes id users to API Resources
And user creates new 'POST', using API:
| title    | author   | age |
| Serenity | Hrynko A | 30  |
And user creates new 'POST', using API:
| title    | author   | age |
| Serenity | Hrynko Y | 35  |
Then new 'POST' should be created to posts


Scenario: Verify user is able to update existing Post (POST + PUT + GET)

Given user creates new 'POST', using API:
| title                                    | author         | age |
| Java Programming Language. JDK Version 7 | Gerbert Shield | 50  |

When user update existing post, using following data:
| title                                    | author         | age |
| Java Programming Language. JDK Version 8 | Gerbert Shield | 51  |
Then following post should be updated


Scenario: Verify user is able to filter all Posts, by filter data ( POST + GET (getByQueryParams))

Given user retrieved all 'POST'
When user filters retrieved Posts by next filter params:
| title                                    | author         |
| Java Programming Language. JDK Version 8 | Gerbert Shield |
Then each filtered Post should contain such data only:
| title                                    | author         |
| Java Programming Language. JDK Version 8 | Gerbert Shield |


Scenario: Verify user is able to filter all Posts, by filter data ( 3 POST + GET (getByQueryParams))

Given user creates new 'POST', using API:
| title           | author           | age |
| Some Fake Title | Some Fake Author | 20  |
And user creates new 'POST', using API:
| title                                    | author         | age |
| Java Programming Language. JDK Version 8 | Gerbert Shield | 51  |
And user creates new 'POST', using API:
| title                                    | author         | age |
| Java Programming Language. JDK Version 8 | Gerbert Shield | 51  |

When user filters retrieved Posts by next filter params:
| title                                    | author         |
| Java Programming Language. JDK Version 8 | Gerbert Shield |
Then each filtered Post should contain such data only:
| title                                    | author         |
| Java Programming Language. JDK Version 8 | Gerbert Shield |