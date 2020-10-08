
import co.mycompany.restaurante.cliente.access.Factory;
import co.mycompany.restaurante.cliente.access.IRestauranteAccess;
import co.mycompany.restaurante.cliente.domain.services.RestauranteService;
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

    static ArrayList<Plato> menu = new ArrayList<Plato>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        IRestauranteAccess service = Factory.getInstance().getRestauranteService();
        // Inyecta la dependencia
        RestauranteService restauranteService = new RestauranteService(service);
        
        Plato plato1 = new Plato(10000,"300g de carne","carne");
        Plato plato2 = new Plato(9000,"300g de pollo","pollo");
        menu.add(plato1);
        menu.add(plato2);
        
        try {
            String[] nombrePlatos = restauranteService.addMenuSemana(menu);
            for (String nombrePlato : nombrePlatos) System.out.println(nombrePlato);    
        } catch (Exception ex) {
            System.out.println("Error");
        }
        
    }
    
}
