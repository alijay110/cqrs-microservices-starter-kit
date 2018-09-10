# cqrs-microservices-starter-kit

## *** Full Documentation coming shortly ***

Ouick overview:

A basic command line application to show the work flow process using a basic domain object (entity & value object) that is written to via a Command microservice and read from a Query microservice.

A Gateway API used to take a REST service call and translate into underlying microservice calls. Spring Netflix Eureka server and Spring Config-Server are set up as their own microservices to allow for both the configuration and discovery of microservices.

Client services calls are either writing data or reading data, each service is on it's own microservice instance. One of writing (Command) and one for reading (Query). This follows the CQRS pattern. 
The underlying storage used by the Command service is MySQL accessed via Hibernate/JPA. 
The underlying storage used by the Query service is MongoDB.

Communication between the Command & Query services (to allow for Eventual Consistency of data) is done by sending event to the  RabbitMQ Message Broker. The interface calls to RabbitMQ is done via Spring Stream which is also set up as a microservice.

The data that is stored by the Command service is denomalised and stored in a slightly different more client centric view in the Query service. 


