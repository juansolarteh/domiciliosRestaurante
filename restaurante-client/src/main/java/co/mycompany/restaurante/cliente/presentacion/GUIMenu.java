/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mycompany.restaurante.cliente.presentacion;

//import co.unicauca.travelagency.commons.infra.Utilities;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Image;
import java.awt.Toolkit;
//import static co.unicauca.travelagency.client.infra.Messages.warningMessage;
//import static co.unicauca.travelagency.client.infra.Messages.successMessage;

/**
 *
 * @author libardo
 */
public class GUIMenu extends javax.swing.JFrame {

    /**
     * Creates new form GUIMenu
     */
    public GUIMenu() {
        initComponents();
        //Poner el icono de la aplicación
        Image icon = Toolkit.getDefaultToolkit().getImage("./src/recursos/logo.png");
        this.setIconImage(icon);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dskEscritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuPaqueteTodoIncluido = new javax.swing.JMenu();
        mnuConsultarClientes = new javax.swing.JMenuItem();
        mnuPaquetesPersonalizados = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuSalir = new javax.swing.JMenuItem();
        mnuInformes = new javax.swing.JMenu();
        mnuIngresosPorFecha = new javax.swing.JMenuItem();
        mnuConsultaAbierta = new javax.swing.JMenuItem();
        mnuEmpleadoLogueado = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agencia de viajes");

        mnuPaqueteTodoIncluido.setText("Gestion Restaurante");

        mnuConsultarClientes.setText("Gestión de Platos");
        mnuConsultarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConsultarClientesActionPerformed(evt);
            }
        });
        mnuPaqueteTodoIncluido.add(mnuConsultarClientes);

        mnuPaquetesPersonalizados.setText("Gestión de menu semanal");
        mnuPaquetesPersonalizados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPaquetesPersonalizadosActionPerformed(evt);
            }
        });
        mnuPaqueteTodoIncluido.add(mnuPaquetesPersonalizados);
        mnuPaqueteTodoIncluido.add(jSeparator1);

        mnuSalir.setText("Salir");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        mnuPaqueteTodoIncluido.add(mnuSalir);

        jMenuBar1.add(mnuPaqueteTodoIncluido);

        mnuInformes.setText("Informes");

        mnuIngresosPorFecha.setText("Restaurantes");
        mnuIngresosPorFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIngresosPorFechaActionPerformed(evt);
            }
        });
        mnuInformes.add(mnuIngresosPorFecha);

        mnuConsultaAbierta.setText("Menu semanal");
        mnuConsultaAbierta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConsultaAbiertaActionPerformed(evt);
            }
        });
        mnuInformes.add(mnuConsultaAbierta);

        jMenuBar1.add(mnuInformes);

        mnuEmpleadoLogueado.setBackground(java.awt.Color.magenta);
        mnuEmpleadoLogueado.setForeground(java.awt.SystemColor.activeCaption);
        mnuEmpleadoLogueado.setText("Usuario_logueado");
        mnuEmpleadoLogueado.setEnabled(false);
        jMenuBar1.add(mnuEmpleadoLogueado);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dskEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dskEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//jjj
    private void mnuPaquetesPersonalizadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPaquetesPersonalizadosActionPerformed
        //GUICustomizerPackage ins = GUICustomizerPackage.getInstancia();
        //ins.setMaximizable(true);

        //dskEscritorio.add(ins);
        //ins.show();
    }//GEN-LAST:event_mnuPaquetesPersonalizadosActionPerformed
//jjj
    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mnuSalirActionPerformed
//jjj
    private void mnuIngresosPorFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIngresosPorFechaActionPerformed
        //warningMessage("En construcción....", "Atención");


    }//GEN-LAST:event_mnuIngresosPorFechaActionPerformed
///jjj
    private void mnuConsultaAbiertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConsultaAbiertaActionPerformed
        //warningMessage("En construcción....", "Atención");
    }//GEN-LAST:event_mnuConsultaAbiertaActionPerformed
//jjj
    private void mnuConsultarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConsultarClientesActionPerformed
        
        //GUICustomer ins = new GUICustomer();
        //ins.setMaximizable(true);
        //dskEscritorio.add(ins);
        //ins.show();
    }//GEN-LAST:event_mnuConsultarClientesActionPerformed

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
            java.util.logging.Logger.getLogger(GUIMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIMenu ins = new GUIMenu();
                ins.setExtendedState(MAXIMIZED_BOTH);
                ins.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dskEscritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem mnuConsultaAbierta;
    private javax.swing.JMenuItem mnuConsultarClientes;
    private javax.swing.JMenu mnuEmpleadoLogueado;
    private javax.swing.JMenu mnuInformes;
    private javax.swing.JMenuItem mnuIngresosPorFecha;
    private javax.swing.JMenu mnuPaqueteTodoIncluido;
    private javax.swing.JMenuItem mnuPaquetesPersonalizados;
    private javax.swing.JMenuItem mnuSalir;
    // End of variables declaration//GEN-END:variables

}
