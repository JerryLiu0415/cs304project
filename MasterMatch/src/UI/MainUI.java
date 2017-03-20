package UI;

import BackEnd.DataBaseConnection;

import javax.swing.*;


/**
 * Created by Jerry on 2017-03-17.
 */
public class MainUI {
    private JPanel MainPanel;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private DataBaseConnection dbconn = new DataBaseConnection();


    public MainUI() {
        dbconn.connect();

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainUI");
        frame.setContentPane(new MainUI().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
