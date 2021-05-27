package domain;

import java.util.Date;
import java.util.Objects;

/**
 * 
 * @author daniCV
 */

public class Dispositivo {
    private String clave;
    private String descripcion; 
    private String estatus;
    private Date fechaIngreso;
    private String nombreRegistro; 

    public Dispositivo(String clave, String descripcion, String estatus, Date fechaIngreso, String nombreRegistro) {
        this.clave = clave;
        this.descripcion = descripcion;
        this.estatus = estatus;
        this.fechaIngreso = fechaIngreso;
        this.nombreRegistro = nombreRegistro;
    }

    public String getClave() {
        return clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstatus() {
        return estatus;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public String getNombreRegistro() {
        return nombreRegistro;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setNombreRegistro(String nombreRegistro) {
        this.nombreRegistro = nombreRegistro;
    }

    @Override
    public String toString() {
        return "Dispositivo{" + "clave=" + clave + ", descripcion=" + descripcion + ", estatus=" + estatus + ", fechaIngreso=" + fechaIngreso + ", nombreRegistro=" + nombreRegistro + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dispositivo other = (Dispositivo) obj;
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.estatus, other.estatus)) {
            return false;
        }
        if (!Objects.equals(this.fechaIngreso, other.fechaIngreso)) {
            return false;
        }
        if (!Objects.equals(this.nombreRegistro, other.nombreRegistro)) {
            return false;
        }
        return true;
    }
}
