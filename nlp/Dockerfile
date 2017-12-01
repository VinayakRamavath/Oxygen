FROM java:8-jre

VOLUME /tmp

WORKDIR /src

COPY en-pos-maxent.bin /src

COPY en-token.bin /src

COPY ner-custom-model.bin /src

COPY input.txt /src

COPY FinanceOutpuutt.txt /src

COPY ner-custom-model-finance.bin /src

#add the local jar to docker context (jar in target folder after mvn package)
ADD ./target/nlp-0.0.1-SNAPSHOT.jar /src/pos-ner.jar

#different port for each image
EXPOSE 8052

CMD ["java","-Xmx200m", "-jar", "/src/pos-ner.jar"]
