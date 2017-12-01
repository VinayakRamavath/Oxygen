FROM openjdk:8-jre-alpine

VOLUME /tmp

#add the local jar to docker context (jar in target folder after mvn package)
ADD ./target/Parser-0.0.1-SNAPSHOT.jar parserapp.jar

#different port for each image
EXPOSE 8060

CMD ["java","-Xmx200m",  "-jar", "/parserapp.jar"]

