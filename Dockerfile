#
# Jar Package
#
FROM eclipse-temurin:17-jre-focal
# StudentListSecureDB-0.0.1-SNAPSHOT.jar  = <artifactId>-<version>.jar (pom.xml)
COPY --from=build /home/app/target/Bookstore-0.0.1-SNAPSHOT.jar /usr/local/lib/bookstore.jar
FROM eclipse-temurin:17-jre-alpine
COPY --from=builder /opt/app/*.jar /opt/app/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/bookstore.jar"]
ENTRYPOINT ["java", "-jar", "/opt/app/app.jar" ]