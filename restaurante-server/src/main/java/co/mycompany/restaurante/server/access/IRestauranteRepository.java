package co.mycompany.restaurante.server.access;

import java.util.ArrayList;
import co.mycompany.restaurante.commons.domain.Restaurante;
import co.mycompany.restaurante.commons.domain.Plato;

/**
 * Interface del respositorio de clientes
 * @author Libardo Pantoja
 */
public interface IRestauranteRepository {
    /**
     * Busca un Customer por su ceduka
     * @param id cedula del cliente
     * @return  objeto de tipo Customer
     */
    public String addMenuSemanal(ArrayList<Plato> menuSemanal);
    
    public ArrayList<Plato> getMenuSemanal();
}
