FROM openjdk:8
MAINTAINER teeyagundi karthikavreddy@gmail.com
COPY ./target/Calculator-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java", "-jar", "Calculator-SNAPSHOT-jar-with-dependencies.jar"]