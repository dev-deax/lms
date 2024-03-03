 package com.proyect.lms.model;

import java.sql.Date;


/**
 *
 * @author dany
 */
public class LibroModel {
    private String codigo;
    private String autor;
    private String titulo;
    private String editorial;
    private int cantidadCopias;
    private Date fechaPublicacion;

    public LibroModel() {
    }

    public LibroModel(String codigo, String autor, String titulo, String editorial, int cantidadCopias, Date fechaPublicacion) {
        this.codigo = codigo;
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
        this.cantidadCopias = cantidadCopias;
        this.fechaPublicacion = fechaPublicacion;
    }

    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getCantidadCopias() {
        return cantidadCopias;
    }

    public void setCantidadCopias(int cantidadCopias) {
        this.cantidadCopias = cantidadCopias;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
 
}