package businesslogic;

import dataaccess.Conexion;
import domain.JefeCentroComputo;
import domain.Responsable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 * 
 * @author daniCV
 */

public class JefeCentroComputoDAO implements IJefeCentroComputoDAO {
    private final Conexion conexion = new Conexion();
    
    @Override
    public int registrarNuevoResponsable(Responsable responsable) {
        String query = "INSERT INTO responsable (ResponsableFullName, PhoneNumber, Turn, Password, DepartmentHead_Name) VALUES (?, ?, ?, ?, ?)";
        int result = 0;
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(query);
            preparedStatement.setString(1, responsable.getNombreCompleto());
            preparedStatement.setLong(2, responsable.getNumeroTelefonico());
            preparedStatement.setString(3, responsable.getTurno());
            preparedStatement.setString(4, responsable.getContrasena());
            preparedStatement.setString(5, responsable.getNombreJefeCentroComputo());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JefeCentroComputoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return result;
    }
    
    @Override
    public void generarReporteDePrestamosyDevolucionesTotales(Date fechaCualquiera) {
        
    }
    
    @Override
    public ArrayList<JefeCentroComputo> consultarListaDeJefesCentroComputo() {
        String query = "SELECT Name, PhoneNumber, Email, Password FROM departmenthead";
        ArrayList<JefeCentroComputo> arrayListJefeCentroComputo = new ArrayList<>();     
        try {
            Statement statement = conexion.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                arrayListJefeCentroComputo.add(new JefeCentroComputo(resultSet.getString("Name"), resultSet.getLong("PhoneNumber"), resultSet.getString("Email"), resultSet.getString("Password"))); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(JefeCentroComputoDAO.class.getName()).log(Level.SEVERE, null, ex);
            /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campos inválidos en el formulario");        
            alert.setHeaderText("Existen campos invalidos en el formulario");
            alert.setContentText("Revisa los campos del formulario");
            alert.show();*/
        } finally {
            conexion.disconnect();
        }
        return arrayListJefeCentroComputo;
    }
}
