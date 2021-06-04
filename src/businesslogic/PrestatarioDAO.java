package businesslogic;

import businesslogic.IPrestatarioDAO;
import businesslogic.DispositivoDAO;
import dataaccess.Conexion;
import domain.Prestamo;
import domain.Prestatario;
import java.sql.Date;
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

public class PrestatarioDAO implements IPrestatarioDAO {
    private final Conexion conexion = new Conexion();

    
    @Override
    public int registrarPrestatario(Prestatario prestatario) {
        String query = "INSERT INTO borrower (Name, Kind, Enrollment) VALUES (?, ?, ?)";
        int result = 0;
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(query);
            preparedStatement.setString(1, prestatario.getNombreCompleto());
            preparedStatement.setString(2, prestatario.getTipoPrestatario());
            preparedStatement.setString(3, prestatario.getMatricula());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PrestatarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return result;
    }
    
    public ArrayList<Prestatario> consultarListaPrestarios() {
        String query = "SELECT idBorrower, Name, Kind, Enrollment FROM borrower";
        ArrayList<Prestatario> arrayListPrestatarios = new ArrayList<>();     
        try {
            Statement statement = conexion.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                arrayListPrestatarios.add(new Prestatario(resultSet.getInt("idBorrower"), resultSet.getString("Name"), resultSet.getString("Kind"), resultSet.getString("Enrollment"))); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return arrayListPrestatarios;
    }
    
    @Override
    public int registrarPrestamo(Prestamo prestamo) {
        String query = "INSERT INTO loans (Place, LoanDate, DeviceKeyCode, Borrower_idBorrower, Responsable_ResponsableFullName) VALUES (?, ?, ?, ?, ?)";
        String fechaPrestamo = (new SimpleDateFormat("yyyy-MM-dd").format(prestamo.getFechaPrestamo()));
        int result = 0;
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(query);
            preparedStatement.setString(1, prestamo.getLugar());
            preparedStatement.setString(2, fechaPrestamo);
            preparedStatement.setString(3, prestamo.getClaveDispositivoPrestado());
            preparedStatement.setInt(4, prestamo.getPrestatarioId());
            preparedStatement.setString(5, prestamo.getNombreRegistra());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PrestatarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return result;
    }
}
