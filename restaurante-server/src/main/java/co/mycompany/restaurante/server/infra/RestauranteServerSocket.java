package co.mycompany.restaurante.server.infra;

import co.mycompany.restaurante.commons.domain.Restaurante;
import co.mycompany.restaurante.commons.infra.JsonError;
import co.mycompany.restaurante.commons.infra.Protocol;
import co.mycompany.restaurante.commons.infra.Utilities;
import co.mycompany.restaurante.server.access.Factory;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import co.mycompany.restaurante.server.domain.services.RestauranteService;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import co.mycompany.restaurante.commons.domain.Plato;
import co.mycompany.restaurante.server.access.IRestauranteRepository;

/**
 * Servidor Socket que está escuchando permanentemente solicitudes de los
 * clientes. Cada solicitud la atiende en un hilo de ejecución
 *
 * @author Libardo, Julio
 */
public class RestauranteServerSocket implements Runnable {

    /**
     * Servicio de clientes
     */
    private final RestauranteService service;
    /**
     * Server Socket, la orejita
     */
    private static ServerSocket ssock;
    /**
     * Socket por donde se hace la petición/respuesta
     */
    private static Socket socket;
    /**
     * Permite leer un flujo de datos del socket
     */
    private Scanner input;
    /**
     * Permite escribir un flujo de datos del scoket
     */
    private PrintStream output;
    /**
     * Puerto por donde escucha el server socket
     */
    private static final int PORT = Integer.parseInt(Utilities.loadProperty("server.port"));

    /**
     * Constructor
     */
    public RestauranteServerSocket() {
        // Se hace la inyección de dependencia
        IRestauranteRepository repository = Factory.getInstance().getRepository();
        service = new RestauranteService(repository);
    }

    /**
     * Arranca el servidor y hace la estructura completa
     */
    public void start() {
        openPort();

        while (true) {
            waitToClient();
            throwThread();
        }
    }

    /**
     * Lanza el hilo
     */
    private static void throwThread() {
        new Thread(new RestauranteServerSocket()).start();
    }

    /**
     * Instancia el server socket y abre el puerto respectivo
     */
    private static void openPort() {
        try {
            ssock = new ServerSocket(PORT);
            Logger.getLogger("Server").log(Level.INFO, "Servidor iniciado, escuchando por el puerto {0}", PORT);
        } catch (IOException ex) {
            Logger.getLogger(RestauranteServerSocket.class.getName()).log(Level.SEVERE, "Error del server socket al abrir el puerto", ex);
        }
    }

    /**
     * Espera que el cliente se conecta y le devuelve un socket
     */
    private static void waitToClient() {
        try {
            socket = ssock.accept();
            Logger.getLogger("Socket").log(Level.INFO, "Socket conectado");
        } catch (IOException ex) {
            Logger.getLogger(RestauranteServerSocket.class.getName()).log(Level.SEVERE, "Eror al abrir un socket", ex);
        }
    }

    /**
     * Cuerpo del hilo
     */
    @Override
    public void run() {
        try {
            createStreams();
            readStream();
            closeStream();

        } catch (IOException ex) {
            Logger.getLogger(RestauranteServerSocket.class.getName()).log(Level.SEVERE, "Eror al leer el flujo", ex);
        }
    }

    /**
     * Crea los flujos con el socket
     *
     * @throws IOException
     */
    private void createStreams() throws IOException {
        output = new PrintStream(socket.getOutputStream());
        input = new Scanner(socket.getInputStream());
    }

    /**
     * Lee el flujo del socket
     */
    private void readStream() {
        if (input.hasNextLine()) {
            // Extrae el flujo que envió la aplicación cliente
            String request = input.nextLine();
            processRequest(request);

        } else {
            output.flush();
            String errorJson = generateErrorJson();
            output.println(errorJson);
        }
    }

