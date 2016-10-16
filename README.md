# Introduction
An example project that demonstrates how to create microservices with Dropwizard. It has three different microservices/projects: product catalog service, product review service, api gateway service.

##Build
On the three independent projects, do
```
mvn clean package
```

##Run
Zookeeper must have been installed locally and running in the default port(2181) for service discovery. If not, pls install from https://zookeeper.apache.org/releases.html

To launch product catalog service
```
java -jar product-catalog-0.0.1-SNAPSHOT.jar server product-catalog.yml
```
To launch product review service
```
java -jar product-review-0.0.1-SNAPSHOT.jar server product-review.yml
```
To launch api gateway service
```
java -jar api-gateway-0.0.1-SNAPSHOT.jar server api-gateway.yml
```

##Endpoints
- Catalog: http://localhost:9090/api/product/catalog/SKU-000
- Review:  http://localhost:9092/api/product/review/SKU-001
- API Gateway: http://localhost:8080/api/product/SKU-002

API Gateway endpoint uses basic digest auth. Supply the below creds.
```
User:shopback
Pass:$hopback
```
#Technologies
##Dropwizard Modules
- dropwizard-core
- dropwizard-jdbi
- dropwizard-migrations

##External Bundles
- GuiceBundle: https://github.com/HubSpot/dropwizard-guice
- DiscoveryBundle: https://github.com/dropwizard/dropwizard-discovery

##Database
H2: http://www.h2database.com/
