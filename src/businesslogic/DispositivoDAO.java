package businesslogic;

import dataaccess.Conexion;
import domain.Cable;
import domain.Conector;
import domain.Control;
import domain.Dispositivo;
import domain.Laptop;
import domain.Proyector;
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

public class DispositivoDAO implements IDispositivoDAO {
    private final Conexion conexion = new Conexion();

    @Override
    public int registrarNuevoCable(Cable cable) {
        String query = "INSERT INTO cable (DeviceKeyCode, Description, AdmissionDate, Status, DepartmentHead_Name) VALUES (?, ?, ?, ?, ?)";
        String fechaRegistro = (new SimpleDateFormat("yyyy-MM-dd").format(cable.getFechaIngreso()));
        int result = 0;
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(query);
            preparedStatement.setString(1, cable.getClave());
            preparedStatement.setString(2, cable.getDescripcion());
            preparedStatement.setString(3, fechaRegistro);
            preparedStatement.setString(4, cable.getEstatus());
            preparedStatement.setString(5, cable.getNombreRegistro());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return result;
    }

    @Override
    public int registrarNuevoConector(Conector conector) {
        String query = "INSERT INTO conector (DeviceKeyCode, Description, AdmissionDate, Status, DepartmentHead_Name) VALUES (?, ?, ?, ?, ?)";
        String fechaRegistro = (new SimpleDateFormat("yyyy-MM-dd").format(conector.getFechaIngreso()));
        int result = 0;
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(query);
            preparedStatement.setString(1, conector.getClave());
            preparedStatement.setString(2, conector.getDescripcion());
            preparedStatement.setString(3, fechaRegistro);
            preparedStatement.setString(4, conector.getEstatus());
            preparedStatement.setString(5, conector.getNombreRegistro());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return result;
    }

    @Override
    public int registrarNuevoControl(Control control) {
        String query = "INSERT INTO control (DeviceKeyCode, Description, AdmissionDate, Status, ProjectorPlace, ProjectorKeycode, DepartmentHead_Name) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String fechaRegistro = (new SimpleDateFormat("yyyy-MM-dd").format(control.getFechaIngreso()));
        int result = 0;
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(query);
            preparedStatement.setString(1, control.getClave());
            preparedStatement.setString(2, control.getDescripcion());
            preparedStatement.setString(3, fechaRegistro);
            preparedStatement.setString(4, control.getEstatus());
            preparedStatement.setString(5, control.getLugarProyector());
            preparedStatement.setString(6, control.getClaveProyector());
            preparedStatement.setString(7, control.getNombreRegistro());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return result;
    }

    @Override
    public int registrarNuevaLapatop(Laptop laptop) {
        String query = "INSERT INTO laptop (DeviceKeyCode, Description, AdmissionDate, Status, DepartmentHead_Name) VALUES (?, ?, ?, ?, ?)";
        String fechaRegistro = (new SimpleDateFormat("yyyy-MM-dd").format(laptop.getFechaIngreso()));
        int result = 0;
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(query);
            preparedStatement.setString(1, laptop.getClave());
            preparedStatement.setString(2, laptop.getDescripcion());
            preparedStatement.setString(3, fechaRegistro);
            preparedStatement.setString(4, laptop.getEstatus());
            preparedStatement.setString(5, laptop.getNombreRegistro());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return result;
    }

    @Override
    public int registrarNuevoProyector(Proyector proyector) {
        String query = "INSERT INTO projector (DeviceKeyCode, Description, AdmissionDate, Status, DepartmentHead_Name) VALUES (?, ?, ?, ?, ?)";
        String fechaRegistro = (new SimpleDateFormat("yyyy-MM-dd").format(proyector.getFechaIngreso()));
        int result = 0;
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(query);
            preparedStatement.setString(1, proyector.getClave());
            preparedStatement.setString(2, proyector.getDescripcion());
            preparedStatement.setString(3, fechaRegistro);
            preparedStatement.setString(4, proyector.getEstatus());
            preparedStatement.setString(5, proyector.getNombreRegistro());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return result;
    }

