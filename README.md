# Getting Started

## Build
```
./mvnw package && docker build -t demo-spring-webflux .
```

## Run
1. Deploy
```
docker run -it -p 9191:8181 demo-spring-webflux
```
2. Go to http://localhost:9191/customers/stream


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.1/maven-plugin/reference/html/#build-image)
