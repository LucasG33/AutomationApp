# Automation-App
Prueba automatizada con tecnologias Selenium y Springboot
RECURSOS UTILIZADOS:
https://www.youtube.com/watch?v=lx_Nr-ZF-M4


El video es sobre selectores css, un recurso del cual hice uso para desarrollar esta automatizacion

Si bien nunca habia realizado una automatización antes, pude llevar a cabo el desafío tecnico sin mayores inconvenientes.
Al principio se me complicó entender un poco la arquitectura de una automatizacion, pero investigue en internet sobre los conceptos basicos y buenas practicas.

Tecnologias utilizadas:
-JAVA
-MAVEN
-SPRINGBOOT
-SELENIUM
-JUNIT
-EXTENT REPORTS
-WEBDRIVERMANAGER

Arquetipo del proyecto:

com.cg.driverconfig: Este paquete contiene la clase de configuración DriverConfig. Es responsable de configurar el WebDriver (ChromeDriver en este caso) utilizando WebDriverManager.

com.cg.pageobjects: Este paquete contiene la clase de objeto de página LoginPage. Representa la página de inicio de sesión de la aplicación web y proporciona métodos para interactuar con los elementos de la página.

com.cg: El paquete raíz contiene la clase principal AutomationAppApplication anotada con @SpringBootApplication. Sirve como punto de entrada de la aplicación Spring Boot.

src/test/java/com.cg: Este directorio contiene la clase de prueba AutomationAppApplicationTests. Utiliza JUnit para definir y ejecutar casos de prueba para la clase LoginPage.


En el transcurso del desarrollo han ido surgiendo dudas e inconvenientes. Generalmente suelo recurrir a Stack OverFlow, que me es de gran ayuda.
https://stackoverflow.com/questions/41511511/unsatisfieddependencyexception-error-creating-bean-with-name
https://stackoverflow.com/questions/30688368/java-selenium-chromedriver-exe-does-not-exist-illegalstateexception
https://stackoverflow.com/questions/21520316/the-annotation-bean-is-disallowed-for-this-location-error