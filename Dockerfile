FROM openjdk:17

COPY order-app-backend-0.0.1-SNAPSHOT.jar orderapp.jar

ENTRYPOINT ["java","-jar","/orderapp.jar"]