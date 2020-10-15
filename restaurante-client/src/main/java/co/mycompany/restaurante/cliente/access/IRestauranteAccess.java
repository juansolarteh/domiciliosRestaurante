package co.mycompany.restaurante.cliente.access;

import co.mycompany.restaurante.commons.domain.Plato;
import java.util.ArrayList;
import co.mycompany.restaurante.commons.domain.Restaurante;

/**
 * Interface que define los servicios de persistencia de Clientes de la agencia
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public interface IRestauranteAccess {

    public String addMenuSemanal(ArrayList<Plato> menuSemanal)throws Exception;
    
    public ArrayList<Plato> getMenu(String tipoMenu)throws Exception;
    
    public ArrayList<Restaurante>getRestaurantes()throws Exception;
}
