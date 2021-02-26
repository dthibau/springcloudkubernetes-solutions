FROM openjdk:8-jre-alpine
MAINTAINER David THIBAU <david.thibau@gmail.com>

ADD ./target/acc*.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/members.jar"]

EXPOSE 8080
