
package com.proyect.lms.controller;

/**
 *
 * @author dany
 */

import com.proyect.lms.model.CarreraModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarreraController {
    private Connection connection;

    public CarreraController(Connection connection) {
        this.connection = connection;
    }

    public List<CarreraModel> obtenerTodasCarreras() {
        List<CarreraModel> carreras = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM carreras");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                CarreraModel carrera = new CarreraModel(resultSet.getInt("codigo"), resultSet.getString("nombre"));
                carreras.add(carrera);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carreras;
    }

    public void agregarCarrera(CarreraModel carrera) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO carreras (codigo, nombre) VALUES (?, ?)")) {
            statement.setInt(1, carrera.getCodigo());
            statement.setString(2, carrera.getNombre());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarCarrera(CarreraModel carrera) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE carreras SET nombre = ? WHERE codigo = ?")) {
            statement.setString(1, carrera.getNombre());
            statement.setInt(2, carrera.getCodigo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCarrera(int codigo) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM carreras WHERE codigo = ?")) {
            statement.setInt(1, codigo);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
