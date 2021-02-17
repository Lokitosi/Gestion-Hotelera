package DAO;

import java.sql.*;

import Database.*;
import Logic.Type;

public class TypeDAO {
    private Type type;
    
    /* Constructor */
    public TypeDAO() {
        type = new Type();
    }
    
    /* Setters */ 
    public void setType(Type type) {
        this.type = type;
    }
    
    /* Getters */
    public Type getType() {
        return type;
    }
    
    public void getTypeByID () throws CaException {
        try{
            String strSQL = "SELECT k_idTipo, n_descripcion, v_precio FROM tipo WHERE k_idTipo = ?";
            
            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);
            
            pState.setString(1, type.getK_idTipo());    
            
            ResultSet res = pState.executeQuery();
        
            while (res.next()){
                type.setK_idTipo(res.getString(1));
                type.setN_descripcion(res.getString(2)); 
                type.setV_precio(res.getDouble(3));
            }
        } catch(SQLException e) {
            throw new CaException("TypeDAO", "No pudo recuperar el tipo de habitación " + e.getMessage());
        }
    }
    
    /* CRUD */
    public void insertType() throws CaException {
        try {
            String strSQL = "INSERT INTO tipo (k_idTipo, n_descripcion, v_precio) values(?,?,?)";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);

            pState.setString(1, type.getK_idTipo());
            pState.setString(2, type.getN_descripcion());
            pState.setDouble(3, type.getV_precio()); 

            pState.executeUpdate();
            pState.close();
            
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("TypeDAO", "No pudo insertar el tipo de habitación " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void updatePayment() throws CaException {
        try {
            String strSQL = "UPDATE tipo SET n_descripcion = ? , v_precio = ? WHERE k_idTipo = ?";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);

            pState.setString(1, type.getN_descripcion());
            pState.setDouble(2, type.getV_precio()); 
            pState.setString(3, type.getK_idTipo());

            pState.executeUpdate();
            pState.close();
            
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("TypeDAO", "No pudo actualizar el tipo de habitación " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void deleteType() {}
}
