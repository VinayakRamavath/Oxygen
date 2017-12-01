FROM openjdk:8-jre-alpine

VOLUME /tmp

#add the local jar to docker context (jar in target folder after mvn package)
ADD ./target/Crawler-0.0.1-SNAPSHOT.jar crawlerapp.jar

#different port for each image
EXPOSE 8070

CMD ["java","-Xmx200m", "-jar", "/crawlerapp.jar"]

