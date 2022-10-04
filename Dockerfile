FROM adoptopenjdk/openjdk16-openj9:alpine-jre
ADD customer/target/customer-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
