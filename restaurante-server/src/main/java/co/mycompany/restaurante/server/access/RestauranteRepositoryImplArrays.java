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
        
        Restaurante regRestaurante2 = new Restaurante(9,"Cra 9 a ","CHAO");
        listaPlatos.add(new Plato(10000,"400 g de todo","todo"));
        listaPlatos.add(new Plato(11000,"222 g de todo","todo2"));
        regRestaurante2.setAtrMenuEspecial(listaPlatos);
        restaurante.add(regRestaurante2);
    }

    @Override
    public String addMenuSemanal(ArrayList<Plato> menuSemanal) {
        try{
            restaurante.get(0).setAtrMenuSemanal(menuSemanal);
            return "correcto";
        }catch(Exception e){
            return e.toString();
        }      
    }

    @Override
    public ArrayList<Plato> getMenuSemanal() {
        return restaurante.get(0).getAtrMenuSemanal();
    }
    
    public ArrayList<Restaurante> getRestaurantes() {
        ArrayList<Restaurante> Restaurantes = new ArrayList<Restaurante>();
        for (int i = 0; i < restaurante.size(); i++){
            Restaurantes.add(restaurante.get(i));
        }
        return Restaurantes;
    }
    
}
