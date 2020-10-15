/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mycompany.restaurante.cliente.presentacion;

import co.mycompany.restaurante.cliente.access.Factory;
import co.mycompany.restaurante.cliente.access.IRestauranteAccess;
import co.mycompany.restaurante.cliente.domain.services.RestauranteService;
import co.mycompany.restaurante.commons.domain.Plato;
import co.mycompany.restaurante.commons.domain.Restaurante;
import java.util.ArrayList;

/**
 *
 * @author juan-
 */
public class ControladorCliente {
    
    private static ControladorCliente instance;
    IRestauranteAccess service = Factory.getInstance().getRestauranteService();
    RestauranteService restauranteService = new RestauranteService(service);
    
    public static ControladorCliente getInstance() {
        if (instance == null) {
            instance = new ControladorCliente();
        }
        return instance;
    }
    
    public String addMenuSemanal(ArrayList<String> nombrePlato, ArrayList<Integer> precioPlato, ArrayList<String> descripcionPlato) throws Exception{
        ArrayList<Plato> menu = new ArrayList<Plato>();
        int posicion = 0;
        for (String nombre : nombrePlato){
            Plato plato = new Plato(precioPlato.get(posicion),descripcionPlato.get(posicion),nombre);
            posicion++;
            menu.add(plato);
        }
        return restauranteService.addMenuSemana(menu); 
    }
    
    public ArrayList<Plato> getMenuSemanal() throws Exception{       
        return restauranteService.getMenu("menuSemanal");
    }
    
    public ArrayList<Restaurante> getRestaurantes() throws Exception{       
        return restauranteService.getRestaurantes();
    }
}
