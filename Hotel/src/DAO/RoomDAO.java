package DAO;

/**
 * 
 * @author William Alejandro Ardila Sánchez
*/

import java.sql.*;

import Data.DBConnection;
import Logic.Room;

public class RoomDAO {
    private DBConnection connection;
    private Room room;
    
    /* Constructor */
    public RoomDAO() {
        connection = new DBConnection();
        room = new Room();
    }
    
    /* Setters */
    public void setRoom(Room room) {
        this.room = room;
    }
    
    /* Getters */
    public String getMessage() {
        return connection.getMessage();
    }
    
    public Room getRoom() {
        return room;
    }
    
    public ResultSet getRoomByID(int id) throws SQLException {
        PreparedStatement pState = connection.getConnection().prepareStatement("SELECT k_numero, i_estado FROM habitacion WHERE k_numero = ?");
        
        pState.setInt(1, id); 
        ResultSet res = pState.executeQuery();
        return res;
    }
    
    /* CRUD */
    public void insertRoom() {
      try {
      
        PreparedStatement pState = connection.getConnection().prepareStatement("INSERT INTO habitacion (k_numero, i_estado) values(?,?)");
        
            pState.setString(1, room.getK_numero());
            pState.setString(2, room.getI_estado());
            
            pState.executeUpdate();
      } catch (SQLException e) {
          System.out.println("ERROR: " + e);
      }
    }
    
    public void updateRoom() {
        try {
            PreparedStatement pState = connection.getConnection().prepareStatement("UPDATE habitacion SET i_estado = ? WHERE k_numero = ?");
            
            pState.setString(1, room.getI_estado());
            pState.setString(1, room.getK_numero());

            pState.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
    }
    
    public void deleteRoom() {}
}
