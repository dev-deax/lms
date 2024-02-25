package com.proyect.lms.database;

/**
 *
 * @author dany
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/lms";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "root";

    private Connection connection;

    private ConexionDB() {
    }
    
    public Connection obtenerConexion() throws SQLException {
        try {
            this.connection = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conexión creada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void desconectar() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
