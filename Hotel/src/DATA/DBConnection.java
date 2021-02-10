package Data;

/**
 *
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static String bd = "Hotel_4_0";
    static String login = "root";
    static String password = "11122001";
    static String url = "jdbc:mysql://localhost/"+bd;
    static String mensaje = "";
    
    Connection conexion = null;
    
    /* Constructor*/
    public DBConnection() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url,login,password);

            if (conexion!=null){
                System.out.println("Conexión a base de datos "+bd+" OK");
            }
        }catch(SQLException | ClassNotFoundException e){
            mensaje = e.getMessage();
        }
    }
    
    /* Setters */
    public static void setMensaje(String mensaje) {
        DBConnection.mensaje = mensaje;
    }
    
    /* Getters */
    public static String getMensaje() {
        return mensaje;
    }

    public Connection getConexion(){
        return conexion;
    }

    /* Disconnect */
    public void desconectar(){
        conexion = null;
    }
}
