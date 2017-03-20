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
            // First create some tables
            Statement stmt = dbconn.conn.createStatement();
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
                            "isBlocked BOOLEAN)";

            cleanTable(dbconn.conn, "USERS");
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
    }

    public static void cleanTable(Connection con, String tableName) {
        DatabaseMetaData dbm = null;

        try {
            Statement stmt = con.createStatement();
            dbm = con.getMetaData();
            ResultSet tables = dbm.getTables(null, null, tableName, null);
            if (tables.next()) {
                String sql = "DROP TABLE " + tableName;
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
