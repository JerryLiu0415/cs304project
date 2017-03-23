# CPSC 304 Project Repository

## Code Structure
#### Main Classes
* BackEndMain.java: Running this main class will connect to sql server without UI.
* CreateAndPopulateDBMain.java: Run it to reset your database to a standard one. It overrites any existing table in masterMatch database with new ones, and populates each table.
* MainUI.java: Connect to sql with UI comes out.

#### Connection
* DataBaseConnection.java: Contains methods for connecting to the database, each main method will need to have an instance of DataBaseConnection to connect.
* QueryAndUpdate.java: Contains methods for sending SQL queries and return their results. For example, all queires looks like "select * from students where age > 20 AND age < 25" can be wrtten as "findStudentOfAge(a,b)", such that UI can simply call that in an event handler instead of puting lots of low level codes "stmt.execute("..."), resp.getString(1), ..."

#### DataStructures (May not needed)
* The result from a query can be parsed into objects such that we can handel them easily.


## Notes 
* After cloning from the repo, open the "MasterMatch" folder using IntelliJ instead of "cs304project"
* After cloning other's work, always need to reset the library path for connector by files -> project structure -> libraries and remove (-) any existing library path and add (+) your own. (otherwise get driver not found error)
* Either change your password to 1, or modify line 22 in DataBaseConnection.java to use your own password.
* masterMatch database had to be there already.


## Plan
#### 1a. Finish CreateAndPopulateDBMain.java by creating tables and inserting tuples. (- March 21)
* Users (Created) + (Populated)
* Register (Created) C 
* Lesson (Created) C
* Book (Created) K
* Plessons (Created) C
* Request (Created) K
* Students (Created) + (Populated) 
* Instructors (Created) K
* MartialArtsType (Created) K


#### 1b. Summarize all queries we need according to functionalities and demo marking checklist. (- March 21)
* (1 point) Selection and projection query: pick one query of this category and provide an interface for the user to specify the selection condition and the attributes to be returned.

* (1 point) Join query: pick one query of this category and provide an interface for the user to choose this query.

* (1 point) Division query: pick one query of this category and provide an interface for the user to choose this query.

* (1 point) Aggregation query: pick one query that requires the use of aggregation (min, max, average, or count are all fine).

* (2 points) Nested aggregation with group-by: pick one query that finds the average for each group and then finds either the minimum or maximum across all those averages. Provide an interface for the user to specify whether the minimum or maximum is requested.

* (1 point) Delete operation: implement a cascade-on-delete situation. Provide an interface for the user to specify some input for the deletion operation.  Some input values would fail the cascade specification but others would successfully follow the cascade specification. Provide an interface for the user to display the relation instance after the operation.

* (1 point) Update operation: implement a constraint using the check statement. Provide an interface for the user to specify some input for the update operation. Some input values would successfully satisfy a constraint while others would fail. Provide an interface for the user to display the relation relation after the operation.Note that MySQL 5.5 does not support the Check constraint. If your team is using MySQL 5.5, keep the check in the SQL statement, but actually do the check at the application level (and comment it in the code).

* (2 points)  Graphical user interface: create an easy to use GUI  that allows the users to execute all the above operations and transactions. Use the menu facility provided by the graphics environment you use to define appropriate menus and submenus. Make sure to design your interface in such a way that all the error messages appear in separate pop-up boxes, or in a designated area of the main window, so that they do not interfere with the other activities. Whenever user input is requested, make sure that there is sufficient type checking. 

* (3 points) Extra features: Create unique features that your application supports. You can really be creative about this. Some examples are using Bootstrap to prettify your UI, implementing Triggers and Privileges in the database, using any cloud-based databases. See the marking scheme for more examples and the breakdown.

###### Queries we have so far
* 1. Find user with user id "101" and password 55555555 (This query is sent whenever someone tries to log in).
* 2. Find the student who registered in all lessons held by 'Kevin Ho' (Interested by instructor)
* 3. Find details of student with id = 101 (Instructor may right click a row in the table to see the details)
* 4. Find average teaching exp among instructors of age over 20.
* 5. List all students (name,id) of age between 20 and 30.
* 6. List all instructos (name , id) with more than 5 years of teaching experience.
* 7. Find the name and id of students who've sent a request to instructor 'Kevin Ho'
* 8. Find the average age of studeents for each lesson.
* 9. Find the average age among the min age of each student grouped by lesson.
* 10. Find all lessons held by 'Kevin Ho'

###### Updates we have so far
* 1. Change the password of user 101 to 1
* 2. Add stuent to some lesson held by 'Kevin Ho'.
* 3. Add student to 'Kevin Ho', meanwhile remove him from the request table.
* 4. Add student to some private lesson and remove him from the booking record.
* 5. Remove student from a lesson, a relationship or a private lesson.
* 6. Remove student from lesson held by 'Kevin Ho'
* 7. Add a user. (The user are required to provide essential imformations.)
* 8. Upate a user's isBlocked field to true. 
* 9. Remove a lesson from instructor 'Kevin Ho'. (Lots of updates followed by this, for example all students register)




#### 2a. Translating all queries into SQL, and run to test if they really work. (?)

#### 2b. Updates/Insertions. (?)

#### 3. Refactor SQLs into functions such that the UI class can call them easily. (?)

#### 4. Combine backend with UI. (March 21 - March 31)

