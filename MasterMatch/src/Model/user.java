package Model;

/**
 * Created by Jerry on 2017-03-17.
 */

// User model
// When query about users, you can convert the query result to user object for easier access their fields
public class user {
    public int uid;
    public String uname;
    public int age;
    public String gender;
    public String address;
    public String email;
    public int phone;
    public boolean isInstructor;
    public boolean isBlocked;

    public user(String[] tuple) {
        this.uid = parseStringRobust(tuple[0]);
        this.uname = tuple[1];
        this.age = parseStringRobust(tuple[2]);
        this.address = tuple[3];
        this.gender = tuple[4];
        this.email = tuple[5];
        this.phone = parseStringRobust(tuple[6]);
        this.isInstructor = Boolean.parseBoolean(tuple[7]);
        this.isBlocked = Boolean.parseBoolean(tuple[8]);
    }

    // Get integer for string while ensure that null value will not cause errors
    public int parseStringRobust(String s) {
        if (s.equals("null") || s.equals("NULL")) {
            return  -1;
        }
        else  {
            return Integer.parseInt(s);
        }

    }



}
