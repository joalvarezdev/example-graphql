FROM joalvarezdev/springboot-alpine-17:latest

MAINTAINER joalvarez

COPY target/Example GraphQL.jar .

EXPOSE 8090

ENTRYPOINT ["java","-jar","Example GraphQL.jar"]
