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

            safeDelete("Register");
            safeDelete("Lesson");
            safeDelete("Book");
            safeDelete("Plessons");
            safeDelete("Request");
            safeDelete("Students");
            safeDelete("Instructors");
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
                            "phone BIGINT," +
                            "isInstructor BOOLEAN," +
                            "isBlocked BOOLEAN," +
                            "password INT NOT NULL," +
                            "bio VARCHAR (5000)," +
                            "PRIMARY KEY (uid)," +
                            "CONSTRAINT email_unique UNIQUE(email))";

            stmt.execute(addUserSchema);

            // Populate tuple after schemas are created
            String insertUser = "INSERT INTO Users " +
                    "(uid, uname, age, gender, address, email, phone, isInstructor, isBlocked, password) " +
                    "VALUES " +
                    // Students:
                    "(101, 'Jerry Liu', 20, 'M', '2205 Lower Mall', 'jl@gmail.com', 778101101, FALSE, FALSE, 55555555)," +
                    "(103, 'Ari Knills', 23, 'M', '2200 Earth Ave.', 'akbro@hotmail.com', 604222000, FALSE, FALSE, 55555555)," +
                    "(104, 'Eleanor Knills', 25, 'F', '2200 Earth Ave.', 'eksis@gmail.ca', 604101000, FALSE, FALSE, 55555555)," +
                    "(105, 'Alec Yip', 24, 'M', '1988 Goodary St.', 'ay@badmail.com', 604111800, FALSE, FALSE, 55555555)," +
                    "(106, 'Simon Kennedy', 22, 'M', '3222 Alison Road.', 'sky@hotmail.com', 604111810, FALSE, FALSE,55555555)," +
                    "(107, 'Roger Brown', 17, 'M', '2220 W Broadway.', 'Rb@gmail.com', 604111820, FALSE, FALSE, 55555555)," +
                    "(108, 'Emily Swift', 18, 'F', '2205 Lower Mall', 'EShaha@gmail.com', 604111830, FALSE, FALSE, 55555555)," +
                    "(109, 'Philip Situ', 33, 'M', '147-8899 River Rd.', 'philst@gmail.com', 604111840, FALSE, FALSE, 55555555)," +
                    "(110, 'Olivia Guo', 50, 'F', '603 Bianca St.', '33687499@qq.com', 604111850, FALSE, FALSE, 55555555)," +
                    "(115, 'Dawei Zhang', 31, 'M', '2301 University Boulevard.', 'DZ1994@gmail.com', 6042736454, FALSE, FALSE, 55555555)," +
                    "(116, 'Naam Lim', 32, 'M', '3933 W Broadway.', 'naaml@gmail.com', 702211000, FALSE, FALSE, 55555555)," +
                    "(117, 'Jessie Lim', 12, 'F', '3933 W Broadway.' ,'gojessie@gmail.ca', 720111000, FALSE, FALSE, 55555555)," +
                    "(118, 'Aaron Cambridge', 32, 'M', '900 Marine Dr.', 'ABC@hotmail.com', 705511000, FALSE, FALSE, 55555555)," +
                    "(119, 'Mario Zhang', 23, 'M', '1988 Yew St.', 'mariozh@gmail.ca', 700771000, FALSE, FALSE, 55555555)," +
                    "(120, 'Silvia Ho', 22, 'F', '2044 Higher Mall.', 'silvershine@gmail.hk', 700111800, FALSE, FALSE, 55555555)," +
                    "(121, 'Kelvin J. White', 22, 'M', '2044 Higher Mall.', 'kjw@hotmail.com', 700177000, FALSE, FALSE, 55555555)," +
                    "(122, 'Karen Choi', 66, 'F', '390 King Edward St.', 'KCloveMR@yahoo.com', 700119900, FALSE, FALSE, 55555555)," +

                    "(123, 'Yuna Kim', 17, 'F', '1762 Legend Highway', 'ykchamp@gmail.com', 800999339, FALSE, FALSE, 55555555)," +
                    "(124, 'Yuna Sotnikova', 42, 'F', '3456 University Boulevard', 'ys@gmail.com', 800999393, FALSE, FALSE, 55555555)," +
                    "(125, 'Aaron Zhao', 16, 'M', '2474 Larch Ave.', 'azhao@163.com', 203993392, FALSE, FALSE, 55555555)," +
                    "(126, 'Hannah Leung', 19, 'F', '2645 Trutch Ave.', 'hleung@hotmail.com', 203939332, FALSE, FALSE, 55555555)," +
                    "(127, 'Steven Kim', 47, 'M', '2456 Gold Ave.', 'kim.s@hotmail.com', 800993392, FALSE, FALSE, 55555555)," +
                    "(128, 'Steve Wagner', 26, 'M', '2234 Oldtown Ave.', 'hind@hotmail.com', 800349392, FALSE, FALSE, 55555555)," +
                    "(129, 'Yuki Miahara', 25, 'F', '4254 Youth Ave.', 'yukiii@hotmail.com', 834993392, FALSE, FALSE, 55555555)," +
                    "(131, 'George Ibrahim', 25, 'M', '2400 Heather St.', 'ggi@alumni.ubc.ca', 7789000909, FALSE, FALSE, 55555555)," +
                    "(132, 'Cindy Ibrahim', 30, 'F', '2400 Heather St.', 'myibrahim@gmail.com', 80993392, FALSE, FALSE,55555555)," +

                    "(136, 'Fahanh Amari', 27, 'M', '478 Commercial Dr.', 'fa010@hotmaill.com', 6042788339, FALSE, FALSE, 55555555)," +
                    "(137, 'Giovanni Rossi', 42, 'M', '4756 Sunny Ave.', 'GioRos@hotmail.com', 999992999, FALSE, FALSE, 55555555)," +
                    "(138, 'Leo Bruno', 65, 'M', '8657 West Mall.', 'leo@goodmail.com', 604999999, FALSE, FALSE, 55555555)," +
                    "(139, 'Suzanne Schneider', 19, 'F', '270-4578 71th St.', 'ss.this@gmail.ca', 7789026453, FALSE, FALSE, 55555555)," +
                    "(140, 'Abel Durand', 39, 'M', '9800 Swing Rd.', 'ad.me@hotmail.com', 604779999, FALSE, FALSE, 55555555)," +
                    // Instructors:
                    "(901, 'Eric Kim', 36, 'M', '2311 Moon Ave.', 'erick@hotmail.com', 604111000, TRUE, FALSE, 55555555)," +
                    "(902, 'Kevin Ho', 20, 'M', '2205 West Mall.', 'KACH@mycs.com', 2040389393, TRUE, FALSE, 55555555)," +
                    "(903, 'Bella Sayson', 30, 'F', '2205 East Mall.', 'smith@alumni.ubc.ca', 604111000, TRUE, FALSE, 55555555)," +
                    "(904, 'Cassandra Dion', 24, 'F', '2301 4th St.', '134dion@yahoo.com', 604111000, TRUE, FALSE, 55555555)," +
                    "(906, 'Ben Chiu', 40, 'M', '2399 Brown St.', 'ben.instructor@gmail.com', 604111000, TRUE, FALSE, 55555555)," +
                    "(907, 'Wenjun Lee', 35, 'M', '1433 No.3 Rd.', '43998000@qq.com', 7923045663, TRUE, FALSE, 55555555)," +
                    "(908, 'Akihiko Suzuki', 46, 'M', '902 Robson St.', 'akizuki@gmail.ca', 7788290987, TRUE, FALSE, 55555555)," +
                    "(909, 'Hyun Song', 28, 'M', '7288 West Boulevard.', 'TaekwonSong@hotmail.com', 604111000, TRUE, FALSE, 55555555)," +
                    "(910, 'Simon Lu', 50, 'M', '2311 Earth Ave.', 'slu167@gmail.com', 604111000, TRUE, FALSE, 55555555)";

            // Users whose address are null
            String insertUserAddNull = "INSERT INTO Users " +
                    "(uid, uname, age, gender, email, phone, isInstructor, isBlocked, password) " +
                    "VALUES " +
                    "(111, 'Masako Mihara', 24, 'F', 'mnm@gmail.ca', 604111001, FALSE, FALSE, 55555555)," +

                    "(112, 'Alan Jia', 44, 'M', 'AJ121@hotmail.com', 2038884747,FALSE, FALSE, 55555555)," +
                    "(113, 'Eric Khuyabaatar', 20, 'M', 'EKara@hotmail.com', 6045538274, FALSE, FALSE, 55555555)," +
                    "(114, 'Yoshiko Asada', 29, 'F', 'Yoasada@gmail.com', 403400600, FALSE, FALSE, 55555555)";

            // Users whose cellphone is null
            String insertUserPhoNull = "INSERT INTO Users " +
                    "(uid, uname, age, gender, address, email, isInstructor, isBlocked, password) " +
                    "VALUES " +
                    "(133, 'Mia Heydar', 36, 'F', '456 Commercial Dr.', 'miame@alumni.ubc.com', FALSE, FALSE, 55555555)," +
                    "(134, 'Yuli Lipnitskaya', 15, 'M', '4299 9th St.', 'yulili@hotmail.com', FALSE, FALSE, 55555555)," +
                    "(135, 'Astrid Jobs', 55, 'F', '3546 Sunny Ave.', 'astrjob@gmail.ca', FALSE, FALSE, 55555555)," +
                    "(905, 'Yvonne Adalene', 45, 'F', '8775 Cartier St.', 'yvad@yahoo.com', TRUE, FALSE, 55555555)," +
                    "(130, 'Gary Li', 25, 'M', '2454 White Ave.', 'GLi@163.com', FALSE, FALSE, 55555555)";

            // Users who have Bio (bio not null)
            String insertUserHasBio = "INSERT INTO Users " +
                    "(uid, uname, age, gender, address, email, phone, isInstructor, isBlocked, password, bio) " +
                    "VALUES " +
                    "(102, 'Victoria Wang', 22, 'F', '2205 Lower Mall', 'vw266@hotmail.com', 604111000, FALSE, FALSE, 55555555," +
                    " 'I am a UBC student who loves Martial Arts. I had some experiences with Taekwondo and Taichi, but now I want to focus more on Kungfu and in particular, combat. " +
                    " I think my character gets better through learning how to control my body in Kungfu training. I also do other sports, such as figure skating and ping pong. They help with my Kingfu as well.')";

            // Create student table ===============================================================
            String addUserSchemaStu =
                    "CREATE TABLE Students(" +
                            "achievements VARCHAR (800)," +
                            "headline VARCHAR (800)," +
                            "sid INT NOT NULL," +
                            "inid INT," +
                            "FOREIGN KEY (sid) REFERENCES Users(uid)," +
                            "FOREIGN KEY (inid) REFERENCES Instructors(inid))";
            // an example of headline could be "searching for a passionate KungFu instructor"


            // Populate a tuple for Students
            String insertStudents =
                    "INSERT INTO Students " +
                            "(achievements, headline, sid, inid) " +
                            "VALUES " +
                            "('ITF TaeKwondo yellow belt', 'Looking for Taekwondo instructor in Marpole area', 101, NULL)," +
                            "('Wing Chun Kung Fu Sash', 'Looking for experienced Wing Chun Teacher near Kitsilano', 102, NULL)," +
                            "('Shotokan-ryu Karate White Belt', 'Searching for easy going instructor of Shotokun in Burnaby', 104, 901)," +
                            "('Wushu Kung Fu No Experience', 'Wondering if there are any good teachers at UBC for Wushu, wish to learn how to butterfly', 103, NULL)," +
                            "('Hun Gar Kung Fu Senoir Sash Student', 'I have trained in the hun gar style of kung fu and wish to further my skills. Looking for instructor with 20+ years of experience.', 105, 902)," +
                            "('Shito-ryu Karate Purple Belt','Very Experienced Karate practitioner looking for sensei to complete my belts in the shawnessy catchman', 106, 902)," +
                            "('Choy Lei Fut Kung Fu Junior level sash','Previously trained in a school for choi lei fut and wish to continue in the Richmond district', 107, 902)," +
                            "('Wushu Kung Fu 2 years experience','Looking for instructor in Wushu in the Richmond Area', 108, 902)," +
                            "('ITF TaeKwondo yellow belt', 'Looking for Taekwondo instructor in Marpole area', 109, 902)," +
                            "('Wing Chun Kung Fu Sash', 'Looking for experienced Wing Chun Teacher near Kitsilano', 110, 902)," +
                            "('Shotokan-ryu Karate White Belt', 'Searching for easy going instructor of Shotokun in Burnaby', 111, 902)," +
                            "('Wushu Kung Fu No Experience', 'Wondering if there are any good teachers at UBC for Wushu, wish to learn how to butterfly', 112, 903)," +
                            "('Hun Gar Kung Fu Senoir Sash Student', 'I have trained in the hun gar style of kung fu and wish to further my skills. Looking for instructor with 20+ years of experience.', 113, 903)," +
                            "('WTF TaeKwondo Green Belt With Blue Stripe','Looking to further my career in TaeKwonDo in West Point Grey Area', 114, 903)," +
                            "('Shito-ryu Karate Purple Belt','Very Experienced Karate practitioner looking for sensei to complete my belts in the shawnessy catchman', 115, 903)," +
                            "('Choy Lei Fut Kung Fu Junior level sash','Previously trained in a school for choi lei fut and wish to continue in the Richmond district', 116, 903)," +
                            "('Wushu Kung Fu 2 years experience','Looking for instructor in Wushu in the Richmond Area', 117, 903)," +
                            "('ITF TaeKwondo yellow belt', 'Looking for Taekwondo instructor in Marpole area', 118, 903)," +
                            "('Wing Chun Kung Fu Sash', 'Looking for experienced Wing Chun Teacher near Kitsilano', 119, 904)," +
                            "('Shotokan-ryu Karate White Belt', 'Searching for easy going instructor of Shotokun in Burnaby', 120, NULL)," +
                            "('Wushu Kung Fu No Experience', 'Wondering if there are any good teachers at UBC for Wushu, wish to learn how to butterfly', 121, 905)," +
                            "('Hun Gar Kung Fu Senoir Sash Student', 'I have trained in the hun gar style of kung fu and wish to further my skills. Looking for instructor with 20+ years of experience.', 122, 905)," +
                            "('WTF TaeKwondo Green Belt With Blue Stripe','Looking to further my career in TaeKwonDo in West Point Grey Area', 123, 905)," +
                            "('Shito-ryu Karate Purple Belt','Very Experienced Karate practitioner looking for sensei to complete my belts in the shawnessy catchman', 124, NULL)," +
                            "('Choy Lei Fut Kung Fu Junior level sash','Previously trained in a school for choi lei fut and wish to continue in the Richmond district', 125, NULL)," +
                            "('Wushu Kung Fu 2 years experience','Looking for instructor in Wushu in the Richmond Area', 126, 905)," +
                            "('ITF TaeKwondo yellow belt', 'Looking for Taekwondo instructor in Marpole area', 127, NULL)," +
                            "('Wing Chun Kung Fu Sash', 'Looking for experienced Wing Chun Teacher near Kitsilano', 128, NULL)," +
                            "('Shotokan-ryu Karate White Belt', 'Searching for easy going instructor of Shotokun in Burnaby', 129, NULL)," +
                            "('Wushu Kung Fu No Experience', 'Wondering if there are any good teachers at UBC for Wushu, wish to learn how to butterfly', 130, 906)," +
                            "('Hun Gar Kung Fu Senoir Sash Student', 'I have trained in the hun gar style of kung fu and wish to further my skills. Looking for instructor with 20+ years of experience.', 131, 906)," +
                            "('WTF TaeKwondo Green Belt With Blue Stripe','Looking to further my career in TaeKwonDo in West Point Grey Area', 132, 907 )," +
                            "('Shito-ryu Karate Purple Belt','Very Experienced Karate practitioner looking for sensei to complete my belts in the shawnessy catchman', 133, 907)," +
                            "('Choy Lei Fut Kung Fu Junior level sash','Previously trained in a school for choi lei fut and wish to continue in the Richmond district', 134, 908)," +
                            "('Wushu Kung Fu 2 years experience','Looking for instructor in Wushu in the Richmond Area', 135, 908)," +
                            "('ITF TaeKwondo yellow belt', 'Looking for Taekwondo instructor in Marpole area', 136, 908)," +
                            "('Wing Chun Kung Fu Sash', 'Looking for experienced Wing Chun Teacher near Kitsilano', 137, 908)," +
                            "('Shotokan-ryu Karate White Belt', 'Searching for easy going instructor of Shotokun in Burnaby', 138, NULL)," +
                            "('Wushu Kung Fu No Experience', 'Wondering if there are any good teachers at UBC for Wushu, wish to learn how to butterfly', 139, NULL)," +
                            "('Hun Gar Kung Fu Senoir Sash Student', 'I have trained in the hun gar style of kung fu and wish to further my skills. Looking for instructor with 20+ years of experience.', 140, NULL)";

            // Create instructor table ===============================================================
            String addUserSchemaInst =
                    "CREATE TABLE Instructors(" +
                            "year INT," +
                            "style CHAR (20)," +
                            "headline VARCHAR (400)," +
                            "inid INT NOT NULL," +
                            "FOREIGN KEY (inid) REFERENCES Users(uid)," +
                            "FOREIGN KEY (style) REFERENCES MartialArtsType(style))";
            // an example of headline could be "Upcoming group lesson of 20 in ST building"



            // Populate a tuple for Instructors
            String insertInstructors =
                    "INSERT INTO Instructors " +
                            "(year , style, headline, inid) " +
                            "VALUES " +
                            "(7, 'Wing Chun', 'Upcoming group Kungfu lesson of 20 in Oakridge Center', 901)," +
                            "(10, 'Wushu', 'Kung Fu Lessons Every Friday at the UBC NEST', 902)," +
                            "(8, 'Shaolin','Training 3 times a week for 2 hours at Dunbar Community Center', 903)," +
                            "(5, 'Jeet Kun Do','Lessons for those new to the art once a week at the UBC dojo', 904)," +
                            "(2, 'Bagua', 'For fun and more casual lessons at the beach', 905)," +
                            "(4, 'Shotokan-Ryu', 'Training  for 2 days a week at the Fraser Dojo', 906)," +
                            "(5, 'Shuri-ryu', 'Lessons held at the downtown dojo 3 times a week', 907)," +
                            "(6, 'WTF', 'Training Center open for lessons near kingsway for up to 100 students', 908)," +
                            "(4, 'ITF', 'Sparring facilities located in Korea Town in Burnaby', 909)";


            // The martialArtsType table ===============================================================
            String addMartialArtsType =
                    "CREATE TABLE MartialArtsType(" +
                            "style CHAR (20), " +
                            "typeName CHAR (10)," +
                            "forms CHAR (255)," +
                            "PRIMARY KEY (style))";

            stmt.execute(addMartialArtsType);
            stmt.execute(addUserSchemaInst);
            stmt.execute(addUserSchemaStu);

            // Insert Martial Arts Types
            String insertMartialArtsType =
                    "INSERT INTO MartialArtsType " +
                            "VALUES" +
                            "('Wushu','Kung Fu','Long Fist, Southern Fist, Wushu Staff, Wushu Sword, Wushu Straight Sword, Wushu Spear, Chain Whip')," +
                            "('Hun Gar','Kung Fu','Plum Blossom Fist, LGK, Staff, Praying Mantis, Plum Blossom Broad Sword, CL Straight Sword, Spear, Tiger Crane')," +
                            "('Wing Chun','Kung Fu','Siu Lim Tao, Chum Kiu, Biu Gee, Dummy Form, Pole Form, Knife Form')," +
                            "('Choy Lei Fut','Kung Fu','Five Wheel Stance, Jiangmen Small Tiger-Blocking Hand Form, Junior Bin-Gwai Staff, Throat Locking Spear')," +
                            "('Shaolin','Kung Fu','Pao Chui, Dragon Boxing, Fire Staff, Five Tigers Kill Sheep Staff, Dragon Spring Sword, Swallow Saber, Meteor Hammer')," +
                            "('Bagua','Kung Fu','Single palm change Double palm change,Smooth body palm ,Back body palm')," +
                            "('Northen Shaolin','Kung Fu','Tan Teui ,Lian Bu,Xiao Yuen ,Enter The Gate ,Leading Steps ,Riding Horse ,Connecting Links ,The Method')," +
                            "('Jeet Kun Do','Kung Fu','The Five Gates, Un Moon')," +
                            "('Shotokan-Ryu','Karate','Fukyu, Pinan, Naihanchi, passai, kanku, seisan')," +
                            "('Shito-Ryu','Karate','Pinan, Bassai Dai, Seienchin, Saifa, Rōhai, Nipaipo')," +
                            "('Goju-ryu','Karate','Sanchin, Tensho, Gekisai Dai, Seipai, Saifa')," +
                            "('Wado-ryu','Karate','Pinan, Kushanku, Seishan, Chintō, Naihanchi, Jion, Wanshu, Jitte and Niseishi')," +
                            "('Shorin-ryu','Karate','Fukyu, Pinan, Naihanchi, passai, kanku, seisan')," +
                            "('Uechi-ryu','Karate','Sanchin, Seisan, Sanseirui')," +
                            "('Shuri-ryu','Karate','Wunsu, O-Naihanchi, Sanchin')," +
                            "('Kyokushinkai','Karate','Taikyoku, Pinan, Kanku, Sanchin, Tensho, Garyu')," +
                            "('Yoshukai','Karate','Seisan, Bassai, Yoshu, San Shi Ryu')," +
                            "('Chito-ryu','Karate','Shi Ho Hai, Seisan, Ro Hai Sho, Niseishi, Bassai, Chinto, Sochin, Tenshin, Ro Hai Dai, Sanshiryu, Ryushan, Kusanku, Sanchin')," +
                            "('WTF','Taekwondo','WTF Form 1,WTF Form 2,WTF Form 3,WTF Form 4,WTF Form 5,WTF Form 6,WTF Form 7,WTF Form 8')," +
                            "('ITF','Taekwando','Chon-Ji,Dan-Gun, Do-San, Won-Hyo, Yul-Gok,Joong-Gun, Toi-Gye, Hwa-Rang')";

            // The request table ===============================================================
            String addRequest =
                    "CREATE TABLE Request(" +
                            "sid INT, " +
                            "inid INT, " +
                            "PRIMARY KEY (sid)," +
                            "FOREIGN KEY (sid) REFERENCES Students(sid), " +
                            "FOREIGN KEY (inid) REFERENCES Instructors(inid))";

            stmt.execute(addRequest);

            // Populate tuples for request
            String insertRequests =
                    "INSERT INTO Request " +
                            "(sid, inid) " +
                            "VALUES " +
                            "(101, 901)," +
                            "(102, 902)," +
                            "(103, 903)," +
                            "(140, 904)," +
                            "(139, 905)," +
                            "(138, 902)," +
                            "(129, 908)," +
                            "(128, 907)," +
                            "(127, 907)," +
                            "(124, 902)," +
                            "(125, 901)," +
                            "(120, 902)" ;


            // Create  table Plessons ===============================================================
            String addPl =
                    "CREATE TABLE Plessons(" +
                            "plid CHAR (10) NOT NULL," +
                            "sid INT NOT NULL," +
                            "price FLOAT NOT NULL," +
                            "loc VARCHAR (200) NOT NULL," +
                            "startTime CHAR (5) NOT NULL," +
                            "endTime CHAR (5) NOT NULL," +
                            "date CHAR(20) NOT NULL," +
                            "PRIMARY KEY (plid)," +
                            "FOREIGN KEY (sid) REFERENCES Students (sid))" ;

            stmt.execute(addPl);

            // Populate a tuple for Plessons
            String insertPl =
                    "INSERT INTO Plessons " +
                            "(plid, sid, price, loc, startTime, endTime, date) " +
                            "VALUES " +
                            "('p5000', 101, 100.00,'401, 8918 Marine DR.', '11:00', '13:00', 'Mar12-2017')," +
                            "('p5001', 104, 100.00, '401, 8918 Marine DR.', '11:00', '13:00', 'Mar14-2017')," +
                            "('p5002', 104, 200.00, '401, 8918 Marine DR.', '08:00', '13:00','April12-2017')," +
                            "('p5003', 105, 300.00, '401, 8918 Marine DR.', '11:00', '16:00', 'Mar22-2017')," +
                            "('p5004', 106, 100.00, '401, 8918 Marine DR.', '09:00', '12:00', 'April02-2017')," +
                            "('p5005', 107, 100.00, '401, 8918 Marine DR.', '11:00', '13:00', 'May17-2017')," +
                            "('p5006', 110, 50.00,  '401, 8918 Marine DR.',  '11:00', '12:00', 'May08-2017')," +
                            "('p5007', 119, 50.00,  '401, 8918 Marine DR.', '14:00', '14:30', 'April25-2017')," +
                            "('p5008', 119, 100.00, '401, 8918 Marine DR.', '13:00', '15:00', 'Sep27-2017')," +
                            "('p5009', 123, 100.00, '401, 8918 Marine DR.', '13:00', '14:00', 'Oct12-2017')," +
                            "('p5100', 126, 100.00, '401, 8918 Marine DR.', '11:00', '13:00', 'Sep22-2017')," +
                            "('p5110', 130, 25.00,  '401, 8918 Marine DR.', '09:00', '09:30', 'Nov04-2017')," +
                            "('p5120', 130, 25.00,  '401, 8918 Marine DR.', '16:00', '16:30', 'Dec23-2017')";


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
                            "(101, 'p5000')," +
                            "(104, 'p5002')," +
                            "(104, 'p5003')," +
                            "(105, 'p5004')," +
                            "(101, 'p5005')," +
                            "(101, 'p5006')," +
                            "(101, 'p5007')," +
                            "(101, 'p5008')," +
                            "(101, 'p5009')," +
                            "(101, 'p5100')," +
                            "(101, 'p5110')," +
                            "(101, 'p5120')" ;


            // Create Lesson table =============================================================
            String addLesson =
                    "CREATE TABLE Lesson(" +
                            "lid CHAR (10) NOT NULL," +
                            "inid INT NOT NULL," +
                            "loc VARCHAR (200) NOT NULL," +
                            "startTime CHAR (5) NOT NULL," +
                            "endTime CHAR (5) NOT NULL," +
                            "date CHAR(20) NOT NULL," +
                            "price FLOAT NOT NULL," +
                            "capacity INT NOT NULL," +
                            "PRIMARY KEY (lid)," +
                            "FOREIGN KEY (inid) REFERENCES Instructors (inid))";
            stmt.execute(addLesson);

            // Populate a tuple for lesson
            String insertLesson =
                    "INSERT INTO Lesson " +
                            "(lid, inid, price, loc, startTime, endTime, date, capacity) " +
                            "VALUES " +
                            "('L700', 908, 50.00, '401, 8918 Marine DR.', '11:00', '12:00','Marh22-2017', 10 ),"+
                            "('L701', 901, 75.00,'401, 8918 Marine DR.', '11:00', '13:00', 'Mar13-2017', 10)," +
                            "('L702', 903, 30.00, '401, 8918 Marine DR.', '08:00', '13:00','April10-2017', 20)," +
                            "('L703', 902, 30.00, '401, 8918 Marine DR.', '11:00', '16:00', 'Mar25-2017', 20)," +
                            "('L704', 905, 50.00, '401, 8918 Marine DR.', '09:00', '12:00', 'April01-2017', 15)," +
                            "('L705', 907, 75.00, '401, 8918 Marine DR.', '11:00', '13:00', 'May19-2017', 10)," +
                            "('L706', 908, 50.00,  '401, 8918 Marine DR.',  '11:00', '12:00', 'May05-2017', 10)," +
                            "('L707', 908, 50.00,  '401, 8918 Marine DR.', '14:00', '14:30', 'April29-2017', 20)," +
                            "('L708', 906, 30.00, '401, 8918 Marine DR.', '13:00', '15:00', 'Sep17-2017', 25)," +
                            "('L709', 904, 40.00, '401, 8918 Marine DR.', '13:00', '14:00', 'Oct10-2017', 15)," +
                            "('L710', 902, 30.00, '401, 8918 Marine DR.', '11:00', '13:00', 'Sep23-2017', 10)," +
                            "('L711', 907, 25.00,  '401, 8918 Marine DR.', '09:00', '09:30', 'Nov02-2017', 15)," +
                            "('L712', 909, 25.00,  '401, 8918 Marine DR.', '16:00', '16:30', 'Nov02-2017', 10)";


            // Create Register table =============================================================
            String addRegister =
                    "CREATE TABLE Register(" +
                            "sid INT NOT NULL,"+
                            "lid CHAR (10) NOT NULL," +
                            "PRIMARY KEY (sid, lid)," +
                            "FOREIGN KEY (sid) REFERENCES Students (sid)," +
                            "FOREIGN KEY (lid) REFERENCES Lesson (lid) " +
                            "ON DELETE CASCADE)";

            String insertRegister =
                    "INSERT INTO Register" +
                            "(sid, lid)" +
                            "VALUES" +
                            "(104, 'L701')," +
                            "(105, 'L703')," +
                            "(106, 'L703')," +
                            "(107, 'L703')," +
                            "(110, 'L703')," +
                            "(114, 'L702')," +
                            "(119, 'L709')," +
                            "(133, 'L711')," +
                            "(130, 'L708')," +
                            "(135, 'L707')," +
                            "(126, 'L704')," +
                            "(121, 'L704')";



            stmt.execute(addRegister);


            // Execute all insertion statements here, they are ordered in parent -> child way
            // Keep the order of the executes to this
            // insertuser, insertuseraddnull,
            stmt.execute(insertUser);
            stmt.execute(insertUserAddNull);
            stmt.execute(insertUserPhoNull);
            stmt.execute(insertUserHasBio);
            stmt.execute(insertMartialArtsType);
            stmt.execute(insertInstructors);
            stmt.execute(insertStudents);
            stmt.execute(insertRequests);
            stmt.execute(insertPl);
            stmt.execute(insertBook);
            stmt.execute(insertLesson);
            stmt.execute(insertRegister);




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
}