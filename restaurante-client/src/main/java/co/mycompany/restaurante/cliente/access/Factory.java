package co.mycompany.restaurante.cliente.access;

import co.mycompany.restaurante.commons.infra.Utilities;

/**
 * Fabrica que se encarga de instanciar CustomerServiceImplSockets o cualquier
 * otro que se cree en el futuro.
 *
 * @author Libardo, Julio
 */
public class Factory {

    private static Factory instance;

    private Factory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia ICustomerService
     *
     * @return una clase hija de la abstracción IRepositorioClientes
     */
    public IRestauranteAccess getRestauranteService() {

        IRestauranteAccess result = null;
        String type = Utilities.loadProperty("restaurante.service");

        switch (type) {
            case "default":
                result = new RestauranteAccessImplSockets();
                break;
        }

        return result;

    }
}
