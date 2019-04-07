FROM openjdk:8-alpine
RUN mkdir -p /opt/demos/webhooks
ADD target/WebHooksDemo-0.0.1-SNAPSHOT.jar /opt/demos/webhooks
EXPOSE 8080
CMD ["java", "-jar", "/opt/demos/webhooks/WebHooksDemo-0.0.1-SNAPSHOT.jar"]
