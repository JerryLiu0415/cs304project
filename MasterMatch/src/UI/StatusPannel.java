package UI;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;

/**
 * Created by Jerry on 2017-03-20.
 */
public class StatusPannel extends JPanel {


    private JPanel StatusPannel;
    private JTable table1;
    private JScrollPane pane;
    private JLabel label1;

    public StatusPannel() {
        this.setLayout(new GridLayout(3,3));

        String data[][] = {{"001","vinod","Bihar","India","Biology","65","First"},
                {"002","Raju","ABC","Kanada","Geography","58","second"},
                {"003","Aman","Delhi","India","computer","98","Dictontion"},
                {"004","Ranjan","Bangloor","India","chemestry","90","Dictontion"},
                {"001","vinod","Bihar","India","Biology","65","First"},
                {"002","Raju","ABC","Kanada","Geography","58","second"},
                {"003","Aman","Delhi","India","computer","98","Dictontion"},
                {"004","Ranjan","Bangloor","India","chemestry","90","Dictontion"},
                {"001","vinod","Bihar","India","Biology","65","First"},
                {"002","Raju","ABC","Kanada","Geography","58","second"},
                {"003","Aman","Delhi","India","computer","98","Dictontion"},
                {"004","Ranjan","Bangloor","India","chemestry","90","Dictontion"},
                {"001","vinod","Bihar","India","Biology","65","First"},
                {"002","Raju","ABC","Kanada","Geography","58","second"},
                {"003","Aman","Delhi","India","computer","98","Dictontion"},
                {"004","Ranjan","Bangloor","India","chemestry","90","Dictontion"},
                {"001","vinod","Bihar","India","Biology","65","First"},
                {"002","Raju","ABC","Kanada","Geography","58","second"},
                {"003","Aman","Delhi","India","computer","98","Dictontion"},
                {"004","Ranjan","Bangloor","India","chemestry","90","Dictontion"},
                {"001","vinod","Bihar","India","Biology","65","First"},
                {"002","Raju","ABC","Kanada","Geography","58","second"},
                {"003","Aman","Delhi","India","computer","98","Dictontion"},
                {"004","Ranjan","Bangloor","India","chemestry","90","Dictontion"},
                {"001","vinod","Bihar","India","Biology","65","First"},
                {"002","Raju","ABC","Kanada","Geography","58","second"},
                {"003","Aman","Delhi","India","computer","98","Dictontion"},
                {"004","Ranjan","Bangloor","India","chemestry","90","Dictontion"},
                {"001","vinod","Bihar","India","Biology","65","First"},
                {"002","Raju","ABC","Kanada","Geography","58","second"},
                {"003","Aman","Delhi","India","computer","98","Dictontion"},
                {"004","Ranjan","Bangloor","India","chemestry","90","Dictontion"}};
        String col[] = {"Roll","Name","State","country","Math","Marks","Grade"};

        table1 = new JTable(data, col);
        JTableHeader header = table1.getTableHeader();
        header.setBackground(Color.yellow);
        pane = new JScrollPane(table1);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.add(pane);
        this.add(new JTextArea("AA"));
        this.add(new JTextArea("BB"));
        this.add(new JTextArea("CC"));
        this.add(new JTextArea("DD"));





    }

}
