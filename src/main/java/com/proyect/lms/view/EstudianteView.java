/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.proyect.lms.view;

/**
 *
 * @author dany
 */
public class EstudianteView extends javax.swing.JPanel {

    /**
     * Creates new form EstudianteView
     */
    public EstudianteView() {
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

        jLabel3 = new javax.swing.JLabel();
        codigoCarreraField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nombreCarreraField = new javax.swing.JTextField();
        crearCarreraBtn = new javax.swing.JButton();
        editarCarreraBtn = new javax.swing.JButton();
        eliminarCarreraBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jLabel3.setText("Codigo carrera");

        codigoCarreraField.setEditable(false);

        jLabel2.setText("Nombre de la carrera");

        crearCarreraBtn.setText("Crear");

        editarCarreraBtn.setText("Editar");

        eliminarCarreraBtn.setText("Eliminar");

        clearBtn.setText("Limpiar campos");

        jScrollPane1.setViewportView(jTable1);

        setPreferredSize(new java.awt.Dimension(613, 300));

        jLabel1.setText("Carrera View");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(273, 273, 273)
                    .addComponent(jLabel1)
                    .addContainerGap(361, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(142, 142, 142)
                    .addComponent(jLabel1)
                    .addContainerGap(166, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBtn;
    private javax.swing.JTextField codigoCarreraField;
    private javax.swing.JButton crearCarreraBtn;
    private javax.swing.JButton editarCarreraBtn;
    private javax.swing.JButton eliminarCarreraBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nombreCarreraField;
    // End of variables declaration//GEN-END:variables
}