    /**
     * Procesar la solicitud que proviene de la aplicación cliente
     *
     * @param requestJson petición que proviene del cliente socket en formato
     * json que viene de esta manera:
     * "{"resource":"restaurante","action":"get","parameters":[{"name":"id","value":"1"}]}"
     *
     */
    private void processRequest(String requestJson) {
        // Convertir la solicitud a objeto Protocol para poderlo procesar
        Gson gson = new Gson();
        Protocol protocolRequest = gson.fromJson(requestJson, Protocol.class);

        switch (protocolRequest.getResource()) {
            case "restaurante":
                if (protocolRequest.getAction().equals("set")) {
                    // Agregar un menu
                    processSetMenuSemanal(protocolRequest);
                }
                else if (protocolRequest.getAction().equals("get")) {
                    processGetMenuSemanal(protocolRequest);
                }
                break;
            case "restaurantes":
                if (protocolRequest.getAction().equals("get")) {
                    // Obtener datos de restaurante
                    processGetRestaurantes(protocolRequest);
                }
        }

    }

    /**
     * Procesa la solicitud de agregar un menuSemanal
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processSetMenuSemanal(Protocol protocolRequest) {
        ArrayList <Plato> menuSemanal= new ArrayList<Plato>();
        for (int i = 0; i < protocolRequest.getParameters().size(); i++){
            Plato regPlato = new Plato();
            regPlato.setAtrPrecio(Integer.parseInt(protocolRequest.getParameters().get(i).getValue()));
            i++;
            regPlato.setAtrDescripcion(protocolRequest.getParameters().get(i).getValue());
            i++;
            regPlato.setAtrNombre(protocolRequest.getParameters().get(i).getValue());
            menuSemanal.add(regPlato);
        }
        String response = service.addMenuSemanal(menuSemanal);
        output.println(response);
    }
    
    /**
     * Procesa la solicitud de dar el menuSemanal
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processGetMenuSemanal(Protocol protocolRequest) {  
        ArrayList<Plato> menuSemanal = service.getMenuSemanal();
        if (menuSemanal.size() == 0) {
            output.println("menu semanal vacio");
        } else {
            output.println(objectToJSON(menuSemanal));
        }
    }

    private void processGetRestaurantes(Protocol protocolRequest) {  
        ArrayList<Restaurante> Restaurantes = service.getRestaurantes();
        if (Restaurantes.size() == 0) {
            output.println("Restaurantes vacio");
        } else {
            output.println(objectRestToJSON(Restaurantes));
        }
    }
    
    /**
     * Genera un ErrorJson de cliente no encontrado
     *
     * @return error en formato json
     */
    private String generateNotFoundErrorJson() {
        List<JsonError> errors = new ArrayList<>();
        JsonError error = new JsonError();
        error.setCode("404");
        error.setError("NOT_FOUND");
        error.setMessage("Cliente no encontrado. Cédula no existe");
        errors.add(error);

        Gson gson = new Gson();
        String errorsJson = gson.toJson(errors);

        return errorsJson;
    }

    /**
     * Genera un ErrorJson genérico
     *
     * @return error en formato json
     */
    private String generateErrorJson() {
        List<JsonError> errors = new ArrayList<>();
        JsonError error = new JsonError();
        error.setCode("400");
        error.setError("BAD_REQUEST");
        error.setMessage("Error en la solicitud");
        errors.add(error);

        Gson gson = new Gson();
        String errorJson = gson.toJson(errors);

        return errorJson;
    }

    /**
     * Cierra los flujos de entrada y salida
     *
     * @throws IOException
     */
    private void closeStream() throws IOException {
        output.close();
        input.close();
        socket.close();
    }

    /**
     * Convierte el objeto Restaurante a json para que el servidor lo envie como
     * respuesta por el socket
     *
     * @param restaurante cliente
     * @return restaurante en formato json
     */
    private String objectToJSON(ArrayList<Plato> menu) {
        Gson gson = new Gson();
        String strObject = gson.toJson(menu);
        return strObject;
    }
    
    private String objectRestToJSON(ArrayList<Restaurante> restaurantes) {
        Gson gson = new Gson();
        String strObject = gson.toJson(restaurantes);
        return strObject;
    }

}
