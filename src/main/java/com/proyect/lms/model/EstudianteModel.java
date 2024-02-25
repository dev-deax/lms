package com.proyect.lms.model;

/**
 *
 * @author dany
 */
import java.util.Date;

public class EstudianteModel {
    private int carnet;
    private String nombre;
    private int carrera;
    private Date fechaNacimiento;

    public EstudianteModel() {
    }

    public EstudianteModel(int carnet, String nombre, int carrera, Date fechaNacimiento) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.carrera = carrera;
        this.fechaNacimiento = fechaNacimiento;
    }
  
    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCarrera() {
        return carrera;
    }

    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
 
}
