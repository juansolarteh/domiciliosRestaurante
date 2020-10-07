package restaurante.cliente.domain.services;

import restaurante.commons.domain.Restaurante;
import restaurante.cliente.access.IRestauranteAccessRestaurante;

/**
 * Es una fachada para comunicar la presentación con el
 * dominio
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public class RestauranteService {

    private final IRestauranteAccessRestaurante service;

    /**
     * Constructor privado que evita que otros objetos instancien
     * @param service implementacion de tipo ICustomerService
     */
    public RestauranteService(IRestauranteAccessRestaurante service) {
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
    public Customer findCustomer(String id) throws Exception {
        return service.findCustomer(id);

    }
    
    public String createCustomer(Customer customer) throws Exception {
        return service.createCustomer(customer);

    }    

}
