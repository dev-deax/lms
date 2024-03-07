package com.proyect.lms.view;

import com.proyect.lms.controller.CargaDatosController;
import com.proyect.lms.controller.CarreraController;
import com.proyect.lms.controller.LibroController;
import com.proyect.lms.controller.ReportesController;
import com.proyect.lms.database.ConexionDB;
import com.proyect.lms.model.CarreraModel;
import com.proyect.lms.model.EstudianteModel;
import com.proyect.lms.model.LibroModel;
import com.proyect.lms.model.PrestamoModel;
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author dany
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    private ConexionDB conexionDB;
    private Connection connection;

    private CarreraView carreraView;
    private CarreraController carreraController;
    private CarreraModel carreraModel;

    private EstudianteView estudianteView;
    private EstudianteModel estudianteModel;
    
    private LibroView libroView;
    private LibroController libroController;
    private LibroModel libroModel;

    private PrestamoView prestamoView;
    private PrestamoModel prestamoModel;

    private CargaDatosView cargaDatosView;
    private CargaDatosController cargaDatosController;
    
    private ReportesView reportesView;
    private ReportesController reportesController;

    public Menu() {
        initComponents();
        this.conexionDB = new ConexionDB();
        try {
            this.connection = conexionDB.obtenerConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.carreraView = new CarreraView();
        this.carreraModel = new CarreraModel();
        this.carreraController = new CarreraController(connection, carreraModel);

        this.estudianteView = new EstudianteView();
        this.estudianteModel=new EstudianteModel();
        
        this.libroView = new LibroView();
        this.libroModel = new LibroModel();
        this.libroController = new LibroController(connection, libroModel);

        this.prestamoView = new PrestamoView();
        this.prestamoModel = new PrestamoModel();
        
        this.cargaDatosView = new CargaDatosView();
        this.cargaDatosController= new CargaDatosController(connection, libroModel, estudianteModel, prestamoModel);

        this.reportesView = new ReportesView();
        this.reportesController= new ReportesController(connection, libroModel, estudianteModel, prestamoModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        contenedorPrincipal = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        carreraJMenu = new javax.swing.JMenu();
        estudianteJMenu = new javax.swing.JMenu();
        libroJMenu = new javax.swing.JMenu();
        prestamoJMenu = new javax.swing.JMenu();
        cargaDatosJMenu = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contenedorPrincipal.setLayout(new java.awt.CardLayout());

        carreraJMenu.setText("Carrera");
        carreraJMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                carreraJMenuMousePressed(evt);
            }
        });
        jMenuBar1.add(carreraJMenu);

        estudianteJMenu.setText("Estudiante");
        estudianteJMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                estudianteJMenuMousePressed(evt);
            }
        });
        jMenuBar1.add(estudianteJMenu);

        libroJMenu.setText("Libro");
        libroJMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                libroJMenuMousePressed(evt);
            }
        });
        jMenuBar1.add(libroJMenu);

        prestamoJMenu.setText("Prestamo");
        prestamoJMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                prestamoJMenuMousePressed(evt);
            }
        });
        jMenuBar1.add(prestamoJMenu);

        cargaDatosJMenu.setText("Cargar datos");
        cargaDatosJMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cargaDatosJMenuMousePressed(evt);
            }
        });
        jMenuBar1.add(cargaDatosJMenu);

        jMenu1.setText("Reportes");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu1MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedorPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedorPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carreraJMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carreraJMenuMousePressed
        this.carreraView.setController(carreraController);
        this.carreraView.initView();
        mostrarPanel(this.carreraView);
    }//GEN-LAST:event_carreraJMenuMousePressed

    private void estudianteJMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estudianteJMenuMousePressed
        mostrarPanel(this.estudianteView);
    }//GEN-LAST:event_estudianteJMenuMousePressed

    private void libroJMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_libroJMenuMousePressed
        this.libroView.setController(libroController);
        this.libroView.initView();

        mostrarPanel(this.libroView);
    }//GEN-LAST:event_libroJMenuMousePressed

    private void prestamoJMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prestamoJMenuMousePressed
        mostrarPanel(this.prestamoView);
    }//GEN-LAST:event_prestamoJMenuMousePressed

    private void cargaDatosJMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargaDatosJMenuMousePressed
        this.cargaDatosView.setController(this.cargaDatosController);
        this.cargaDatosView.initView();

        mostrarPanel(this.cargaDatosView);
    }//GEN-LAST:event_cargaDatosJMenuMousePressed

    private void jMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MousePressed
        this.reportesView.setController(this.reportesController);
        this.reportesView.initView();

        mostrarPanel(this.reportesView);
    }//GEN-LAST:event_jMenu1MousePressed

    private void mostrarPanel(JPanel panel) {
        contenedorPrincipal.removeAll();
        contenedorPrincipal.add(panel);
        ((CardLayout) contenedorPrincipal.getLayout()).show(contenedorPrincipal, panel.getClass().getName());
        revalidate();
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu cargaDatosJMenu;
    private javax.swing.JMenu carreraJMenu;
    private javax.swing.JPanel contenedorPrincipal;
    private javax.swing.JMenu estudianteJMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu libroJMenu;
    private javax.swing.JMenu prestamoJMenu;
    // End of variables declaration//GEN-END:variables
}
