# Primeiro estágio: Compila a aplicação com Maven e Java 23
FROM eclipse-temurin:23-jdk AS builder

# Instala o Maven manualmente
RUN apt-get update && apt-get install -y maven

# Exibe as versões para depuração
RUN java -version && mvn -version

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos do projeto para dentro do container
COPY . .

# Executa o build e gera o JAR
RUN mvn clean package -DskipTests


# Segundo estágio: Apenas executa a aplicação para reduzir o tamanho da imagem final
FROM eclipse-temurin:23-jdk

# Define o diretório de trabalho
WORKDIR /app

# Copia apenas o JAR gerado no primeiro estágio
COPY --from=builder /app/target/*.jar github-manager-app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Define o comando de execução da aplicação
CMD ["java", "-jar", "app.jar"]