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
import Logic.Bill_Consumption;

public class Bill_ConsumptionDAO {
    
    private DBConnection connection;
    private Bill_Consumption bill_consumption;

    /* Constructor */
    public Bill_ConsumptionDAO(Bill_Consumption bill_consumption) {
        connection = new DBConnection();
        this.bill_consumption = bill_consumption;
    }
    
    /* Setters */

    public void setBill_consumption(Bill_Consumption bill_consumption) {
        this.bill_consumption = bill_consumption;
    }
    
    /* Getters */

    public DBConnection getConnection() {
        return connection;
    }

    public Bill_Consumption getBill_consumption() {
        return bill_consumption;
    }
    
    /* CRUD */
    public void insertBill_Consumption() {
      try {
      
        PreparedStatement pState = connection.getConnection().prepareStatement("INSERT INTO bill_consumption (f_consumo, q_cantidadPedida)"
                + " values(?,?)");
        
            pState.setString(1, bill_consumption.getF_consumo());
            pState.setShort(2, bill_consumption.getQ_cantidadPedida());           
            pState.executeUpdate();
      } catch (SQLException e) {
          System.out.println("ERROR: " + e);
      }
    }
    
    public void updateBill_Consumption() {
        try {
            PreparedStatement pState = connection.getConnection().prepareStatement("UPDATE cuentaConsumo SET f_consumo() = ? WHERE q_cantidadPedida = ?");
            
            pState.setString(1, bill_consumption.getF_consumo());
            pState.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
    }
    
    public void deleteBill_Consumption() {
        
    }
    
}
