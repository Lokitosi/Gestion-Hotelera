/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;

import Data.DBConnection;
import Logic.Person;
import Logic.Phone;

/**
 *
 * @author Julian Sanchez
 */
public class PhoneDAO {
    
    private DBConnection connection;
    private Phone phone;
    private Person person;

    /* Constructor*/
    public PhoneDAO() {
       connection = new DBConnection();
       phone = new Phone();
       person = new Person();
    }
    
    /* Setters */
    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    /* Getters */
    public String getMessage() {
        return connection.getMessage();
    }
    
    public Phone getPhone(){
        return phone;
    }

    public Person getPerson() {
        return person;
    }
    
    public ResultSet getPhoneByID(int id,String type) throws SQLException {
        PreparedStatement pState = connection.getConnection().prepareStatement("SELECT k_numeroid, k_tipo,"
                +" k_telefono FROM telefono WHERE k_numeroid = ? AND k_tipo = ?");
        
        pState.setInt(1, id);
        pState.setString(2,type);
        ResultSet res = pState.executeQuery();
        return res;
    }
    
    /* CRUD */
    public void insertPhone() {
      try {
      
        PreparedStatement pState = connection.getConnection().prepareStatement("INSERT INTO telefono (k_numeroid, k_tipo," 
                + "k_telefono) values (?,?,?)");
        
            pState.setInt(1, person.getK_numeroid());
            pState.setString(2, person.getK_tipo());
            pState.setInt(3, phone.getK_telefono());
            
            pState.executeUpdate();
      } catch (SQLException e) {
          System.out.println("ERROR: " + e);
      }
    }
    
    public void updatePhone() {}
    
    public void deletePhone() {}
    
}
