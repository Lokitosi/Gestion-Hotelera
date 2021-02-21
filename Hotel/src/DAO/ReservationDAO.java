package DAO;

import java.sql.*;

import Database.*;
import Logic.Bill;
import Logic.Hotel;
import Logic.Person;
import Logic.Reservation;

public class ReservationDAO {
    private Reservation reservation;
    private Person person;
    private Hotel hotel;
    private Bill bill;
    
    
    /* Constructor */
    public ReservationDAO() {
        reservation = new Reservation();
        person = new Person();
    }
    
    /* Setters */
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    
    /* Getters */
    public Reservation getReservation() {
        return reservation;
    }

    public Person getPerson() {
        return person;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Bill getBill() {
        return bill;
    }
    
    public int getAllReservations() throws CaException {
        int registers = 0;
        
        try{
            String strSQL = "SELECT k_codigo, k_idhotel, k_numeroid, k_tipo, k_cuenta, f_inicio, q_duracion, i_estado, q_cantpersonas FROM reserva";
            
            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL); 
            
            ResultSet res = pState.executeQuery();
        
            while (res.next()){
                registers +=1;
            }
        } catch(SQLException e) {
            throw new CaException("ReservationDAO", "No pudo recuperar las reservaciones " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().releaseConnection();
        }
        
        return registers;
    }
    
    public void getReservationByID( String K_codigo) throws CaException { 
        try{
            String strSQL = "SELECT k_codigo, k_idhotel, k_numeroid, k_tipo, k_cuenta, f_inicio, q_duracion, i_estado, q_cantpersonas "
                    + "FROM reserva WHERE k_codigo = ?";
            
            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);
            
            pState.setString(1, K_codigo);
            
            ResultSet res = pState.executeQuery();
        
            while (res.next()){
                reservation.setK_codigo(res.getString(1));
                hotel.setK_idHotel(res.getString(2));
                person.setK_numeroid(res.getInt(3));
                person.setK_tipo(res.getString(4));
                bill.setK_cuenta(res.getString(5));
                reservation.setF_inicio(res.getString(6));
                reservation.setQ_duracion(res.getShort(7));
                reservation.setI_estado(res.getString(8));
                reservation.setQ_cantPersonas(res.getShort(9)); 
            }
        } catch(SQLException e) {
            throw new CaException("ReservationDAO", "No pudo recuperar la reservación " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().releaseConnection();
        }
    }
    
    public void getCodeReservation (String k_numeroid) throws CaException{
        try {
            String strSQL  = "SELECT k_codigo FROM reserva WHERE k_numeroid = ?";
            
            Connection connection = ServiceLocator.getInstance().takeConnection();
            PreparedStatement pState = connection.prepareStatement(strSQL);
            
            pState.setString(1, k_numeroid);
            
            ResultSet res = pState.executeQuery();
            
            while (res.next()){
                reservation.setK_codigo(res.getString(1));
            }
        } catch(SQLException e) {
            throw new CaException("ReservationDAO", "No pudo recuperar el codigo de reserva " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().releaseConnection();
        }
            
    }    
    
    /* CRUD */
    public void insertReservation() throws CaException {
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
    
    public void updateReservation() throws CaException {  
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
    
    public void deleteReservation() {}
}
