#base image
FROM java:8-jre

VOLUME /tmp

COPY concepts.csv ./

#add the local jar to docker context (jar in target folder after mvn package)
ADD ./target/neo4j-concept-0.1.0.jar neo4jconcept.jar

#different port for each image
EXPOSE 8095

CMD ["java","-Xmx200m", "-jar", "/neo4jconcept.jar"]
