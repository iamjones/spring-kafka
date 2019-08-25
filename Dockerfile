FROM maven:3.5.0-jdk-8-alpine

WORKDIR /srv

ENV SPRING_PROFILES_DEFAULT development

# Prepare by downloading dependencies
ADD pom.xml ./pom.xml

# Adding source, compile and package into a fat jar
ADD src ./src

RUN ["mvn", "package"]

EXPOSE 80

ENTRYPOINT ["/usr/bin/java", "-jar", "/srv/target/testservice-0.0.1-SNAPSHOT.jar"]