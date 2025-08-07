This repository contains 2 microservices and a service registry:
1. Election service  - To schedule election and view election-candidate details.
2. Candiate service - To register as candidates for specific election and view candidates.
3. Eureka server    - As discovery service and service registry.

Configured Swagger to view the end points
1. Candidate Service - http://localhost:8282/swagger-ui/index.html
2. Election service  - http://localhost:8181/swagger-ui/index.html

Configured Actuator service for health checkup, detailed endpoint mappings etc...
1. Candidate Service - http://localhost:8282/actuator/health, http://localhost:8282/actuator/mappings
2. Election service  - http://localhost:8181/actuator/health, http://localhost:8181/actuator/mappings
