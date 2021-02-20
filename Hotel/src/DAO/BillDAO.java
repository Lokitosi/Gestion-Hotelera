package DAO;

import java.sql.*;

import Database.*;
import Logic.Bill;
import Logic.Payment;

public class BillDAO {
    private Bill bill;
    private Payment payment;
    
    /* Constructor */
    public BillDAO() {
        bill = new Bill();
        payment = new Payment();
    }
    
    /*Setters*/
    public void setBill(Bill bill) {
        this.bill = bill;
    }
    
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
    /*Getters*/
    public Bill getBill() {
        return bill;
    }
    
    public Payment getPayment() {
        return payment;
    }
    
    public int getAllBills() throws CaException {
        int registers = 0;
        
        try{
            String strSQL = "SELECT k_cuenta, k_idPago FROM cuenta";
            
            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL); 
            
            ResultSet res = pState.executeQuery();
        
            while (res.next()){
                registers +=1;
            }
        } catch(SQLException e) {
            throw new CaException("BillDAO", "No pudo recuperar las cuenta " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().releaseConnection();
        }
        
        return registers;
    }
    
    public void getBillByID(String k_cuenta) throws CaException {
        try{
            String strSQL = "SELECT k_cuenta, k_idPago FROM cuenta WHERE k_cuenta = ?";
            
            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);
            
            pState.setString(1, k_cuenta);  
            
            ResultSet res = pState.executeQuery();
        
            while (res.next()){
                bill.setK_cuenta(res.getString(1));
                payment.setK_idPago(res.getString(2)); 
            }
        } catch(SQLException e) {
            throw new CaException("BillDAO", "No pudo recuperar la cuenta " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    /* CRUD */  
    public void insertBill() throws CaException {
        try {
            String strSQL = "INSERT INTO cuenta (k_cuenta, k_idPago) values(?,?)";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);

            pState.setString(1, bill.getK_cuenta());
            pState.setString(2, payment.getK_idPago()); 

            pState.executeUpdate();
            pState.close();
            
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("BillDAO", "No pudo insertar la cuenta " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void updateBill() throws CaException {
        try {
            String strSQL = "UPDATE cuenta SET k_idPago = ? WHERE k_cuenta = ?";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);

            pState.setString(1, payment.getK_idPago()); 
            pState.setString(2, bill.getK_cuenta());

            pState.executeUpdate();
            pState.close();
            
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("BillDAO", "No pudo actualizar la cuenta " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void deleteBill() {}
}

