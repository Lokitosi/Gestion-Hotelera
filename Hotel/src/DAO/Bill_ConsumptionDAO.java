package DAO;

/**
 *
 * @author Santiago Galindo
*/

import java.sql.*;

import Database.*;
import Logic.Bill;
import Logic.Consumption;
import Logic.Bill_Consumption;

public class Bill_ConsumptionDAO {
    private Bill bill;
    private Consumption consumption;
    private Bill_Consumption bill_consumption;

    /* Constructor */
    public Bill_ConsumptionDAO() {
        bill = new Bill();
        consumption = new Consumption();
        bill_consumption = new Bill_Consumption();
    }
    
    /* Setters */
    public void setBill(Bill bill) {
        this.bill = bill;
    }
    
    public void setConsumption(Consumption consumption) {
        this.consumption = consumption;
    }
    
    public void setBill_consumption(Bill_Consumption bill_consumption) {
        this.bill_consumption = bill_consumption;
    }
    
    /* Getters */
    public Bill getBill() {
        return bill;
    }
    
    public Consumption getConsumption() {
        return consumption;
    }
    
    public Bill_Consumption getBill_consumption() {
        return bill_consumption;
    }
    
    public void getBill_consumptionByID() throws CaException {
        try{
            String strSQL = "SELECT k_cuenta, k_idconsumo, f_consumo, q_cantidadPedida FROM bill_consumption WHERE k_cuenta = ? and k_idconsumo = ?";
            
            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);
            
            pState.setString(1, bill.getK_cuenta());  
            pState.setString(2, consumption.getK_id_consumo()); 
            
            ResultSet res = pState.executeQuery();
        
            while (res.next()){
                bill.setK_cuenta(res.getString(1));
                consumption.setK_id_consumo(res.getString(2)); 
                bill_consumption.setF_consumo(res.getString(3));
                bill_consumption.setQ_cantidadPedida(res.getShort(4));
            }
        } catch(SQLException e) {
            throw new CaException("Bill_ConsumptionDAO", "No pudo recuperar la cuenta - consumo " + e.getMessage());
        }
    }
    
    /* CRUD */
    public void insertBill_Consumption() throws CaException {
        try {
            String strSQL = "INSERT INTO bill_consumption (k_cuenta, k_idconsumo, f_consumo, q_cantidadPedida) values(?,?,?,?)";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);

            pState.setString(1, bill.getK_cuenta());
            pState.setString(2, consumption.getK_id_consumo()); 
            pState.setString(3, bill_consumption.getF_consumo());
            pState.setShort(4, bill_consumption.getQ_cantidadPedida());

            pState.executeUpdate();
            pState.close();
            
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("Bill_ConsumptionDAO", "No pudo insertar la cuenta - consumo " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void updateBill_Consumption() throws CaException {
        try {
            String strSQL = "UPDATE cuentaConsumo SET f_consumo() = ?, q_cantidadPedida = ? WHERE k_cuenta = ? AND k_idconsumo = ?";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);

            pState.setString(1, bill_consumption.getF_consumo());
            pState.setShort(2, bill_consumption.getQ_cantidadPedida());
            pState.setString(3, bill.getK_cuenta());
            pState.setString(4, consumption.getK_id_consumo()); 

            pState.executeUpdate();
            pState.close();
            
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("Bill_ConsumptionDAO", "No pudo actualizar la cuenta - consumo " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void deleteBill_Consumption() {}
    
}
