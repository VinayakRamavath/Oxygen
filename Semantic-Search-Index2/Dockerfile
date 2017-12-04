#base image
FROM openjdk:8-jre-alpine

VOLUME /tmp

#add the local jar to docker context (jar in target folder after mvn package)
ADD ./target/Semantic-Search-Index-0.0.1-SNAPSHOT.jar indexapp.jar

#different port for each image
EXPOSE 8085

CMD ["java","-Xmx200m", "-jar", "/indexapp.jar"]

