FROM java:8-jre
ADD target/Api-Gateway-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Xmx200m", "-jar", "/app.jar"]
EXPOSE 8082
