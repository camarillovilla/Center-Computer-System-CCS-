package domain;

import java.util.Objects;

/**
 * 
 * @author daniCV
 */

public class Responsable {
    private String nombreCompleto;
    private long numeroTelefonico;
    private String turno; 
    private String contrasena; 
    private String nombreJefeCentroComputo;

    public Responsable(String nombreCompleto, long numeroTelefonico, String turno, String contrasena, String nombreJefeCentroComputo) {
        this.nombreCompleto = nombreCompleto;
        this.numeroTelefonico = numeroTelefonico;
        this.turno = turno;
        this.contrasena = contrasena;
        this.nombreJefeCentroComputo = nombreJefeCentroComputo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public long getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public String getTurno() {
        return turno;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombreJefeCentroComputo() {
        return nombreJefeCentroComputo;
    }
    
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setNumeroTelefonico(long numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setNombreJefeCentroComputo(String nombreJefeCentroComputo) {
        this.nombreJefeCentroComputo = nombreJefeCentroComputo;
    }

    @Override
    public String toString() {
        return "Responsable{" + "nombreCompleto=" + nombreCompleto + ", numeroTelefonico=" + numeroTelefonico + ", turno=" + turno + ", contrasena=" + contrasena + ", nombreJefeCentroComputo=" + nombreJefeCentroComputo + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Responsable other = (Responsable) obj;
        if (!Objects.equals(this.nombreCompleto, other.nombreCompleto)) {
            return false;
        }
        if (this.numeroTelefonico != other.numeroTelefonico) {
            return false;
        }
        if (!Objects.equals(this.turno, other.turno)) {
            return false;
        }
        if (!Objects.equals(this.contrasena, other.contrasena)) {
            return false;
        }
        if (!Objects.equals(this.nombreJefeCentroComputo, other.nombreJefeCentroComputo)) {
            return false;
        }
        return true;
    }
}
