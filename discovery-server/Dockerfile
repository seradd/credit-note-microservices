FROM maven:3-jdk-8 as builder
# create app folder for sources
RUN mkdir -p /build
WORKDIR /build
COPY pom.xml /build
#Download all required dependencies into one layer
RUN mvn -B dependency:resolve dependency:resolve-plugins
#Copy source code
COPY src /build/src;
# Build application
RUN mvn -Dmaven.test.skip=true package

FROM openjdk:8-jre-alpine
EXPOSE 8761
ENV JAVA_OPTS=""
ENV APP_HOME /app

#Create base app folder
RUN mkdir $APP_HOME
COPY --from=builder /build/target/*.jar app.jar
WORKDIR $APP_HOME
#Copy executable jar file from the builder image
COPY target/*.jar app.jar
ENTRYPOINT [ "sh", "-c", "java -jar app.jar" ]