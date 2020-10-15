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
            for (int i=0;i<menuSemanal.size();i++){
                cont = 1;
<<<<<<< HEAD
                pstmt.setInt(cont, 1);
=======
                String sql = "INSERT INTO PLATOS(restid, pltNombre, pltPrecio, pltDescripcion) VALUES (?,?,?,?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(cont, menuSemanal.get(i).getAtrIdRestaurante());
>>>>>>> d7bdbf1b206f09b1a0e988b934383400a61f9d23
                cont++;
                pstmt.setString(cont, menuSemanal.get(i).getAtrNombre());
                cont++;
                pstmt.setInt(cont, menuSemanal.get(i).getAtrPrecio());
                cont++;
                pstmt.setString(cont, menuSemanal.get(i).getAtrDescripcion());
                pstmt.executeUpdate();
                pstmt.close();
            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        return "Menu añadido Correctamente";
    }

    @Override
    public ArrayList<Plato> getMenuSemanal() {
        ArrayList<Plato> menu = new ArrayList();
        try{
            this.connect();
            String sql = "SELECT * from Platos where restid=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Integer.toString(1));
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
}
