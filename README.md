# fuego-quasar
código fuente que resuelve la prueba de Fuego de Quasar

para iniciar el API (se debe tener instalado el JDK 8 de Java). Se puede seguir el siguiente procedimiento:

ruta: fuego-quasar/apirestquasarfire/target/

1. descargar el archivo apirest-0.0.1-SNAPSHOT.jar
2. abrir una ventana de línea de comandos y ubicarse donde se encuentra el archivo
3. ejecutar el siguiente comando: java -jar apirest-0.0.1-SNAPSHOT.jar

una vez ejecutado el servicio, se puede iniciar un cliente para servicios rest, como postman o soapui el endpoint es el siguiente:

http://localhost:8080/FuegoQuasar/topsecret/

el json de prueba es el siguiente:
{"satellites": [{"name": "kenobi","distance": 100.0,"message": ["este", "", "", "mensaje", ""]},{"name": "skywalker","distance": 115.5,"message": ["", "es", "", "", "secreto"]},{"name": "sato","distance": 142.7,"message": ["este", "", "un", "", ""]}]}

para el nivel 3, el endpoint es el siguiente:

GET

http://localhost:8080/FuegoQuasar/topsecret_split/{nombre_satellite}

POST

http://localhost:8080/FuegoQuasar/topsecret_split/{nombre_satellite}

json
{"distance": 100.0,"message": ["este", "", "", "mensaje", ""]}
