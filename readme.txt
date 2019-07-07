
1) How to run the application
#We can run the spring boot application using the following maven command.
mvn spring-boot:run or java -jar BookingBoss.jar


2)Restful API Doc
# Use SwaggerConfig.java to generate API Doc and expose Swagger UI for testing and reference
# The exposed API details can be viewed in swagger-ui.html
# Swagger UI URL
http://localhost:8081/bookingboss/v2/api-docs
http://localhost:8081/bookingboss/swagger-ui.html


3) Convert Swagger API Doc To AsciiDoc
Use Swagger2MarkupTest.java to generate AsciiDoc and save to location: target/docs/asciidoc/generated.
In the future, based on the generated asciidoc, can use swagger2markup libraries to convert to HTML5 or PDF document.


Use defualt swagger url
#Authentication
WebConfiguration
UserDetailsServiceAutoConfiguration
Using generated security password: 01a33889-98f1-43df-bd99-70e30901df7e


4) H2 Database Console URL
# Access via console and can query the database, credential: sa/password
http://localhost:8081/bookingboss/console


5) Spring Security and Authentication
Use SecurityConfig.java to implement basic username/password authentication before initialize the API call.

In future, can add AuthenticationProvider to AuthenticationManagerBuilder while implementing configure() method in SecurityConfig.java
to apply TokenService, and authenticate using token.

