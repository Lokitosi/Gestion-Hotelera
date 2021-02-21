package DAO;

/**
 *
 * @author Julian Sanchez
*/

import java.sql.*;

import Database.*;
import Logic.Host;

public class HostDAO {
    private Host host;
    
    /* Constructor */
    public HostDAO() {
        host = new Host();   
    }
    
    /* Setters */
    public void setHost(Host host) {
        this.host = host;
    }
    
    /* Getters */
    public Host getHost() {
        return host;
    }
    
    public void getHostByID() throws CaException {
        try{
            String strSQL = "SELECT k_numeroid, k_tipo, f_nacimiento, n_direccion FROM reserva WHERE k_numeroid = ? AND k_tipo = ?";
            
            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);
            
            pState.setLong(1, host.getK_numeroid());  
            pState.setString(2, host.getK_tipo());    
            
            ResultSet res = pState.executeQuery();
        
            while (res.next()){
                host.setK_numeroid(res.getInt(1));
                host.setK_tipo(res.getString(2)); 
                host.setF_nacimiento(res.getString(3)); 
                host.setN_direccion(res.getString(4)); 
            }
        } catch(SQLException e) {
            throw new CaException("HostDAO", "No pudo recuperar el huésped " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    /* CRUD */
    public void insertHost() throws CaException {
        try {
            String strSQL = "INSERT INTO huesped (k_numeroid, k_tipo, f_nacimiento, n_direccion) values (?,?,TO_DATE(?,'DD/MM/YYYY'),?)";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);

            pState.setLong(1, host.getK_numeroid());
            pState.setString(2, host.getK_tipo());
            pState.setString(3, host.getF_nacimiento());
            pState.setString(4, host.getN_direccion());

            pState.executeUpdate();
            pState.close();
            
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("HostDAO", "No pudo insertar el huésped " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void updateHost() throws CaException {
        try {
            String strSQL = "UPDATE huesped SET f_nacimiento = ?, n_direccion = ?  WHERE k_numeroid = ? AND k_tipo = ?";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);

            pState.setString(1, host.getF_nacimiento());
            pState.setString(2, host.getN_direccion());
            pState.setLong(3, host.getK_numeroid());
            pState.setString(4, host.getK_tipo());

            pState.executeUpdate();
            pState.close();
            
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("HostDAO", "No pudo actualizar el huésped " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void deleteHost() {}
}
