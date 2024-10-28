# ExamenGauss

url = https://github.com/ProyectoGauss/ExamenGauss.git

El proyecto es una aplicación web basada en Spring Boot que maneja la importación de datos CSV y una simulación de caída de bolas. A continuación, se describen las principales clases y sus funciones:

### Clases relacionadas con CSV

1. **`CsvData`**:
   - Es una entidad JPA que representa los datos del CSV.
   - Contiene campos como `id`, `edad`, `altura`, `peso`, `nota` y `genero`.

2. **`CsvDataRepository`**:
   - Es una interfaz que extiende `JpaRepository` para proporcionar métodos CRUD para la entidad `CsvData`.

3. **`CsvDataLoader`**:
   - Es un servicio que maneja la lógica de importación de archivos CSV.
   - Lee el archivo CSV, borra los datos existentes en la base de datos y guarda los nuevos datos.

4. **`CsvDataService`**:
   - Es un servicio que utiliza `CsvDataLoader` y `CsvDataRepository` para importar datos CSV y obtener todos los datos CSV.

5. **`CsvDataController`**:
   - Es un controlador REST que expone endpoints para importar archivos CSV y obtener datos CSV.

### Clases relacionadas con la simulación

1. **`SimulationController`**:
   - Es un controlador que maneja las solicitudes web relacionadas con la simulación.
   - Proporciona endpoints para la página de inicio, iniciar la simulación y mostrar la página de simulación de caída de bolas.

2. **`SimulationRestController`**:
   - Es un controlador REST que proporciona datos en tiempo real para la simulación de caída de bolas.
   - Simula la caída de bolas en intervalos regulares y actualiza los datos de los contenedores.

### Clases relacionadas con la fábrica

1. **`FactorySimulation`**:
   - Es un servicio que simula la producción de componentes en una fábrica.
   - Lee datos del repositorio CSV y produce componentes utilizando `ComponentProducer`.
   - Ensambla componentes utilizando `AssemblyProducer`.

2. **`AssemblyConsumer`**:
   - Es un servicio que consume mensajes de una cola de RabbitMQ relacionada con la ensambladura de componentes.
   - Procesa los nombres de los componentes ensamblados.

   3. **`ComponentProducer`**:
    - Es un servicio que produce mensajes en una cola de RabbitMQ relacionada con la producción de componentes.
    - Lee datos del repositorio CSV y produce componentes.
    - Envía mensajes a la cola de RabbitMQ para ensamblar componentes.
   4. **`ComponentConsumer`**:
    - Es un servicio que consume mensajes de una cola de RabbitMQ relacionada con la producción de componentes.
    - Procesa los nombres de los componentes producidos.
    - Envía mensajes a la cola de RabbitMQ para ensamblar componentes.

1. **`RabbitMQConfig`**:
   - Es una clase de configuración que define las colas, intercambios y enlaces de RabbitMQ.
   - Configura las colas `COMPONENT_QUEUE` y `ASSEMBLY_QUEUE`.

### Archivo `pom.xml`

- Define las dependencias del proyecto, como `spring-boot-starter-data-jpa`, `spring-boot-starter-web`, `opencsv`, `mysql-connector-j`, entre otras.
- Configura el plugin de Maven para Spring Boot.

### Archivo `simulation.html`

- Es una página HTML que utiliza D3.js para visualizar la simulación de la caída de bolas.
- Actualiza el gráfico en intervalos regulares para mostrar la distribución de las bolas en los contenedores.

Este proyecto combina la importación y manipulación de datos CSV con una simulación visual interactiva, utilizando Spring Boot para la lógica del servidor y D3.js para la visualización en el cliente.

