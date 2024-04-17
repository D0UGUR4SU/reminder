FROM openjdk:11

VOLUME /tmp
ADD ./target/authentication-0.0.1-SNAPSHOT.jar authentication.jar
ENTRYPOINT ["java", "-jar", "/authentication.jar"]