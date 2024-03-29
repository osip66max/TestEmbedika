FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM tomcat:9.0-jre11-openjdk-slim
COPY --from=build /home/app/target/TestEmbedika.war /usr/local/tomcat/webapps/TestEmbedika.war
COPY tomcat-conf.xml /usr/local/tomcat/conf/server.xml
COPY tomcat-web.xml /usr/local/tomcat/conf/web.xml
EXPOSE 8080
CMD ["catalina.sh", "run"]