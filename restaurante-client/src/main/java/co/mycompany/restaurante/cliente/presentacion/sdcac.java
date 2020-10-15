package co.mycompany.restaurante.cliente.presentacion;



import co.mycompany.restaurante.commons.domain.Plato;
import co.mycompany.restaurante.commons.domain.Restaurante;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juan-
 */
public class sdcac {

    static ControladorCliente miControlador  = ControladorCliente.getInstance();
    
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        ArrayList Restaurantes = new ArrayList();
        ArrayList nombres = new ArrayList();
        ArrayList precios = new ArrayList();
        ArrayList descripcion = new ArrayList();
        nombres.add("carne");
        nombres.add("pollo");
        precios.add(10000);
        precios.add(9000);
        descripcion.add("300g de carne");
        descripcion.add("300g de pollo");
        
        String resultado = miControlador.addMenuSemanal(nombres, precios, descripcion);
        if (resultado.contains("error"))System.out.println("error no se por que");
        else System.out.println(resultado);
        
        for (Plato plato : miControlador.getMenuSemanal()){
            System.out.println(plato.getAtrNombre());
            System.out.println(plato.getAtrDescripcion());
            System.out.println(plato.getAtrPrecio());
        }
        
        for(Restaurante restaurante : miControlador.getRestaurantes()){
            System.out.println("---------------------------------------");
            System.out.println(restaurante.getAtrNombre());
            System.out.println(restaurante.getAtrDirecccion());
            System.out.println(restaurante.getAtrTelefono());
        }
    }
}
