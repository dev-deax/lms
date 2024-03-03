/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.proyect.lms.view;

import com.proyect.lms.controller.CarreraController;
import com.proyect.lms.controller.LibroController;
import com.proyect.lms.model.CarreraModel;
import com.proyect.lms.model.LibroModel;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dany
 */
public class LibroView extends javax.swing.JPanel {

    /**
     * Creates new form LibroView
     */
    private LibroController controller;
    private DefaultTableModel modeloTabla;

    public void setController(LibroController controller) {
        this.controller = controller;
    }
    
    public LibroView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        clearBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        codigoLibro = new javax.swing.JTextField();
        editarCarreraBtn = new javax.swing.JButton();
        eliminarCarreraBtn = new javax.swing.JButton();
        crearCarreraBtn = new javax.swing.JButton();
        nombreTitulo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CantidadLibros = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        NombreAutor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        FechaPublicacion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Editorial = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(613, 300));

        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jPanel1formComponentHidden(evt);
            }
        });

        jLabel1.setText("Libto View");

        jLabel2.setText("Titulo");

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        clearBtn.setText("Limpiar campos");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Codigo libro");

        editarCarreraBtn.setText("Editar");
        editarCarreraBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarCarreraBtnActionPerformed(evt);
            }
        });

        eliminarCarreraBtn.setText("Eliminar");
        eliminarCarreraBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarCarreraBtnActionPerformed(evt);
            }
        });

        crearCarreraBtn.setText("Crear");
        crearCarreraBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearCarreraBtnActionPerformed(evt);
            }
        });

        nombreTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTituloActionPerformed(evt);
            }
        });

        jLabel5.setText("Autor");

        jLabel6.setText("Cantidad de libros");

        jLabel7.setText("Fecha de publicacion");

        jLabel8.setText("Editorial");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Editorial)
                    .addComponent(FechaPublicacion)
                    .addComponent(codigoLibro)
                    .addComponent(crearCarreraBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombreTitulo)
                    .addComponent(CantidadLibros, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NombreAutor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(editarCarreraBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                                .addComponent(eliminarCarreraBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(clearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codigoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nombreTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NombreAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CantidadLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(12, 12, 12)
                        .addComponent(FechaPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Editorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(crearCarreraBtn)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editarCarreraBtn)
                            .addComponent(eliminarCarreraBtn))
                        .addGap(18, 18, 18)
                        .addComponent(clearBtn)
                        .addGap(0, 57, Short.MAX_VALUE)))
                .addGap(76, 76, 76))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked
      public void mostrarDatosEnCampos() {
        int filaSeleccionada = this.jTable1.getSelectedRow();
        try {
            if (filaSeleccionada != -1) {
                int codigo = (int) this.jTable1.getValueAt(filaSeleccionada, 0);
                String nombre = (String) this.jTable1.getValueAt(filaSeleccionada, 1);
                this.codigoLibro.setText(nombre);
                this.codigoLibro.setText(codigo + "");
            }
        } catch (Exception e) {
            resetFields();
        }

    }

    private void resetFields() {
        this.codigoLibro.setText("");
        this.codigoLibro.setText("");
       this.crearCarreraBtn.setEnabled(true);
        this.editarCarreraBtn.setEnabled(false);
        this.eliminarCarreraBtn.setEnabled(false);
        this.clearBtn.setEnabled(false);
    }

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        if (evt.getClickCount() == 1) {
            mostrarDatosEnCampos();
            this.crearCarreraBtn.setEnabled(false);
            this.editarCarreraBtn.setEnabled(true);
            this.eliminarCarreraBtn.setEnabled(true);
            this.clearBtn.setEnabled(true);
        }
    }//GEN-LAST:event_jTable1MousePressed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        resetFields();
    }//GEN-LAST:event_clearBtnActionPerformed

    //---------------------------------------------------
    
        public void initView() {
        initComponents();
        this.modeloTabla = new DefaultTableModel(new Object[0][2], new String[]{"ID", "Nombre"});
        this.jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        this.jTable1.getTableHeader().setReorderingAllowed(false);
        loadDataJTable();
        resetFields();
    }

    private void loadDataJTable() {
        List<LibroModel> libros = this.controller.obtenerLibros();
        this.modeloTabla.setRowCount(0);
        for (LibroModel libro : libros) {
            this.modeloTabla.addRow(new Object[]{libro.getCodigo(), libro.getTitulo()});
        }
        this.jTable1.setModel(this.modeloTabla);
    }
    
    //---------------------------------------------------
    private void editarCarreraBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarCarreraBtnActionPerformed
        String mensaje = this.controller.actualizarLibro(this.codigoLibro.getText(), this.CantidadLibros.getText());
        this.CantidadLibros.setText("");
        JOptionPane.showMessageDialog(this, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        resetFields();
        loadDataJTable();
    }//GEN-LAST:event_editarCarreraBtnActionPerformed

    private void eliminarCarreraBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarCarreraBtnActionPerformed
        String mensaje = this.controller.eliminarLibro(this.codigoLibro.getText());
        JOptionPane.showMessageDialog(this, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        resetFields();
        loadDataJTable();
    }//GEN-LAST:event_eliminarCarreraBtnActionPerformed

    private void crearCarreraBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearCarreraBtnActionPerformed
        String codigo = this.codigoLibro.getText();
        String autor = this.NombreAutor.getText();
        String titulo = this.nombreTitulo.getText();
        String editorial = this.Editorial.getText();
        String cantidadCopias = this.CantidadLibros.getText();
        String fechaPublicacion = this.FechaPublicacion.getText();
                
                
        String mensaje = this.controller.agregarLibro(codigo, autor, titulo, editorial, FRAMEBITS, fechaPublicacion);
        JOptionPane.showMessageDialog(this, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        resetFields();
        loadDataJTable();
    }//GEN-LAST:event_crearCarreraBtnActionPerformed

    private void jPanel1formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1formComponentHidden
        // TODO add your handling code here:
        System.out.println("fue escondido jijija");
    }//GEN-LAST:event_jPanel1formComponentHidden

    private void nombreTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTituloActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CantidadLibros;
    private javax.swing.JTextField Editorial;
    private javax.swing.JTextField FechaPublicacion;
    private javax.swing.JTextField NombreAutor;
    private javax.swing.JButton clearBtn;
    private javax.swing.JTextField codigoLibro;
    private javax.swing.JButton crearCarreraBtn;
    private javax.swing.JButton editarCarreraBtn;
    private javax.swing.JButton eliminarCarreraBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nombreTitulo;
    // End of variables declaration//GEN-END:variables
}
