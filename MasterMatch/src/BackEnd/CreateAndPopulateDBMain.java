package BackEnd;

import java.sql.*;

/**
 * Created by Jerry on 2017-03-17.
 */
public class CreateAndPopulateDBMain {

    public static DataBaseConnection dbconn = new DataBaseConnection();

    // Run to populate your database
    public static void main(String[] args) {
        dbconn.connect();
        ResultSet rs = null;

        try {
            Statement stmt = dbconn.conn.createStatement();

            safeDelete("Book");
            safeDelete("Plessons");
            safeDelete("Request");
            safeDelete("Instructors");
            safeDelete("Students");
            safeDelete("MartialArtsType");
            safeDelete("Users");


            // First create some tables
            // User table ===============================================================
            String addUserSchema =
                    "CREATE TABLE Users(" +
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

            stmt.execute(addUserSchema);
            
            // Populate tuple after schemas are created
            String insertUser = "INSERT INTO Users " +
                            "(uid, uname, age, gender, address, email, phone, isInstructor, isBlocked) " +
                            "VALUES " +
                            "(101, 'Jerry Liu', 20, 'M', '2205 Lower Mall', 'jl@gmail.com', 778101101, FALSE, FALSE)," +
                            "(102, 'Aaron Smith', 36, 'M', '2311 Moon Ave.', 'AS36@hotmail.com', 604111000, FALSE, FALSE)," +
                            "(103, 'Victoria Wang', 22, 'F', '2200 Earth Ave.', 'VW@coldmail.com', 604222000, FALSE, FALSE)," +
                            "(104, 'Alan Alison', 25, 'M', '2222 Good Ave.', 'AA@goodmail.com', 604101000, FALSE, FALSE)," +
                            "(105, 'Alec Alison', 24, 'M', '2222 Good Ave.', 'AL@badmail.com', 604111800, FALSE, FALSE)," +
                            "(106, 'Simon Alison', 22, 'M', '2222 Good Ave.', 'SA@hotmail.com', 604111810, FALSE, FALSE)," +
                            "(107, 'Roger Alison', 17, 'F', '2220 Bad Ave.', 'RA@gmail.com', 604111820, FALSE, FALSE)," +
                            "(108, 'Roger Lisa', 18, 'F', '2205 Lower Mall', 'RL@gmail.com', 604111830, FALSE, FALSE)," +
                            "(109, 'Philip Alison', 33, 'M', '2205 Lower Mall', 'PA@gmail.com', 604111840, FALSE, FALSE)," +
                            "(110, 'Mycroft Olivia', 50, 'M', '2205 Lower Mall', 'MO@gmail.com', 604111850, FALSE, FALSE)," +
                            "(111, 'Mark Abigail', 24, 'M', '2205 Lower Mall', 'MA@gmail.com', 604111001, FALSE, FALSE)," +

                            "(112, 'Alan Wang', 21, 'F', '2001 UBC Ave.', 'AWL@hotmail.com', 700111000, FALSE, FALSE)," +
                            "(113, 'Blan Zhang', 20, 'M', '2311 UAC Ave.', 'BZ@hotmail.com', 403400400, FALSE, FALSE)," +
                            "(114, 'Clan Wang', 29, 'M', '2311 UCC Ave.', 'CW@gmail.com', 403400600, FALSE, FALSE)," +
                            "(115, 'Dlan Zhang', 31, 'F', '1010 UDC Ave.', 'DZ@gmail.com', 403400422, FALSE, FALSE)," +
                            "(116, 'Elan Wang', 32, 'F', '1022 SFU Ave.', 'EW@gmail.com', 702211000, FALSE, FALSE)," +
                            "(117, 'Flan Zhang', 32, 'M', '1022 SFU Ave.', 'FZ@gmail.com', 720111000, FALSE, FALSE)," +
                            "(118, 'Garon Wang', 32, 'F', '1022 SFU Ave.', 'AAA@hotmail.com', 705511000, FALSE, FALSE)," +
                            "(119, 'Haron Zhang', 23, 'M', '1022 SFU Ave.', 'BBB@fastmail.com', 700771000, FALSE, FALSE)," +
                            "(120, 'Iaron Zhang', 22, 'F', '1022 SFU Ave.', 'CCC@fastmail.com', 700111800, FALSE, FALSE)," +
                            "(121, 'Jaron Zhang', 22, 'M', '1022 SFU Ave.', 'DDD@fastmail.com', 700177000, FALSE, FALSE)," +
                            "(122, 'Karon Wang', 22, 'F', '1022 SFU Ave.', 'RRR@fastmail.com', 700119900, FALSE, FALSE)," +

                            "(123, 'Karen Steven', 17, 'M', '6446 Big Ave.', 'KD@fastmail.com', 800999339, FALSE, FALSE)," +
                            "(124, 'Aaren Colin', 18, 'F', '3244 Small Mall', 'FGH@fastmail.com', 800999393, FALSE, FALSE)," +
                            "(125, 'Baren Steven', 16, 'M', '2474 Large Ave.', 'DG@fastmail.com', 800993392, FALSE, FALSE)," +
                            "(126, 'Caren Colin', 27, 'M', '2645 Hot Ave.', 'DB@hotmail.com', 800939332, FALSE, FALSE)," +
                            "(127, 'Daren Steven', 27, 'M', '2456 Cold Ave.', 'DG@hotmail.com', 800993392, FALSE, FALSE)," +
                            "(128, 'Earon Colin', 26, 'M', '2234 Old Ave.', 'V@hotmail.com', 800349392, FALSE, FALSE)," +
                            "(129, 'Faron Steven', 25, 'M', '4254 Young Ave.', 'EV@fastmail.com', 834993392, FALSE, FALSE)," +
                            "(130, 'Garon George', 25, 'M', '2454 White Ave.', 'GD@hotmail.com', 819993392, FALSE, FALSE)," +
                            "(131, 'Ayn Steven', 25, 'F', '2452 Black Ave.', 'DB@UBCmail.com', 801993392, FALSE, FALSE)," +
                            "(132, 'Byn George', 36, 'F', '234 Black Ave.', 'DB@fastmail.com', 80993392, FALSE, FALSE)," +
                            "(133, 'Cyn Steven', 36, 'F', '456 Black Ave.', 'DFB@fastmail.com',800993192, FALSE, FALSE)," +
                            "(134, 'Dyn George', 25, 'F', '457 Black Ave.', 'DRR@hotmail.com',999929999, FALSE, FALSE)," +
                            "(135, 'Eyn Steven', 55, 'F', '3546 Sunny Ave.', 'DVF@fastmail.com', 99999999, FALSE, FALSE)," +
                            "(136, 'Fyn George', 27, 'F', '457 Mid Ave.', 'XCV@goodmail.com', 999299999, FALSE, FALSE)," +
                            "(137, 'Gyn Steven', 42, 'F', '4756 Sunny Ave.', 'TNH@hotmail.com', 999992999, FALSE, FALSE)," +
                            "(138, 'Hyn George', 45, 'F', '8657 Mid Ave.', 'RRG@goodmail.com', 996999999, FALSE, FALSE)," +
                            "(139, 'Iyn Steven', 24, 'F', '3456 Mid Ave.', 'GG@goodmail.com', 999699999, FALSE, FALSE)," +
                            "(140, 'Jyn George', 26, 'F', '4567 Mid Ave.', 'DFDB@hotmail.com', 999779999, FALSE, FALSE)," +

                            "(901, 'Aaron Smith', 36, 'M', '2311 Moon Ave.', 'AS36@UBCmail.com', 604111000, TRUE, FALSE)," +
                            "(902, 'Kevin A-ch', 20, 'M', '2205 West Mall.', 'KACH@UBCmail.com', 2040389393, TRUE, FALSE)," +
                            "(903, 'Baron Smith', 22, 'M', '2011 Earth Ave.', '13@UBCmail.com', 604111000, TRUE, FALSE)," +
                            "(904, 'Caron Smith', 24, 'M', '2301 Earth St.', '134@UBCmail.com', 604111000, TRUE, FALSE)," +
                            "(905, 'Daron Smith', 45, 'M', '2311 Earth Ave.', 'dghe@UBCmail.com', 604111000, TRUE, FALSE)," +
                            "(906, 'Earon Smith', 57, 'M', '2311 Earth St.', 'eeh@UBCmail.com', 604111000, TRUE, FALSE)," +
                            "(907, 'Faron Smith', 35, 'M', '2311 Earth St.', 'dht@UBCmail.com', 604111000, TRUE, FALSE)," +
                            "(908, 'Garon Smith', 46, 'M', '2311 Earth Ave.', 'etjetj@UBCmail.com', 604111000, TRUE, FALSE)," +
                            "(909, 'Haron Smith', 28, 'M', '2311 Earth Ave.', 'eth3t@UBCmail.com', 604111000, TRUE, FALSE)," +
                            "(910, 'Iaron Smith', 26, 'M', '2311 Earth Ave.', 'ethe@UBCmail.com', 604111000, TRUE, FALSE)";
            stmt.execute(insertUser);

            // Create student table ===============================================================
            String addUserSchemaStu =
                    "CREATE TABLE Students(" +
                            "achievements VARCHAR (200)," +
                            "headline VARCHAR (400)," +
                            "sid INT NOT NULL,"+
                            "FOREIGN KEY (sid) REFERENCES Users(uid))";
            // an example of headline could be "searching for a passionate KungFu instructor"
            stmt.execute(addUserSchemaStu);

            // Populate a tuple for Students
            String insertStudents =
                    "INSERT INTO Students " +
                            "(achievements, headline, sid) " +
                            "VALUES " +
                            "('ITF TaeKwondo yellow belt', 'Looking for Taekwondo instructor in Marpole area', 101)" +
                            "('Wing Chun Kung Fu Sash', 'Looking for experienced Wing Chun Teacher near Kitsilano', 102)" +
                            "('Shotokan-ryu Karate White Belt', 'Searching for easy going instructor of Shotokun in Burnaby', 104)" +
                            "('Wushu Kung Fu No Experience', 'Wondering if there are any good teachers at UBC for Wushu, wish to learn how to butterfly', 103)" +
                            "('Hun Gar Kung Fu Senoir Sash Student', 'I've trained in the hun gar style of kung fu and wish to further my skills. Looking for instructor with 20+ years of experience.', 105)" +
                            "('WTF TaeKwondo Green Belt With Blue Stripe','Looking to further my career in TaeKwonDo in West Point Grey Area', 105)" +
                            "('Shito-ryu Karate Purple Belt','Very Experienced Karate practitioner looking for sensei to complete my belts in the shawnessy catchman', 106)" +
                            "('Choy Lei Fut Kung Fu Junior level sash','Previously trained in a school for choi lei fut and wish to continue in the Richmond district', 107)";


            stmt.execute(insertStudents);

            // Create instructor table ===============================================================
            String addUserSchemaInst =
                    "CREATE TABLE Instructors(" +
                            "year INT," +
                            "headline VARCHAR (400)," +
                            "inid INT NOT NULL,"+
                            "FOREIGN KEY (inid) REFERENCES Users(uid))";
            // an example of headline could be "Upcoming group lesson of 20 in ST building"

            stmt.execute(addUserSchemaInst);

            // Populate a tuple for Instructors
            String insertInstructors =
                    "INSERT INTO Instructors " +
                            "(year , headline, inid) " +
                            "VALUES " +
                            "(10, 'Upcoming group lesson of 20 in Oakridge Center', 901)" +
                            "(12,'Group lesson occuring every Friday's from 4pm to 6pm in the NEST',902";

            stmt.execute(insertInstructors);

            // The martialArtsType table ===============================================================
            String addMartialArtsType =
                    "CREATE TABLE MartialArtsType(" +
                            "style CHAR (10), " +
                            "typeName CHAR (20)," +
                            "forms CHAR (10)," +
                            "PRIMARY KEY (style))";
            stmt.execute(addMartialArtsType);

            // The request table ===============================================================
            String addRequest =
                    "CREATE TABLE Request(" +
                            "inid INT, " +
                            "sid INT, " +
                            "pref CHAR (10)," +
                            "PRIMARY KEY (inid), " +
                            "FOREIGN KEY (sid) REFERENCES Students(sid), " +
                            "FOREIGN KEY (inid) REFERENCES Instructors(inid))";

            stmt.execute(addRequest);
            // Populate tuples for request
            String insertRequests =
                    "INSERT INTO Request " +
                            "(inid , sid, pref) " +
                            "VALUES " +
                            "(901, 101, 'BecomeStu')";
            stmt.execute(insertRequests);

            // Create  table Plessons ===============================================================
            String addUserSchemaPl =
                    "CREATE TABLE Plessons(" +
                            "plid CHAR (10) NOT NULL," +
                            "sid INT NOT NULL," +
                            "inid INT NOT NULL,"+
                            "loc VARCHAR (200) NOT NULL," +
                            "startTime CHAR (5) NOT NULL,"+
                            "endTime CHAR (5) NOT NULL," +
                            "price FLOAT NOT NULL," +
                            "PRIMARY KEY (plid)," +
                            "FOREIGN KEY (sid) REFERENCES Students (sid)," +
                            "FOREIGN KEY (inid) REFERENCES Instructors (inid))" ;

            stmt.execute(addUserSchemaPl);

            // Populate a tuple for Plessons
            String insertPl =
                    "INSERT INTO Plessons " +
                            "(plid, sid, inid, loc, startTime, endTime, price) " +
                            "VALUES " +
                            "('p5000', 101, 901, '401, 8918 Marine DR.', '11:00', '13:00', 100.00)";
            stmt.execute(insertPl);

            // Create Book table ===============================================================
            String addUserSchemaBook =
                    "CREATE TABLE Book(" +
                            "sid INT NOT NULL," +
                            "plid CHAR (10) NOT NULL," +
                            "PRIMARY KEY (sid, plid)," +
                            "FOREIGN KEY (sid) REFERENCES Students (sid)," +
                            "FOREIGN KEY (plid) REFERENCES PLessons (plid))";
            // an example of headline could be "Upcoming group lesson of 20 in ST building"

            stmt.execute(addUserSchemaBook);

            // Populate a tuple for Book
            String insertBook =
                    "INSERT INTO Book " +
                            "(sid, plid) " +
                            "VALUES " +
                            "(101, 'p5000')";
            stmt.execute(insertBook);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void safeDelete(String tableName) {
        DatabaseMetaData dbm = null;

        try {
            Statement stmt = dbconn.conn.createStatement();
            dbm = dbconn.conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, tableName, null);
            if (tables.next()) {
                String sql = "DROP TABLE " + tableName;
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
