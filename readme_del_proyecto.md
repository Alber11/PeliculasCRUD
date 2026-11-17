# Gestión de Películas (CRUD)

Aplicación de escritorio desarrollada en Java Swing para la gestión de un catálogo de películas. Este proyecto permite realizar operaciones completas CRUD (Crear, Leer, Actualizar, Eliminar) conectándose a una base de datos MySQL.

## Tecnologías utilizadas

* **Lenguaje:** Java (JDK 8 o superior)

* **Interfaz Gráfica:** Java Swing

* **Gestor de Dependencias:** Maven

* **Base de Datos:** MySQL

* **Driver:** MySQL Connector/J (gestionado vía Maven)

## Configuración del Entorno y Base de Datos

Para que la aplicación funcione correctamente, es necesario preparar la base de datos siguiendo estos pasos:

### 1. Creación de la base de datos (DDL)

Abre tu cliente de MySQL  y ejecuta el script `ddl.sql` incluido en la carpeta `scripts_sql`. Este script se encarga de crear automáticamente la base de datos `gestion_peliculas` y la estructura de la tabla `peliculas` con sus respectivas restricciones.

### 2. Carga de datos de prueba (DML)

A continuación, ejecuta el script `dml.sql` en el mismo cliente. Esto insertará 10 registros iniciales necesarios para probar las operaciones de la aplicación.

### 3. Configuración de Credenciales

Antes de ejecutar la aplicación, debes configurar tus credenciales locales de MySQL.
Abre el archivo de configuración ubicado en:
`src/main/resources/bdprop.properties`

Y modifica los valores con tu usuario y contraseña local:

```
db.host = localhost
db.puerto = 3306
db.user = TU_USUARIO
db.password = TU_CONTRASEÑA
```

## Ejecución

Al ser un proyecto gestionado con **Maven**, no es necesario instalar el driver JDBC manualmente, Maven descargará automáticamente las dependencias declaradas en el `pom.xml`.

Para iniciar la aplicación, ejecuta la clase principal:
`com.gmail.albermargar9.peliculasav.PeliculasAV`