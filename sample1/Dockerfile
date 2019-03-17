# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine
#FROM openjdk:11-jre-slim
RUN apk add --no-cache bash

# copy WAR into image
COPY sample1-0.0.1-SNAPSHOT.war /app.war 

COPY run.sh /run.sh


#use this, if logback.xml is externally provided and does not sit inside the classpath, e.g. procect-dir/docker/logback.xml
#COPY src/main/resources/logback.xml /logback.xml
#CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "-Dlogging.config=/logback.xml", "/app.war"]



#use this, if logback.xml sits inside the classpath, e.g. src/main/resources
#CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/app.war"]

ENTRYPOINT ["/run.sh"]