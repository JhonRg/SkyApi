#Variable
ARG FILE_DIR=/target
ARG JAR_FILE=SkyApi-0.0.1-SNAPSHOT.jar
#jdk for the application
FROM openjdk:21
LABEL maintainer="sky_api"
#Add the .jar of the application
ADD ./target/SkyApi-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app/
ENTRYPOINT ["java", "-jar", "SkyApi-0.0.1-SNAPSHOT.jar"]