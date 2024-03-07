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
     private Date fechaDevolucion;
    private LibroModel libro;
    private EstudianteModel estudiante;
    private double mora;
    private int diasMora;

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

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    
    public double getMora() {
        return mora;
    }

    public void setMora(double mora) {
        this.mora = mora;
    }

    public int getDiasMora() {
        return diasMora;
    }

    public void setDiasMora(int diasMora) {
        this.diasMora = diasMora;
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