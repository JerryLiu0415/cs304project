package UI;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;

/**
 * Created by Jerry on 2017-03-20.
 */
public class StatusPannel extends JPanel {

    private JLabel label1;

    public StatusPannel() {
        this.setLayout(new GridLayout(2,0));
        String data[][] = {{"a", "1"},{"b", "2"},{"c", "3"},{"d", "5"},{"e", "6"},{"f", "7"}};
        String col[] = {"name", "id"};

        JTable table1 = new JTable(data, col);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table1.setShowGrid(true);
        table1.setGridColor(Color.BLACK);
        JTableHeader header = table1.getTableHeader();
        header.setBackground(Color.lightGray);
        JScrollPane pane = new JScrollPane(table1);

        TableColumn column = null;
        for (int i = 0; i < 2; i++) {
            column = table1.getColumnModel().getColumn(i);
            if (i == 1) {
                column.setPreferredWidth(50);
            } else {
                column.setPreferredWidth(50);
            }
        }

        pane.setPreferredSize(new Dimension(120,200));
        pane.setBorder(BorderFactory.createTitledBorder("Students"));
        pane.setBackground(Color.lightGray);

        JTable table2 = new JTable(data, col);
        table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table2.setShowGrid(true);
        table2.setGridColor(Color.BLACK);
        JTableHeader header2 = table2.getTableHeader();
        header.setBackground(Color.lightGray);
        JScrollPane pane2 = new JScrollPane(table2);

        TableColumn column2 = null;
        for (int i = 0; i < 2; i++) {
            column2 = table2.getColumnModel().getColumn(i);
            if (i == 1) {
                column2.setPreferredWidth(50);
            } else {
                column2.setPreferredWidth(50);
            }
        }

        pane2.setPreferredSize(new Dimension(120,200));
        pane2.setBorder(BorderFactory.createTitledBorder("Lessons"));
        pane2.setBackground(Color.lightGray);

        JTable table3 = new JTable(data, col);
        table3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table3.setShowGrid(true);
        table3.setGridColor(Color.BLACK);
        JTableHeader header3 = table3.getTableHeader();
        header.setBackground(Color.lightGray);
        JScrollPane pane3 = new JScrollPane(table3);

        TableColumn column3 = null;
        for (int i = 0; i < 2; i++) {
            column3 = table3.getColumnModel().getColumn(i);
            if (i == 1) {
                column3.setPreferredWidth(50);
            } else {
                column3.setPreferredWidth(50);
            }
        }

        pane3.setPreferredSize(new Dimension(120,200));
        pane3.setBorder(BorderFactory.createTitledBorder("Requests"));
        pane3.setBackground(Color.lightGray);

        JPanel top = new JPanel();
        top.setLayout(new GridLayout());

        JPanel topLeft = new JPanel();
        topLeft.setLayout(new GridLayout(0,3));

        JPanel topLeftP1 = new JPanel();
        topLeftP1.setBorder(BorderFactory.createRaisedBevelBorder());
        topLeftP1.add(pane);
        JPanel topLeftP1S = new JPanel();
        topLeftP1S.setLayout(new BoxLayout(topLeftP1S, BoxLayout.Y_AXIS));
        JButton TLP1B1 = new JButton("Dtl");
        TLP1B1.setPreferredSize(new Dimension(30,20));
        JButton TLP1B2 = new JButton("Rmv");
        TLP1B2.setPreferredSize(new Dimension(30,20));


        topLeftP1S.add(TLP1B1);
        topLeftP1S.add(Box.createRigidArea(new Dimension(10, 10)));
        topLeftP1S.add(TLP1B2);
        topLeftP1.add(topLeftP1S);

        JPanel topLeftP2 = new JPanel();
        topLeftP2.setBorder(BorderFactory.createRaisedBevelBorder());
        topLeftP2.add(pane2);
        JPanel topLeftP2S = new JPanel();
        topLeftP2S.setLayout(new BoxLayout(topLeftP2S, BoxLayout.Y_AXIS));
        JButton TLP2B1 = new JButton("Dtl");
        TLP2B1.setPreferredSize(new Dimension(30,20));
        JButton TLP2B2 = new JButton("Rmv");
        TLP2B2.setPreferredSize(new Dimension(30,20));
        JButton TLP2B3 = new JButton("Upd");
        TLP2B3.setPreferredSize(new Dimension(30,20));
        JButton TLP2B4 = new JButton("Sum");
        TLP2B4.setPreferredSize(new Dimension(30,20));


        topLeftP2S.add(TLP2B1);
        topLeftP2S.add(Box.createRigidArea(new Dimension(10, 10)));
        topLeftP2S.add(TLP2B2);
        topLeftP2S.add(Box.createRigidArea(new Dimension(10, 10)));
        topLeftP2S.add(TLP2B3);
        topLeftP2S.add(Box.createRigidArea(new Dimension(10, 10)));
        topLeftP2S.add(TLP2B4);
        topLeftP2.add(topLeftP2S);


        JPanel topLeftP3 = new JPanel();
        topLeftP3.setBorder(BorderFactory.createRaisedBevelBorder());
        topLeftP3.add(pane3);
        JPanel topLeftP3S = new JPanel();
        topLeftP3S.setLayout(new BoxLayout(topLeftP3S, BoxLayout.Y_AXIS));
        JButton TLP3B1 = new JButton("Rej");
        TLP3B1.setPreferredSize(new Dimension(30,20));
        JButton TLP3B2 = new JButton("Acp");
        TLP3B2.setPreferredSize(new Dimension(30,20));
        JButton TLP3B3 = new JButton("Dtl");
        TLP3B3.setPreferredSize(new Dimension(30,20));


        topLeftP3S.add(TLP3B1);
        topLeftP3S.add(Box.createRigidArea(new Dimension(10, 10)));
        topLeftP3S.add(TLP3B2);
        topLeftP3S.add(Box.createRigidArea(new Dimension(10, 10)));
        topLeftP3S.add(TLP3B3);
        topLeftP3.add(topLeftP3S);

        topLeft.setLayout(new FlowLayout(FlowLayout.LEFT));
        topLeft.setBorder(BorderFactory.createTitledBorder("Relationships"));



        topLeft.add(topLeftP1);
        topLeft.add(topLeftP2);
        topLeft.add(topLeftP3);
        topLeft.add(new Label("df"));

        JPanel topRight = new JPanel();
        topRight.add(new Label("Name: XXX"));
        topRight.add(new Label("Id: XXX"));
        topRight.add(new Label("Email: XXX"));
        topRight.add(new Label("Number Students: XXXX"));
        topRight.setBorder(BorderFactory.createTitledBorder("Personal Info"));
        top.add(topLeft);
        top.add(topRight);


        this.add(top);
        JPanel bot = new JPanel();
        bot.setBorder(BorderFactory.createTitledBorder("GeneralQueries"));
        bot.add(new Label("A large by dynamic table here, displaying all kinds of query results!"));


        this.add(bot);

    }

}
