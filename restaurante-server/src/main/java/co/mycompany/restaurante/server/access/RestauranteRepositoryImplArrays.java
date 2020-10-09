package co.mycompany.restaurante.server.access;

import co.mycompany.restaurante.commons.domain.Restaurante;
import co.mycompany.restaurante.commons.domain.Plato;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de IRestauranteRepository. Utilliza arreglos en memoria
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public final class RestauranteRepositoryImplArrays implements IRestauranteRepository {

    /**
     * Array List de clientes
     */
    private static List<Restaurante> restaurante;

    public RestauranteRepositoryImplArrays() {
        if (restaurante == null){
            restaurante = new ArrayList();
        }
        
        if (restaurante.size() == 0){
            inicializar();
        }
    }

    public void inicializar() {
        ArrayList <Plato> listaPlatos = new ArrayList<Plato>(); 
        Restaurante regRestaurante = new Restaurante(10,"Cra 12 a ","HOLA");
        listaPlatos.add(new Plato(10000,"300 g de nada","Nada"));
        listaPlatos.add(new Plato(11000,"222 g de nada","Nada2"));
        regRestaurante.setAtrMenuEspecial(listaPlatos);
        restaurante.add(regRestaurante);
    }

    @Override
    public String addMenuSemanal(ArrayList<Plato> menuSemanal) {
        try{
            restaurante.get(0).setAtrMenuSemanal(menuSemanal);
            String nombresPlatos = "";
            for (int i = 0; i < menuSemanal.size(); i++) {
                nombresPlatos += menuSemanal.get(i).getAtrNombre() + "/";
            }
            return "correcto";
        }catch(Exception e){
            return e.toString();
        }      
    }
}
