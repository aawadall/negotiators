# negotiators
Simple negotiating agents attempting to reach consensus  

each agent will inspect prior offers, and propose an offer in the environment
currently, agents are using simple curve fitting mechanism

~~future development, is to inject an objective function, e.g. a function of high amount or low amount and minimum negotiating time~~

This project was developed and tested on Ubuntu 18.04, with some minor testing on Windows 10, both using IntelliJ Idea

TODO:
* simulate two way transactions, bid, and product delivered to simulate trading transactions
* separate environments from agents to host environments on a cloud provider, e.g. AWS Lambda
