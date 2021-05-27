package domain;

import java.util.Objects;

/**
 * 
 * @author daniCV
 */

public class JefeCentroComputo {
    private String nombreCompleto;
    private long numeroTelefonico;
    private String correo;
    private String contrasena; 

    public JefeCentroComputo(String nombreCompleto, long numeroTelefonico, String correo, String contrasena) {
        this.nombreCompleto = nombreCompleto;
        this.numeroTelefonico = numeroTelefonico;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public long getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setNumeroTelefonico(long numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "JefeCentroComputo{" + "nombreCompleto=" + nombreCompleto + ", numeroTelefonico=" + numeroTelefonico + ", correo=" + correo + ", contrasena=" + contrasena + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JefeCentroComputo other = (JefeCentroComputo) obj;
        if (!Objects.equals(this.nombreCompleto, other.nombreCompleto)) {
            return false;
        }
        if (this.numeroTelefonico != other.numeroTelefonico) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.contrasena, other.contrasena)) {
            return false;
        }
        return true;
    }
   
}
