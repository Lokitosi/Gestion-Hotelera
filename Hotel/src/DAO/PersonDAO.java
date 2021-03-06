package DAO;

/**
 *
 * @author Julian Sanchez
*/

import java.sql.*;

import GUI.Ads;
import Database.*;
import Logic.Person;

public class PersonDAO {
    private Ads adWindow;
    private Person person;

    /*Constructor*/
    public PersonDAO() {    
        person = new Person();
    }
    
    /*Setters*/
    public void setPerson(Person person) {
        this.person = person;
    }
    
    /*Getters*/ 
    public Person getPerson(){
        return person;
    }
    
    public void getPersonByID (long k_numeroid, String n_nombre1, String n_apellido1) throws CaException {
        try{
            String strSQL = "SELECT k_numeroid, k_tipo, n_nombre1, " 
                +"n_nombre2, n_apellido1, n_apellido2  FROM persona WHERE k_numeroid = ? AND n_nombre1 = ? AND n_apellido1 = ?";
            
            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);
            
            pState.setLong(1, k_numeroid);  
            pState.setString(2, n_nombre1);   
            pState.setString(3, n_apellido1);  
            
            ResultSet res = pState.executeQuery();
        
            while (res.next()){
                person.setK_numeroid(res.getInt(1));
                person.setK_tipo(res.getString(2)); 
                person.setN_nombre1(res.getString(3)); 
                person.setN_nombre2(res.getString(4)); 
                person.setN_apellido1(res.getString(5)); 
                person.setN_apellido2(res.getString(6)); 
            }
        } catch(SQLException e) {
            throw new CaException("PersonDAO", "No pudo recuperar la persona " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    /* CRUD */
    public void insertPerson() throws CaException {  
        try {
            String strSQL = "INSERT INTO persona (k_numeroid, k_tipo, n_nombre1, "
                + "n_nombre2, n_apellido1, n_apellido2 ) values(?,?,?,?,?,?)";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);

            pState.setLong(1, person.getK_numeroid());
            pState.setString(2, person.getK_tipo());
            pState.setString(3, person.getN_nombre1());
            pState.setString(4, person.getN_nombre2());
            pState.setString(5, person.getN_apellido1());
            pState.setString(6, person.getN_apellido2());

            pState.executeUpdate();
            pState.close();
            
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("PersonDAO", "No pudo insertar la persona " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void updatePerson() throws CaException {
        try {
            String strSQL = "UPDATE persona SET  n_nombre1 = ?, n_nombre2 = ?,"
                + "n_apellido1 = ?, n_apellido2 = ? WHERE k_numeroid = ? AND k_tipo = ?";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);

            pState.setString(1, person.getN_nombre1());
            pState.setString(2, person.getN_nombre2());
            pState.setString(3, person.getN_apellido1());
            pState.setString(4, person.getN_apellido2());
            pState.setLong(5, person.getK_numeroid());
            pState.setString(6, person.getK_tipo());

            pState.executeUpdate();
            pState.close();
            
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException( "PersonDAO", "No pudo actualizar la persona " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void deletePerson() {}
}
