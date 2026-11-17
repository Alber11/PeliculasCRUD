package com.gmail.albermargar9.peliculasav;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Objeto de Acceso a Datos (Data Access Object - DAO) para la entidad Película.
 * Centraliza todas las operaciones de consulta y manipulación de datos (CRUD)
 * contra la base de datos MySQL utilizando sentencias parametrizadas seguras.
 * 
 * @author alberto.martin
 */
public class PeliculaDAO {
    
    /**
     * Consulta todas las películas registradas en la base de datos y vuelca los 
     * resultados directamente en el modelo de la tabla proporcionada.
     * 
     * @param tablaPeliculas El componente {@link JTable} de la interfaz gráfica donde se mostrarán los datos.
     */
    public static void cargarTabla(JTable tablaPeliculas) {
        String[] titulosColumnas = {"ID", "Título", "Director", "Estreno", "Duración", "Clasificación"};
        
        // Creamos un modelo de tabla no editable directamente desde la celda
        DefaultTableModel modelo = new DefaultTableModel(null, titulosColumnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        String sql = "SELECT id_pelicula, titulo, director, fecha_estreno, duracion_minutos, clasificacion_edad FROM peliculas";

        try (Connection conexion = ConexionBD.obtenerConexion();
             Statement sentencia = conexion.createStatement();
             ResultSet resultado = sentencia.executeQuery(sql)) {

            if (conexion == null) {
                return;
            }

            while (resultado.next()) {
                Object[] fila = new Object[6];
                fila[0] = resultado.getInt("id_pelicula");
                fila[1] = resultado.getString("titulo");
                fila[2] = resultado.getString("director");
                fila[3] = resultado.getDate("fecha_estreno");
                fila[4] = resultado.getInt("duracion_minutos");
                fila[5] = resultado.getString("clasificacion_edad");

                modelo.addRow(fila);
            }

            tablaPeliculas.setModel(modelo);
            System.out.println("Tabla de películas cargada correctamente.");

        } catch (Exception e) {
            System.err.println("Error al consultar las películas: " + e.getMessage());
        }
    }
    
    /**
     * Inserta un nuevo registro de película en la base de datos.
     * 
     * @param titulo Título de la película.
     * @param director Nombre del director.
     * @param estreno Fecha de estreno en formato YYYY-MM-DD.
     * @param duracion Duración de la película en minutos (debe ser mayor que 0).
     * @param clasificacion Clasificación por edades (ej. TP, +7, +12, +16, +18).
     * @return {@code true} si la inserción fue exitosa; {@code false} en caso de error.
     */
    public static boolean insertarPelicula(String titulo, String director, String estreno, int duracion, String clasificacion) {
        String sql = "INSERT INTO peliculas (titulo, director, fecha_estreno, duracion_minutos, clasificacion_edad) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conexion = ConexionBD.obtenerConexion();
             java.sql.PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            
            if (conexion == null) return false;

            pstmt.setString(1, titulo);
            pstmt.setString(2, director);
            pstmt.setString(3, estreno); 
            pstmt.setInt(4, duracion);
            pstmt.setString(5, clasificacion);

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (Exception e) {
            System.err.println("Error al insertar la película: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Actualiza los datos de una película existente en la base de datos.
     * 
     * @param idPelicula Identificador único de la película a modificar.
     * @param titulo Nuevo título de la película.
     * @param director Nuevo director.
     * @param estreno Nueva fecha de estreno (YYYY-MM-DD).
     * @param duracion Nueva duración en minutos.
     * @param clasificacion Nueva clasificación por edades.
     * @return {@code true} si la actualización modificó algún registro; {@code false} en caso contrario o de error.
     */
    public static boolean actualizarPelicula(int idPelicula, String titulo, String director, String estreno, int duracion, String clasificacion) {
        String sql = "UPDATE peliculas SET titulo = ?, director = ?, fecha_estreno = ?, duracion_minutos = ?, clasificacion_edad = ? WHERE id_pelicula = ?";
        
        try (Connection conexion = ConexionBD.obtenerConexion();
             java.sql.PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            
            if (conexion == null) return false;

            pstmt.setString(1, titulo);
            pstmt.setString(2, director);
            pstmt.setString(3, estreno);
            pstmt.setInt(4, duracion);
            pstmt.setString(5, clasificacion);
            pstmt.setInt(6, idPelicula); 

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (Exception e) {
            System.err.println("Error al actualizar la película: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Elimina un registro de película de la base de datos basándose en su ID.
     * 
     * @param idPelicula Identificador único de la película que se desea borrar.
     * @return {@code true} si el borrado se realizó con éxito; {@code false} si hubo un error o no se encontró el registro.
     */
    public static boolean eliminarPelicula(int idPelicula) {
        String sql = "DELETE FROM peliculas WHERE id_pelicula = ?";
        
        try (Connection conexion = ConexionBD.obtenerConexion();
             java.sql.PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            
            if (conexion == null) return false;
            
            pstmt.setInt(1, idPelicula); 
            
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (Exception e) {
            System.err.println("Error al eliminar la película: " + e.getMessage());
            return false;
        }
    }
}