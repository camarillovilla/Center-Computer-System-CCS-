package businesslogic;

import domain.Cable;
import domain.Conector;
import domain.Control;
import domain.Dispositivo;
import domain.Laptop;
import domain.Proyector;
import java.util.ArrayList;

/**
 * 
 * @author daniCV
 */

public interface IDispositivoDAO {
    public int registrarNuevoCable(Cable cable);
    public int registrarNuevoConector(Conector conector);
    public int registrarNuevoControl(Control control);
    public int registrarNuevaLapatop(Laptop laptop);
    public int registrarNuevoProyector(Proyector proyector);
    public ArrayList<Dispositivo> consultarTodosDispositivos();
    public ArrayList<Cable> consultarListaCables();
    public ArrayList<Conector> consultarListaConectores();
    public ArrayList<Control> consultarListaControles();
    public ArrayList<Laptop> consultarListaLaptops();
    public ArrayList<Proyector> consultarListaProyectores();
    public int cambiarEstatusPrestadoCable(Cable cable);
    public int cambiarEstatusPrestadoConector(Conector conector);
    public int cambiarEstatusPrestadoLaptop(Laptop laptop);
    public int cambiarEstatusPrestadoProyector(Proyector proyector);
    public int cambiarEstatusPrestadoControl(Control control);
    public int cambiarEstatusDisponibleCable(String clave);
    public int cambiarEstatusDisponibleConector(String clave);
    public int cambiarEstatusDisponibleLaptop(String clave);
    public int cambiarEstatusDisponibleProyector(String clave);
    public int cambiarEstatusDisponibleControl(String clave);
}
