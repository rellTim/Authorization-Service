# Используем базовый образ OpenJDK для Java
FROM openjdk:17-jdk-alpine

# Установка Maven
RUN apk update && \
    apk add --no-cache maven

# Установка рабочей директории внутри контейнера
WORKDIR /app

# Копируем файлы сборки проекта внутрь контейнера
COPY . /app

# Сборка приложения с помощью Maven
RUN mvn clean && mvn package

# Запуск приложения при старте контейнера
CMD ["java", "-jar", "target/AuthorizationService-0.0.1-SNAPSHOT.jar"]
