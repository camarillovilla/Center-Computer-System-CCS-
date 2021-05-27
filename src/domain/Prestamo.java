package domain;

import java.util.Date;
import java.util.Objects;

/**
 * 
 * @author daniCV
 */

public class Prestamo {
    private int prestamoId;
    private String lugar;
    private Date fechaPrestamo;
    private String claveDispositivoPrestado;
    private int prestatarioId;
    private String nombreRegistra; 

    public Prestamo(int prestamoId, String lugar, Date fechaPrestamo, String claveDispositivoPrestado, int prestatarioId, String nombreRegistra) {
        this.prestamoId = prestamoId;
        this.lugar = lugar;
        this.fechaPrestamo = fechaPrestamo;
        this.claveDispositivoPrestado = claveDispositivoPrestado;
        this.prestatarioId = prestatarioId;
        this.nombreRegistra = nombreRegistra;
    }

    public Prestamo(String lugar, Date fechaPrestamo, String claveDispositivoPrestado, int prestatarioId, String nombreRegistra) {
        this.lugar = lugar;
        this.fechaPrestamo = fechaPrestamo;
        this.claveDispositivoPrestado = claveDispositivoPrestado;
        this.prestatarioId = prestatarioId;
        this.nombreRegistra = nombreRegistra;
    }

    public int getPrestamoId() {
        return prestamoId;
    }
    
    public String getLugar() {
        return lugar;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public String getClaveDispositivoPrestado() {
        return claveDispositivoPrestado;
    }

    public int getPrestatarioId() {
        return prestatarioId;
    }

    public String getNombreRegistra() {
        return nombreRegistra;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }
    
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setClaveDispositivoPrestado(String claveDispositivoPrestado) {
        this.claveDispositivoPrestado = claveDispositivoPrestado;
    }

    public void setPrestatarioId(int prestatarioId) {
        this.prestatarioId = prestatarioId;
    }

    public void setNombreRegistra(String nombreRegistra) {
        this.nombreRegistra = nombreRegistra;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "prestamoId=" + prestamoId + ", lugar=" + lugar + ", fechaPrestamo=" + fechaPrestamo + ", claveDispositivoPrestado=" + claveDispositivoPrestado + ", prestatarioId=" + prestatarioId + ", nombreRegistra=" + nombreRegistra + '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prestamo other = (Prestamo) obj;
        if (this.prestamoId != other.prestamoId) {
            return false;
        }
        if (!Objects.equals(this.lugar, other.lugar)) {
            return false;
        }
        if (!Objects.equals(this.fechaPrestamo, other.fechaPrestamo)) {
            return false;
        }
        if (!Objects.equals(this.claveDispositivoPrestado, other.claveDispositivoPrestado)) {
            return false;
        }
        if (this.prestatarioId != other.prestatarioId) {
            return false;
        }
        if (!Objects.equals(this.nombreRegistra, other.nombreRegistra)) {
            return false;
        }
        return true;
    }
}
