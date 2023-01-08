#define base docker image
FROM openjdk:8
EXPOSE 8888
ADD target/librarymanagement.jar librarymanagement.jar
ENTRYPOINT ["java", "-jar", "librarymanagement.jar"]