FROM adoptopenjdk/openjdk11:alpine-slim
RUN mkdir /app && addgroup springboot && adduser  -H  -S -G springboot springboot && chown -R springboot:springboot /app
ADD target/*.jar /app/app.jar
USER springboot
ENTRYPOINT ["java","-jar","/app/app.jar"]