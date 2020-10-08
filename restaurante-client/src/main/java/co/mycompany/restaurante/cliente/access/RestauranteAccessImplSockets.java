package co.mycompany.restaurante.cliente.access;

import restaurante.commons.infra.Protocol;
import restaurante.commons.domain.Restaurante;
import restaurante.commons.infra.JsonError;
import co.mycompany.restaurante.cliente.infra.SocketRestaurante;
import co.mycompany.restaurante.commons.domain.Plato;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import restaurante.commons.domain.Restaurante;

/**
 * Servicio de Cliente. Permite hacer el CRUD de clientes solicitando los
 * servicios con la aplicación server. Maneja los errores devueltos
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class RestauranteAccessImplSockets implements IRestauranteAccess {

    /**
     * El servicio utiliza un socket para comunicarse con la aplicación server
     */
    private SocketRestaurante mySocket;

    public RestauranteAccessImplSockets() {
        mySocket = new SocketRestaurante();
    }
 
    @Override
    public String[] addMenuSemanal(ArrayList<Plato> menuSemanal)throws Exception {
        String jsonResponse = null;
        String requestJson = addMenuSemanalRequestJson(menuSemanal);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(RestauranteAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(RestauranteAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Agregó correctamente el menu, devuelve los nombres de los platos
                return jsonResponse.split("/");
            }
        }
    }
    
    /**
     * Extra los mensajes de la lista de errores
     * @param jsonResponse lista de mensajes json
     * @return Mensajes de error
     */
    private String extractMessages(String jsonResponse) {
        JsonError[] errors = jsonToErrors(jsonResponse);
        String msjs = "";
        for (JsonError error : errors) {
            msjs += error.getMessage();
        }
        return msjs;
    }

    /**
     * Convierte el jsonError a un array de objetos jsonError
     *
     * @param jsonError
     * @return objeto MyError
     */
    private JsonError[] jsonToErrors(String jsonError) {
        Gson gson = new Gson();
        JsonError[] error = gson.fromJson(jsonError, JsonError[].class);
        return error;
    }

    /**
     * Crea una solicitud json para ser enviada por el socket
     *
     *
     * @param menuSemanal lista de platos nuevos
     * @return solicitud de creacion de menu:
     * {"resource":"restaurante","action":"set","parameters":[{"percio plato":"int","descripcion":"String","nombre":"String"}]}
     */
    private String addMenuSemanalRequestJson(ArrayList<Plato> menuSemanal) {

        Protocol protocol = new Protocol();
        protocol.setResource("restaurante");
        protocol.setAction("set");
        for (int i = 0; i < menuSemanal.size(); i++) {
            protocol.addParameter("Precio Plato " + Integer.toString(i)
                    , Integer.toString(menuSemanal.get(i).getAtrPrecio()));
            protocol.addParameter("Descripcion Plato " + Integer.toString(i)
                    , menuSemanal.get(i).getAtrDescripcion());
            protocol.addParameter("Nombre Plato " + Integer.toString(i)
                    , menuSemanal.get(i).getAtrNombre());
        }

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    /**
     * Convierte jsonRestaurante, proveniente del server socket, de json a un
     * objeto Restaurante
     *
     * @param jsonRestaurante objeto cliente en formato json
     */
    private Restaurante jsonToRestaurante(String jsonRestaurante) {

        Gson gson = new Gson();
        Restaurante restaurante = gson.fromJson(jsonRestaurante, Restaurante.class);

        return restaurante;

    }
}
