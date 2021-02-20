package DAO;

import java.sql.*;

import Database.*;
import Logic.Room;
import Logic.RoomType;

public class RoomDAO {
    private Room room;
    private RoomType type;
    
    /* Constructor */
    public RoomDAO() {
        room = new Room();
        type = new RoomType();
    }
    
    /* Setters */
    public void setRoom(Room room) {
        this.room = room;
    }
    
    public void setType(RoomType type) {
        this.type = type;
    }
    
    /* Getters */
    public Room getRoom() {
        return room;
    }
    
    public RoomType getType() {
        return type;
    }
    
    public void getRoomByID(String k_numero) throws CaException {  
        try{
            String strSQL = "SELECT k_numero, k_idtipo, i_estado FROM habitacion WHERE k_numero = ?";
            
            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);
            
            pState.setString(1, k_numero); 
            
            ResultSet res = pState.executeQuery();
        
            while (res.next()){
                room.setK_numero(res.getString(1));
                type.setK_idTipo(res.getString(2));
                room.setI_estado(res.getString(3));
            }
        } catch(SQLException e) {
            throw new CaException("RoomDAO", "No pudo recuperar la habitación " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public int getAllRoomsByType(String k_idtipo) throws CaException {   
        int registers = 0;
        
        try{
            String strSQL = "SELECT k_numero, k_idtipo, i_estado FROM habitacion WHERE k_idtipo = ?";
            
            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL); 
            
            pState.setString(1, k_idtipo); 
            
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
    
    /* CRUD */
    public void insertRoom() throws CaException {
        try {
            String strSQL = "INSERT INTO habitacion (k_numero, k_idtipo, i_estado) values(?,?,?)";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);

            pState.setString(1, room.getK_numero());
            pState.setString(2, type.getK_idTipo());
            pState.setString(3, room.getI_estado());

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
