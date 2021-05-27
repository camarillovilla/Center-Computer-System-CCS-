package businesslogic;

import dataaccess.Conexion;
import domain.Responsable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author daniCV
 */

public class ResponsableDAO implements IResponsableDAO {
    private final Conexion conexion = new Conexion();

    @Override
    public ArrayList<Responsable> consultarListaDeResponsables() {
        String query = "SELECT ResponsableFullName, PhoneNumber, Turn, Password, Departmenthead_Name FROM responsable";
        ArrayList<Responsable> arrayListResponsables = new ArrayList<>();     
        try {
            Statement statement = conexion.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                arrayListResponsables.add(new Responsable(resultSet.getString("ResponsableFullName"), resultSet.getLong("PhoneNumber"), resultSet.getString("Turn"), resultSet.getString("Password"), resultSet.getString("Departmenthead_Name"))); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return arrayListResponsables;
    }
}