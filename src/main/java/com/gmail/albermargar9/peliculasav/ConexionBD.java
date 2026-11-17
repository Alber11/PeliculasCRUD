package com.gmail.albermargar9.peliculasav;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Clase de utilidad encargada de gestionar la conexión con la base de datos MySQL.
 * Extrae las credenciales y parámetros de configuración desde un archivo de propiedades
 * externo para garantizar la seguridad y portabilidad del proyecto.
 * 
 * @author alberto.martin
 */
public class ConexionBD {

    /**
     * Establece y devuelve una conexión activa a la base de datos gestion_peliculas.
     * Lee los datos de conexión (host, puerto, usuario y contraseña) desde el archivo
     * {@code bdprop.properties} ubicado en el classpath (resources).
     * 
     * @return Un objeto {@link Connection} si la conexión es exitosa; {@code null} en caso de error o si no encuentra el archivo.
     */
    public static Connection obtenerConexion() {
        Properties propiedades = new Properties();
        Connection conexion = null;

        // Leemos el archivo desde la carpeta resources (classpath)
        try (InputStream input = ConexionBD.class.getClassLoader().getResourceAsStream("bdprop.properties")) {
            
            if (input == null) {
                System.err.println("Error: No se encontró el archivo bdprop.properties en src/main/resources");
                return null;
            }

            // Cargamos los pares clave-valor del archivo
            propiedades.load(input);

            // Recuperamos los valores usando las claves exactas definidas en el .properties
            String host = propiedades.getProperty("db.host");
            String puerto = propiedades.getProperty("db.puerto");
            String usuario = propiedades.getProperty("db.user");
            String contrasena = propiedades.getProperty("db.password");
            String conexionURL = "jdbc:mysql://" + host + ":" + puerto + "/gestion_peliculas";

            // Establecemos la conexión con MySQL
            conexion = DriverManager.getConnection(conexionURL, usuario, contrasena);
            System.out.println("Conexión a la base de datos establecida con éxito.");

        } catch (Exception e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }

        return conexion;
    }
}