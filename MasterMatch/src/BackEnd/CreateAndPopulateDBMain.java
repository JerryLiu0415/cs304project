package BackEnd;

import java.sql.*;

/**
 * Created by Jerry on 2017-03-17.
 */
public class CreateAndPopulateDBMain {
    
    // Run to populate your database
    public static void main(String[] args) {
        DataBaseConnection dbconn = new DataBaseConnection();
        dbconn.connect();
        ResultSet rs = null;
        
        
        try {
            Statement stmt = dbconn.conn.createStatement();
            
            // Delete all tables before re-creating later (child table must go before parent)
            String sql = "DROP TABLE STUDENTS, USERS";
            stmt.executeUpdate(sql);
            
            String addUserSchema =
            "CREATE TABLE USERS(" +
            "uid INT NOT NULL," +
            "uname VARCHAR (40) NOT NULL," +
            "age INT," +
            "gender CHAR (1)," +
            "address VARCHAR (40)," +
            "email VARCHAR (30) NOT NULL," +
            "phone INT," +
            "isInstructor BOOLEAN," +
            "isBlocked BOOLEAN," +
            "bio VARCHAR (500)," +
            "PRIMARY KEY (uid)," +
            "CONSTRAINT email_unique UNIQUE(email))";
            
            //cleanTable(dbconn.conn, "USERS");
            stmt.execute(addUserSchema);
            
            // Populate tuple after schemas are created
            String insertUser =
            "INSERT INTO USERS " +
            "(uid, uname, age, gender, address, email, phone, isInstructor, isBlocked) " +
            "VALUES " +
            "(101, 'Jerry Liu', 2, 'M', '2205 Lower Mall', 'jl@gmail.com', 778101101, FALSE, FALSE)";
            stmt.execute(insertUser);
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            // Create student table
            Statement stmtstu = dbconn.conn.createStatement();
            String addUserSchemaStu =
            "CREATE TABLE STUDENTS(" +
            "achievements VARCHAR (200)," +
            "headline VARCHAR (400)," +
            "sid INT NOT NULL,"+
            "FOREIGN KEY (sid) REFERENCES USERS(uid))";
            // an example of headline could be "searching for a passionate KungFu instructor"
            
            //            cleanTable(dbconn.conn, "STUDENTS");
            stmtstu.execute(addUserSchemaStu);
            
            // Populate a tuple for Students
            String insertStudents =
            "INSERT INTO STUDENTS " +
            "(achievements, headline, sid) " +
            "VALUES " +
            "('TaeKwondo yellow belt', 'Looking for Taekwondo instructor in Marpole area', 101)";
            stmtstu.execute(insertStudents);
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // No longer need this function
    //    public static void cleanTable(Connection con, String tableName) {
    //        DatabaseMetaData dbm = null;
    //
    //        try {
    //            Statement stmt = con.createStatement();
    //            dbm = con.getMetaData();
    //            ResultSet tables = dbm.getTables(null, null, tableName, null);
    //            if (tables.next()) {
    //                String sql = "DROP TABLE " + tableName;
    //                stmt.executeUpdate(sql);
    //            }
    //        } catch (SQLException e) {
    //            e.printStackTrace();
    //        }
    //    }
    
    
}
