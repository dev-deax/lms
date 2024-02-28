package com.proyect.lms.controller;

/**
 *
 * @author dany
 */
import com.proyect.lms.database.ConexionDB;
import com.proyect.lms.model.CarreraModel;
import com.proyect.lms.view.CarreraView;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarreraController {

    public Connection connection;
    public CarreraModel carreraModel;

    public CarreraController(Connection connection, CarreraModel carreraModel) {
        this.connection = connection;
        this.carreraModel = carreraModel;
    }

    public List<CarreraModel> obtenerTodasCarreras() {
        System.out.println("obtenerTodasCarreras");
        List<CarreraModel> carreras = new ArrayList<>();
        try (PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM carreras"); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                carreras.add(new CarreraModel(resultSet.getInt("codigo"), resultSet.getString("nombre")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carreras;
    }

    public String agregarCarrera(String nombreField) {
        this.carreraModel.setNombre(nombreField);
        try (PreparedStatement statement = this.connection.prepareStatement("INSERT INTO carreras (nombre) VALUES (?)")) {
            statement.setString(1, this.carreraModel.getNombre());
            statement.executeUpdate();
            return "Carrera creada correctamente";
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String actualizarCarrera(String codigoField, String nombreField) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE carreras SET nombre = ? WHERE codigo = ?")) {
            int codigo = Integer.parseInt(codigoField);
            this.carreraModel.setCodigo(codigo);
            this.carreraModel.setNombre(nombreField);
            statement.setString(1, this.carreraModel.getNombre());
            statement.setInt(2, this.carreraModel.getCodigo());
            statement.executeUpdate();
            return "Carrera actualizada correctamente";
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (NumberFormatException e) {
            return e.getMessage();
        }
    }

    public String eliminarCarrera(String codigoField) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM carreras WHERE codigo = ?")) {
            int codigo = Integer.parseInt(codigoField);
            this.carreraModel.setCodigo(codigo);
            statement.setInt(1, this.carreraModel.getCodigo());
            statement.executeUpdate();
            return "Carrera eliminada correctamente";
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (NumberFormatException e) {
            return e.getMessage();
        }
    }

}
