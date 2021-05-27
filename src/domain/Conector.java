package domain;

import java.util.Date;

/**
 * 
 * @author daniCV
 */ 

public class Conector extends Dispositivo {

    public Conector(String clave, String descripcion, String estatus, Date fechaIngreso, String nombreRegistro) {
        super(clave, descripcion, estatus, fechaIngreso, nombreRegistro);
    }
    
}
