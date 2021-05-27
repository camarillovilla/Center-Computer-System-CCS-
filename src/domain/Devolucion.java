package domain;

import java.util.Date;
import java.util.Objects;

/**
 * 
 * @author daniCV
 */

public class Devolucion {
    private int idDevolucion; 
    private Date fechaDevolucion;
    private String claveDispositivo;
    private int idPrestatario;
    private String nombreRegistro; 

    public Devolucion(int idDevolucion, Date fechaDevolucion, String claveDispositivo, int idPrestatario, String nombreRegistro) {
        this.idDevolucion = idDevolucion;
        this.fechaDevolucion = fechaDevolucion;
        this.claveDispositivo = claveDispositivo;
        this.idPrestatario = idPrestatario;
        this.nombreRegistro = nombreRegistro;
    }

    public Devolucion(Date fechaDevolucion, String claveDispositivo, int idPrestatario, String nombreRegistro) {
        this.fechaDevolucion = fechaDevolucion;
        this.claveDispositivo = claveDispositivo;
        this.idPrestatario = idPrestatario;
        this.nombreRegistro = nombreRegistro;
    }

    public int getIdDevolucion() {
        return idDevolucion;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public String getClaveDispositivo() {
        return claveDispositivo;
    }

    public int getIdPrestatario() {
        return idPrestatario;
    }

    public String getNombreRegistro() {
        return nombreRegistro;
    }

    public void setIdDevolucion(int idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setClaveDispositivo(String claveDispositivo) {
        this.claveDispositivo = claveDispositivo;
    }

    public void setIdPrestatario(int idPrestatario) {
        this.idPrestatario = idPrestatario;
    }

    public void setNombreRegistro(String nombreRegistro) {
        this.nombreRegistro = nombreRegistro;
    }

    @Override
    public String toString() {
        return "Devolucion{" + "idDevolucion=" + idDevolucion + ", fechaDevolucion=" + fechaDevolucion + ", claveDispositivo=" + claveDispositivo + ", idPrestatario=" + idPrestatario + ", nombreRegistro=" + nombreRegistro + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Devolucion other = (Devolucion) obj;
        if (this.idDevolucion != other.idDevolucion) {
            return false;
        }
        if (!Objects.equals(this.fechaDevolucion, other.fechaDevolucion)) {
            return false;
        }
        if (!Objects.equals(this.claveDispositivo, other.claveDispositivo)) {
            return false;
        }
        if (this.idPrestatario != other.idPrestatario) {
            return false;
        }
        if (!Objects.equals(this.nombreRegistro, other.nombreRegistro)) {
            return false;
        }
        return true;
    }
}
