Instructions:

- git clone https://saradraj@github.com/saradraj/shiny-application.git 
- cd shiny-application
- mvn spring-boot:run

The following are not required but might be nice additions to the exercise.

* Describe a fault tolerant deployment topology for your application, and the types of failures it would and would not be resilient to.
- Implement using relational data store instead of in memory store
- Cluster applicaiton and database servers in different regions.
- Autoscale app servers for handling spikes

* Discuss the advantages and disadvantages of your persistence mechanism.
- In memory store is not scalable
- Not good for production ready service
- Good for testing and fast booting

* Add a URL to return a list of all campaigns as JSON.
- GET localhost:8080/ad

* Add support for multiple ad campaigns per partner.
Separate out partner and ad table using a one to many relation ship
