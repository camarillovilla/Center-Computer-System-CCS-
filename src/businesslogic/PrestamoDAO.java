/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package businesslogic;

import dataaccess.Conexion;
import domain.Prestamo;
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
public class PrestamoDAO implements IPrestamoDAO {
    private final Conexion conexion = new Conexion();

    @Override
    public ArrayList<Prestamo> consultarPrestamos() {
        String query = "SELECT Place, LoanDate, DeviceKeycode, Borrower_idBorrower, Responsable_ResponsableFullName FROM loans";
        ArrayList<Prestamo> arrayListPrestamos = new ArrayList<>();     
        try {
            Statement statement = conexion.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                arrayListPrestamos.add(new Prestamo(resultSet.getString("Place"), resultSet.getDate("LoanDate"), resultSet.getString("DeviceKeyCode"), resultSet.getInt("Borrower_idBorrower"), resultSet.getString("Responsable_ResponsableFullName"))); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResponsableDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return arrayListPrestamos;
    }   
}