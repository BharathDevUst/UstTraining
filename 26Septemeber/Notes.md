# 26/09/2024

eureka service registry is provided and created by Netflix (They're the first people to convert from monolithic application architecture to micro-services application architecture). we'll be using it for development.

## interservice communication
as Database Per Service states, each microservices should have separate database
but we can't join 2 tables from different databases, That's why interservice communication comes in action to get the details from other services and process the business logic.

## zipkin-service 
it traces and keeps track of all the traces like where, which, what, how, when, etc.. in the micro service application
there are other log tracing products just like zipkin.

## configuration
each application config is done in `application.properties` file.
but we too can have common properties so that a service should follow a service configuration defined in `Cloud Config`.
you can use **Cloud Config** or **Native Config**.

# Today's agenda

1. [x] create eureka service registry
2. [x] create department service
3. [x] create the config server
4. [x] create zipkin server
5. [x] finish department service
6. [x] create employee service
7. [x] interservice communication using RestClient
8. [x] create api gateway - EOD[26/09/2024]
9. [x] spring boot actuator
10. [x] create circuit breakers using Resilence4J - EOD[27/09/2024]


[6] Interservice communication using RestClient

[8] 
change `spring-cloud-starter-gateway-mvc` to `spring-cloud-starter-gateway` in `pom.xml` file.
   - Add `@EnableDiscoveryClient` above the class with main method.
   - add properties in `application.properties` file
   - start the application


# Task
- customer-service
- order-service