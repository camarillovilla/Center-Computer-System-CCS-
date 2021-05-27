package gui;

/**
 * 
 * @author daniCV
 */

class CamposInvalidosRegistroPrestamo {
    private boolean lugarPrestamoValido;
    private boolean nombrePrestatarioValido;
    private boolean tipoPrestatarioValido;
    private boolean numeroPersonalPrestatarioValido;

    public CamposInvalidosRegistroPrestamo(boolean lugarPrestamoValido, boolean nombrePrestatarioValido, boolean tipoPrestatarioValido, boolean numeroPersonalPrestatarioValido) {
        this.lugarPrestamoValido = lugarPrestamoValido;
        this.nombrePrestatarioValido = nombrePrestatarioValido;
        this.tipoPrestatarioValido = tipoPrestatarioValido;
        this.numeroPersonalPrestatarioValido = numeroPersonalPrestatarioValido;
    }

    public boolean getLugarPrestamoValido() {
        return lugarPrestamoValido;
    }

    public boolean getNombrePrestatarioValido() {
        return nombrePrestatarioValido;
    }

    public boolean getTipoPrestatarioValido() {
        return tipoPrestatarioValido;
    }

    public boolean getNumeroPersonalPrestatarioValido() {
        return numeroPersonalPrestatarioValido;
    }

    public void setLugarPrestamoValido(boolean lugarPrestamoValido) {
        this.lugarPrestamoValido = lugarPrestamoValido;
    }

    public void setNombrePrestatarioValido(boolean nombrePrestatarioValido) {
        this.nombrePrestatarioValido = nombrePrestatarioValido;
    }

    public void setTipoPrestatarioValido(boolean tipoPrestatarioValido) {
        this.tipoPrestatarioValido = tipoPrestatarioValido;
    }

    public void setNumeroPersonalPrestatarioValido(boolean numeroPersonalPrestatarioValido) {
        this.numeroPersonalPrestatarioValido = numeroPersonalPrestatarioValido;
    }
}