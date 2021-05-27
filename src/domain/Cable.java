package domain;

import java.util.Date;

/**
 * 
 * @author daniCV
 */

public class Cable extends Dispositivo{
    public Cable(String clave, String descripcion, String estatus, Date fechaIngreso, String nombreRegistro) {
        super(clave, descripcion, estatus, fechaIngreso, nombreRegistro);
    }
}
