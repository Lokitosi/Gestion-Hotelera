package DAO;

import java.sql.*;

import Data.DBConnection;
import Logic.Reservation;

public class ReservationDAO {
    private DBConnection connection;
    private Reservation reservation;
    
    /* Constructor */
    public ReservationDAO() {
        connection = new DBConnection();
        reservation = new Reservation();
    }
    
    /* Setters */
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
    
    /* Getters */
    public String getMessage() {
        return connection.getMessage();
    }
    
    public Reservation getReservation() {
        return reservation;
    }
    
    public ResultSet getRoomByID(String id) throws SQLException {
        PreparedStatement pState = connection.getConnection().prepareStatement("SELECT k_codigo, f_inicio, q_duracion, "
                + "i_estado, q_cantPersonas FROM reserva WHERE k_numero = ?");
        
        pState.setString(1, id);  
        ResultSet res = pState.executeQuery();
        return res;
    }
    
    /* CRUD */
    public void insertRoom() {
      try {
      
        PreparedStatement pState = connection.getConnection().prepareStatement("INSERT INTO reserva (k_codigo, f_inicio, q_duracion, "
                + "i_estado, q_cantPersonas) values(?,?,?,?,?)");
        
            pState.setString(1, reservation.getK_codigo());
            pState.setString(2, reservation.getF_inicio());
            pState.setInt(3, reservation.getQ_duracion());
            pState.setString(4, reservation.getI_estado());
            pState.setInt(5, reservation.getQ_cantPersonas());
            
            pState.executeUpdate();
      } catch (SQLException e) {
          System.out.println("ERROR: " + e);
      }
    }
    
    public void updateRoom() {
        try {
            PreparedStatement pState = connection.getConnection().prepareStatement("UPDATE reserva SET f_inicio = ?, q_duracion = ?, "
                    + "i_estado = ?, q_cantPersonas = ? WHERE k_codigo = ?");
            
            pState.setString(1, reservation.getF_inicio());
            pState.setInt(2, reservation.getQ_duracion());
            pState.setString(3, reservation.getI_estado());
            pState.setInt(4, reservation.getQ_cantPersonas());
            pState.setString(5, reservation.getK_codigo());

            pState.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
    }
    
    public void deleteRoom() {}
}
