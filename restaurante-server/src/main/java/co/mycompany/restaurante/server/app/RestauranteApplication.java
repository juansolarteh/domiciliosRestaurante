package co.mycompany.restaurante.server.app;

import co.mycompany.restaurante.server.infra.RestauranteServerSocket;



/**
 * Aplicación principal que lanza el servidor en un hilo
 * @author Libardo, Julio
 */
public class RestauranteApplication {
    public static void main(String args[]){
        RestauranteServerSocket server = new RestauranteServerSocket();
        server.start();
    }
}
