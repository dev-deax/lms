package com.proyect.lms.model;

/**
 *
 * @author dany
 */
import java.util.Date;

public class EstudianteModel {
    private String carnet;
    private String nombre;
    private int carrera;
    private Date fechaNacimiento;
    
    private CarreraModel carreraModel;

    public EstudianteModel() {
    }

    public EstudianteModel(String carnet, String nombre, int carrera) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.carrera = carrera;
    }

    public EstudianteModel(String carnet, String nombre, int carrera, Date fechaNacimiento) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.carrera = carrera;
        this.fechaNacimiento = fechaNacimiento;
    }

    public EstudianteModel(String carnet, String nombre, int carrera, Date fechaNacimiento, CarreraModel carreraModel) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.carrera = carrera;
        this.fechaNacimiento = fechaNacimiento;
        this.carreraModel = carreraModel;
    }

    public CarreraModel getCarreraModel() {
        return carreraModel;
    }

    public void setCarreraModel(CarreraModel carreraModel) {
        this.carreraModel = carreraModel;
    }
    
    
  
    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
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
