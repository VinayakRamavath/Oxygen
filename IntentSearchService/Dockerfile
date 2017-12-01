FROM java:8-jre

VOLUME /tmp


COPY intentcsv.csv .

COPY searchIntent.csv .

#add the local jar to docker context (jar in target folder after mvn package)
ADD ./target/IntentSearchService-0.0.1-SNAPSHOT.jar /IntentSearch.jar

#different port for each image
EXPOSE 8055

CMD ["java","-Xmx200m", "-jar", "/IntentSearch.jar"]
