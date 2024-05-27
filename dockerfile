# Use uma imagem base com JDK 17
FROM openjdk:17

# Copie o arquivo jar para a imagem
COPY target/viacep-1.0-Version.jar app.jar

# Comando para rodar a aplicação
ENTRYPOINT ["java","-jar","/app.jar"]