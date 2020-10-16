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
public class ControladorAdministrador {
    
    private static ControladorAdministrador instance;
    IRestauranteAccess service = Factory.getInstance().getRestauranteService();
    RestauranteService restauranteService = new RestauranteService(service);
    
    public static ControladorAdministrador getInstance() {
        if (instance == null) {
            instance = new ControladorAdministrador();
        }
        return instance;
    }
    
    public String addMenuSemanal(Plato plato)throws Exception{
        ArrayList<Plato> MenuSem = new ArrayList<Plato>();
        MenuSem.add(plato);
        return restauranteService.addMenuSemana(MenuSem);
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
    
    public ArrayList<Plato> getMenuSemanal(int idRestaurantes) throws Exception{       
        return restauranteService.getMenu(idRestaurantes);
    }
}
