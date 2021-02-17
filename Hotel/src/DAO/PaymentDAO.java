package DAO;

import java.sql.*;

import Database.*;
import Logic.Payment;

public class PaymentDAO {
    private Payment payment;
    
    /* Constructor */
    public PaymentDAO() {
        payment = new Payment();
    }
    
    /* Setters*/
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
    /* Getters */
    public Payment getPayment() {
        return payment;
    }
    
    public void getPaymentByID () throws CaException {
        try{
            String strSQL = "SELECT k_idPago, f_pago FROM pago WHERE k_idPago = ?";
            
            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);
            
            pState.setString(1, payment.getK_idPago());    
            
            ResultSet res = pState.executeQuery();
        
            while (res.next()){
                payment.setK_idPago(res.getString(1));
                payment.setF_pago(res.getString(2)); 
            }
        } catch(SQLException e) {
            throw new CaException("PaymentDAO", "No pudo recuperar el pago " + e.getMessage());
        }
    }
    
    /* CRUD */
    public void insertPayment() throws CaException { 
        try {
            String strSQL = "INSERT INTO pago (k_idPago, f_pago) values(?,?)";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);

            pState.setString(1, payment.getK_idPago());
            pState.setString(2, payment.getF_pago()); 

            pState.executeUpdate();
            pState.close();
            
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("PaymentDAO", "No pudo insertar el pago " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void updatePayment() throws CaException {
        try {
            String strSQL = "UPDATE pago SET f_pago = ? WHERE k_idPago = ?";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);

            pState.setString(1, payment.getF_pago()); 
            pState.setString(2, payment.getK_idPago());

            pState.executeUpdate();
            pState.close();
            
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("PaymentDAO", "No pudo actualizar el pago " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void deletePayment() {}
}
