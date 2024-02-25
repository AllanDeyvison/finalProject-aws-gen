
FROM maven:latest AS build 

WORKDIR /inocencio

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM amazoncorretto:17

WORKDIR /inocencio

COPY --from=build /inocencio/target/inocencio-0.0.1-SNAPSHOT.jar ./

CMD [ "java", "-jar", "inocencio-0.0.1-SNAPSHOT.jar" ]



