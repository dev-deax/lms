package com.proyect.lms.database;

/**
 *
 * @author dany
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static ConexionDB instancia;
    private static final String URL = "jdbc:mysql://localhost:3306/lms";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "root";

    private ConexionDB() {
    }

    public static synchronized ConexionDB obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConexionDB();
        }
        return instancia;
    }

    public Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }
}
