FROM alpine:latest
RUN apk update && \
    apk add openjdk21 && \
    apk add maven
COPY . /app
WORKDIR /app
RUN mvn clean install -DskipTests
CMD [ "java -jar /app/target/SecretariaCEOAKEdu-0.0.1-SNAPSHOT.jar" ]