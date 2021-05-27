package businesslogic;

import domain.Devolucion;
import java.util.ArrayList;

/**
 * 
 * @author daniCV
 */

public interface IDevolucionDAO {
    public int registrarDevolucion(Devolucion devolucion);
    public ArrayList<Devolucion> consultarListaDevoluciones(); 
}
