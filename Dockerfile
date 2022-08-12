FROM openjdk:17

EXPOSE 8080

ADD target/iteminventory.jar iteminventory.jar

ENTRYPOINT ["java", "-jar", "iteminventory.jar"]