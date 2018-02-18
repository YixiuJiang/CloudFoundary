cf login -a https://api.run.pivotal.io
./gradlew build
cf push spring-helloworld-cf -p build/libs/PCF-0.0.1-SNAPSHOT.jar