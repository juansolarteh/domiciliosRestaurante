package restaurante.server.domain.services;

import restaurante.commons.domain.Restaurante;
import restaurante.commons.infra.JsonError;
import restaurante.commons.infra.Utilities;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import restaurante.commons.domain.Plato;
import restaurante.server.access.IRestauranteRepository;

/**
 * Servicio de clientes. Da acceso a la lógica de negocio
 *
 * @author Libardo, Julio
 */
public class RestauranteService {

    /**
     * Repositorio de clientes
     */
    IRestauranteRepository repo;

    /**
     * Constructor parametrizado. Hace inyeccion de dependencias
     *
     * @param repo repositorio de tipo IRestauranteRepository
     */
    public RestauranteService(IRestauranteRepository repo) {
        this.repo = repo;
    }

    /**
     * Buscar un cliente
     *
     * @param id cedula
     * @return objeto tipo Restaurante
     */
    public String addMenuSemanal(ArrayList<Plato> menuSemanal) {
        return repo.addMenuSemanal(menuSemanal);
    }

}
