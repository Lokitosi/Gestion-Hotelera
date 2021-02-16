package DAO;

import java.sql.*;

import Data.DBConnection;
import Logic.Payment;
import Logic.Type;

public class TypeDAO {
    private DBConnection connection;
    private Type type;
    
    /* Constructor */
    public TypeDAO() {
        connection = new DBConnection();
        type = new Type();
    }
    
    /*Getters and settes*/

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    
    
    /* CRUD */
    public void insertType() {
      try {
      
        PreparedStatement pState = connection.getConnection().prepareStatement("INSERT INTO tipo (k_idTipo, n_descripcion, v_precio)"
                + " values(?,?,?)");
        
            pState.setString(1, type.getK_idTipo());
            pState.setString(2, type.getN_descripcion());
            pState.setDouble(3, type.getV_precio()); 
            pState.executeUpdate();
      } catch (SQLException e) {
          System.out.println("ERROR: " + e);
      }
    }
    
    public void updatePayment() {
        try {
            PreparedStatement pState = connection.getConnection().prepareStatement("UPDATE tipo SET n_descripcion = ? , v_precio = ?" 
                    + "WHERE k_idTipo = ?");
            
            pState.setString(1, type.getN_descripcion());
            pState.setDouble(2, type.getV_precio()); 
            pState.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
    }
    
    public void deleteRoom() {}
}
