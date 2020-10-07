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

   
    @Test
    public void testCreateMenuSmanal() {  
        System.out.println("CrearMenuSemanal");      
        ArrayList<Plato> menu = new ArrayList<Plato>();
        Plato regPlato1 = new Plato();
        Plato regPlato2 = new Plato(10000,"Descripcion","Nombre");
        menu.add(regPlato1);
        menu.add(regPlato2);
        IRestauranteRepository repo = Factory.getInstance().getRepository();
        RestauranteService instance = new RestauranteService(repo);
        ArrayList nombresPlatos = instance.addMenuSemanal(menu);
        assertEquals(null, nombresPlatos.get(0));
        assertEquals("Nombre", nombresPlatos.get(1));
        assertEquals(2, nombresPlatos.size());
    }    
    
}
