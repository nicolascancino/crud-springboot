FROM openjdk:8-jdk-alpine as build
EXPOSE 8080
RUN mkdir /opt/app
COPY ./target/crud-0.0.1-SNAPSHOT.jar /opt/app
CMD ["java","-jar","/opt/app/crud-0.0.1-SNAPSHOT.jar"]
