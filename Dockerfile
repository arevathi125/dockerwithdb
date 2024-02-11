FROM openjdk:8
EXPOSE 8084
ADD target/dockerWithDB-0.0.1-SNAPSHOT.war dockerWithDB-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java","-jar","/dockerWithDB-0.0.1-SNAPSHOT.war" ]