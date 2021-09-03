# GothicLLamasBE
Team GothicLlamas' back end Java API repo.

How to start the application
---

1. Navigate to GothicLlamasAPI folder
2. Run `mvn clean install` to test and build your application
3. Start application with `java -jar target/GothicLlamas-1.0-SNAPSHOT.jar server config.yml`

To check that your application is running enter url `http://localhost:8080`

To run built-in tests without building the application, run 'mvn test' in the GothicLlamasAPI folder

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
