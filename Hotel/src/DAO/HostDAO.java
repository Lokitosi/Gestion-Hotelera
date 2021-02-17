package DAO;

import java.sql.*;

import Data.DBConnection;
import Logic.Host;
import Logic.Person;
/**
 *
 * @author Julian Sanchez
 */
public class HostDAO {
    
    private DBConnection connection;
    private Person person;
    private Host host;
    
    /* Constructor */

    public HostDAO() {
        connection = new DBConnection();
        person = new Person();
        host = new Host();   
    }
    
    /* Setters */
    public void setPerson(Person person) {
        this.person = person;
    }

    public void setHost(Host host) {
        this.host = host;
    }
    
    /* Getters */
    
    public String getMessage() {
        return connection.getMessage();
    }
    
    public Host getHost() {
        return host;
    }
    
    public ResultSet getHostByID(int id,String type) throws SQLException {
        PreparedStatement pState = connection.getConnection().prepareStatement("SELECT k_numeroid, k_tipo,"
                +" f_nacimiento, n_direccion FROM reserva WHERE k_numeroid = ? AND k_tipo = ?");
        
        pState.setInt(1, id);
        pState.setString(2,type);
        ResultSet res = pState.executeQuery();
        return res;
    }
    
    /* CRUD */
    public void insertHost() {
      try {
      
        PreparedStatement pState = connection.getConnection().prepareStatement("INSERT INTO huesped (k_numeroid, k_tipo," 
                + "f_nacimiento, n_direccion) values (?,?,?,?)");
        
            pState.setInt(1, person.getK_numeroid());
            pState.setString(2, person.getK_tipo());
            pState.setString(3, host.getF_nacimiento());
            pState.setString(4, host.getN_direccion());
            
            pState.executeUpdate();
      } catch (SQLException e) {
          System.out.println("ERROR: " + e);
      }
    }
    
    public void updateHost() {
        try {
            PreparedStatement pState = connection.getConnection().prepareStatement("UPDATE huesped SET f_nacimiento = ?,"
                +" n_direccion = ?  WHERE k_numeroid = ? AND k_tipo = ?");
            
            pState.setString(1, host.getF_nacimiento());
            pState.setString(2, host.getN_direccion());
            
            pState.setInt(3, person.getK_numeroid());
            pState.setString(4, person.getK_tipo());

            pState.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
    }
    
    public void deleteHost() {}
}
