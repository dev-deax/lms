/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyect.lms.controller;

import com.proyect.lms.model.EstudianteModel;
import com.proyect.lms.model.LibroModel;
import com.proyect.lms.model.PrestamoModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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

    public void cargarArchivos(File archivo, JTextArea txtMensajes) throws FileNotFoundException, IOException {

        FileReader fileReader = new FileReader(archivo);
        Scanner scanner = new Scanner(fileReader);

        List<LibroModel> libros = new ArrayList<>();
        List<EstudianteModel> estudiantes = new ArrayList<>();
        List<PrestamoModel> prestamos = new ArrayList<>();

        int lineasProcesadas = 0;
        int erroresEncontrados = 0;
        List<String> lineasIgnoradas = new ArrayList<>();

        while (scanner.hasNextLine()) {
            lineasProcesadas++;
            String linea = scanner.nextLine();
            String tipoRegistro = linea.split(" ")[0];
            
        }
    }

   // Métodos para leer cada tipo de registro
    private static LibroModel leerLibro(String linea) {
        String[] partes = linea.split(" ");
        if (partes.length != 5) {
            return null;
        }
        try {
            return new LibroModel(partes[1], partes[2], partes[3], Integer.parseInt(partes[4]));
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    private static EstudianteModel leerEstudiante(String linea) {
        String[] partes = linea.split(" ");
        if (partes.length != 4) {
            return null;
        }
        try {
            return new EstudianteModel(partes[1], partes[2], Integer.parseInt(partes[3]));
        } catch (NumberFormatException ex) {
            return null;
        }
    }

   


}
