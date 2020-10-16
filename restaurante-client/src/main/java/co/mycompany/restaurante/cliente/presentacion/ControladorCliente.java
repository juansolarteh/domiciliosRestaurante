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
    
    public ArrayList<Restaurante> getRestaurantes() throws Exception{       
        return restauranteService.getRestaurantes();
    }
    
    public ArrayList<Plato> getMenuSemanal(int idRestaurantes) throws Exception{       
        return restauranteService.getMenu(idRestaurantes);
    }
}
