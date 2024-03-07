/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyect.lms.controller;

import com.proyect.lms.model.CarreraModel;
import com.proyect.lms.model.EstudianteModel;
import com.proyect.lms.model.LibroModel;
import com.proyect.lms.model.PrestamoModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dany
 */
public class ReportesController {

    private static final String FECHA_DEVOLUCION = "DATE(DATE_ADD(p.fecha_prestamo, INTERVAL 3 DAY)) ";
    private Connection connection;
    private LibroModel libroModel;
    private EstudianteModel estudianteModel;
    private PrestamoModel prestamoModel;

    public ReportesController(Connection connection, LibroModel libroModel, EstudianteModel estudianteModel, PrestamoModel prestamoModel) {
        this.connection = connection;
        this.libroModel = libroModel;
        this.estudianteModel = estudianteModel;
        this.prestamoModel = prestamoModel;
    }

    public List<PrestamoModel> getPrestamosPorEstudiante(String carnet) {
        System.out.println("getPrestamosPorEstudiante carnet" + carnet);
        String query = "SELECT p.*,l.*,e.*,c.nombre 'carrera_nombre', " + FECHA_DEVOLUCION + " AS fecha_devolucion "
                + "FROM prestamos p "
                + "INNER JOIN libros l ON l.codigo = p.libro_codigo "
                + "INNER JOIN estudiantes e ON e.carnet = p.estudiante_carnet "
                + "INNER JOIN carreras c ON c.codigo = e.carrera "
                + "WHERE p.estudiante_carnet = ?;";

        List<PrestamoModel> prestamos = new ArrayList<>();

        try (
                PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setString(1, carnet);

            try (
                    ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {

                    String codigoLibro = resultSet.getString("codigo");
                    String autorLibro = resultSet.getString("autor");
                    String tituloLibro = resultSet.getString("titulo");
                    String editorialLibro = resultSet.getString("editorial");
                    int cantidadCopiasLibro = resultSet.getInt("cantidad_copias");
                    Date fechaPublicacionLibro = resultSet.getDate("fecha_publicacion");

                    this.libroModel = new LibroModel(codigoLibro, autorLibro, tituloLibro, editorialLibro, cantidadCopiasLibro, fechaPublicacionLibro);
                    String carnetEstudiante = resultSet.getString("carnet");
                    String nombreEstudiante = resultSet.getString("nombre");
                    int carreraEstudiante = resultSet.getInt("carrera");
                    Date fechaNacimientoEstudiante = resultSet.getDate("fecha_nacimiento");

                    String nombreCarrera = resultSet.getString("carrera_nombre");

                    this.estudianteModel = new EstudianteModel(
                            carnetEstudiante, nombreEstudiante,
                            carreraEstudiante, fechaNacimientoEstudiante,
                            new CarreraModel(carreraEstudiante, nombreCarrera));

                    String libroCodigo = resultSet.getString("libro_codigo");
                    String estudianteCarnet = resultSet.getString("estudiante_carnet");
                    Date fechaPrestamo = resultSet.getDate("fecha_prestamo");
                    PrestamoModel prestamo = new PrestamoModel(libroCodigo, estudianteCarnet, fechaPrestamo, libroModel, estudianteModel);
                    prestamo.setFechaDevolucion(resultSet.getDate("fecha_devolucion"));
                    prestamos.add(prestamo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prestamos;
    }

    public List<PrestamoModel> getPrestamosAHoy() {
        String query = "SELECT p.*,l.*,e.*,c.nombre 'carrera_nombre', " + FECHA_DEVOLUCION + " AS fecha_devolucion "
                + "FROM prestamos p "
                + "INNER JOIN libros l ON l.codigo = p.libro_codigo "
                + "INNER JOIN estudiantes e ON e.carnet = p.estudiante_carnet "
                + "INNER JOIN carreras c ON c.codigo = e.carrera "
                + "WHERE " + FECHA_DEVOLUCION + " = DATE(now());";
        System.out.println("getPrestamosAHoy " + query);
        List<PrestamoModel> prestamos = new ArrayList<>();

        try (
                PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery();) {
            while (resultSet.next()) {

                String codigoLibro = resultSet.getString("codigo");
                String autorLibro = resultSet.getString("autor");
                String tituloLibro = resultSet.getString("titulo");
                String editorialLibro = resultSet.getString("editorial");
                int cantidadCopiasLibro = resultSet.getInt("cantidad_copias");
                Date fechaPublicacionLibro = resultSet.getDate("fecha_publicacion");

                this.libroModel = new LibroModel(codigoLibro, autorLibro, tituloLibro, editorialLibro, cantidadCopiasLibro, fechaPublicacionLibro);
                String carnetEstudiante = resultSet.getString("carnet");
                String nombreEstudiante = resultSet.getString("nombre");
                int carreraEstudiante = resultSet.getInt("carrera");
                Date fechaNacimientoEstudiante = resultSet.getDate("fecha_nacimiento");

                String nombreCarrera = resultSet.getString("carrera_nombre");

                this.estudianteModel = new EstudianteModel(
                        carnetEstudiante, nombreEstudiante,
                        carreraEstudiante, fechaNacimientoEstudiante,
                        new CarreraModel(carreraEstudiante, nombreCarrera));

                String libroCodigo = resultSet.getString("libro_codigo");
                String estudianteCarnet = resultSet.getString("estudiante_carnet");
                Date fechaPrestamo = resultSet.getDate("fecha_prestamo");
                PrestamoModel prestamo = new PrestamoModel(libroCodigo, estudianteCarnet, fechaPrestamo, libroModel, estudianteModel);
                prestamo.setFechaDevolucion(resultSet.getDate("fecha_devolucion"));
                prestamos.add(prestamo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prestamos;
    }

    public List<PrestamoModel> getPrestamosEnMora() {
        String query = "SELECT p.*,l.*,e.*,c.nombre 'carrera_nombre', " + FECHA_DEVOLUCION + " AS fecha_devolucion, "
                + "DATEDIFF(CURRENT_DATE(), " + FECHA_DEVOLUCION + ") AS dias_mora "
                + "FROM prestamos p "
                + "INNER JOIN libros l ON l.codigo = p.libro_codigo "
                + "INNER JOIN estudiantes e ON e.carnet = p.estudiante_carnet "
                + "INNER JOIN carreras c ON c.codigo = e.carrera "
                + "WHERE CURRENT_DATE() > " + FECHA_DEVOLUCION + ";";
        System.out.println("getPrestamosEnMora " + query);
        List<PrestamoModel> prestamos = new ArrayList<>();
        try (
                PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery();) {
            while (resultSet.next()) {
                String codigoLibro = resultSet.getString("codigo");
                String autorLibro = resultSet.getString("autor");
                String tituloLibro = resultSet.getString("titulo");
                String editorialLibro = resultSet.getString("editorial");
                int cantidadCopiasLibro = resultSet.getInt("cantidad_copias");
                Date fechaPublicacionLibro = resultSet.getDate("fecha_publicacion");

                this.libroModel = new LibroModel(codigoLibro, autorLibro, tituloLibro, editorialLibro, cantidadCopiasLibro, fechaPublicacionLibro);
                String carnetEstudiante = resultSet.getString("carnet");
                String nombreEstudiante = resultSet.getString("nombre");
                int carreraEstudiante = resultSet.getInt("carrera");
                Date fechaNacimientoEstudiante = resultSet.getDate("fecha_nacimiento");

                String nombreCarrera = resultSet.getString("carrera_nombre");

                this.estudianteModel = new EstudianteModel(
                        carnetEstudiante, nombreEstudiante,
                        carreraEstudiante, fechaNacimientoEstudiante,
                        new CarreraModel(carreraEstudiante, nombreCarrera));

                String libroCodigo = resultSet.getString("libro_codigo");
                String estudianteCarnet = resultSet.getString("estudiante_carnet");
                Date fechaPrestamo = resultSet.getDate("fecha_prestamo");
                PrestamoModel prestamo = new PrestamoModel(libroCodigo, estudianteCarnet, fechaPrestamo, libroModel, estudianteModel);
                prestamo.setDiasMora(resultSet.getInt("dias_mora"));
                prestamo.setFechaDevolucion(resultSet.getDate("fecha_devolucion"));
                prestamos.add(prestamo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prestamos;
    }

    public void getTotalRecaudado(Date fechaInicio, Date fechaFin) {
        String query = "SELECT "
                + "SUM(IF(p.mora = 0, l.precio_prestamo, l.precio_mora)) AS total_recaudado, "
                + "SUM(IF(p.mora = 0, 1, 0)) AS prestamos_normales, "
                + "SUM(IF(p.mora = 1, 1, 0)) AS prestamos_mora "
                + "FROM prestamos p "
                + "INNER JOIN libros l ON l.codigo = p.libro_codigo "
                + "WHERE p.fecha_prestamo BETWEEN ? AND ?;";

        try (
                PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setDate(1, fechaInicio);
            statement.setDate(2, fechaFin);

            try (
                    ResultSet resultSet = statement.executeQuery();) {
                if (resultSet.next()) {
                    System.out.println("**Total recaudado:** $" + resultSet.getDouble("total_recaudado"));
                    System.out.println("**Préstamos normales:** " + resultSet.getInt("prestamos_normales"));
                    System.out.println("**Préstamos en mora:** " + resultSet.getInt("prestamos_mora"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PrestamoModel> obtenerPrestamosIntervaloTiempo(Date fechaInicio, Date fechaFin) throws SQLException {
        List<PrestamoModel> prestamos = new ArrayList<>();

        String query = "SELECT p.*,l.*,e.*,c.nombre 'carrera_nombre' "
                + "p.fecha_prestamo, p.fecha_devolucion, p.mora "
                + "FROM prestamos p "
                + "INNER JOIN libros l ON l.codigo = p.libro_codigo "
                + "WHERE p.fecha_prestamo BETWEEN ? AND ?";

        try (
                PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setDate(1, new java.sql.Date(fechaInicio.getTime()));
            statement.setDate(2, new java.sql.Date(fechaFin.getTime()));
            try (
                    ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    String codigoLibro = resultSet.getString("codigo");
                    String autorLibro = resultSet.getString("autor");
                    String tituloLibro = resultSet.getString("titulo");
                    String editorialLibro = resultSet.getString("editorial");
                    int cantidadCopiasLibro = resultSet.getInt("cantidad_copias");
                    Date fechaPublicacionLibro = resultSet.getDate("fecha_publicacion");

                    this.libroModel = new LibroModel(codigoLibro, autorLibro, tituloLibro, editorialLibro, cantidadCopiasLibro, fechaPublicacionLibro);
                    String carnetEstudiante = resultSet.getString("carnet");
                    String nombreEstudiante = resultSet.getString("nombre");
                    int carreraEstudiante = resultSet.getInt("carrera");
                    Date fechaNacimientoEstudiante = resultSet.getDate("fecha_nacimiento");

                    String nombreCarrera = resultSet.getString("carrera_nombre");

                    this.estudianteModel = new EstudianteModel(
                            carnetEstudiante, nombreEstudiante,
                            carreraEstudiante, fechaNacimientoEstudiante,
                            new CarreraModel(carreraEstudiante, nombreCarrera));

                    String libroCodigo = resultSet.getString("libro_codigo");
                    String estudianteCarnet = resultSet.getString("estudiante_carnet");
                    Date fechaPrestamo = resultSet.getDate("fecha_prestamo");
                    PrestamoModel prestamo = new PrestamoModel(libroCodigo, estudianteCarnet, fechaPrestamo, libroModel, estudianteModel);

                    prestamos.add(prestamo);
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener los préstamos del intervalo: " + e.getMessage());
        }

        return prestamos;
    }

    public List<PrestamoModel> obtenerReportePrestamosPorCarrera(Date fechaInicio, Date fechaFin) {
        String query = "SELECT p.*,l.*,e.*,c.nombre 'carrera_nombre', COUNT(*) AS cantidad_prestamos"
                + "FROM prestamos p "
                + "INNER JOIN libros l ON l.codigo = p.libro_codigo "
                + "INNER JOIN estudiantes e ON e.carnet = p.estudiante_carnet "
                + "INNER JOIN carreras c ON c.codigo = e.carrera "
                + "WHERE p.fecha_prestamo BETWEEN ? AND ? "
                + "GROUP BY e.carrera;";

        List<PrestamoModel> prestamos = new ArrayList<>();
        System.out.println("fechaInicio" + fechaInicio);
        System.out.println("fechaFin" + fechaFin);

        try (
                PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setDate(1, fechaInicio);
            statement.setDate(2, fechaFin);
            try (
                    ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {

                    String codigoLibro = resultSet.getString("codigo");
                    String autorLibro = resultSet.getString("autor");
                    String tituloLibro = resultSet.getString("titulo");
                    String editorialLibro = resultSet.getString("editorial");
                    int cantidadCopiasLibro = resultSet.getInt("cantidad_copias");
                    Date fechaPublicacionLibro = resultSet.getDate("fecha_publicacion");

                    this.libroModel = new LibroModel(codigoLibro, autorLibro, tituloLibro, editorialLibro, cantidadCopiasLibro, fechaPublicacionLibro);
                    String carnetEstudiante = resultSet.getString("carnet");
                    String nombreEstudiante = resultSet.getString("nombre");
                    int carreraEstudiante = resultSet.getInt("carrera");
                    Date fechaNacimientoEstudiante = resultSet.getDate("fecha_nacimiento");

                    String nombreCarrera = resultSet.getString("carrera_nombre");

                    this.estudianteModel = new EstudianteModel(
                            carnetEstudiante, nombreEstudiante,
                            carreraEstudiante, fechaNacimientoEstudiante,
                            new CarreraModel(carreraEstudiante, nombreCarrera));

                    String libroCodigo = resultSet.getString("libro_codigo");
                    String estudianteCarnet = resultSet.getString("estudiante_carnet");
                    Date fechaPrestamo = resultSet.getDate("fecha_prestamo");
                    PrestamoModel prestamo = new PrestamoModel(libroCodigo, estudianteCarnet, fechaPrestamo, libroModel, estudianteModel);

                    prestamos.add(prestamo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prestamos;
    }

}