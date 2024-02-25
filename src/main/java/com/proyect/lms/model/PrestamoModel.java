package com.proyect.lms.model;

/**
 *
 * @author dany
 */
import java.util.Date;

public class PrestamoModel {
    private String libroCodigo;
    private int estudianteCarnet;
    private Date fechaPrestamo;

    public PrestamoModel() {
    }

    public PrestamoModel(String libroCodigo, int estudianteCarnet, Date fechaPrestamo) {
        this.libroCodigo = libroCodigo;
        this.estudianteCarnet = estudianteCarnet;
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getLibroCodigo() {
        return libroCodigo;
    }

    public void setLibroCodigo(String libroCodigo) {
        this.libroCodigo = libroCodigo;
    }

    public int getEstudianteCarnet() {
        return estudianteCarnet;
    }

    public void setEstudianteCarnet(int estudianteCarnet) {
        this.estudianteCarnet = estudianteCarnet;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

}