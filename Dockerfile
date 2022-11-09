FROM adoptopenjdk/openjdk11
MAINTAINER farahani.dev@gmail.com
COPY target/FileUploader-1.0.0-SNAPSHOT.jar FileUploader-1.0.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/FileUploader-1.0.0-SNAPSHOT.jar"]