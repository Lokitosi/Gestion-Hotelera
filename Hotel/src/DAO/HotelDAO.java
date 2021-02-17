package DAO;

/**
 *
 * @author Santiago Galindo
*/

import java.sql.*;

import Database.*;
import Logic.Hotel;

public class HotelDAO {
    private Hotel hotel;
    
    /* Constructor */
    public HotelDAO() {
        hotel = new Hotel();
    }
    
    /* Setters */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    
    /* Getters */  
    public Hotel getHotel() {
        return hotel;
    }
    
    public void getHotelByID() throws CaException {
        try{
            String strSQL = "SELECT k_idHotel, t_descuento, q_restriccionAforo FROM hotel WHERE k_idHotel = ?";
            
            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);
            
            pState.setString(1, hotel.getK_idHotel());    
            
            ResultSet res = pState.executeQuery();
        
            while (res.next()){
                hotel.setK_idHotel(res.getString(1));
                hotel.setT_descuento(res.getShort(2)); 
                hotel.setQ_restriccionAforo(res.getShort(3)); 
            }
        } catch(SQLException e) {
            throw new CaException("HotelDAO", "No pudo recuperar el hotel " + e.getMessage());
        }
    }
    
    /* CRUD */
    public void insertHotel() throws CaException {
        try {
            String strSQL = "INSERT INTO hotel (k_idHotel, t_descuento, q_restriccionAforo) values(?,?)";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);

            pState.setString(1, hotel.getK_idHotel());
            pState.setShort(2, hotel.getT_descuento());
            pState.setShort(3, hotel.getQ_restriccionAforo()); 

            pState.executeUpdate();
            pState.close();
            
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("HotelDAO", "No pudo insertar el hotel " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void updateHotel() throws CaException {
        try {
            String strSQL = "UPDATE hotel SET t_descuento = ?, q_restriccionAforo = ? WHERE k_idHotel = ?";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);
            
            pState.setShort(1, hotel.getT_descuento());
            pState.setShort(2, hotel.getQ_restriccionAforo()); 
            pState.setString(3, hotel.getK_idHotel());

            pState.executeUpdate();
            pState.close();
            
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("HotelDAO", "No pudo actualizar el hotel " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void deleteHotel() {}
}

