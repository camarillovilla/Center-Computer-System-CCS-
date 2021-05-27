package businesslogic;

import domain.JefeCentroComputo;
import domain.Responsable;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author daniCV
 */

public interface IJefeCentroComputoDAO {
    public int registrarNuevoResponsable(Responsable responsable); 
    public void generarReporteDePrestamosyDevolucionesTotales(Date fechaCualquiera);
    public ArrayList<JefeCentroComputo> consultarListaDeJefesCentroComputo();
}
