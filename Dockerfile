# Base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Add application JAR to the working directory
ADD target/Hiring-app.jar ./

# Expose the application port (replace with your application's port if not 8080)
EXPOSE 8080

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "Hiring-app.jar"]

#  Run these when ever you want to create the image of this app


# mvn clean package
# docker build -t springboot-mongodb-app:1.0 .
# docker run -p 8080:8080 springboot-mongodb-app:1.0


# these does not create a new container each time you run :
#docker run -p 8080:8080 --name springboot-mongodb-app springboot-mongodb-app:1.0
#docker start springboot-mongodb-app
#docker stop springboot-mongodb-app