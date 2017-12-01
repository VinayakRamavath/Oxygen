FROM java:8-jre

VOLUME /tmp

WORKDIR /src

COPY en-lemmatizer.txt /src

#add the local jar to docker context (jar in target folder after mvn package)
ADD ./target/Lemmatizer-0.0.1-SNAPSHOT.jar /src/lemmatizer.jar

#different port for each image
EXPOSE 8054

CMD ["java","-Xmx200m", "-jar", "/src/lemmatizer.jar"]
