FROM java:8-jre

VOLUME /tmp

WORKDIR /src

COPY en_US.dic /src

COPY en_US.aff /src

#add the local jar to docker context (jar in target folder after mvn package)
ADD ./target/spell-checker-0.0.1-SNAPSHOT.jar /src/spellchecker.jar

#different port for each image
EXPOSE 8051

CMD ["java","-Xmx200m", "-jar", "/src/spellchecker.jar"]
