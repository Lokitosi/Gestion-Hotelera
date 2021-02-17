package DAO;

/**
 *
 * @author Julian Sanchez
*/

import java.sql.*;

import Database.*;
import Logic.Phone;
import Logic.Person;

public class PhoneDAO {
    private Phone phone;
    private Person person;

    /* Constructor*/
    public PhoneDAO() {
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
    public Phone getPhone(){
        return phone;
    }

    public Person getPerson() {
        return person;
    }
    
    public void getPhoneByID() throws CaException {   
        try{
            String strSQL = "SELECT k_numeroid, k_tipo, k_telefono FROM telefono WHERE k_numeroid = ? AND k_tipo = ?";
            
            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);
            
            pState.setInt(1, person.getK_numeroid());  
            pState.setString(2, person.getK_tipo());
            
            ResultSet res = pState.executeQuery();
        
            while (res.next()){
                person.setK_numeroid(res.getInt(1));
                person.setK_tipo(res.getString(2)); 
                phone.setK_telefono(res.getInt(3));
            }
        } catch(SQLException e) {
            throw new CaException("PhoneDAO", "No pudo recuperar el teléfono " + e.getMessage());
        }
    }
    
    /* CRUD */
    public void insertPhone() throws CaException {
        try {
            String strSQL = "INSERT INTO telefono (k_numeroid, k_tipo, k_telefono) values (?,?,?)";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);

            pState.setInt(1, person.getK_numeroid());
            pState.setString(2, person.getK_tipo());
            pState.setInt(3, phone.getK_telefono());

            pState.executeUpdate();
            pState.close();
            
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("PersonDAO", "No pudo insertar la persona " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void updatePhone() {}
    
    public void deletePhone() {}
    
}
