FROM openjdk:8-jre-alpine

VOLUME /tmp

#add the local jar to docker context (jar in target folder after mvn package)
ADD ./target/domain-expert-0.0.1-SNAPSHOT.jar domainexpert.jar

#different port for each image
EXPOSE 8089

CMD ["java","-Xmx200m", "-jar", "/domainexpert.jar"]
