package com.proyect.lms.controller;

import com.proyect.lms.model.CarreraModel;
import com.proyect.lms.model.LibroModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class LibroController {
    
    
    public Connection connection;
    public LibroModel libroModel;

    public LibroController(Connection connection, LibroModel carreraModel) {
        this.connection = connection;
        this.libroModel = carreraModel;
    }

        public List<LibroModel> obtenerLibros() {
        System.out.println("obtenerLibros");
        List<LibroModel> libros = new ArrayList<>();
        try (PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM libros"); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String codigo = resultSet.getString("codigo");
                String autor = resultSet.getString("autor");
                String titulo = resultSet.getString("titulo");
                String editorial = resultSet.getString("editorial");
                int cantidadCopias = resultSet.getInt("cantidad_copias");
                Date fechaPublicacion = resultSet.getDate("fecha_publicacion");
                
                LibroModel libro = new LibroModel(codigo, autor, titulo, editorial, cantidadCopias, fechaPublicacion);  
                libros.add(libro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }
    
            public String agregarLibro(String codigo, String autor,String TituloField, String editorial,int cantidad_copias, String fechaPublicacion) {
        this.libroModel.setCodigo(codigo);
        this.libroModel.setAutor(autor);
        this.libroModel.setTitulo(TituloField);
        this.libroModel.setEditorial(editorial);
        this.libroModel.setCantidadCopias(cantidad_copias);
        this.libroModel.setFechaPublicacion(Date.valueOf(fechaPublicacion));

        try (PreparedStatement statement = this.connection.prepareStatement("INSERT INTO libros(titulo, autor, cantidad_copias, fecha_publicacion, editorial, codigo) VALUES (?,?,?,?,?,?)")) {
            statement.setString(1, this.libroModel.getTitulo());
            statement.setString(2, this.libroModel.getAutor());
            statement.setInt(3, this.libroModel.getCantidadCopias());
            statement.setDate(4, this.libroModel.getFechaPublicacion()); 
            statement.setString(5, this.libroModel.getEditorial());
            statement.setString(6, this.libroModel.getCodigo());
            statement.executeUpdate();
            return "Libro creado correctamente";
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
    
     public String actualizarLibro(String codigoField, String nombreField) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE libros SET titulo = ?, autor = ?, "
                + "                                                     cantidad_copias = ?, fecha_publicacion = ?, editorial = ?  WHERE codigo = ?")) {
            int codigo = Integer.parseInt(codigoField);
            this.libroModel.setCodigo(codigoField);
            this.libroModel.setTitulo(nombreField);
            statement.setString(1, this.libroModel.getTitulo());
            statement.setString(2, this.libroModel.getAutor());
            statement.setInt(3, this.libroModel.getCantidadCopias());
            statement.setDate(4, this.libroModel.getFechaPublicacion()); 
            statement.setString(5, this.libroModel.getEditorial());
            statement.setString(6, this.libroModel.getCodigo());
            statement.executeUpdate();
            return "Libro actualizado correctamente";
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (NumberFormatException e) {
            return e.getMessage();
        }
    }
     
         public String eliminarLibro(String codigo) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM libros WHERE codigo = ?")) {
            this.libroModel.setCodigo(codigo);
            statement.setString(1, this.libroModel.getCodigo());
            statement.executeUpdate();
            return "Libro eliminada correctamente";
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (NumberFormatException e) {
            return e.getMessage();
        }
    }
}
