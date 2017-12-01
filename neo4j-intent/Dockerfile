#base image
FROM openjdk:8-jre-alpine

VOLUME /tmp

COPY /intents/javaIntent.csv ./

#add the local jar to docker context (jar in target folder after mvn package)
ADD ./target/neo4j-intent-0.0.1-SNAPSHOT.jar neo4jIntent.jar

#different port for each image
EXPOSE 8096

CMD ["java","-Xmx200m", "-jar", "/neo4jIntent.jar"]
