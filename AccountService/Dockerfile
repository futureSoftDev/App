#base-image
from openjdk:21
#Info
MAINTAINER shrayimjonov
#add app jar file to image
COPY target/accountService-0.0.1-SNAPSHOT.jar accountService-0.0.1-SNAPSHOT.jar
#execute command
ENTRYPOINT ["java","-jar","accountService-0.0.1-SNAPSHOT.jar"]