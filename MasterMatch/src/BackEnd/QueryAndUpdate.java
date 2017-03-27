package BackEnd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Jerry on 2017-03-17.
 */

// Class for non-update queries
public class QueryAndUpdate {
    private Statement stmt = null;
    private ResultSet rs = null;

    public QueryAndUpdate(Connection conn) {
        try {
            this.stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Queries ============================================================================
    /* Very first query sent when someone tries to log in
       Id+Password need to matching existing ones in order to login
       The user name is retured if success
    */
    public String findIdPassPair(int id, int pw) {
        // Set res to the user's name if given id-pw pair exist
        String res = "";
        try {
            rs = stmt.executeQuery("SELECT * FROM users WHERE uid = "+id+" AND password = " + pw);

            if (stmt.execute("SELECT * FROM users WHERE uid = "+id+" AND password = " + pw)) {
                rs = stmt.getResultSet();
            }

            while (rs.next()) {
                int uid = rs.getInt("uid");
                String name = rs.getString("uname");
                int pass = rs.getInt("password");

                System.out.println(uid + "\t" + name +
                        "\t" + pass);
                res = name;
            }
            // Empty string will be returned if given id-pw invalide
            return res;
        }
        catch (SQLException ex){
            // handle any errors (Code from JDBC tutorial)
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return res;
    }

    /* General query sent from checking if some value exist in a table
       We may need this to check for duplicates if CHECK is not supported by mysql
       Return true if exist, false otherwise
    */
    public boolean checkValueExistGeneral(String tableName, String colName, String val, Boolean isString) {
        boolean res = false;
        // Set to the user's name of the id/pw pair exist
        try {
            if (isString) {
                rs = stmt.executeQuery("SELECT * FROM "+tableName+" WHERE "+colName+" = "+"'"+val+"'");

                if (stmt.execute("SELECT * FROM "+tableName+" WHERE "+colName+" = "+"'"+val+"'")) {
                    rs = stmt.getResultSet();
                }
            }
            else {
                rs = stmt.executeQuery("SELECT * FROM "+tableName+" WHERE "+colName+" = "+val);

                if (stmt.execute("SELECT * FROM "+tableName+" WHERE "+colName+" = "+val)) {
                    rs = stmt.getResultSet();
                }

            }
            while (rs.next()) {
                res = true;
            }
            return res;
        }
        catch (SQLException ex){
            // handle any errors (Code from JDBC tutorial)
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return res;
    }


    /* Updates ============================================================================
    General function for inserting a tuple to a table
    <table> is the name of the table to be populated
    <Args> should have the structure: [columnName1, columnName2,..., valForColumn1, valForColumn2,..., typeForCols...  ]
    Types are CHAR, INT ..., which will determine whether values are surrounded by ''
    Example: insertGeneral("users", "uid", "password", "101", "555", "INT", "INT")
             Which inserts a tuple (101,555) corresponding to the field (uid, password)
             of type INT both into table "users"
    Return true if sql insertion succeed
    */
    public boolean insertGeneral(String table, String... args) {
        int oneThird = (args.length/3) - 1;
        int twoThirds = (args.length/3) + oneThird;
        String colName = "(";
        String vals = "(";
        for (int i = 0; i < args.length; i++) {
            if (i <= oneThird) {
                if (i == oneThird) {
                    colName += args[i] + ")";
                } else {
                    colName += args[i] + " ,";
                }
            }
            else if (i > oneThird && i <= twoThirds){
                int refIndex = i+(args.length/3);
                if (i == twoThirds) {
                    if (args[refIndex].equals("CHAR")) {
                        vals += "'" + args[i] + "'" + ")";
                    }
                    else {
                        vals += args[i] + ")";
                    }
                } else {
                    if (args[refIndex].equals("CHAR")) {
                        vals += "'" + args[i] + "'" + " ,";
                    }
                    else {
                        vals += args[i] + " ,";
                    }
                }
            }
            else {
                break;
            }
        }

        String insertionStatement =
                "INSERT INTO "+table+" " + colName + " VALUES " + vals;

        String res = "";
        try {
            stmt.execute(insertionStatement);
            // Printout the generated query
            System.out.println(insertionStatement);
            return true;
        }
        catch (SQLException ex){
            // handle any errors (Code from JDBC tutorial)
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return false;
        }

    }


}
