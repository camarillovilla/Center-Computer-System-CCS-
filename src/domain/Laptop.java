package domain;

import java.util.Date;

/**
 * 
 * @author daniCV
 */

public class Laptop extends Dispositivo {

    public Laptop(String clave, String descripcion, String estatus, Date fechaIngreso, String nombreRegistro) {
        super(clave, descripcion, estatus, fechaIngreso, nombreRegistro);
    }
    
}
