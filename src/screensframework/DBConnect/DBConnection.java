package screensframework.DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    private static Connection conn;
    private static String url = "jdbc:postgresql://localhost:5432/JAVA_PROJECT_TEST";
    private static String user = "postgres";
    private static String pass = "yeika";
    
    public static Connection connect() throws SQLException{
	try {
            Class.forName("org.postgresql.Driver").newInstance();
	} catch(ClassNotFoundException cnfe) {
            System.err.println("Error: "+cnfe.getMessage());
	} catch(InstantiationException ie) {
            System.err.println("Error: "+ie.getMessage());
	} catch(IllegalAccessException iae) {
            System.err.println("Error: "+iae.getMessage());
	}
        
        return conn = DriverManager.getConnection(url,user,pass);
    }
	
    public static Connection getConnection() throws SQLException {
        if(conn != null && !conn.isClosed()){
            return DBConnection.conn;
        }
        else{
            return DBConnection.connect();
        }
    }
}
