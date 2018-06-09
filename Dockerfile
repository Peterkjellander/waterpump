FROM hypriot/rpi-java
ADD target/com.pk.rpi.gpio.waterpump.api-0.0.1-SNAPSHOT.jar waterpumpapi.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "waterpumpapi.jar"]
