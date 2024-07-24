# Proyecto Final: Registro de Mascotas para Adopción

## Información del Proyecto
Este proyecto tiene como objetivo crear un registro de mascotas para adopción utilizando Spring Boot. La aplicación expone una API Rest que permite a las protectoras de animales construir aplicaciones que se conecten con el servicio para mostrar y gestionar las mascotas disponibles para adopción.

## Objetivo de la Práctica
El objetivo principal es crear una aplicación que permita gestionar un registro de mascotas, proporcionando varias funcionalidades a través de una API Rest. Adicionalmente, se puede implementar un módulo opcional que añade la funcionalidad de gestionar propietarios de mascotas.

## Funcionalidades Obligatorias
1. **Mostrar Mascota por ID**: Permite obtener la información de una mascota específica mediante su ID.
2. **Mostrar Mascota por Nombre**: Permite buscar y mostrar una mascota por su nombre.
3. **Subir una Mascota**: Permite agregar una nueva mascota al registro.
4. **Listar todas las Mascotas**: Muestra todas las mascotas registradas.
5. **Listar las 20 Mascotas más Jóvenes**: Muestra una lista con las 20 mascotas más jóvenes registradas.
6. **Mostrar todas las Mascotas en Páginas de a 5**: Permite paginar los resultados de la lista de mascotas, mostrando 5 mascotas por página.
7. **Borrar una Mascota**: Permite eliminar una mascota del registro.
8. **Incorporar Swagger**: Documenta la API utilizando Swagger para facilitar el consumo de la API por parte de desarrolladores externos.

## Funcionalidades Opcionales
1. **Agregar Propietario**: Un propietario puede tener más de una mascota, estableciendo una relación OneToMany entre las entidades Propietario y Mascota.
2. **Listar Mascotas por Propietario**: Permite listar las mascotas que han sido adoptadas por un propietario específico.

## Estructura del Proyecto
- **Mascota**: Una entidad que representa a las mascotas disponibles para adopción.
  - `id`: Long
  - `nombre`: String
  - `fechaNac`: Date
  - `raza`: String
  - `peso`: int
  - `tiene_chip`: boolean
  - `url_foto`: String

- **Propietario**: Una entidad que representa a los propietarios de las mascotas.
  - `id`: Long
  - `name`: String

## Mecanica del Proyecto
1. **Carga y Organización de Datos**: Inicialmente se cargan los datos de las mascotas y propietarios desde archivos SQL (`schema.sql` y `data.sql`).
2. **Configuración del Proyecto**: 
   - Configurar las dependencias de Spring Boot, incluyendo Swagger para la documentación de la API.
   - Crear las entidades `Mascota` y `Propietario` con sus respectivas relaciones.
3. **Desarrollo de la API Rest**:
   - Crear los controladores (`PetControllerApi` y `OwnerControllerApi`) para manejar las solicitudes HTTP.
   - Implementar los métodos de los controladores para proporcionar las funcionalidades requeridas.
4. **Desarrollo de las Vistas**:
   - Utilizar Thymeleaf para crear las vistas que permiten interactuar con la aplicación a través del navegador.
   - Crear formularios para agregar y listar mascotas y propietarios.

## Pruebas en Postman
Se han realizado pruebas exhaustivas utilizando Postman para asegurar el correcto funcionamiento de la API. El archivo `api-adoption.postman_collection.json` incluido en el proyecto contiene las siguientes pruebas:

### Pet:
- Encontrar la mascota más joven.
- Ver mascota por ID.
- Ver mascota por nombre.
- Agregar una nueva mascota.
- Ver todas las mascotas.
- Borrar una mascota.
- Ver mascotas en un rango (paginación).
- Actualizar una mascota.

### Owner:
- Ver todos los propietarios.
- Ver propietario por ID.
- Agregar un nuevo propietario.
- Actualizar un propietario.
- Borrar un propietario.
- Ver mascotas de un propietario.

## Pasos para Ejecutar el Proyecto
1. **Configurar la Base de Datos**: Asegurarse de que la configuración de la base de datos H2 esté correcta en el archivo `application.properties`.
2. **Inicializar Datos**: Verificar que los archivos `schema.sql` y `data.sql` estén correctamente configurados para crear las tablas y cargar los datos iniciales.
3. **Ejecutar la Aplicación**: Iniciar la aplicación Spring Boot.
4. **Probar la API**: Utilizar Postman o cualquier otra herramienta de prueba de APIs para verificar que todas las funcionalidades estén funcionando correctamente.
5. **Acceder a Swagger**: Acceder a la documentación de Swagger para ver y probar los endpoints disponibles.