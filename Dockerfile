FROM nexus.sberbank.kz:5001/maven:3.8-adoptopenjdk-15 AS build
ENV JAVA_HOME=/opt/java/openjdk
ENV MAVEN_HOME=/usr/share/maven
COPY src /home/app/src
COPY pom.xml /home/app
# Copy maven settings, containing repository configurations
COPY settings.xml /usr/share/maven/.m2
RUN mkdir -p /root/.m2
COPY settings.xml /root/.m2
RUN mvn -f /home/app/pom.xml clean install -Dmaven.wagon.http.ssl.insecure=true

FROM nexus.sberbank.kz:5001/adoptopenjdk/openjdk15:jre-15.0.2_7-alpine
ENV TZ=Asia/Almaty
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
