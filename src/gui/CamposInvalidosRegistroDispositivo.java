package gui;

/**
 * 
 * @author daniCV
 */

public class CamposInvalidosRegistroDispositivo {
    
    private boolean categoriaDispositivoValida;
    private boolean claveDispositivoValida;
    private boolean descripcionDispositivoValida;
    private boolean estatusDispositivoValido;
    private boolean fechaIngresoDispositivoValida;
    private boolean lugarProyectorControlValida;
    private boolean claveProyectorControlValida;

    public CamposInvalidosRegistroDispositivo(boolean categoriaDispositivoValida, boolean claveDispositivoValida, boolean descripcionDispositivoValida, boolean estatusDispositivoValido, boolean fechaIngresoDispositivoValida, boolean lugarProyectorControlValida, boolean claveProyectorControlValida) {
        this.categoriaDispositivoValida = categoriaDispositivoValida;
        this.claveDispositivoValida = claveDispositivoValida;
        this.descripcionDispositivoValida = descripcionDispositivoValida;
        this.estatusDispositivoValido = estatusDispositivoValido;
        this.fechaIngresoDispositivoValida = fechaIngresoDispositivoValida;
        this.lugarProyectorControlValida = lugarProyectorControlValida;
        this.claveProyectorControlValida = claveProyectorControlValida;
    }

    public CamposInvalidosRegistroDispositivo(boolean categoriaDispositivoValida) {
        this.categoriaDispositivoValida = categoriaDispositivoValida;
    }   
        
    public CamposInvalidosRegistroDispositivo() {
    }

    public boolean getCategoriaDispositivoValida() {
        return categoriaDispositivoValida;
    }

    public boolean getClaveDispositivoValida() {
        return claveDispositivoValida;
    }

    public boolean getDescripcionDispositivoValida() {
        return descripcionDispositivoValida;
    }

    public boolean getEstatusDispositivoValido() {
        return estatusDispositivoValido;
    }

    public boolean getFechaIngresoDispositivoValida() {
        return fechaIngresoDispositivoValida;
    }

    public boolean getLugarProyectorControlValida() {
        return lugarProyectorControlValida;
    }
    
    public boolean getClaveProyectorControlValida() {
        return claveDispositivoValida;
    }
    
    public void setCategoriaDispositivoValida(boolean categoriaDispositivoValida) {
        this.categoriaDispositivoValida = categoriaDispositivoValida;
    }

    public void setClaveDispositivoValida(boolean claveDispositivoValida) {
        this.claveDispositivoValida = claveDispositivoValida;
    }

    public void setDescripcionDispositivoValida(boolean descripcionDispositivoValida) {
        this.descripcionDispositivoValida = descripcionDispositivoValida;
    }

    public void setEstatusDispositivoValido(boolean estatusDispositivoValido) {
        this.estatusDispositivoValido = estatusDispositivoValido;
    }

    public void setFechaIngresoDispositivoValida(boolean fechaIngresoDispositivoValida) {
        this.fechaIngresoDispositivoValida = fechaIngresoDispositivoValida;
    }

    public void setLugarProyectorControlValida(boolean lugarProyectorControlValida) {
        this.lugarProyectorControlValida = lugarProyectorControlValida;
    }
    
    public void setClaveProyectorControlValida(boolean claveProyectorControlValida) {
        this.claveProyectorControlValida = claveProyectorControlValida;
    }
}
