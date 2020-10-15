package co.mycompany.restaurante.server.domain.services;

import co.mycompany.restaurante.commons.domain.Restaurante;
import co.mycompany.restaurante.commons.infra.JsonError;
import co.mycompany.restaurante.commons.infra.Utilities;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import co.mycompany.restaurante.commons.domain.Plato;
import co.mycompany.restaurante.server.access.IRestauranteRepository;

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
    
    public ArrayList<Plato> getMenuSemanal(){
        return repo.getMenuSemanal();
    }
    
    public ArrayList<Restaurante> getRestaurantes(){
        return repo.getRestaurantes();
    }

}
