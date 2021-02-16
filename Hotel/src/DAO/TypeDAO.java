/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Data.DBConnection;
import Logic.Reservation;
import Logic.Type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author andre
 */
public class TypeDAO {

    private DBConnection connection;
    private Type type;
    
    /* Constructor */
    public TypeDAO() {
        connection = new DBConnection();
        type = new Type();
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
        
    /* CRUD */
    public void insertType() {
      try {
      
        PreparedStatement pState = connection.getConnection().prepareStatement("INSERT INTO tipo (k_codigo, f_inicio, q_duracion, "
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

}
