## General information ##
Getting a practical skills in development of microservices application using Spring boot and Netflix OSS.

## Technologies used ##
- Spring Boot
- Spring Cloud
- Spring Security
- Netflix OSS

## Scope ##
1. Registry service - Eureka server. Keeps track of information about available services in the system.
2. Config service - Provides APIs to the configuration files stored in: https://github.com/ka5ta/config-repo repository
3. Client service 1: Creates in memory database with Product and Inventory information. Rest endpoints to query products information
4. Client Service 2: Rest endpoints to query products availability
5. Client Service 3: Using OpenFeign communicated with RESt controllers to get product data. Configured circuitbreakers stops communication if failure treashold is reached.
6. Gateway service: Allow communication within microservice architecture
