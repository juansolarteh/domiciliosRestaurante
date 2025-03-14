package co.mycompany.restaurante.server.access;

import co.mycompany.restaurante.commons.domain.Restaurante;
import co.mycompany.restaurante.commons.domain.Plato;
import co.mycompany.restaurante.commons.infra.Utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Repositorio de Clientes en MySWL
 *
 * @author Libardo, Julio
 */
public class RestauranteRepositoryImplMysql implements IRestauranteRepository {

    /**
     * Conección con Mysql
     */
    private Connection conn;

    public RestauranteRepositoryImplMysql() {
    }
    /**
     * Busca en la bd un customer
     * @param id cedula
     * @return objeto customer, null si no lo encuentra
     */
    @Override
    public String addMenuSemanal(ArrayList<Plato> menuSemanal) {
        try {
            this.connect();
            int cont;
            String sql = "INSERT INTO PLATOS(restid, pltNombre, pltPrecio, pltDescripcion) VALUES (?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for (int i=0;i<menuSemanal.size();i++){
                cont = 1;               
                pstmt.setInt(cont, 1);
                cont++;
                pstmt.setString(cont, menuSemanal.get(i).getAtrNombre());
                cont++;
                pstmt.setInt(cont, menuSemanal.get(i).getAtrPrecio());
                cont++;
                pstmt.setString(cont, menuSemanal.get(i).getAtrDescripcion());
                pstmt.executeUpdate();
                
            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        return "Menu añadido Correctamente";
    }

    @Override
    public ArrayList<Plato> getMenuSemanal(int idRestaurantes) {
        ArrayList<Plato> menu = new ArrayList();
        try{
            this.connect();
            String sql = "SELECT * from Platos where restid=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Integer.toString(idRestaurantes));
            ResultSet res = pstmt.executeQuery();
            while(res.next()) {      
                Plato plato = new Plato();
                plato.setAtrNombre(res.getString("pltNombre"));
                plato.setAtrDescripcion(res.getString("pltDescripcion"));
                plato.setAtrPrecio(Integer.parseInt(res.getString("pltPrecio")));
                menu.add(plato);
            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Customer de la base de datos", ex);
        }
        return menu;
    }
    
    /**
     * Permite hacer la conexion con la base de datos
     *
     * @return
     */
    public int connect() {
        try {
            Class.forName(Utilities.loadProperty("server.db.driver"));
            //crea una instancia de la controlador de la base de datos
            String url = Utilities.loadProperty("server.db.url");
            String username = Utilities.loadProperty("server.db.username");
            String pwd = Utilities.loadProperty("server.db.password");
            conn = DriverManager.getConnection(url, username, pwd);
            return 1;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RestauranteRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Customer de la base de datos", ex);
        }
        return -1;
    }

    /**
     * Cierra la conexion con la base de datos
     *
     */
    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositoryImplMysql.class.getName()).log(Level.FINER, "Error al cerrar Connection", ex);
        }
    }

    @Override
    public ArrayList<Restaurante> getRestaurantes() {
        ArrayList<Restaurante> Restaurantes = new ArrayList();
        try{
            this.connect();
            String sql = "SELECT * from restaurante";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();
            while(res.next()) {      
                Restaurante RegistroRes = new Restaurante();
                RegistroRes.setAtrNit(Integer.parseInt(res.getString("restId")));
                RegistroRes.setAtrNombre(res.getString("restNombre"));
                RegistroRes.setAtrDirecccion(res.getString("restDireccion"));
                RegistroRes.setAtrTelefono(Integer.parseInt(res.getString("restTelefono")));
                Restaurantes.add(RegistroRes);
            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Customer de la base de datos", ex);
        }
        return Restaurantes;
    }
}
