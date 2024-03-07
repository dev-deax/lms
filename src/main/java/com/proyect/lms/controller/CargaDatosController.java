/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyect.lms.controller;

import com.proyect.lms.model.EstudianteModel;
import com.proyect.lms.model.LibroModel;
import com.proyect.lms.model.PrestamoModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JTextArea;

/**
 *
 * @author dany
 */
public class CargaDatosController {

    private static final String LIBRO = "LIBRO";
    private static final String ESTUDIANTE = "ESTUDIANTE";
    private static final String PRESTAMO = "PRESTAMO";

    private Connection connection;
    private LibroModel libroModel;
    private EstudianteModel estudianteModel;
    private PrestamoModel prestamoModel;

    public CargaDatosController(Connection connection, LibroModel libroModel, EstudianteModel estudianteModel, PrestamoModel prestamoModel) {
        this.connection = connection;
        this.libroModel = libroModel;
        this.estudianteModel = estudianteModel;
        this.prestamoModel = prestamoModel;
    }

    public void cargarArchivos(File archivo) throws FileNotFoundException, IOException {

        List<LibroModel> libros = new ArrayList<>();
        List<EstudianteModel> estudiantes = new ArrayList<>();
        List<PrestamoModel> prestamos = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;

        int lineasProcesadas = 0;
        int erroresEncontrados = 0;
        List<String> lineasIgnoradas = new ArrayList<>();

        while ((linea = br.readLine()) != null) {
            lineasProcesadas++;
            String tipoRegistro = linea.split(" ")[0];

            try {
                switch (tipoRegistro) {
                    case LIBRO:
                        this.libroModel = verificarEstructuraLibro(br, lineasProcesadas);
                        if (this.libroModel != null) {
                            guardarLibro(this.libroModel, lineasIgnoradas, erroresEncontrados);
                        } else {
                            System.out.println("Advertencia: Bloque de LIBRO mal formado en las líneas "
                                    + lineasProcesadas + " a " + (lineasProcesadas + 3));
                        }
                        this.libroModel = null;
                        break;
                    case ESTUDIANTE:
                        this.estudianteModel = verificarEstructuraEstudiante(br, lineasProcesadas);
                        if (this.estudianteModel != null) {
                            guardarEstudiante(this.estudianteModel, lineasIgnoradas, erroresEncontrados);
                        } else {
                            System.out.println("Advertencia: Bloque de LIBRO mal formado en las líneas "
                                    + lineasProcesadas + " a " + (lineasProcesadas + 3));
                        }
                        this.estudianteModel = null;
                        break;
                    case PRESTAMO:
                        this.prestamoModel = verificarEstructuraPrestamo(br, lineasProcesadas);
                        if (this.prestamoModel != null) {
                            guardarPrestamo(this.prestamoModel, lineasIgnoradas, erroresEncontrados);
                        } else {
                            System.out.println("Advertencia: Bloque de LIBRO mal formado en las líneas "
                                    + lineasProcesadas + " a " + (lineasProcesadas + 3));
                        }
                        this.prestamoModel = null;
                        break;

                    default:
                        lineasIgnoradas.add(linea);
                        erroresEncontrados++;
                    // txtMensajes.append("Error: Tipo de registro no válido: " + linea + "\n");
                }
            } catch (Exception ex) {
                lineasIgnoradas.add(linea);
                erroresEncontrados++;
                //txtMensajes.append("Error en la línea " + lineasProcesadas + ": " + ex.getMessage() + "\n");
            }
        }
    }

    private LibroModel verificarEstructuraLibro(BufferedReader bufferedReader, int lineNumber) throws IOException {
        String[] estructura = {"TITULO:", "AUTOR:", "CODIGO:", "CANTIDAD:"};
        LibroModel model = null;
        List<String> datos = new ArrayList<>();

        for (String etiqueta : estructura) {
            String line = bufferedReader.readLine();
            lineNumber++;
            if (line.startsWith(etiqueta)) {
                datos.add(line.split(":")[1].trim());
            }
        }
        if (datos.size() == estructura.length) {
            model = new LibroModel(datos.get(0), datos.get(1), datos.get(2), Integer.parseInt(datos.get(3)));
        }
        return model;
    }

    private EstudianteModel verificarEstructuraEstudiante(BufferedReader bufferedReader, int lineNumber) throws IOException {
        String[] estructura = {"CARNET:", "NOMBRE:", "CARRERA:"};
        EstudianteModel model = null;
        List<String> datos = new ArrayList<>();

        for (String etiqueta : estructura) {
            String line = bufferedReader.readLine();
            lineNumber++;
            if (line.startsWith(etiqueta)) {
                datos.add(line.split(":")[1].trim());
            }
        }
        if (datos.size() == estructura.length) {
            model = new EstudianteModel(datos.get(0), datos.get(1), Integer.parseInt(datos.get(2)));
        }
        return model;
    }

    private PrestamoModel verificarEstructuraPrestamo(BufferedReader bufferedReader, int lineNumber) throws IOException {
        String[] estructura = {"CODIGOLIBRO:", "CARNET:", "FECHA:"};
        PrestamoModel model = null;
        List<String> datos = new ArrayList<>();

        for (String etiqueta : estructura) {
            String line = bufferedReader.readLine();
            lineNumber++;
            if (line.startsWith(etiqueta)) {
                datos.add(line.split(":")[1].trim());
            }
        }
        if (datos.size() == estructura.length) {
            model = new PrestamoModel(datos.get(0), datos.get(1), Date.valueOf(datos.get(2)));
        }
        return model;
    }

    private void guardarLibro(LibroModel libro, List<String> lineasIgnoradas, int erroresEncontrados) {
        String query = "INSERT INTO libros (codigo, autor, titulo, cantidad_copias) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = this.connection.prepareStatement(query)) {

            statement.setString(1, libro.getCodigo());
            statement.setString(2, libro.getAutor());
            statement.setString(3, libro.getTitulo());
            statement.setInt(4, libro.getCantidadCopias());

            statement.executeUpdate();
            System.out.println("Libro guardado en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Libro: " + e.getMessage());
            lineasIgnoradas.add("Libro: " + e.getMessage());
            erroresEncontrados++;
        }
    }

    private void guardarEstudiante(EstudianteModel estudiante, List<String> lineasIgnoradas, int erroresEncontrados) {
        String query = "INSERT INTO estudiantes (carnet, nombre, carrera) VALUES (?, ?, ?)";

        try (PreparedStatement statement = this.connection.prepareStatement(query)) {

            statement.setString(1, estudiante.getCarnet());
            statement.setString(2, estudiante.getNombre());
            statement.setInt(3, estudiante.getCarrera());

            statement.executeUpdate();
            System.out.println("Estudiantes guardado en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Estudiantes: " + e.getMessage());
            lineasIgnoradas.add("Estudiantes: " + e.getMessage());
            erroresEncontrados++;
        }
    }

    public void guardarPrestamo(PrestamoModel prestamo, List<String> lineasIgnoradas, int erroresEncontrados) {
        String query = "INSERT INTO prestamos (libro_codigo, estudiante_carnet, fecha_prestamo) VALUES (?, ?, ?)";

        try (PreparedStatement statement = this.connection.prepareStatement(query)) {

            statement.setString(1, prestamo.getLibroCodigo());
            statement.setString(2, prestamo.getEstudianteCarnet());
            statement.setDate(3, prestamo.getFechaPrestamo());

            statement.executeUpdate();
            System.out.println("Prestamos guardado en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Prestamos: " + e.getMessage());
            lineasIgnoradas.add("Prestamos: " + e.getMessage());
            erroresEncontrados++;
        }
    }

}
