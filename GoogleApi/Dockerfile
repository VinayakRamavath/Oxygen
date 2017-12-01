FROM openjdk:8-jre-alpine

VOLUME /tmp

COPY apikeys.json ./

#add the local jar to docker context (jar in target folder after mvn package)
ADD ./target/GoogleApi-0.0.1-SNAPSHOT.jar googleapiapp.jar

#different port for each image
EXPOSE 8081

CMD ["java","-Xmx200m", "-jar", "/googleapiapp.jar"]
