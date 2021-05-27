package gui;

/**
 * 
 * @author daniCV
 */

public class CamposInvalidosInicioSesion {
    private boolean nombreUsuarioValido;
    private boolean contrasenaUsuarioValida; 
    private boolean usuarioEncontrado;

    public CamposInvalidosInicioSesion(boolean nombreUsuarioValido, boolean contrasenaUsuarioValida, boolean usuarioEncontrado) {
        this.nombreUsuarioValido = nombreUsuarioValido;
        this.contrasenaUsuarioValida = contrasenaUsuarioValida;
        this.usuarioEncontrado = usuarioEncontrado;
    }

    public boolean getNombreUsuarioValido() {
        return nombreUsuarioValido;
    }

    public boolean getContrasenaUsuarioValida() {
        return contrasenaUsuarioValida;
    }

    public boolean getUsuarioEncontrado() {
        return usuarioEncontrado;
    }

    public void setNombreUsuarioValido(boolean nombreUsuarioValido) {
        this.nombreUsuarioValido = nombreUsuarioValido;
    }

    public void setContrasenaUsuarioValida(boolean contrasenaUsuarioValida) {
        this.contrasenaUsuarioValida = contrasenaUsuarioValida;
    }

    public void setUsuarioEncontrado(boolean usuarioEncontrado) {
        this.usuarioEncontrado = usuarioEncontrado;
    }
}
