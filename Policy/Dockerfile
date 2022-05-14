FROM openjdk:8-jdk-alpine
ADD target/policy.jar policy.jar
ENTRYPOINT ["java","-jar", "/policy.jar"]