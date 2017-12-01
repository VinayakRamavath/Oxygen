FROM openjdk:8-jre-alpine

VOLUME /tmp

#add the local jar to docker context (jar in target folder after mvn package)
ADD ./target/StopWords-0.0.1-SNAPSHOT.jar stopword.jar

#different port for each image
EXPOSE 8053

CMD ["java","-Xmx200m",  "-jar", "/stopword.jar"]

