package co.mycompany.restaurante.cliente.domain.services;

import co.mycompany.restaurante.commons.domain.Restaurante;
import co.mycompany.restaurante.cliente.access.IRestauranteAccess;
import co.mycompany.restaurante.commons.domain.Plato;
import java.util.ArrayList;

/**
 * Es una fachada para comunicar la presentación con el
 * dominio
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public class RestauranteService {

    private final IRestauranteAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     * @param service implementacion de tipo ICustomerService
     */
    public RestauranteService(IRestauranteAccess service) {
        this.service = service;
    }

    /**
     * Busca un cliente en el servidor remoto
     *
     * @param id identificador del cliente
     * @return Objeto tipo Cliente, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public String addMenuSemana(ArrayList<Plato> menu) throws Exception {
        return service.addMenuSemanal(menu);
    }
    
    public ArrayList<Plato> getMenu(String tipoMenu) throws Exception{
        return service.getMenu(tipoMenu);
    }
    
    public ArrayList<Restaurante> getRestaurantes()throws Exception{
        return service.getRestaurantes();
    }
}
