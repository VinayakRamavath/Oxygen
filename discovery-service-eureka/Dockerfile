FROM openjdk:8-jre-alpine

ADD target/discovery-service-eureka-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-Xmx200m", "-jar", "/app.jar"]

EXPOSE 8020
