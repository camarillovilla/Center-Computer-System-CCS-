package businesslogic;

import domain.Prestamo;
import java.util.ArrayList;

/**
 * 
 * @author daniCV
 */

public interface IPrestamoDAO {
    public ArrayList<Prestamo> consultarPrestamos();
}
