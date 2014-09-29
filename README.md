# Technology Stack

The project uses the following technologies:
- **java**: Java 7
- **web server**: Tomcat 7, Spring Boot
- **web/REST**: Spring 4.1, RestEasy 3
- **view**: Freemarker
- **marshalling**: Jackson (for JSON)
- **testing**: JUnit, Mockito, Hamcrest Matchers
- **utils**: Lombok

## How to run it
* run 'mvn clean install' inside the main project
* run the main class in the `com.danix.example.spring.jaxrs.backend.Main`
* run 'mvn tomcat7:run' inside the file-upload-frontend folder
* go to http://localhost:8090/

## Call the API:

- get file meta data

    http://localhost:xxxx/files/{id}

- download file

    http://localhost:xxxx/files/{id}/download

- upload file with POST

    http://localhost:xxxx/files/