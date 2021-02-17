package DAO;

/**
 *
 * @author Julian Sanchez
*/

import java.sql.*;

import Database.*;
import Logic.RegisterCI;
import Logic.Reservation;
import Logic.Person;

public class RegisterCIDAO {
    private RegisterCI registerci;
    private Reservation reservation;
    private Person person;
    
    /*Constructor*/
    public RegisterCIDAO() {
        registerci = new RegisterCI();
        person = new Person();
        reservation = new Reservation();   
    }
    
    /* Setters */
    public void setRegisterCI(RegisterCI registerci) {
        this.registerci = registerci;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
    
    /* Getters */
    public RegisterCI getRegisterCI() {
        return registerci;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public Person getPerson() {
        return person;
    }
    
    public void getRegisterCIByID () throws CaException {
        try{
            String strSQL = "SELECT k_registro, k_codigo, k_numeroid, k_tipo, f_inicio, f_salida FROM registroci WHERE k_registro = ?";
            
            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);
            
            pState.setString(1, registerci.getK_registro());    
            
            ResultSet res = pState.executeQuery();
        
            while (res.next()){
                registerci.setK_registro(res.getString(1));
                reservation.setK_codigo(res.getString(2)); 
                person.setK_numeroid(res.getInt(3));
                person.setK_tipo(res.getString(4)); 
                registerci.setF_inicio(res.getString(5));
                registerci.setF_salida(res.getString(6));
            }
        } catch(SQLException e) {
            throw new CaException("RegisterCIDAO", "No pudo recuperar el registro check in " + e.getMessage());
        }
    }
    
    /* CRUD */
    public void insertRegisterCI() throws CaException { 
        try {
            String strSQL = "INSERT INTO registroci (k_registro, k_codigo, k_numeroid,k_tipo, f_inicio, f_salida) values(?,?,?,?,?,?)";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);

            pState.setString(1, registerci.getK_registro());
            pState.setString(2, reservation.getK_codigo());
            pState.setInt(3, person.getK_numeroid());
            pState.setString(4, person.getK_tipo());
            pState.setString(6, registerci.getF_inicio());
            pState.setString(7, registerci.getF_salida());

            pState.executeUpdate();
            pState.close();
            
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("RegisterCIDAO", "No pudo insertar el registro check in " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void updateRegisterCI() throws CaException {
        try {
            String strSQL = "UPDATE registroci SET k_codigo = ?, k_numeroid = ?, k_tipo = ?, f_inicio = ?, f_ salida= ?, WHERE k_registro = ?";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);

            pState.setString(1, reservation.getK_codigo());
            pState.setInt(2, person.getK_numeroid());
            pState.setString(3, person.getK_tipo());
            pState.setString(4, registerci.getF_inicio());
            pState.setString(5, registerci.getF_salida());
            pState.setString(6, registerci.getK_registro());

            pState.executeUpdate();
            pState.close();
            
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException( "RegisterCIDAO", "No pudo actualizar el registro check in " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void deleteRegisterCI() {}
       
}
