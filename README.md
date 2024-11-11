<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a id="readme-top"></a>

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/xSanPrax/Practico2Nosql">
    <img src="logo.png" alt="NoSQL S.A" width="80" height="80">
  </a>

<h3 align="center">API de Gestión de Pacientes</h3>

  <p align="center">
    API REST desarrollada con Flask para gestionar pacientes y sus registros médicos.
    <br />
    <a href="https://github.com/xSanPrax/Practico2Nosql"><strong>Explora la documentación »</strong></a>
    <br />
    <br />
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Contenido</summary>
  <ol>
    <li>
      <a href="#about-the-project">Acerca del Proyecto</a>
      <ul>
        <li><a href="#built-with">Tecnologías utilizadas</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Cómo empezar</a>
      <ul>
        <li><a href="#prerequisites">Requisitos previos</a></li>
        <li><a href="#installation">Instalación</a></li>
      </ul>
    </li>
    <li><a href="#usage">Uso</a></li>
    <li><a href="#contributing">Contribuciones</a></li>
    <li><a href="#license">Licencia</a></li>
    <li><a href="#contact">Contacto</a></li>
    <li><a href="#acknowledgments">Agradecimientos</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## Acerca del Proyecto

Este proyecto es una API REST desarrollada con Flask que permite gestionar pacientes y sus registros médicos. La aplicación se conecta a una base de datos MongoDB y está dockerizada para facilitar la instalación y despliegue.

<p align="right">(<a href="#readme-top">Volver arriba</a>)</p>

### Tecnologías utilizadas

Este proyecto está construido con las siguientes tecnologías:

* Python 3.13.0 - Lenguaje de programación principal.
* Flask 3.0.3 - Framework web ligero para Python.
* MongoDB (Compass) - Base de datos NoSQL utilizada para almacenar los datos de los pacientes y registros médicos.
* Docker - Para la creación de contenedores y facilitar el despliegue del proyecto.
* Locust 2.32.0 Para las pruebas automaticas de los endpoint.

### Justificacion de la eleccion de la base de datos

  Se eligió MongoDB como base de datos por su flexibilidad en el almacenamiento de documentos JSON, lo que permite una estructura de datos no relacional, 
  ideal para el manejo de registros médicos que pueden variar en formato y contenido.

<p align="right">(<a href="#readme-top">Volver arriba</a>)</p>

## Cómo empezar

Para obtener una copia local de este proyecto y comenzar a trabajar con ella, sigue estos pasos sencillos.

### Requisitos previos

Asegúrate de tener instalados los siguientes programas:

* Docker (si deseas usar Docker) - [Docker](https://www.docker.com/)
* Python (si prefieres ejecutar el proyecto sin Docker) - [Python](https://www.python.org/downloads/)

### Instalación

#### Opción 1: Instalación con Docker

1. Clona el repositorio:
   ```
   git clone https://github.com/xSanPrax/Practico2Nosql.git
   ```

2. Navega al directorio del proyecto:
   ```
   cd Practico2Nosql
   ```

3. Asegúrate de que Docker esté en funcionamiento y ejecuta el siguiente comando para construir y ejecutar los contenedores:
   ```
   docker-compose up --build
   ```

4. La aplicación debería estar corriendo en [http://localhost:5000](http://localhost:5000).

#### Opción 2: Instalación sin Docker

Si prefieres ejecutar el proyecto sin Docker, sigue estos pasos:

1. Clona el repositorio:
   ```
   git clone https://github.com/xSanPrax/Practico2Nosql.git
   ```

2. Navega al directorio del proyecto:
   ```
   cd Practico2Nosql
   ```

3. Instala las dependencias necesarias:
   ```
   pip install -r requirements.txt
   ```

4. Crea un archivo `.env` en el directorio raíz del proyecto con las siguientes variables de entorno:

   ```
   FLASK_APP=app.py
   FLASK_ENV=development
   MONGO_URI=mongodb://localhost:27017/program
   ```

5. Ejecuta la aplicación:
   ```
   python init.py
   ```

6. La aplicación debería estar corriendo en [http://localhost:5000](http://localhost:5000).

<p align="right">(<a href="#readme-top">Volver arriba</a>)</p>

## Uso

Esta API proporciona varios endpoints para gestionar pacientes y registros médicos. A continuación se describen los principales endpoints y cómo utilizarlos.

### Locust

1. Instalarlo en el directorio del proyecto aunque deberia estar en el requirements.txt, con el comando:
  ```
   pip install locust
  ```
2. Ejecutar el comando
  ```
   locust
  ```

3. Entrar en el navegador a la URL
  ```
   http://localhost:8089
  ```
4. Iniciar las pruebas.

### Endpoints disponibles

1. **Crear un nuevo paciente**

   ** Método: POST  
   ** URL: `/paciente`  
   ** Cuerpo de la solicitud:
   ```
   {
        "_id": ObjectID"671fc468410e3d9df463db2c",
        "CI": "3159866",
        "Nombre": "PacienteNombre",
        "Apellido": "PacienteApellido",
        "Fecha de nacimiento": "1990-01-01",
        "Sexo": "M"
   }
   ```
   
    ** Respuesta exitosa:
    ```
    {
      "mensaje": "Paciente creado con éxito",
    }
    ```

2. **Recuperar información de un paciente por ID**

** Método: GET
** URL: /paciente/<id>
** Respuesta exitosa:
```
{
    "_id": ObjectID"671fc468410e3d9df463db2c",
    "CI": "3159866",
    "Nombre": "PacienteNombre",
    "Apellido": "PacienteApellido",
    "Fecha de nacimiento": "1990-01-01",
    "Sexo": "M"
}
```

3. **Agregar un registro médico a un paciente**

** Método: POST
** URL: /registro
** Cuerpo de la solicitud:
```
{
    "_id":ObjectID"671fc492410e3d9df463db2e",
    "CI": "3159866",
    "Fecha": "2024-10-28",
    "Tipo": "Consulta",
    "Diagnóstico": "Diagnóstico de prueba",
    "Médico": "Dr. Ejemplo",
    "Institución": "Instituto de Pruebas",
    "Descripción": "Descripción de prueba",
    "Medicación": "Medicación de prueba"
}
```

** Respuesta exitosa:
```
{
  "mensaje": "Registro médico agregado exitosamente"
}
```

4. **Buscar un registro médico por criterio**

** Método: GET
** URL: /registros?criterio={criterio}&valor={valor}

** Respuesta exitosa:
```
   { 
    "_id":ObjectID"671fc492410e3d9df463db2e",
    "CI": "3159866",
    "Fecha": "2024-10-28",
    "Tipo": "Consulta",
    "Diagnóstico": "Diagnóstico de prueba",
    "Médico": "Dr. Ejemplo",
    "Institución": "Instituto de Pruebas",
    "Descripción": "Descripción de prueba",
    "Medicación": "Medicación de prueba"
   }
   ```

<p align="right">(<a href="#readme-top">Volver arriba</a>)</p> 
