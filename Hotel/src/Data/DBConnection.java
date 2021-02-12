package Data;

/**
 * 
 * @author William Alejandro Ardila Sánchez
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static String bd = "Hotel";
    static String login = "root";
    static String password = "11122001";
    static String url = "jdbc:mysql://localhost/"+bd;
    static String message = "";
    
    Connection connection = null;
    
    /* Constructor*/
    public DBConnection() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,login,password);

            if (connection!=null){
                System.out.println("Conexión a base de datos "+bd+" OK");
            }
        }catch(SQLException | ClassNotFoundException e){
            message = e.getMessage();
        }
    }
    
    /* Setters */
    public static void setMessage(String mensaje) {
        DBConnection.message = mensaje;
    }
    
    /* Getters */
    public static String getMessage() {
        return message;
    }

    public Connection getConnection(){
        return connection;
    }

    /* Disconnect */
    public void disconnect(){
        connection = null;
    }
}
