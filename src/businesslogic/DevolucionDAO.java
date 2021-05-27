package businesslogic;

import dataaccess.Conexion;
import domain.Devolucion;
import domain.Prestamo;
import domain.Responsable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author daniCV
 */

public class DevolucionDAO implements IDevolucionDAO {
    private final Conexion conexion = new Conexion();

    @Override
    public int registrarDevolucion(Devolucion devolucion) {
        String query = "INSERT INTO returns (ReturnsDate, DeviceKeyCode, Borrower_idBorrower, Responsable_ResponsableFullName) VALUES (?, ?, ?, ?)";
        String fechaRegistro = (new SimpleDateFormat("yyyy-MM-dd").format(devolucion.getFechaDevolucion()));

        int result = 0;
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(query);
            preparedStatement.setString(1, fechaRegistro);
            preparedStatement.setString(2, devolucion.getClaveDispositivo());
            preparedStatement.setInt(3, devolucion.getIdPrestatario());
            preparedStatement.setString(4, devolucion.getNombreRegistro());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DevolucionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return result;
    }

    @Override
    public ArrayList<Devolucion> consultarListaDevoluciones() {
        String query = "SELECT ReturnsDate, DeviceKeyCode, Borrower_idBorrower, Responsable_ResponsableFullName FROM returns";
        ArrayList<Devolucion> arrayListDevoluciones = new ArrayList<>();     
        try {
            Statement statement = conexion.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                arrayListDevoluciones.add(new Devolucion(resultSet.getDate("ReturnsDate"), resultSet.getString("DeviceKeyCode"), resultSet.getInt("Borrower_idBorrower"), resultSet.getString("Responsable_ResponsableFullName"))); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(DevolucionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return arrayListDevoluciones;
    }
}
