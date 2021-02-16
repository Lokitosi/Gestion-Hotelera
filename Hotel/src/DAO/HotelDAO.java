
package DAO;

/**
 *
 * @author Santiago Galindo
 */

import java.sql.*;

import Data.DBConnection;
import Logic.Hotel;


public class HotelDAO {
    private DBConnection connection;
    private Hotel hotel;
    
    /* Constructor */
    public HotelDAO() {
        connection = new DBConnection();
        hotel = new Hotel();
    }
    
    /* Setters */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    
    /* Getters */
    public String getMessage() {
        return connection.getMessage();
    }
    
    public Hotel getHotel() {
        return hotel;
    }
    
    public ResultSet getRoomByID(int id) throws SQLException {
        PreparedStatement pState = connection.getConnection().prepareStatement("SELECT k_idHotel, t_descuento, q_restriccionAforo FROM hotel WHERE k_idHotel = ?");
        
        pState.setInt(1, id); 
        ResultSet res = pState.executeQuery();
        return res;
    }
    
    /* CRUD */
    public void insertHotel() {
      try {
      
        PreparedStatement pState = connection.getConnection().prepareStatement("INSERT INTO hotel (k_idHotel, t_descuento, q_restriccionAforo) values(?,?)");
        
            pState.setString(1, hotel.getK_idHotel());
            pState.setShort(2, hotel.getT_descuento());
            pState.setShort(3, hotel.getQ_restriccionAforo());
            
            pState.executeUpdate();
      } catch (SQLException e) {
          System.out.println("ERROR: " + e);
      }
    }
    
    public void updateHotel() {
        try {
            PreparedStatement pState = connection.getConnection().prepareStatement("UPDATE hotel SET K_idHotel = ? WHERE t_descuento = ?");
            
            pState.setString(1, hotel.getK_idHotel());
            pState.setShort(2, hotel.getT_descuento());
            pState.setShort(3, hotel.getQ_restriccionAforo());

            pState.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
    }
    
    public void deleteHotel() {}
}

