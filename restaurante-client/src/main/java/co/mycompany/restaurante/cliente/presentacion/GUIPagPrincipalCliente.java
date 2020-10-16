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

public class GUIPagPrincipalCliente extends JPanel {

    private static ControladorCliente controlador = ControladorCliente.getInstance();
    private static JFrame marco;
    
    private GUIPagPrincipalCliente() throws Exception {
        super();
        BoxLayout by = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(by);
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
    
    private static void crearYMostrarGUI() throws Exception {
        ArrayList<Restaurante> restaurantes = controlador.getRestaurantes();
        marco = new JFrame();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GUIPagPrincipalCliente panel = new GUIPagPrincipalCliente();
        marco.setContentPane(panel);

        for (Restaurante rest: restaurantes){
            JTextArea jTextArea1 = crearTextAreaRestaurante(rest);    
            jTextArea1.setEditable(false);
            marco.add(jTextArea1);
            marco.add(new javax.swing.JPopupMenu.Separator());
            
            //Añadir evento click
            jTextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt){
                    try {
                        jTextArea1MouseClicked(evt, jTextArea1);
                    } catch (Exception ex) {
                        Logger.getLogger(GUIPagPrincipalCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            
        }

        marco.pack();
        marco.setLocationRelativeTo(null);
        marco.setVisible(true);
    }
    
    private static void jTextArea1MouseClicked(java.awt.event.MouseEvent evt, JTextArea jta) throws Exception {                                        
        GUIListaPlatosCliente instance = GUIListaPlatosCliente.getInstance();
        instance.show();
    }        

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    crearYMostrarGUI();
                } catch (Exception ex) {
                    Logger.getLogger(GUIPagPrincipalCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
