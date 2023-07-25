# Documentación.
Este proyecto provee una aplicación web para un servicio de entrega a domicilio que busca cumplir dentro de sus posibilidades con las tareas solicitadas en el documento de especificación tambipen presente en el repositorio.


# Diseño de la solución.
El diseño de este proyecto se divide en tres partes principales:
La estructura principal del proyecto cuenta con la siguiente estructura:
- Frontend
- Backend
- BDD
Cada una es prácticamente una aplicación independiente a la otra, comunicandose como lo indica el siguiente diagrama:
![Arquitectura del proyecto](/doc/img/dia1.png)
Ya que cada parte está separada de la otra y se comunican a través de peticiones estandarizadas (REST, JPA) se tienen las siguientes ventajas:
- Proyectos más escalables.
- Equipos de desarrollo especializados para el mantenimiento del servicio.
- Distintas intancias/aplicaciones que consuman el backend. (Por ejemplo una aplicacion de escritorio, una aplicación movil y una aplicación web pueden alimentarse del mismo backend)
- Migraciones y actualizaciones más fáciles.
 

# Tecnologías principales:
## Angular. 
El frontend está programado con HTML, CSS y Typescript utilizando el framework  Angular. Actualmente Angular es uno de los frameworks más utilizados para el desarrollo de frontend y al estar  desarrollado por Google se puede confiar en su funcionamiento.

## Springboot.
La parte del backend está escrita en Java utilizando el framework Spring boot, un framework completo y muy popular entre los desarrolladores de backend, este permite desarrollar aplicaciones seguras e incluso permite la modularización de aplicaciones en microservicios. 

## MySQL.
Para la persistencia de los datos se utilizó una base de datos MySQL, cuya definicion se encuentra en la carpeta BDD.

# Técnologías adicionales:
## Backend:
- **Maven** como gestor de dependencias.
- **Hibernate** como ORM
- **JWT** para generar tokens de seguridad para gestionar las sesiones de los usuarios.
- **Argon2** para cifrar datos delicados e ingresarlos a la base de datos.
## Frontend:
- **Angular Material** para tener componentes estéticos y funcionaes más a la mano desarrollada tambien por google.
- **Leaflet** como libreria para mapas interactivos.
- **AQUI VA LA API QUE USARË** como API para los datos geográficos.  

## Herramientas de desarrollo:
- InteliJ IDEA
- Visual Studio Code
- Postman
- XAMPP
- GitHub Desktop

# Caso de uso de las funcionalidades de la aplicación.
![Caso de uso](/doc/img/casoUso.png)


En esta version falta por implementar el repartidor como actor del sistema.
