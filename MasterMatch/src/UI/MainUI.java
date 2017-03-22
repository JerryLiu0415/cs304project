package UI;

import BackEnd.DataBaseConnection;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Jerry on 2017-03-17.
 */

public class MainUI extends JFrame {
    private JPanel MainPanel;
    private AccountPannel calendar;
    private StatusPannel status;

    JPanel cards;

    private static DataBaseConnection dbconn = new DataBaseConnection();
    final static int extraWindowWidth = 100;


    public MainUI() {
        //Put the JComboBox in a JPanel to get a nicer look.
        JTabbedPane tabbedPane = new JTabbedPane();

        //Create the "cards".
        JPanel card1 = new JPanel() {
            //Make the panel wider than it really needs, so
            //the window's wide enough for the tabs to stay
            //in one row.
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                return size;
            }
        };

        card1.setLayout(new GridLayout(0,2));
        card1.add(new JTextField(20));
        card1.add(new JButton("Button 1"));
        card1.add(new JButton("Button 2"));
        card1.add(new JButton("Button 3"));

        status = new StatusPannel();
        calendar = new AccountPannel();

        tabbedPane.addTab("Account", calendar);
        tabbedPane.addTab("Status", status);
        tabbedPane.addTab("Calendar", card1);

        MainPanel.add(tabbedPane, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        dbconn.connect();
        JFrame frame = new JFrame("MainUI");
        frame.setContentPane(new MainUI().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(800, 600));
        frame.setTitle("MasterMatch");
        frame.setVisible(true);
    }
}
