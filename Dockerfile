FROM openjdk:17

EXPOSE 8080

EXPOSE 1521

EXPOSE 1527

ADD target/iteminventory.jar iteminventory.jar

ENTRYPOINT ["java", "-jar", "/iteminventory.jar"]

# lsnrctl start