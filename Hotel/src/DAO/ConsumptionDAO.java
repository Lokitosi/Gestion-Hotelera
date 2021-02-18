package DAO;

/**
 *
 * @author Santiago Galindo
*/

import java.sql.*;

import Database.*;
import Logic.Consumption;

public class ConsumptionDAO {
    private Consumption consumption;
    
    /* Constructor */
    public ConsumptionDAO() {
        consumption = new Consumption();
    }
    
    /* Setters */
    public void setConsumption(Consumption consumption) {
        this.consumption = consumption;
    }
    
    /* Getters */
    public Consumption getConsumption() {
        return consumption;
    }
    
    public void getConsumptionByID() throws CaException {
        try{
            String strSQL = "SELECT k_id_consumo, n_nombre, i_tipo, i_unidad, q_stock, v_valor FROM consumo WHERE k_id_consumo = ?";
            
            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);
            
            pState.setString(1, consumption.getK_id_consumo());  
            
            ResultSet res = pState.executeQuery();
        
            while (res.next()){
                consumption.setK_id_consumo(res.getString(1));
                consumption.setN_nombre(res.getString(2)); 
                consumption.setI_tipo(res.getString(3)); 
                consumption.setI_unidad(res.getString(4)); 
                consumption.setQ_stock(res.getShort(5)); 
                consumption.setV_valor(res.getDouble(5)); 
            }
        } catch(SQLException e) {
            throw new CaException("ConsumptionDAO", "No pudo recuperar el consumo " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    /* CRUD */
    public void insertConsumption() throws CaException {
        try {
            String strSQL = "INSERT INTO consumo(k_id_consumo, n_nombre, i_tipo, i_unidad, q_stock, v_valor) values(?,?,?,?,?.?)";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);

            pState.setString(1, consumption.getK_id_consumo());
            pState.setString(2, consumption.getN_nombre());
            pState.setString(3, consumption.getI_tipo());
            pState.setString(4, consumption.getI_unidad());
            pState.setShort(5, consumption.getQ_stock());
            pState.setDouble(6, consumption.getV_valor());

            pState.executeUpdate();
            pState.close();
            
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("ConsumptionDAO", "No pudo insertar el consumo " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void updateConsumption() throws CaException {
        try {
            String strSQL = "UPDATE consumption SET n_nombre = ?, i_tipo = ?, i_unidad = ?, q_stock = ?, v_valor = ? WHERE k_id_consumo = ?";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);

            pState.setString(1, consumption.getN_nombre());
            pState.setString(2, consumption.getI_tipo());
            pState.setString(3, consumption.getI_unidad());
            pState.setShort(4, consumption.getQ_stock());
            pState.setDouble(5, consumption.getV_valor());
            pState.setString(6, consumption.getK_id_consumo());

            pState.executeUpdate();
            pState.close();
            
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("ConsumptionDAO", "No pudo actualizar el consumo " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void deleteConsumption() {}
    
}
