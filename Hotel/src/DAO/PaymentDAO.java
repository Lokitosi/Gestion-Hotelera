package DAO;

import java.sql.*;

import Data.DBConnection;
import Logic.Payment;

public class PaymentDAO {
    private DBConnection connection;
    private Payment payment;
    
    /* Constructor */
    public PaymentDAO() {
        connection = new DBConnection();
        payment = new Payment();
    }
    
    /*getters and setters*/

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
    /* CRUD */
    public void insertPayment() {
      try {
      
        PreparedStatement pState = connection.getConnection().prepareStatement("INSERT INTO pago (k_idPago, f_pago)"
                + " values(?,?,?,?,?)");
        
            pState.setString(1, payment.getK_idPago());
            pState.setString(2, payment.getK_idPago());           
            pState.executeUpdate();
      } catch (SQLException e) {
          System.out.println("ERROR: " + e);
      }
    }
    
    public void updatePayment() {
        try {
            PreparedStatement pState = connection.getConnection().prepareStatement("UPDATE pago SET f_pago = ? WHERE k_idPago = ?");
            
            pState.setString(1, payment.getF_pago());
            pState.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
    }
    
    public void deleteRoom() {}
}
