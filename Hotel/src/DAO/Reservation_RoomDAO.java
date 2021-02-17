package DAO;

import java.sql.*;

import Database.*;
import Logic.Reservation;
import Logic.Room;

public class Reservation_RoomDAO {
    private Reservation reservation;
    private Room room;

    /* Constructor */
    public Reservation_RoomDAO() {
        reservation = new Reservation();
        room = new Room();
    }
    
    /* Setters */
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
    
    public void setRoom(Room room) {
        this.room = room;
    }
    
    /* Getters */
    public Reservation getReservation() {
        return reservation;
    }
    
    public Room getRoom() {
        return room;
    }
    
    public void getReservation_RoomByID() throws CaException {
        try{
            String strSQL = "SELECT * WHERE k_numero = ? and k_codigo = ?";
            
            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);
            
            pState.setString(1, room.getK_numero()); 
            pState.setString(2, reservation.getK_codigo());  
            
            ResultSet res = pState.executeQuery();
        
            while (res.next()){
                room.setK_numero(res.getString(1));
                reservation.setK_codigo(res.getString(2)); 
            }
        } catch(SQLException e) {
            throw new CaException("Reservation_RoomDAO", "No pudo recuperar la reservación - habitación " + e.getMessage());
        }
    }
    
    /* CRUD */
    public void insertReservation_Room() throws CaException {
        try {
            String strSQL = "INSERT INTO bill_consumption (k_numero, k_codigo) values(?,?)";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);

            pState.setString(1, room.getK_numero());
            pState.setString(2, reservation.getK_codigo()); 

            pState.executeUpdate();
            pState.close();
            
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("Reservation_RoomDAO", "No pudo insertar la reservación - habitación " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void updateReservation_Room() {}
    
    public void deleteReservation_Room() {} 
}
