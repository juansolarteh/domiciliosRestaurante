package co.mycompany.restaurante.server.domain;




import co.mycompany.restaurante.commons.domain.Plato;
import co.mycompany.restaurante.server.domain.services.RestauranteService;
import co.mycompany.restaurante.commons.domain.Restaurante;
import co.mycompany.restaurante.server.access.Factory;
import co.mycompany.restaurante.server.access.IRestauranteRepository;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

/**
 *
 * @author Libardo, Julio
 */
public class RestauranteServiceTest {

    Plato regPlato1 = new Plato();
    Plato regPlato2 = new Plato(10000,"Descripcion","Nombre");
    
    @Test
    public void testgetMenuSmanalVacio() {  
        System.out.println("darMenuSemanalVacio");      
        IRestauranteRepository repo = Factory.getInstance().getRepository();
        RestauranteService instance = new RestauranteService(repo);
        ArrayList<Plato> menu = instance.getMenuSemanal(); 
        assertEquals(0, menu.size());
    }   
   
    @Test
    public void testCreateMenuSmanal() {  
        System.out.println("CrearMenuSemanal");      
        ArrayList<Plato> menu = new ArrayList<Plato>();
        menu.add(regPlato1);
        menu.add(regPlato2);
        IRestauranteRepository repo = Factory.getInstance().getRepository();
        RestauranteService instance = new RestauranteService(repo);
        String resultado = instance.addMenuSemanal(menu); 
        assertEquals("correcto", resultado);
    }     
    
    @Test
    public void testgetMenuSmanal() {  
        System.out.println("darMenuSemanal");      
        IRestauranteRepository repo = Factory.getInstance().getRepository();
        RestauranteService instance = new RestauranteService(repo);
        ArrayList<Plato> menu = instance.getMenuSemanal();  
        assertEquals(regPlato1, menu.get(0));
        assertEquals(regPlato2, menu.get(1));
        assertEquals(2, menu.size());
    }  
}
