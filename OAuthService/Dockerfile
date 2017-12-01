FROM java:8-jre
VOLUME /tmp

WORKDIR /usr/src

#add the local jar to docker context (jar in target folder after mvn package)
ADD ./target/OAuthService-1.5.8.RELEASE.jar /usr/src/app.jar
ADD ./oauth-microservice.sh /usr/src/oauth-microservice.sh

#different port for each image
EXPOSE 8087

RUN ["chmod", "+x", "/usr/src/oauth-microservice.sh"]

ENTRYPOINT ["/usr/src/oauth-microservice.sh"]

