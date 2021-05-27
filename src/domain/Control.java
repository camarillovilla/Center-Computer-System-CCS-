package domain;

import java.util.Date;
import java.util.Objects;

/**
 * 
 * @author daniCV
 */

public class Control extends Dispositivo {
    private String lugarProyector;
    private String claveProyector;

    public Control(String clave, String descripcion, String estatus, Date fechaIngreso, String lugarProyector, String claveProyector, String nombreRegistro) {
        super(clave, descripcion, estatus, fechaIngreso, nombreRegistro);
        this.lugarProyector = lugarProyector;
        this.claveProyector = claveProyector;
    }
    
    public String getLugarProyector() {
        return lugarProyector;
    }

    public String getClaveProyector() {
        return claveProyector;
    }
    
    public void setLugarProyector(String lugarProyector) {
        this.lugarProyector = lugarProyector;
    }

    public void setClaveProyector(String claveProyector) {
        this.claveProyector = claveProyector;
    }

    @Override
    public String toString() {
        return "Control{" + "lugarProyector=" + lugarProyector + ", claveProyector=" + claveProyector + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Control other = (Control) obj;
        if (!Objects.equals(this.lugarProyector, other.lugarProyector)) {
            return false;
        }
        if (!Objects.equals(this.claveProyector, other.claveProyector)) {
            return false;
        }
        return true;
    }  
}
