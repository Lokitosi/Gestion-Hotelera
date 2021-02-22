package Database;

import java.sql.*;

/**
 * 
 * @author Alba Consuelo Nieto
*/

public class ServiceLocator {
    private static ServiceLocator instance = null;
    private Connection connection = null;
    private boolean freeConnection = true;

    /* Constructor */
    private ServiceLocator() throws Exception {
        try {
            String url = "jdbc:postgresql://localhost:5432/Hotel";
            String usuario = "postgres";
            String password = "juliono1999";
            Class.forName("org.postgresql.Driver").newInstance();
            connection = DriverManager.getConnection(url, usuario, password);
            connection.setAutoCommit(false);
        } catch (Exception e) {
            throw new CaException("ServiceLocator", "ERROR_CONEXION_BD " + e);
        }
    }
        
    /* Getters */
    public static ServiceLocator getInstance() {
        if (instance == null) {
            try {
                instance = new ServiceLocator();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return instance;
    }
	

    /* Connection */
    public synchronized Connection takeConnection() {
        while (!freeConnection) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        freeConnection = false;
        notify();
        return connection;
    }

    public synchronized void releaseConnection() {
        while (freeConnection) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        freeConnection = true;
        notify();
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* Changing database */
    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
