package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Jerry on 2017-03-17.
 */
// Class for connecting to database
public class DataBaseConnection {
    public Connection conn = null;

    public DataBaseConnection() {
        this.conn = null;
    }

    // Connect to mysql database
    // Make sure you have created a database called masterMatch
    public void connect() {
        try {
            // The last argument is your password
            conn = DriverManager.getConnection("jdbc:mysql://localhost/masterMatch?useSSL=false", "root", "1");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }
        catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
    }



}
