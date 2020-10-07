package restaurante.server.access;

import java.util.ArrayList;
import restaurante.commons.domain.Restaurante;
import restaurante.commons.domain.Plato;

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
    
    
}
