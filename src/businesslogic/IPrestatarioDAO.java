package businesslogic;

import domain.Prestamo;
import domain.Prestatario;
import java.util.ArrayList;

/**
 * 
 * @author daniCV
 */

public interface IPrestatarioDAO {
    public int registrarPrestatario(Prestatario prestatario); 
    public ArrayList<Prestatario> consultarListaPrestarios();
    public int registrarPrestamo(Prestamo prestamo);
}
