FROM openjdk:17

EXPOSE 8080

ADD target/item-inventory.jar item-inventory.jar

ENTRYPOINT ["java", "-jar", "item-inventory.jar"]