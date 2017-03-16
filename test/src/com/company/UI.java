package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by Jerry on 2017-03-15.
 */
public class UI {
    private JTextArea textArea1;
    private JPanel MainPanel;
    private JButton button1;

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private cat c = null;


    public UI() {
        connect();
        // Called when button is clicked
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Just make sure that UI class interact with other classes
                c = new cat(100);
                textArea1.setText("Here lists the ids you stored in table cat: \n");
                try {
                    stmt = conn.createStatement();
                    // Sending a query on tabel cats
                    if (stmt.execute("SELECT * FROM cats")) {
                        rs = stmt.getResultSet();
                        while (rs.next()) {
                            System.out.println(rs.getString(1));
                            textArea1.setText(textArea1.getText() + "\n" + rs.getString(1));
                        }
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

// Uncomment and move the below statements into try clause above if cat table haven't set up.

//            String createTable = "CREATE TABLE cats (id INT unsigned NOT NULL AUTO_INCREMENT, " +
//                    "name VARCHAR(150) NOT NULL, PRIMARY KEY (id))";
//
//            stmt.executeUpdate(createTable);
//            rs = stmt.executeQuery("CREATE TABLE cats (id INT unsigned NOT NULL AUTO_INCREMENT, " +
//                    "name VARCHAR(150) NOT NULL, PRIMARY KEY (id))");
//

//            String insert = "INSERT INTO cats ( id, name) VALUES" +
//                    "(87654321, 'cat2'), (22222222, 'cat3')";
//            stmt.executeUpdate(insert);

            }
        });
    }

    public void setData(UI data) {
    }

    public void getData(UI data) {
    }

    public boolean isModified(UI data) {
        return false;
    }

    public void connect() {
        //  Connection Set Up
        try {
            /*
            Connect using driver
            replace 1 with your own password
            */


            conn = DriverManager.getConnection("jdbc:mysql://localhost/pets?" +
                    "user=root&password=1");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }
        catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage());

        }
    }


    public static void main(String[] args) {
        // UI Stuff generated automatically
        JFrame frame = new JFrame("UI");
        frame.setPreferredSize(new Dimension(640, 800));
        frame.setContentPane(new UI().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
