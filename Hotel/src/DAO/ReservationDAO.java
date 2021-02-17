package DAO;

import java.sql.*;

import Database.*;
import Logic.Reservation;

public class ReservationDAO {
    private Reservation reservation;
    
    /* Constructor */
    public ReservationDAO() {
        reservation = new Reservation();
    }
    
    /* Setters */
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
    
    /* Getters */
    public Reservation getReservation() {
        return reservation;
    }
    
    public void getRoomByID() throws CaException { 
        try{
            String strSQL = "SELECT k_codigo, f_inicio, q_duracion, i_estado, q_cantPersonas FROM reserva WHERE k_numero = ?";
            
            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);
            
            pState.setString(1, reservation.getK_codigo());
            
            ResultSet res = pState.executeQuery();
        
            while (res.next()){
                reservation.setK_codigo(res.getString(1));
                reservation.setF_inicio(res.getString(2));
                reservation.setQ_duracion(res.getShort(3));
                reservation.setI_estado(res.getString(4));
                reservation.setQ_cantPersonas(res.getShort(5)); 
            }
        } catch(SQLException e) {
            throw new CaException("ReservationDAO", "No pudo recuperar la reservación " + e.getMessage());
        } 
    }
    
    /* CRUD */
    public void insertRoom() throws CaException {
        try {
            String strSQL = "INSERT INTO reserva (k_codigo, f_inicio, q_duracion, i_estado, q_cantPersonas) values(?,?,?,?,?)";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);

            pState.setString(1, reservation.getK_codigo());
            pState.setString(2, reservation.getF_inicio());
            pState.setShort(3, reservation.getQ_duracion());
            pState.setString(4, reservation.getI_estado());
            pState.setShort(5, reservation.getQ_cantPersonas());

            pState.executeUpdate();
            pState.close();
            
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("ReservationDAO", "No pudo insertar la reservación " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void updateRoom() throws CaException {  
        try {
            String strSQL = "UPDATE reserva SET f_inicio = ?, q_duracion = ?, i_estado = ?, q_cantPersonas = ? WHERE k_codigo = ?";

            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);

            pState.setString(1, reservation.getF_inicio());
            pState.setShort(2, reservation.getQ_duracion());
            pState.setString(3, reservation.getI_estado());
            pState.setShort(4, reservation.getQ_cantPersonas());
            pState.setString(5, reservation.getK_codigo());

            pState.executeUpdate();
            pState.close();
            
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException( "ReservationDAO", "No pudo actualizar la reservación " + e.getMessage());
        }  finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void deleteRoom() {}
}
