package com.gmail.albermargar9.peliculasav;

/**
 * Clase principal (Main) de la aplicación Gestión de Películas.
 * Contiene el punto de entrada que inicializa y lanza la interfaz gráfica de usuario.
 * 
 * @author alberto.martin
 */
public class PeliculasAV {

    /**
     * Método principal que arranca la aplicación. 
     * Utiliza el Event Dispatch Thread (EDT) de Swing para garantizar 
     * la seguridad y fluidez al dibujar la interfaz gráfica.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Instanciamos y mostramos la ventana visual
                VentanaPrincipal ventana = new VentanaPrincipal();
                ventana.setLocationRelativeTo(null); // Centrar en pantalla
                ventana.setVisible(true);
            }
        });
    }
}