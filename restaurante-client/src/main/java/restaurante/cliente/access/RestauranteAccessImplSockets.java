package restaurante.cliente.access;

import restaurante.commons.infra.Protocol;
import restaurante.commons.domain.Restaurante;
import restaurante.commons.infra.JsonError;
import restaurante.cliente.infra.SocketRestaurante;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import restaurante.commons.domain.Restaurante;

/**
 * Servicio de Cliente. Permite hacer el CRUD de clientes solicitando los
 * servicios con la aplicación server. Maneja los errores devueltos
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class RestauranteAccessImplSockets implements IRestauranteAccessRestaurante {

    /**
     * El servicio utiliza un socket para comunicarse con la aplicación server
     */
    private SocketRestaurante mySocket;

    public RestauranteAccessImplSockets() {
        mySocket = new SocketRestaurante();
    }

    /**
     * Busca un Restaurante. Utiliza socket para pedir el servicio al servidor
     *
     * @param id cedula del cliente
     * @return Objeto Restaurante
     * @throws Exception cuando no pueda conectarse con el servidor
     */

    public Restaurante findRestaurante(String id) throws Exception {
        String jsonResponse = null;
        String requestJson = findRestauranteRequestJson(id);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(RestauranteAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(RestauranteAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró el customer
                Restaurante customer = jsonToRestaurante(jsonResponse);
                return customer;
            }
        }

    }

    /**
     * Crea un Restaurante. Utiliza socket para pedir el servicio al servidor
     *
     * @param customer cliente de la agencia de viajes
     * @return devuelve la cedula del cliente creado
     * @throws Exception error crear el cliente
     */

    public String createRestaurante(Restaurante customer) throws Exception {
        String jsonResponse = null;
        String requestJson = createRestauranteRequestJson(customer);
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
                //Agregó correctamente, devuelve la cedula del customer 
                return "implementar";
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
     * @param idRestaurante identificación del cliente
     * @return solicitud de consulta del cliente en formato Json, algo como:
     * {"resource":"customer","action":"get","parameters":[{"name":"id","value":"98000001"}]}
     */
    private String findRestauranteRequestJson(String idRestaurante) {

        Protocol protocol = new Protocol();
        protocol.setResource("customer");
        protocol.setAction("get");
        protocol.addParameter("id", idRestaurante);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    /**
     * Crea la solicitud json de creación del customer para ser enviado por el
     * socket
     *
     * @param customer objeto customer
     * @return devulve algo como:
     * {"resource":"customer","action":"post","parameters":[{"name":"id","value":"980000012"},{"name":"fistName","value":"Juan"},...}]}
     */
    private String createRestauranteRequestJson(Restaurante customer) {

        Protocol protocol = new Protocol();
        protocol.setResource("customer");
        protocol.setAction("post");
//        protocol.addParameter("id", customer.getId());
//        protocol.addParameter("fistName", customer.getFirstName());
//        protocol.addParameter("lastName", customer.getLastName());
//        protocol.addParameter("address", customer.getAddress());
//        protocol.addParameter("email", customer.getEmail());
//        protocol.addParameter("gender", customer.getGender());
//        protocol.addParameter("mobile", customer.getMobile());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: " + requestJson);

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
        Restaurante customer = gson.fromJson(jsonRestaurante, Restaurante.class);

        return customer;

    }

    @Override
    public Customer findCustomer(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String createCustomer(Customer customer) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
