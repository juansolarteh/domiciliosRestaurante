/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mycompany.restaurante.cliente.presentacion;

import co.mycompany.restaurante.commons.domain.Plato;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan-
 */
public class GUIPagPrincipalRestaurante extends javax.swing.JFrame {

    private ControladorAdministrador atrControlador = ControladorAdministrador.getInstance();
    ArrayList<Plato> menuSemanal;
    boolean hayPlatos = false;
    
    private static GUIPagPrincipalRestaurante instance;
    public static GUIPagPrincipalRestaurante getInstance() throws Exception {
        if (instance == null) {
            instance = new GUIPagPrincipalRestaurante();
        }
        return instance;
    }
    /**
     * Creates new form JFramePagPrincipalRestaurante
     */
    GUIPagPrincipalRestaurante() throws Exception {
        initComponents();
        this.setLocationRelativeTo(null);
        menuSemanal = atrControlador.getMenuSemanal(1);
        if (menuSemanal == null){
            jtxtAreaPlatos.append("NO HAY PLATOS SEMANALES REGISTRADOS"+"\n");
            jtxtAreaPlatos.setCaretPosition(jtxtAreaPlatos.getDocument().getLength());
            jtxtAreaPlatos.append("EN ESTE RESTAURANTE");
            jtxtAreaPlatos.setCaretPosition(jtxtAreaPlatos.getDocument().getLength());
            hayPlatos = false;
        }else{         
            hayPlatos = true;
            escribirPlatos();       
        }   
        jtxtAreaPlatos.setEditable(false);
        instance = this;
    }
    
    private void escribirPlatos() throws Exception{
        int pos = 0;
        for (Plato plato:menuSemanal){
            jtxtAreaPlatos.append(plato.getAtrNombre() + "\n");
            jtxtAreaPlatos.setCaretPosition(jtxtAreaPlatos.getDocument().getLength());
            jtxtAreaPlatos.append(plato.getAtrDescripcion() + "\n");
            jtxtAreaPlatos.setCaretPosition(jtxtAreaPlatos.getDocument().getLength());
            jtxtAreaPlatos.append("$"+plato.getAtrPrecio() + "\n");
            jtxtAreaPlatos.setCaretPosition(jtxtAreaPlatos.getDocument().getLength());
            jtxtAreaPlatos.append("-----------------------------------------------------------------------------------" + "\n");
            jtxtAreaPlatos.setCaretPosition(jtxtAreaPlatos.getDocument().getLength());
        }
    }
    public void actualizarPlato(Plato plato){
        if (hayPlatos == false){
            hayPlatos = true;
            jtxtAreaPlatos.setText("");
        }           
        jtxtAreaPlatos.append(plato.getAtrNombre() + "\n");
        jtxtAreaPlatos.setCaretPosition(jtxtAreaPlatos.getDocument().getLength());
        jtxtAreaPlatos.append(plato.getAtrDescripcion() + "\n");
        jtxtAreaPlatos.setCaretPosition(jtxtAreaPlatos.getDocument().getLength());
        jtxtAreaPlatos.append("$"+plato.getAtrPrecio() + "\n");
        jtxtAreaPlatos.setCaretPosition(jtxtAreaPlatos.getDocument().getLength());
        jtxtAreaPlatos.append("-----------------------------------------------------------------------------------" + "\n");
        jtxtAreaPlatos.setCaretPosition(jtxtAreaPlatos.getDocument().getLength());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtAreaPlatos = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuGestionRestaurante = new javax.swing.JMenu();
        mnuItmAgregarMenuSemanal = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuItmSalir = new javax.swing.JMenuItem();
        mnuEmpleadoLogueado = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtxtAreaPlatos.setColumns(20);
        jtxtAreaPlatos.setRows(5);
        jScrollPane1.setViewportView(jtxtAreaPlatos);

        mnuGestionRestaurante.setText("Gestion Restaurante");

        mnuItmAgregarMenuSemanal.setText("Agregar menu semanal");
        mnuItmAgregarMenuSemanal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItmAgregarMenuSemanalActionPerformed(evt);
            }
        });
        mnuGestionRestaurante.add(mnuItmAgregarMenuSemanal);
        mnuGestionRestaurante.add(jSeparator1);

        mnuItmSalir.setText("Cerrar sesión");
        mnuItmSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItmSalirActionPerformed(evt);
            }
        });
        mnuGestionRestaurante.add(mnuItmSalir);

        jMenuBar1.add(mnuGestionRestaurante);

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
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuItmSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItmSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_mnuItmSalirActionPerformed

    private void mnuItmAgregarMenuSemanalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItmAgregarMenuSemanalActionPerformed

        GUIAdicionarPlato ins = GUIAdicionarPlato.getInstance();
        ins.show();

    }//GEN-LAST:event_mnuItmAgregarMenuSemanalActionPerformed

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
            java.util.logging.Logger.getLogger(GUIPagPrincipalRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPagPrincipalRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPagPrincipalRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPagPrincipalRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUIPagPrincipalRestaurante().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(GUIPagPrincipalRestaurante.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextArea jtxtAreaPlatos;
    private javax.swing.JMenu mnuEmpleadoLogueado;
    private javax.swing.JMenu mnuGestionRestaurante;
    private javax.swing.JMenuItem mnuItmAgregarMenuSemanal;
    private javax.swing.JMenuItem mnuItmSalir;
    // End of variables declaration//GEN-END:variables
}
