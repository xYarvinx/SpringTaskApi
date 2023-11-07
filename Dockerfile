FROM openjdk:21
ADD ./target/TaskList-0.0.1-SNAPSHOT.jar backend.jar

ENTRYPOINT ["java", "-jar", "backend.jar"]