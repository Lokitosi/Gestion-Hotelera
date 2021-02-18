package DAO;

import java.sql.*;

import Database.*;
import Logic.Room;

public class RoomDAO {
    private Room room;
    
    /* Constructor */
    public RoomDAO() {
        room = new Room();
    }
    
    /* Setters */
    public void setRoom(Room room) {
        this.room = room;
    }
    
    /* Getters */
    public Room getRoom() {
        return room;
    }
    
    public void getRoomByID() throws CaException {  
        try{
            String strSQL = "SELECT k_numero, i_estado FROM habitacion WHERE k_numero = ?";
            
            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);
            
            pState.setString(1, room.getK_numero()); 
            
            ResultSet res = pState.executeQuery();
        
            while (res.next()){
                room.setK_numero(res.getString(1));
                room.setI_estado(res.getString(2));
            }
        } catch(SQLException e) {
            throw new CaException("RoomDAO", "No pudo recuperar la habitación " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    /* CRUD */
    public void insertRoom() throws CaException {
        try {
            String strSQL = "INSERT INTO habitacion (k_numero, i_estado) values(?,?)";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);

            pState.setString(1, room.getK_numero());
            pState.setString(2, room.getI_estado());

            pState.executeUpdate();
            pState.close();
            
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("RoomDAO", "No pudo insertar la habitación " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void updateRoom() throws CaException {      
        try {
            String strSQL = "UPDATE habitacion SET i_estado = ? WHERE k_numero = ?";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);

            pState.setString(1, room.getI_estado());
            pState.setString(2, room.getK_numero());

            pState.executeUpdate();
            pState.close();
            
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException( "RoomDAO", "No pudo actualizar la habitación " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void deleteRoom() {}
}
