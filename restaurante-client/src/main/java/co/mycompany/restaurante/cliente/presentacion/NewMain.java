package co.mycompany.restaurante.cliente.presentacion;
        

import javax.swing.table.AbstractTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import co.mycompany.restaurante.commons.domain.Restaurante;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class NewMain extends JFrame {

    private static ControladorCliente controlador = ControladorCliente.getInstance();
    
    private static NewMain instance;
    public static NewMain getInstance() throws Exception {
        if (instance == null) {
            instance = new NewMain();
        }
        return instance;
    }
    
    private NewMain() throws Exception {
        initComponents();
        ArrayList<Restaurante> restaurantes = controlador.getRestaurantes();
        
        for (Restaurante rest: restaurantes){
            JTextArea jTextArea1 = crearTextAreaRestaurante(rest);    
            jTextArea1.setEditable(false);
            this.add(jTextArea1);
            this.add(new javax.swing.JPopupMenu.Separator());
            
            //Añadir evento click
            jTextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt){
                    try {
                        jTextArea1MouseClicked(evt, jTextArea1);
                    } catch (Exception ex) {
                        Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            
        }
        pack();
        setLocationRelativeTo(null);
    }
    
    private void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        by = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(by);
        this.setContentPane(panel);      
    }
    
    
    private static JTextArea crearTextAreaRestaurante(Restaurante rest){
        JTextArea jTextAreaRestaurante = new JTextArea();
        jTextAreaRestaurante.append(rest.getAtrNombre() + "\n");
        jTextAreaRestaurante.setCaretPosition(jTextAreaRestaurante.getDocument().getLength());
        jTextAreaRestaurante.append(rest.getAtrDirecccion()+ "\n");
        jTextAreaRestaurante.setCaretPosition(jTextAreaRestaurante.getDocument().getLength());
        jTextAreaRestaurante.append("$"+rest.getAtrTelefono()+ "\n");
        return jTextAreaRestaurante;
    } 
    
    private static void jTextArea1MouseClicked(java.awt.event.MouseEvent evt, JTextArea jta) throws Exception {                                        
        GUIListaPlatosCliente ins = GUIListaPlatosCliente.getInstance();
        ins.show();
    }        

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    instance.getInstance().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    //Declaracion de variables no modificar
    private JPanel panel;
    private BoxLayout by;
}

