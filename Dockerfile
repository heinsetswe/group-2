FROM openjdk:latest
COPY ./target/group-2-0.1.0.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "group-2-0.1.0.1-jar-with-dependencies.jar"]
