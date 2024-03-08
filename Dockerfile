FROM alpine:latest
RUN apk update && \
    apk add openjdk21 && \
    apk add maven && \
    mkdir /app
COPY . /app
WORKDIR /app
RUN mvn package -Pdocker -DskipTests
ENTRYPOINT java -jar target/SecretariaCEOAKEdu-0.0.1-SNAPSHOT.jar
