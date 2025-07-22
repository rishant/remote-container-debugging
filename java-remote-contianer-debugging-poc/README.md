## Generate Java Maven Project:
cmd:/> mvn archetype:generate -DgroupId=com.example -DartifactId=java-remote-contianer-debugging-poc -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

## Complate and Build Java Maven Project:
cmd:/java-remote-contianer-debugging-poc> mvn clean package

## Run Java MAven Project:
cmd:/java-remote-contianer-debugging-poc> java -jar target/java-remote-contianer-debugging-poc-1.0-SNAPSHOT.jar /files/input.zip /files/extracted/


## Build Docker Image:
docker build -t java-cli-poc:1.0 .

## Run Docker image (bash):
docker run -it --rm java-cli-poc:1.0

## Run Docker image (Normal):
docker run -it --rm -v %cd%\files:/files java-cli-poc:1.0 java -jar java-remote-contianer-debugging-poc-1.0-SNAPSHOT.jar /files/input.zip /files/extracted/

## Run Docker image (Debug):
docker run -it --rm -v %cd%\files:/files -e JAVA_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005" -p 5005:5005 java-cli-poc:1.0 java $JAVA_OPTS -jar java-remote-contianer-debugging-poc-1.0-SNAPSHOT.jar /files/input.zip /files/extracted/
