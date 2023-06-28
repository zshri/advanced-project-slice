#FROM adoptopenjdk/openjdk11:jdk-11.0.5_10-alpine
#ADD . /src
#WORKDIR /src
#RUN ./mvnw package -DskipTests
#EXPOSE 8085
#ENTRYPOINT ["java","-jar","target/blog-service-0.0.1-SNAPSHOT.jar"]

#FROM adoptopenjdk/openjdk11:jdk-11.0.5_10-alpine as builder
#ADD . /src
#WORKDIR /src
#RUN ./mvnw package -DskipTests

FROM amazoncorretto:17-alpine-jdk
COPY target/blog-service-0.0.1-SNAPSHOT.jar blog-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/blog-service-0.0.1-SNAPSHOT.jar"]