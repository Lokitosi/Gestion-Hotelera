package DAO;

import java.sql.*;
import Data.DBConnection;
import Logic.Bill;

public class BillDAO {
    private DBConnection connection;
    private Bill bill;
    
    /* Constructor */
    public BillDAO() {
        connection = new DBConnection();
        bill = new Bill();
    }
    
    /*Getters*/
    public String getMessage() {
        return connection.getMessage();
    }
    
    public Bill getBill() {
        return bill;
    }
    
    /*Setters*/
    public void setBill(Bill bill) {
        this.bill = bill;
    }
    
    /* CRUD */
    public void insertBill() {
      try {
      
        PreparedStatement pState = connection.getConnection().prepareStatement("INSERT INTO cuenta (k_cuenta, k_idPago)"
                + " values(?,?)");
        
            pState.setString(1, bill.getK_cuenta());
            pState.setString(2, bill.getId_Pago());           
            pState.executeUpdate();
      } catch (SQLException e) {
          System.out.println("ERROR: " + e);
      }
    }
    
    public void updateBill() {
        try {
            PreparedStatement pState = connection.getConnection().prepareStatement("UPDATE cuenta SET k_idPago = ? WHERE k_cuenta = ?");
            
            pState.setString(1, bill.getId_Pago());
            pState.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
    }
    
    public void deleteBill() {}
}

