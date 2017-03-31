package BackEnd;

import UI.MyModel;

import java.sql.*;
import java.util.ArrayList;

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
            rs.close();
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
            rs.close();
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

    // Finding Student of instructor given inid
    public MyModel findStudentOf(int inid) {
        try
        {
            rs = stmt.executeQuery("SELECT students.sid, users.uname FROM students, users WHERE " +
                    "students.sid = users.uid AND students.inid = " + inid);
            System.out.println("Trying to find students of " + inid + " In SQL form: ");
            System.out.println("SELECT students.sid, users.uname FROM students, users WHERE " +
                    "students.sid = users.uid AND students.inid = " + inid);

            return rsToModel(rs);
        } catch (SQLException ex) {
            return null;
        }
    }

    // Finding Inst of student given inid
    public MyModel findInstOf(int sid) {
        try
        {
            rs = stmt.executeQuery("SELECT inid, uname FROM students, users WHERE " +
                    "users.uid = inid AND students.sid = " + sid);
            System.out.println("Trying to find instructor of " + sid + " In SQL form: ");
            System.out.println("SELECT inid, uname FROM students, users WHERE " +
                    "users.uid = inid AND students.sid = " + sid);

            return rsToModel(rs);
        } catch (SQLException ex) {
            return null;
        }
    }

    // Finding details student given sid
    public MyModel findStudentDetail(int sid) {
        try
        {
            rs = stmt.executeQuery(
                    "SELECT students.sid, users.uname, users.age, users.gender, users.address, " +
                            "users.phone, students.achievements, students.headline  FROM students, users WHERE " +
                            "students.sid = users.uid AND students.sid = " + sid);
            System.out.println("Trying to find detail of " + sid + " by joining user and student table. In SQL form: ");
            System.out.println("SELECT students.sid, users.uname, users.age, users.gender, users.address, " +
                    "users.phone, students.achievements, students.headline  FROM students, users WHERE " +
                    "students.sid = users.uid AND students.sid = " + sid);

            return rsToModel(rs);
        } catch (SQLException ex) {
            System.out.println("Invalid Query");
            ex.printStackTrace();
            return null;
        }
    }

    // Finding details of instructor given inid
    public MyModel findInstDetail(int inid) {
        try
        {
            rs = stmt.executeQuery(
                    "SELECT i.inid, u.uname, u.age, u.gender, " +
                            "u.phone, i.year, i.style  FROM instructors i, users u WHERE " +
                            "i.inid = u.uid AND i.inid = " + inid);
            System.out.println("Trying to find detail of " + inid + " by joining user and instructor table. In SQL form: ");
            System.out.println("SELECT i.inid, u.uname, u.age, u.gender, " +
                    "u.phone, i.year, i.style  FROM instructors i, users u WHERE " +
                    "i.inid = u.uid AND i.inid = " + inid);

            return rsToModel(rs);
        } catch (SQLException ex) {
            System.out.println("Invalid Query");
            ex.printStackTrace();
            return null;
        }
    }

    // Finding details of lesson given lid
    public MyModel findLessonDetail(String lid) {
        try
        {
            rs = stmt.executeQuery(
                    "SELECT * FROM lesson WHERE " +
                            "lesson.lid = " + "'" + lid + "'");
            System.out.println("Trying to find detail of " + lid + " In SQL form: ");
            System.out.println("SELECT * FROM lesson WHERE " +
                    "lesson.lid = " + "'" + lid + "'");

            return rsToModel(rs);
        } catch (SQLException ex) {
            System.out.println("Invalid Query");
            ex.printStackTrace();
            return null;
        }
    }

    // Finding lesson of uid
    public MyModel findLessonOf(int uid) {
        try
        {
            rs = stmt.executeQuery(
                    "SELECT lesson.lid, lesson.inid FROM lesson WHERE " +
                            "lesson.inid = " + uid);
            System.out.println("Trying to find lessons of instructor " + uid + " In SQL form: ");
            System.out.println("SELECT lesson.lid, lesson.inid FROM lesson WHERE " +
                    "lesson.inid = " + uid);
            return rsToModel(rs);
        } catch (SQLException ex) {
            System.out.println("Invalid Query");
            ex.printStackTrace();
            return null;
        }
    }

    // Finding lesson of sid
    public MyModel findLessonOfStudent(int sid) {
        try
        {
            rs = stmt.executeQuery(
                    "SELECT lesson.lid, lesson.inid FROM lesson, register WHERE " +
                            "lesson.lid = register.lid AND register.sid = " + sid);
            System.out.println("Trying to find lessons of student " + sid + " In SQL form: ");
            System.out.println("SELECT lesson.lid, lesson.inid FROM lesson, register WHERE " +
                    "lesson.lid = register.lid AND register.sid = " + sid);
            return rsToModel(rs);
        } catch (SQLException ex) {
            System.out.println("Invalid Query");
            ex.printStackTrace();
            return null;
        }
    }

    // Finding request record given inid
    public MyModel findRequestRecord(int inid) {
        try
        {
            rs = stmt.executeQuery(
                    "SELECT * FROM Request WHERE " +
                            "Request.inid = " + inid);
            System.out.println("Trying to find requests of instructor " + inid + " In SQL form: ");
            System.out.println(
                    "SELECT * FROM Request WHERE " +
                            "Request.inid = " + inid);
            return rsToModel(rs);
        } catch (SQLException ex) {
            System.out.println("Invalid Query");
            ex.printStackTrace();
            return null;
        }
    }

    // Finding request record given sid
    public MyModel findRequestRecordBySid(int sid) {
        try
        {
            rs = stmt.executeQuery(
                    "SELECT * FROM Request WHERE " +
                            "Request.sid = " + sid);
            System.out.println("Trying to find requests of student " + sid + " In SQL form: ");
            System.out.println(
                    "SELECT * FROM Request WHERE " +
                            "Request.sid = " + sid);
            return rsToModel(rs);
        } catch (SQLException ex) {
            System.out.println("Invalid Query");
            ex.printStackTrace();
            return null;
        }
    }

    // "Delete a student" set a student's inid to null
    public void deleteRelationShip(int sid) {
        try
        {
            stmt.executeUpdate(
                    "UPDATE students SET students.inid = NULL WHERE students.sid = " + sid);
            System.out.println("Setting inid field of " + sid + " to null. In SQL form: ");
            System.out.println(
                    "UPDATE students SET students.inid = NULL WHERE students.sid = " + sid);
        } catch (SQLException ex) {
            System.out.println("Invalid Query");
            ex.printStackTrace();
        }
    }

    // "Add a student" set a student's inid to someone
    public void addRelationShip(int sid, int init) {
        try
        {
            stmt.executeUpdate(
                    "UPDATE students SET students.inid = "+init+" WHERE students.sid = " + sid);
            System.out.println("Setting inid field of " + sid + " to "+ init +". In SQL form: ");
            System.out.println(
                    "UPDATE students SET students.inid = "+init+" WHERE students.sid = " + sid);
        } catch (SQLException ex) {
            System.out.println("Invalid Query");
            ex.printStackTrace();
        }
    }

    // Add a lesson
    public void addLesson(String start, String end, String date, float price, int inid,
                          String loc, int cap, int lid) {
        try
        {
            stmt.executeUpdate(
                    "INSERT INTO Lesson" +
                    "(lid, inid, loc, startTime, endTime, date, price, capacity)" +
                            "VALUES" +
                            "(" +lid+","+inid+","+singleQ(loc)+","+
                            singleQ(start)+","+singleQ(end)+","+singleQ(date)+","+price+","+cap+")");
            System.out.println("Add a lesson. In SQL form: ");
            System.out.println(
                    "INSERT INTO Lesson" +
                            "(lid, inid, loc, startTime, endTime, date, price, capacity)" +
                            "VALUES" +
                            "(" +lid+","+inid+","+singleQ(loc)+","+
                            singleQ(start)+","+singleQ(end)+","+singleQ(date)+","+price+","+cap+")");
        } catch (SQLException ex) {
            System.out.println("Invalid Query");
            ex.printStackTrace();
        }
    }

    // Add a lesson
    public boolean addRequest(int sid, int inid) {
        try
        {
            stmt.execute(
                    "INSERT INTO Request" +
                            "(sid, inid)" +
                            "VALUES" +
                            "("+sid+","+inid+")");
            System.out.println("Add a request. In SQL form: ");
            System.out.println(
                    "INSERT INTO Request" +
                            "(sid, inid)" +
                            "VALUES" +
                            "("+sid+","+inid+")");
            return true;
        } catch (SQLException ex) {
            System.out.println("Invalid Query");
            ex.printStackTrace();
            return false;
        }
    }

    // Delete a lesson
    public void deleteLesson(String lid) {
        try
        {
            stmt.executeUpdate(
                    "DELETE FROM Lesson WHERE Lesson.lid = " + "'" + lid + "'");
            System.out.println("Remove a lesson. In SQL form: ");
            System.out.println(
                    "DELETE FROM Lesson WHERE Lesson.lid = " + "'" + lid + "'");
        } catch (SQLException ex) {
            System.out.println("Invalid Query");
            ex.printStackTrace();
        }
    }

    // Delete a registration
    public void deleteRegister(int sid) {
        try
        {
            stmt.executeUpdate(
                    "DELETE FROM register WHERE register.sid = " + sid);
            System.out.println("Remove a register record. In SQL form: ");
            System.out.println(
                    "DELETE FROM register WHERE register.sid = " + sid);
        } catch (SQLException ex) {
            System.out.println("Invalid Query");
            ex.printStackTrace();
        }
    }

    // Delete a request
    public void deleteRequest(int sid) {
        try
        {
            stmt.executeUpdate(
                    "DELETE FROM request WHERE request.sid = " + sid);
            System.out.println("Remove a request record. In SQL form: ");
            System.out.println(
                    "DELETE FROM request WHERE request.sid = " + sid);
        } catch (SQLException ex) {
            System.out.println("Invalid Query");
            ex.printStackTrace();
        }
    }

    // Update a lesson, including its starting, finishing time and date
    public void updateLesson(String start, String end, String date, float price, String lid) {
        try
        {
            stmt.executeUpdate(
                    "UPDATE Lesson SET Lesson.startTime = "+singleQ(start)+" WHERE Lesson.lid = " + "'" + lid + "'");
            System.out.println("Update a lesson. SQL: ");
            System.out.println(
                    "DELETE FROM Lesson WHERE Lesson.lid = " + "'" + lid + "'");
            stmt.executeUpdate(
                    "UPDATE Lesson SET Lesson.endTime = "+singleQ(end)+" WHERE Lesson.lid = " + "'" + lid + "'");
            System.out.println(
                    "UPDATE Lesson SET Lesson.endTime = "+singleQ(end)+" WHERE Lesson.lid = " + "'" + lid + "'");
            stmt.executeUpdate(
                    "UPDATE Lesson SET Lesson.date = "+singleQ(date)+" WHERE Lesson.lid = " + "'" + lid + "'");
            System.out.println(
                    "UPDATE Lesson SET Lesson.date = "+singleQ(date)+" WHERE Lesson.lid = " + "'" + lid + "'");
            stmt.executeUpdate(
                    "UPDATE Lesson SET Lesson.price = "+price+" WHERE Lesson.lid = " + "'" + lid + "'");
            System.out.println(
                    "UPDATE Lesson SET Lesson.price = "+price+" WHERE Lesson.lid = " + "'" + lid + "'");
        } catch (SQLException ex) {
            System.out.println("Invalid Query");
            ex.printStackTrace();
        }
    }


    // General query
    public MyModel selectGeneral(String query) {
        try
        {
            rs = stmt.executeQuery(query);
            System.out.println("Executing query: ");
            System.out.println(query);
            return rsToModel(rs);

        } catch (SQLException ex) {
            System.out.println("Invalid Query");
            ex.printStackTrace();
            return null;
        }
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

    // Helper functions
    // Function that convers a resultset to custom table model
    public static MyModel rsToModel(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();

            // names of columns
            ArrayList<String> columnNames = new ArrayList<String>();
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                columnNames.add(metaData.getColumnName(column));
            }

            ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
            while (rs.next()) {
                ArrayList<String> currentRow = new ArrayList<String>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    currentRow.add(rs.getString(columnIndex));
                }
                data.add(currentRow);
            }


            return new MyModel(data, columnNames);

        } catch (SQLException ex) {
            return null;
        }
    }

    public String singleQ(String s) {
        return "'" + s + "'";
    }



}
