[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-718a45dd9cf7e7f842a935f5ebbe5719a5e09af4491e668f4dbf3b35d5cca122.svg)](https://classroom.github.com/online_ide?assignment_repo_id=11081484&assignment_repo_type=AssignmentRepo)
# Práctica 10. Árbol AVL.

**Estructuras de Datos**

Esta práctica incluye bibliotecas para visualizar las estructuras programadas, cuando los métodos requeridos por cada demo ya se encuentren correctamente implementados.

Para utilizar la visualización se requieren las bibliotecas de ```JavaFX```.  Encontrarás las más actuales con soporte en [Gluon JavaFX](https://gluonhq.com/products/javafx/).  La documentación está en [Openjfx](https://openjfx.io/).  Se puede utilizar la última versión disponible, aunque se tenga Java 11.

Esta vez se te provee con un archivo ```Makefile``` para ayudarte a compilar y ejecutar tu práctica, este configura las acciones del comando ```make```.  Necesitarás abrir este archivo y, en la línea que dice:
```
PATH_TO_FX=<dirección de JavaFX>
```
escribir la dirección dónde descargaste ```JavaFX```. Por ejemplo:
```
PATH_TO_FX=/home/blackzafiro/Descargas/openjfx-11.0.1_linux-x64_bin-sdk/javafx-sdk-11.0.1/lib/
```

Si tienes Ubuntu y te indica que no tienes ```make```, instálalo con:
```
sudo apt install build-essential
```
Este archivo define objetivos.  Para compilar el código utiliza:
```
make compile
```
Para ejecutar:
```
make run
```
Para ejecutar las pruebas unitarias:
```
make jtest
```
Para borrar los archivos generados:
```
make clean
```

La entrega se realiza en este repositorio. 
* Recuerda hacer ```make clean``` antes de los commits; no queremos archivos innecesarios.
* Está prohibido publicar las soluciones en reposiorios públicos.
