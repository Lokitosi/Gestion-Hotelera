/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Santiago Galindo
 */

import java.sql.*;

import Data.DBConnection;
import Logic.Consumption;
public class ConsumptionDAO {
    
    private DBConnection connection;
    private Consumption consumption;
    
    /* Constructor */
    public ConsumptionDAO() {
        connection = new DBConnection();
        consumption = new Consumption();
    }
    
    /* Setters */
    public void setConsumption(Consumption consumption) {
        this.consumption = consumption;
    }
    
    /* Getters */
    public String getMessage() {
        return connection.getMessage();
    }
    
    public Consumption getConsumption() {
        return consumption;
    }
    
    public ResultSet getConsumptionByID(int id) throws SQLException {
        PreparedStatement pState = connection.getConnection().prepareStatement("SELECT k_id_consumo, n_nombre, i_tipo, "
                + "i_unidad, q_stock, v_valor FROM consumption WHERE k_id_consumo = ?");
        
        pState.setInt(1, id); 
        ResultSet res = pState.executeQuery();
        return res;
    }
    
    /* CRUD */
    public void insertConsumption() {
      try {
      
        PreparedStatement pState = connection.getConnection().prepareStatement("INSERT INTO reserva (k_id_consumo, n_nombre, i_tipo, "
                + "i_unidad, q_stock, v_valor) values(?,?,?,?,?)");
        
            pState.setString(1, consumption.getK_id_consumo());
            pState.setString(2, consumption.getN_nombre());
            pState.setString(3, consumption.getI_tipo());
            pState.setString(4, consumption.getI_unidad());
            pState.setShort(5, consumption.getQ_stock());
            pState.setDouble(6, consumption.getV_valor());
            
            pState.executeUpdate();
      } catch (SQLException e) {
          System.out.println("ERROR: " + e);
      }
    }
    
    public void updateConsumption() {
        try {
            PreparedStatement pState = connection.getConnection().prepareStatement("UPDATE consumption SET n_nombre = ?, i_tipo = ?, "
                    + "i_unidad = ?, q_stock = ?, v_valor = ? WHERE k_id_consumo = ?");
            
            pState.setString(1, consumption.getK_id_consumo());
            pState.setString(2, consumption.getN_nombre());
            pState.setChar(3, consumption.getI_tipo());
            pState.setChar(4, consumption.getI_unidad());
            pState.setShort(5, consumption.getQ_stock());
            pState.setDouble(6, consumption.getV_valor());

            pState.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
    }
    
    public void deleteConsumption() {}
    
}