    @Override
    public ArrayList<Dispositivo> consultarTodosDispositivos() {
        String query = "SELECT DeviceKeyCode, Description, AdmissionDate, Status, DepartmentHead_Name FROM dispositivo";
        ArrayList<Dispositivo> arrayListDispositivos = new ArrayList<>();     
        try {
            Statement statement = conexion.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                arrayListDispositivos.add(new Dispositivo(resultSet.getString("DeviceKeyCode"), resultSet.getString("Description"), resultSet.getString("Status"), resultSet.getDate("AdmissionDate"), resultSet.getString("Departmenthead_Name"))); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return arrayListDispositivos;
    }
    
    @Override
    public ArrayList<Cable> consultarListaCables() {
        String query = "SELECT DeviceKeyCode, Description, AdmissionDate, Status, DepartmentHead_Name FROM cable";
        ArrayList<Cable> arrayListCables = new ArrayList<>();     
        try {
            Statement statement = conexion.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                arrayListCables.add(new Cable(resultSet.getString("DeviceKeyCode"), resultSet.getString("Description"), resultSet.getString("Status"), resultSet.getDate("AdmissionDate"), resultSet.getString("Departmenthead_Name"))); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return arrayListCables;
    }
    
    @Override
    public ArrayList<Conector> consultarListaConectores() {
        String query = "SELECT DeviceKeyCode, Description, AdmissionDate, Status, DepartmentHead_Name FROM conector";
        ArrayList<Conector> arrayListConectores = new ArrayList<>();     
        try {
            Statement statement = conexion.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                arrayListConectores.add(new Conector(resultSet.getString("DeviceKeyCode"), resultSet.getString("Description"), resultSet.getString("Status"), resultSet.getDate("AdmissionDate"), resultSet.getString("Departmenthead_Name"))); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return arrayListConectores;
    }
    
    @Override
    public ArrayList<Control> consultarListaControles() {
        String query = "SELECT DeviceKeyCode, Description, AdmissionDate, Status, ProjectorPlace, ProjectorKeyCode, DepartmentHead_Name FROM control";
        ArrayList<Control> arrayListControles = new ArrayList<>();     
        try {
            Statement statement = conexion.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                arrayListControles.add(new Control(resultSet.getString("DeviceKeyCode"), resultSet.getString("Description"), resultSet.getString("Status"), resultSet.getDate("AdmissionDate"), resultSet.getString("ProjectorPlace"), resultSet.getString("ProjectorKeyCode"), resultSet.getString("Departmenthead_Name"))); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return arrayListControles;
    }
    
    @Override
    public ArrayList<Laptop> consultarListaLaptops() {
        String query = "SELECT DeviceKeyCode, Description, AdmissionDate, Status, DepartmentHead_Name FROM laptop";
        ArrayList<Laptop> arrayListLaptops = new ArrayList<>();     
        try {
            Statement statement = conexion.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                arrayListLaptops.add(new Laptop(resultSet.getString("DeviceKeyCode"), resultSet.getString("Description"), resultSet.getString("Status"), resultSet.getDate("AdmissionDate"), resultSet.getString("Departmenthead_Name"))); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return arrayListLaptops;
    }
    
    @Override
    public ArrayList<Proyector> consultarListaProyectores() {
        String query = "SELECT DeviceKeyCode, Description, AdmissionDate, Status, DepartmentHead_Name FROM projector";
        ArrayList<Proyector> arrayListProyectores = new ArrayList<>();     
        try {
            Statement statement = conexion.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                arrayListProyectores.add(new Proyector(resultSet.getString("DeviceKeyCode"), resultSet.getString("Description"), resultSet.getString("Status"), resultSet.getDate("AdmissionDate"), resultSet.getString("Departmenthead_Name"))); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return arrayListProyectores;
    }
    
    @Override
    public int cambiarEstatusPrestadoCable(Cable cable) {
        String query = "UPDATE cable SET Status = 'Prestado' WHERE (DeviceKeyCode = ?)";
        int result = 0;
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(query);
            preparedStatement.setString(1, cable.getClave());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return result;
    }
    
    @Override
    public int cambiarEstatusPrestadoConector(Conector conector) {
        String query = "UPDATE conector SET Status = 'Prestado' WHERE DeviceKeyCode = ?";
        int result = 0;
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(query);
            preparedStatement.setString(1, conector.getClave());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return result;
    }
    
    @Override
    public int cambiarEstatusPrestadoLaptop(Laptop laptop) {
        String query = "UPDATE laptop SET Status = 'Prestado' WHERE DeviceKeyCode = ?";
        int result = 0;
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(query);
            preparedStatement.setString(1, laptop.getClave());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return result;
    }
    
    @Override
    public int cambiarEstatusPrestadoProyector(Proyector proyector) {
        String query = "UPDATE projector SET Status = 'Prestado' WHERE DeviceKeyCode = ?";
        int result = 0;
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(query);
            preparedStatement.setString(1, proyector.getClave());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return result;
    }
    
    @Override
    public int cambiarEstatusPrestadoControl(Control control) {
        String query = "UPDATE control SET Status = 'Prestado' WHERE DeviceKeyCode = ?";
        int result = 0;
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(query);
            preparedStatement.setString(1, control.getClave());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return result;
    }
    
    
    @Override
    public int cambiarEstatusDisponibleCable(String clave) {
        String query = "UPDATE cable SET Status = 'Disponible' WHERE (DeviceKeyCode = ?)";
        int result = 0;
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(query);
            preparedStatement.setString(1, clave);
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return result;
    }
    
    @Override
    public int cambiarEstatusDisponibleConector(String clave) {
        String query = "UPDATE conector SET Status = 'Disponible' WHERE DeviceKeyCode = ?";
        int result = 0;
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(query);
            preparedStatement.setString(1, clave);
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return result;
    }
    
    @Override
    public int cambiarEstatusDisponibleLaptop(String clave) {
        String query = "UPDATE laptop SET Status = 'Disponible' WHERE DeviceKeyCode = ?";
        int result = 0;
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(query);
            preparedStatement.setString(1, clave);
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return result;
    }
    
    @Override
    public int cambiarEstatusDisponibleProyector(String clave) {
        String query = "UPDATE projector SET Status = 'Disponible' WHERE DeviceKeyCode = ?";
        int result = 0;
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(query);
            preparedStatement.setString(1, clave);
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return result;
    }
    
    @Override
    public int cambiarEstatusDisponibleControl(String clave) {
        String query = "UPDATE control SET Status = 'Disponible' WHERE DeviceKeyCode = ?";
        int result = 0;
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(query);
            preparedStatement.setString(1, clave);
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.disconnect();
        }
        return result;
    }
}
