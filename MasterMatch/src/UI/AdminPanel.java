package UI;

import BackEnd.QueryAndUpdate;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jerry on 2017-03-31.
 */
public class AdminPanel extends JPanel {
    private JTable adminTable;

    public AdminPanel(final QueryAndUpdate querySender) {
        ArrayList<ArrayList<String>> newData2 = new ArrayList<ArrayList<String>>();
        ArrayList<String> newCol2 = new ArrayList<String>(Arrays.asList("lid", "inid"));
        String query = "SELECT * from USERS";
        MyModel m2 = querySender.selectGeneral(query);


        adminTable = new JTable(m2);
        adminTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        adminTable.setShowGrid(true);
        adminTable.setGridColor(Color.BLACK);
        JTableHeader h2 = adminTable.getTableHeader();
        h2.setBackground(Color.lightGray);
        JScrollPane pane2 = new JScrollPane(adminTable);


        pane2.setPreferredSize(new Dimension(600,600));
        pane2.setBorder(BorderFactory.createTitledBorder("All Users"));
        pane2.setBackground(Color.lightGray);

        JButton remove = new JButton("Remove");
        remove.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int row = adminTable.getSelectedRows()[0];
                System.out.println(row);
                int uid = Integer.parseInt(adminTable.getValueAt(row, 0).toString());
                querySender.deleteUser(uid);
                String query = "SELECT * from USERS";
                MyModel m2 = querySender.selectGeneral(query);
                adminTable.setModel(m2);
            }
        });

        JButton refresh = new JButton("Refresh");
        refresh.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String query = "SELECT * from USERS";
                MyModel m2 = querySender.selectGeneral(query);
                adminTable.setModel(m2);
            }
        });

        this.add(pane2);
        this.add(remove);
        this.add(refresh);
    }

}
