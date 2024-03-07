package com.proyect.lms.model;

import java.sql.Date;

/**
 *
 * @author dany
 */
 

public class PrestamoModel {
    private String libroCodigo;
    private String estudianteCarnet;
    private Date fechaPrestamo;
    private LibroModel libro;
    private EstudianteModel estudiante;

    public PrestamoModel() {
    }

    public PrestamoModel(String libroCodigo, String estudianteCarnet, Date fechaPrestamo) {
        this.libroCodigo = libroCodigo;
        this.estudianteCarnet = estudianteCarnet;
        this.fechaPrestamo = fechaPrestamo;
    }

    public PrestamoModel(String libroCodigo, String estudianteCarnet, Date fechaPrestamo, LibroModel libro, EstudianteModel estudiante) {
        this.libroCodigo = libroCodigo;
        this.estudianteCarnet = estudianteCarnet;
        this.fechaPrestamo = fechaPrestamo;
        this.libro = libro;
        this.estudiante = estudiante;
    }

    public LibroModel getLibro() {
        return libro;
    }

    public void setLibro(LibroModel libro) {
        this.libro = libro;
    }

    public EstudianteModel getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteModel estudiante) {
        this.estudiante = estudiante;
    }
    
    public String getLibroCodigo() {
        return libroCodigo;
    }

    public void setLibroCodigo(String libroCodigo) {
        this.libroCodigo = libroCodigo;
    }

    public String getEstudianteCarnet() {
        return estudianteCarnet;
    }

    public void setEstudianteCarnet(String estudianteCarnet) {
        this.estudianteCarnet = estudianteCarnet;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

}