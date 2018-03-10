FROM java:8-alpine
# Working directories for Tomcat by default
VOLUME /tmp
EXPOSE 8080
ADD mongomvc-1.0.0-SNAPSHOT.jar mongomvc.jar
RUN sh -c 'touch /mongomvc.jar'

ENV JAVA_OPTS=""
# URI with spring.data.mongodb.uri://mongodb://container-name:port/dbname
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Dspring.data.mongodb.uri=mongodb://mongodb:27017/custom -Djava.security.egd=file:/dev/./urandom -jar /mongomvc.jar" ]
