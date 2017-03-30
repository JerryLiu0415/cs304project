package UI;

import BackEnd.DataBaseConnection;
import BackEnd.QueryAndUpdate;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Jerry on 2017-03-17.
 */

public class MainUI extends JFrame {
    private JPanel MainPanel = new JPanel();
    private AccountPannel account;
    private StatusPannel status;


    private static DataBaseConnection dbconn = new DataBaseConnection();
    private static QueryAndUpdate querySender;
    final static int extraWindowWidth = 100;


    public MainUI() {
        MainPanel.setLayout(new GridLayout());
        querySender = new QueryAndUpdate(dbconn.conn);
        //Put the JComboBox in a JPanel to get a nicer look.
        JTabbedPane tabbedPane = new JTabbedPane();
        sharedVariables.getInstance().setMainPanel(tabbedPane);

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

        card1.setLayout(new GridLayout(4,8));
        for (int i = 0; i < 31; i++) {
            String s = Integer.toString(i);
            card1.add(new JButton("Button " + s));
        }

        JPanel holder = new JPanel();
        holder.setLayout(new GridLayout());
        holder.add(new Button("GG"));
        holder.add(new Button("HH"));
        holder.add(new Button("II"));
        card1.add(holder);

        status = new StatusPannel(querySender);
        account = new AccountPannel(querySender);

        tabbedPane.addTab("Account", account);
        tabbedPane.addTab("Status", status);
        tabbedPane.addTab("Calendar", card1);


        MainPanel.add(tabbedPane, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        dbconn.connect();
        sharedVariables currentUser = sharedVariables.getInstance( );

        JFrame frame = new JFrame("MainUI");
        frame.setContentPane(new MainUI().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1200, 1000));
        frame.setTitle("MasterMatch");
        frame.setVisible(true);
    }
}
