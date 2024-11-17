# ExamenGauss

# Parcial 2 hecho por: Arturo López y Roberto Quílez

url = https://github.com/ProyectoGauss/ExamenGauss.git

# Proyecto Máquina de Galton

Este proyecto implementa una Máquina de Galton con visualización en tiempo real, generación y carga de datos CSV, y un tablero de visualización gradual. El proyecto está dividido en dos partes: el backend y el frontend.

## Backend

### Tecnologías Utilizadas
- Java
- Spring Boot
- Maven
- OpenCSV
- WebSocket
- RabbitMQ

### Estructura del Proyecto
- `src/main/java/com/example/Gauss`
  - `Csv`: Contiene las clases relacionadas con la importación y manejo de datos CSV.
  - `WebSocketConfig.java`: Configuración de WebSocket.
  - `WebSocketController.java`: Controlador para manejar mensajes WebSocket.
  - `CsvDataController.java`: Controlador para manejar la importación y recuperación de datos CSV.
  - `CsvService.java`: Servicio para manejar la lógica de importación y recuperación de datos CSV.
  - `CsvData.java`: Clase de modelo para representar los datos CSV.

### Configuración de WebSocket
Configura el broker de mensajes y los endpoints de WebSocket para la comunicación en tiempo real.

### Controlador de Datos CSV
Maneja las solicitudes para importar datos CSV y recuperar los datos importados.

### Servicio de Datos CSV
Implementa la lógica para importar datos desde un archivo CSV y recuperar los datos importados.

### Modelo de Datos CSV
Define la estructura de los datos CSV.

## Frontend

### Tecnologías Utilizadas
- HTML
- CSS
- JavaScript
- D3.js
- Chart.js
- SockJS
- STOMP.js

### Estructura del Proyecto
- `src/main/resources/static`
  - `index.html`: Página principal con la interfaz de usuario.
  - `js/Visualization.js`: Script para la visualización de datos.
  - `js/table.js`: Script para manejar la tabla de datos.
  - `js/distribution.js`: Script para manejar la distribución de datos.

### Página Principal (`index.html`)
Define la estructura de la página con elementos HTML y estilos CSS.

### Script de Visualización (`Visualization.js`)
Implementa la lógica para generar y guardar CSV, cargar datos desde CSV a la base de datos, y visualizar el tablero de Galton en tiempo real.

## Instrucciones de Ejecución

### Backend
1. Clona el repositorio.
2. Navega al directorio del proyecto.
3. Ejecuta `mvn clean install` para construir el proyecto.
4. Ejecuta `mvn spring-boot:run` para iniciar el servidor.

### Frontend
1. Abre el archivo `index.html` en un navegador web.
2. Interactúa con la interfaz para generar y cargar datos CSV, y visualizar el tablero de Galton.

## Notas
- Asegúrate de que el backend esté corriendo antes de interactuar con el frontend.
- Verifica que las URLs en las solicitudes `fetch` del frontend apunten correctamente al backend.

