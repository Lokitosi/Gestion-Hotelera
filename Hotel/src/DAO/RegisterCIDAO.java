package DAO;

import java.sql.*;

import Data.DBConnection;
import Logic.Person;
import Logic.RegisterCI;
import Logic.Reservation;

/**
 *
 * @author Julian Sanchez
 */
public class RegisterCIDAO {
    
    private DBConnection connection;
    private RegisterCI registerci;
    private Reservation reservation;
    private Person person;
    
    /*Constructor*/

    public RegisterCIDAO() {
        connection = new DBConnection();
        registerci = new RegisterCI();
        person = new Person();
        reservation = new Reservation();   
    }
    
    /* Setters */

    public void setRegisterCI(RegisterCI registerci) {
        this.registerci = registerci;
    }
    
    /* Getters */
    public String getMessage(){
        return connection.getMessage();
    }

    public RegisterCI getRegisterCi() {
        return registerci;
    }
    
    public ResultSet getRegisterCIByID (String id) throws SQLException {
        PreparedStatement pState = connection.getConnection().prepareStatement("SELECT k_registro, k_codigo, k_numeroid,"
                + "k_tipo, f_inicio, f_salida FROM registroci WHERE k_registro = ?");
        
        pState.setString(1, id); 
        ResultSet res = pState.executeQuery();
        return res;
    }
    
    /* CRUD */
    public void insertRegisterCI() {
      try {
      
        PreparedStatement pState = connection.getConnection().prepareStatement("INSERT INTO registroci (k_registro, k_codigo, k_numeroid,"
                + "k_tipo, f_inicio, f_salida) values(?,?,?,?,?,?)");
        
            pState.setString(1, registerci.getK_registro());
            pState.setString(2, reservation.getK_codigo());
            pState.setInt(3, person.getK_numeroid());
            pState.setString(4, person.getK_tipo());
            pState.setString(6, registerci.getF_inicio());
            pState.setString(7, registerci.getF_salida());
            
            pState.executeUpdate();
      } catch (SQLException e) {
          System.out.println("ERROR: " + e);
      }
    }
    
    public void updateRegisterCI() {
        try {
            PreparedStatement pState = connection.getConnection().prepareStatement("UPDATE registroci SET f_inicio = ?, f_ salida= ?, "
                    + " WHERE k_registro = ?");
            
            pState.setString(1, registerci.getF_inicio());
            pState.setString(2, registerci.getF_salida());
            pState.setString(3, registerci.getK_registro());
            pState.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
    }
    
    public void deleteRegisterCI() {}
       
}
