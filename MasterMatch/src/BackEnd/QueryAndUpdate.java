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

    // Write functions for sending queries here
}
