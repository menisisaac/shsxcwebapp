# Schenectady High School Cross Country Website

- A website that consolidates information needed for athletes on a cross country team, including results, announcement, schedules, and training tips
- A backend which scrapes meet results, keeps an updated schedule, and gives the coaches secure team management software
- A front end which displays meet results in full as well as team statistics based on those results, displays team information, and gives the coach access to the team management system

## Why Java Spring
- The backend uses microservices because some parts of the system are used much more then others. For example the web scraper will only be activated on certain days following competition, so there is no reason for it to be activated.
- I chose to use Spring for all of the microservices so that if I ever hand maintanace responsibilities over to another person they will only need to work within one language. 

## Challenges
- Using Java for web scraping has caused a bit of a problem as formatting and analyzing the data is more challenging without using Pythons amazing NumPy and Pandas libraries
- This is my first freelance work, so learning to keep the project within the scope of the requirements was difficult, as there are so many features that can be added
- I hope to create a IOS app in the future for the coaches responsibilities like attendance and scheduling practice
- Would like to implement test to ensure that the data was mined correctly and formated correctly in the results data

