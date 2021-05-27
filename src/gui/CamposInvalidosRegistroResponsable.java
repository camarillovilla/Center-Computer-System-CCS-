package gui;

/**
 * 
 * @author daniCV
 */
public class CamposInvalidosRegistroResponsable {
    private boolean nombreValido;
    private boolean turnoValido;
    private boolean contrasenaValida; 
    private boolean confirmacionContrasenaValida;
    private boolean numeroTelefonicoResponsable;
    private boolean contrasenasIguales;

    public CamposInvalidosRegistroResponsable(boolean nombreValido, boolean turnoValido, boolean contrasenaValida, boolean confirmacionContrasenaValida, boolean numeroTelefonicoResponsable, boolean contrasenasIguales) {
        this.nombreValido = nombreValido;
        this.turnoValido = turnoValido;
        this.contrasenaValida = contrasenaValida;
        this.confirmacionContrasenaValida = confirmacionContrasenaValida;
        this.numeroTelefonicoResponsable = numeroTelefonicoResponsable;
        this.contrasenasIguales = contrasenasIguales;
    }

    public boolean getNombreValido() {
        return nombreValido;
    }

    public boolean getTurnoValido() {
        return turnoValido;
    }

    public boolean getContrasenaValida() {
        return contrasenaValida;
    }

    public boolean getConfirmacionContrasenaValida() {
        return confirmacionContrasenaValida;
    }

    public boolean getNumeroTelefonicoResponsable() {
        return numeroTelefonicoResponsable;
    }

    public boolean getContrasenasIguales() {
        return contrasenasIguales;
    }

    public void setNombreValido(boolean nombreValido) {
        this.nombreValido = nombreValido;
    }

    public void setTurnoValido(boolean turnoValido) {
        this.turnoValido = turnoValido;
    }

    public void setContrasenaValida(boolean contrasenaValida) {
        this.contrasenaValida = contrasenaValida;
    }

    public void setConfirmacionContrasenaValida(boolean confirmacionContrasenaValida) {
        this.confirmacionContrasenaValida = confirmacionContrasenaValida;
    }

    public void setNumeroTelefonicoResponsable(boolean numeroTelefonicoResponsable) {
        this.numeroTelefonicoResponsable = numeroTelefonicoResponsable;
    }

    public void setContrasenasIguales(boolean contrasenasIguales) {
        this.contrasenasIguales = contrasenasIguales;
    }
}
