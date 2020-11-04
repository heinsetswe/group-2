FROM openjdk:latest
COPY ./target/group-2-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "group-2-1.0-SNAPSHOT-jar-with-dependencies.jar"]
