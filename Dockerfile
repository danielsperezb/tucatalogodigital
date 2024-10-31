# Usar una imagen base con Java 17
FROM openjdk:17-slim

# Directorio donde se colocará la aplicación en el contenedor
WORKDIR /app

# Copiar el archivo JAR generado al directorio /app en el contenedor
COPY build/libs/ietiproject-0.0.1-SNAPSHOT.jar /app/ietiproject.jar

# Exponer el puerto que usa la aplicación
EXPOSE 3000

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "/app/ietiproject.jar"]
