package domain;

import java.util.Objects;

/**
 * 
 * @author daniCV
 */

public class Prestatario {
    private int prestatarioId;
    private String nombreCompleto;
    private String tipoPrestatario; 
    private String matricula; 

    public Prestatario(int prestatarioId, String nombreCompleto, String tipoPrestatario, String matricula) {
        this.prestatarioId = prestatarioId;
        this.nombreCompleto = nombreCompleto;
        this.tipoPrestatario = tipoPrestatario;
        this.matricula = matricula;
    }

    public Prestatario(String nombreCompleto, String tipoPrestatario, String matricula) {
        this.nombreCompleto = nombreCompleto;
        this.tipoPrestatario = tipoPrestatario;
        this.matricula = matricula;
    }
    
    public int getPrestatarioId() {
        return prestatarioId;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getTipoPrestatario() {
        return tipoPrestatario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setPrestatarioId(int prestatarioId) {
        this.prestatarioId = prestatarioId;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setTipoPrestatario(String tipoPrestatario) {
        this.tipoPrestatario = tipoPrestatario;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Prestatario{" + "prestatarioId=" + prestatarioId + ", nombreCompleto=" + nombreCompleto + ", tipoPrestatario=" + tipoPrestatario + ", matricula=" + matricula + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.prestatarioId;
        hash = 53 * hash + Objects.hashCode(this.nombreCompleto);
        hash = 53 * hash + Objects.hashCode(this.tipoPrestatario);
        hash = 53 * hash + Objects.hashCode(this.matricula);
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
        final Prestatario other = (Prestatario) obj;
        if (this.prestatarioId != other.prestatarioId) {
            return false;
        }
        if (!Objects.equals(this.nombreCompleto, other.nombreCompleto)) {
            return false;
        }
        if (!Objects.equals(this.tipoPrestatario, other.tipoPrestatario)) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }
}
