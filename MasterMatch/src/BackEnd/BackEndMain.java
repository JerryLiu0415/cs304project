package BackEnd;

/**
 * Created by Jerry on 2017-03-17.
 */

// Configure the main method as BackEndMain to connect to server without populating db and UI
public class BackEndMain {
    public static void main(String[] args) {
        DataBaseConnection dbconn = new DataBaseConnection();
        dbconn.connect();

        // Put any code here for testing behaviour
    }
}
