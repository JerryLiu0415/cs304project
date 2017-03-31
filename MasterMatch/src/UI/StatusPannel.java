package UI;

import BackEnd.QueryAndUpdate;
import UI.SubViews.AdvancedFilter;
import UI.SubViews.lessonAddPopUp;
import UI.SubViews.lessonTimePopUp;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jerry on 2017-03-20.
 */
public class StatusPannel extends JPanel {
    public QueryAndUpdate querySender;
    private JLabel label1;
    JScrollPane generalPane;
    JTable studentTable;
    JTable lessonTable;
    JTable requestTable;
    JTable generalTable;
    JTable aggregationTable;
    Label x1 = new Label("Name: None");
    Label x2 = new Label("Id: ");
    JTextField x3 = new JTextField("Email: None");
    JTextField x4 = new JTextField("Age: None");
    JTextField x5 = new JTextField("Address: None");
    JTextField x6 = new JTextField("Gender: None");


    public StatusPannel(final QueryAndUpdate querySender) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


        this.querySender = querySender;
        this.setLayout(new GridLayout(2,0));

        // Relationship Tables
        // Students
        ArrayList<ArrayList<String>> newData = new ArrayList<ArrayList<String>>();
        ArrayList<String> newCol = new ArrayList<String>(Arrays.asList("sid", "unmae"));
        MyModel m = new MyModel(newData,newCol);

        studentTable = new JTable(m);
        studentTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        studentTable.setShowGrid(true);
        studentTable.setGridColor(Color.BLACK);
        JTableHeader h = studentTable.getTableHeader();
        h.setBackground(Color.lightGray);
        JScrollPane pane = new JScrollPane(studentTable);

        TableColumn c = null;
        for (int i = 0; i < newCol.size(); i++) {
            c = studentTable.getColumnModel().getColumn(i);
            c.setPreferredWidth(50);
        }
        pane.setPreferredSize(new Dimension(120,200));
        pane.setBorder(BorderFactory.createTitledBorder("Students"));
        pane.setBackground(Color.lightGray);

        // Lessons
        ArrayList<ArrayList<String>> newData2 = new ArrayList<ArrayList<String>>();
        ArrayList<String> newCol2 = new ArrayList<String>(Arrays.asList("lid", "inid"));
        MyModel m2 = new MyModel(newData2,newCol2);

        lessonTable = new JTable(m2);
        lessonTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        lessonTable.setShowGrid(true);
        lessonTable.setGridColor(Color.BLACK);
        JTableHeader h2 = lessonTable.getTableHeader();
        h2.setBackground(Color.lightGray);
        JScrollPane pane2 = new JScrollPane(lessonTable);

        for (int i = 0; i < newCol2.size(); i++) {
            c = lessonTable.getColumnModel().getColumn(i);
            c.setPreferredWidth(50);
        }
        pane2.setPreferredSize(new Dimension(120,200));
        pane2.setBorder(BorderFactory.createTitledBorder("Lessons"));
        pane2.setBackground(Color.lightGray);

        // Requests
        ArrayList<ArrayList<String>> newData3 = new ArrayList<ArrayList<String>>();
        ArrayList<String> newCol3 = new ArrayList<String>(Arrays.asList("sid", "inid"));
        MyModel m3 = new MyModel(newData3, newCol3);

        requestTable = new JTable(m3);
        requestTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        requestTable.setShowGrid(true);
        requestTable.setGridColor(Color.BLACK);
        JTableHeader h3 = requestTable.getTableHeader();
        h3.setBackground(Color.lightGray);
        JScrollPane pane3 = new JScrollPane(requestTable);

        for (int i = 0; i < newCol3.size(); i++) {
            c = requestTable.getColumnModel().getColumn(i);
            c.setPreferredWidth(50);
        }

        pane3.setPreferredSize(new Dimension(120,200));
        pane3.setBorder(BorderFactory.createTitledBorder("Request"));
        pane3.setBackground(Color.lightGray);
        refresh();


        JPanel top = new JPanel();
        top.setLayout(new GridLayout());

        JPanel topLeft = new JPanel();
        topLeft.setLayout(new BoxLayout(topLeft, BoxLayout.Y_AXIS));

        JPanel topLeftP1 = new JPanel();
        topLeftP1.setBorder(BorderFactory.createRaisedBevelBorder());
        topLeftP1.add(pane);
        JPanel topLeftP1S = new JPanel();
        topLeftP1S.setLayout(new BoxLayout(topLeftP1S, BoxLayout.Y_AXIS));
        JButton TLP1B1 = new JButton("Info");
        TLP1B1.setToolTipText("Select a row and click on info to get students' details");
        TLP1B1.setPreferredSize(new Dimension(30,20));
        TLP1B1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int[] rows = studentTable.getSelectedRows();
                JTable detailTable = new JTable();
                int sid = Integer.parseInt(studentTable.getValueAt(rows[0], 0).toString());
                MyModel m = querySender.findStudentDetail(sid);
                for (int i = 1; i < rows.length; i++) {
                    sid = Integer.parseInt(studentTable.getValueAt(rows[i], 0).toString());
                    ArrayList<String> row = querySender.findStudentDetail(sid).data.get(0);
                    m.addRow(row);
                }
                if (m != null) {
                    detailTable.setModel(m);

                    JFrame detail = new JFrame();
                    detail.setTitle("Details");
                    JPanel detailPane = new JPanel();

                    TableColumn c = null;
                    c = detailTable.getColumnModel().getColumn(0);
                    c.setPreferredWidth(30);
                    c = detailTable.getColumnModel().getColumn(1);
                    c.setPreferredWidth(90);
                    c = detailTable.getColumnModel().getColumn(2);
                    c.setPreferredWidth(30);
                    c = detailTable.getColumnModel().getColumn(3);
                    c.setPreferredWidth(50);
                    c = detailTable.getColumnModel().getColumn(4);
                    c.setPreferredWidth(150);
                    c = detailTable.getColumnModel().getColumn(5);
                    c.setPreferredWidth(100);
                    c = detailTable.getColumnModel().getColumn(6);
                    c.setPreferredWidth(150);
                    c = detailTable.getColumnModel().getColumn(7);
                    c.setPreferredWidth(450);

                    detailTable.setShowGrid(true);
                    detailTable.setGridColor(Color.BLACK);

                    JScrollPane detailS = new JScrollPane(detailTable);
                    detailS.setPreferredSize(new Dimension(1000, 400));


                    detailPane.add(detailS);
                    detail.setContentPane(detailPane);
                    detail.setSize(new Dimension(1000, 400));
                    detail.setVisible(true);
                }
                else {
                    popUpWarning("Invalid query", "Error");
                }

            }
        });
        JButton TLP1B2 = new JButton("Del");
        TLP1B2.setToolTipText("Select a row and click on Del to remove a student ");
        TLP1B2.setPreferredSize(new Dimension(30,20));
        TLP1B2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int[] rows = studentTable.getSelectedRows();
                for (int i = 0; i < rows.length; i++) {
                    int sid = Integer.parseInt(studentTable.getValueAt(rows[i], 0).toString());
                    querySender.deleteRelationShip(sid);
                }
                refresh();
                popUpWarning("Student(s) removed!","Deletion Performed");
            }
        });


        topLeftP1S.add(TLP1B1);
        topLeftP1S.add(Box.createRigidArea(new Dimension(10, 10)));
        topLeftP1S.add(TLP1B2);
        topLeftP1.add(topLeftP1S);

        JPanel topLeftP2 = new JPanel();
        topLeftP2.setBorder(BorderFactory.createRaisedBevelBorder());
        topLeftP2.add(pane2);
        JPanel topLeftP2S = new JPanel();
        topLeftP2S.setLayout(new BoxLayout(topLeftP2S, BoxLayout.Y_AXIS));
        JButton TLP2B1 = new JButton("Info");
        TLP2B1.setToolTipText("Select a row and click on Info to get lesson details");
        TLP2B1.setPreferredSize(new Dimension(30,20));
        TLP2B1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int[] rows = lessonTable.getSelectedRows();
                System.out.println(rows.length);
                JTable detailTable = new JTable();
                String lid = lessonTable.getValueAt(rows[0], 0).toString();
                MyModel m = querySender.findLessonDetail(lid);
                for (int i = 1; i < rows.length; i++) {
                    lid = lessonTable.getValueAt(rows[i], 0).toString();
                    ArrayList<String> row = querySender.findLessonDetail(lid).data.get(0);
                    m.addRow(row);
                }
                if (m != null) {
                    detailTable.setModel(m);
                    JFrame detail = new JFrame();
                    detail.setTitle("Details");
                    JPanel detailPane = new JPanel();

                    TableColumn c = null;
                    c = detailTable.getColumnModel().getColumn(0);
                    c.setPreferredWidth(30);
                    c = detailTable.getColumnModel().getColumn(1);
                    c.setPreferredWidth(30);

                    detailTable.setShowGrid(true);
                    detailTable.setGridColor(Color.BLACK);

                    JScrollPane detailS = new JScrollPane(detailTable);
                    detailS.setPreferredSize(new Dimension(1000, 400));


                    detailPane.add(detailS);
                    detail.setContentPane(detailPane);
                    detail.setSize(new Dimension(1000, 400));
                    detail.setVisible(true);
                } else {
                    popUpWarning("Invalid query", "Error");
                }

            }
        });
        JButton TLP2B2 = new JButton("Del");
        TLP2B2.setToolTipText("Select a row and click on Del to remove a lesson");
        TLP2B2.setPreferredSize(new Dimension(30,20));
        TLP2B2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int[] rows = lessonTable.getSelectedRows();
                for (int i = 0; i < rows.length; i++) {
                    String lid = lessonTable.getValueAt(rows[i], 0).toString();
                    querySender.deleteLesson(lid);
                }
                refresh();
                popUpWarning("Lesson(s) removed!","Deletion Performed");
            }
        });


        JButton TLP2B3 = new JButton("Upd");
        TLP2B3.setToolTipText("Update selected lesson");
        TLP2B3.setPreferredSize(new Dimension(30,20));
        TLP2B3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                lessonTimePopUp frame = new lessonTimePopUp(lessonTable, querySender, lessonTable.getSelectedRow());
                frame.setSize(new Dimension(800, 200));
                frame.setTitle("Update a lesson");
                frame.setVisible(true);
                refresh();
            }
        });

        JButton TLP2B4 = new JButton("Add");
        TLP2B4.setToolTipText("Add a lesson");
        TLP2B4.setPreferredSize(new Dimension(30,20));
        TLP2B4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                lessonAddPopUp frame = new lessonAddPopUp(lessonTable, querySender, lessonTable.getSelectedRow());
                frame.setSize(new Dimension(800, 200));
                frame.setTitle("Add a lesson");
                frame.setVisible(true);
                refresh();
            }
        });


        topLeftP2S.add(TLP2B1);
        topLeftP2S.add(Box.createRigidArea(new Dimension(10, 10)));
        topLeftP2S.add(TLP2B2);
        topLeftP2S.add(Box.createRigidArea(new Dimension(10, 10)));
        topLeftP2S.add(TLP2B3);
        topLeftP2S.add(Box.createRigidArea(new Dimension(10, 10)));
        topLeftP2S.add(TLP2B4);
        topLeftP2S.add(Box.createRigidArea(new Dimension(10, 10)));
        topLeftP2.add(topLeftP2S);


        JPanel topLeftP3 = new JPanel();
        topLeftP3.setBorder(BorderFactory.createRaisedBevelBorder());
        topLeftP3.add(pane3);
        JPanel topLeftP3S = new JPanel();
        topLeftP3S.setLayout(new BoxLayout(topLeftP3S, BoxLayout.Y_AXIS));
        JButton TLP3B1 = new JButton("Rej");
        TLP3B1.setToolTipText("Reject selected request");
        TLP3B1.setPreferredSize(new Dimension(30,20));
        TLP3B1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int[] rows = requestTable.getSelectedRows();
                for (int i = 0; i < rows.length; i++) {
                    int sid = Integer.parseInt(requestTable.getValueAt(rows[i], 0).toString());
                    querySender.deleteRequest(sid);
                }
                refresh();
                popUpWarning("Student(s) rejected!","Deletion Performed");
            }
        });

        JButton TLP3B2 = new JButton("Acp");
        TLP3B2.setToolTipText("Accept selected request");
        TLP3B2.setPreferredSize(new Dimension(30,20));
        TLP3B2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int[] rows = requestTable.getSelectedRows();
                for (int i = 0; i < rows.length; i++) {
                    int sid = Integer.parseInt(requestTable.getValueAt(rows[i], 0).toString());
                    querySender.deleteRequest(sid);
                    querySender.addRelationShip(sid, sharedVariables.getInstance().getUid());
                }
                refresh();
                popUpWarning("Student(s) accepted!","Deletion Performed");
            }
        });


        topLeftP3S.add(TLP3B1);
        topLeftP3S.add(Box.createRigidArea(new Dimension(10, 10)));

        topLeftP3S.add(TLP3B2);
        topLeftP3S.add(Box.createRigidArea(new Dimension(10, 10)));
        topLeftP3.add(topLeftP3S);

        topLeft.setLayout(new FlowLayout(FlowLayout.LEFT));
        topLeft.setBorder(BorderFactory.createTitledBorder("Relationships"));


        JPanel topLeftTalbePanel = new JPanel();
        topLeftTalbePanel.setLayout(new GridLayout(0,3));

        topLeftTalbePanel.add(topLeftP1);
        topLeftTalbePanel.add(topLeftP2);
        topLeftTalbePanel.add(topLeftP3);
        topLeft.add(topLeftTalbePanel);
        JButton refreshRelationships = new JButton("Refresh");
        refreshRelationships.setToolTipText("Refresh relationship panel");
        refreshRelationships.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                refresh();
            }
        });

        refreshRelationships.setPreferredSize(new Dimension(100,30));
        topLeft.add(refreshRelationships);
        Label relationExp = new Label("(Please refresh requently!)");
        relationExp.setFont(new Font("Serif", Font.PLAIN, 11));
        topLeft.add(relationExp);


        JPanel topRight = new JPanel();
        topRight.setLayout(new GridLayout(4,4));

        x1 = new Label("Name: "+ sharedVariables.getInstance().getCurrentName());
        topRight.add(x1);
        x2 = new Label("Id: " + sharedVariables.getInstance().getUid());
        topRight.add(x2);
        x3 = new JTextField("Email: " + sharedVariables.getInstance().getEmail());
        topRight.add(x3);
        x4 = new JTextField("Age: " + sharedVariables.getInstance().getAge());
        topRight.add(x4);
        x5 = new JTextField("Address: " + sharedVariables.getInstance().getAddress());
        topRight.add(x5);
        x6 = new JTextField("Gender: " + sharedVariables.getInstance().getGender());
        topRight.add(x6);
        topRight.setBorder(BorderFactory.createTitledBorder("Personal Info"));
        top.add(topLeft);
        top.add(topRight);


        this.add(top);


        JPanel bot = new JPanel();
        bot.setLayout(new GridLayout(0,3));
        JPanel botL = new JPanel();
        botL.setLayout(new BoxLayout(botL, BoxLayout.Y_AXIS));
        botL.setBorder(BorderFactory.createTitledBorder("General lookup"));


        // Students
        ArrayList<ArrayList<String>> gData = new ArrayList<ArrayList<String>>();
        ArrayList<String> gCol = new ArrayList<String>(Arrays.asList("sid", "unmae"));
        MyModel m4 = new MyModel(gData, gCol);

        generalTable = new JTable(m);
        generalTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        generalTable.setShowGrid(true);
        generalTable.setGridColor(Color.BLACK);
        JTableHeader h4 = generalTable.getTableHeader();
        h4.setBackground(Color.lightGray);
        generalPane = new JScrollPane(generalTable);

        for (int i = 0; i < newCol.size(); i++) {
            c = generalTable.getColumnModel().getColumn(i);
            c.setPreferredWidth(50);
        }

        generalPane.setPreferredSize(new Dimension(300,200));
        generalPane.setBackground(Color.lightGray);
        botL.add(generalPane);

        JPanel generalLookupPopular = new JPanel();
        final String[] fromOption = {
                "Students taking all my class",
                "Instructors order by number of students"};

        final JComboBox<String> from = new JComboBox<String>(fromOption);
        Label X = new Label("BuildIn Queries:");
        X.setFont(new Font("Serif", Font.PLAIN, 11));
        generalLookupPopular.add(X);
        generalLookupPopular.add(from);
        botL.add(generalLookupPopular);

        JPanel generalLookupFunc = new JPanel();
        JButton sub = new JButton("Submit");
        sub.setToolTipText("Submit build in query");
        sub.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int inid = sharedVariables.getInstance().getUid();
                if (fromOption[from.getSelectedIndex()].equals("Students taking all my class")) {
                    String finalQuery = "Select s.sid from students s where not exists(select * " +
                            "from (select lid from lesson where inid="+inid+") l where not exists(select * " +
                            "from register r where r.lid = l.lid and r.sid = s.sid))";
                    System.out.println("Executing query: ");
                    System.out.println(finalQuery);
                    MyModel m = querySender.selectGeneral(finalQuery);
                    if (m == null) {
                        popUpWarning("Something wrong","Invalid query");
                    }
                    generalTable.setModel(m);
                } else if (fromOption[from.getSelectedIndex()].equals("Instructors order by number of students")) {
                    String finalQuery = "Select s.inid, u.uname, count(*) from users u, students s where s.inid=u.uid " +
                            "group by s.inid order by count(*)";
                    System.out.println("Executing query: ");
                    System.out.println(finalQuery);
                    MyModel m = querySender.selectGeneral(finalQuery);
                    if (m == null) {
                        popUpWarning("Something wrong","Invalid query");
                    }
                    generalTable.setModel(m);
                }
            }
        });
        generalLookupFunc.add(sub);
        JButton advancedButtonLeft = new JButton("Advanced Query");
        advancedButtonLeft.setToolTipText("Further specify your query");
        advancedButtonLeft.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                AdvancedFilter adv = new AdvancedFilter(generalTable, querySender);
                adv.setSize(new Dimension(600, 600));
                adv.setTitle("Advanced");
                adv.setVisible(true);
            }
        });

        generalLookupFunc.add(advancedButtonLeft);
        botL.add(generalLookupFunc);

        // Bot M
        JPanel botM = new JPanel();
        botM.setBorder(BorderFactory.createTitledBorder("Aggregations"));
        botM.setLayout(new BoxLayout(botM, BoxLayout.Y_AXIS));
        JPanel tpAggregation = new JPanel();
        JPanel midAggregation = new JPanel();
        JPanel botAggregation = new JPanel();
        final String[] groupOption = {"none", "lesson", "(non-group) student", "(non-group) instructor"};
        final JComboBox<String> group = new JComboBox<String>(groupOption);
        final String[] operations = {"none","max", "min", "count", "avg"};
        final JComboBox<String> op = new JComboBox<String>(operations);
        final String[] appliedField = {"*", "age", "year"};
        final JComboBox<String> ap = new JComboBox<String>(appliedField);
        String[] operations2 = {"none","max", "min", "count", "avg"};
        final JComboBox<String> op2 = new JComboBox<String>(operations2);
        tpAggregation.add(new Label("Grouping:"));
        tpAggregation.add(group);
        midAggregation.add(new Label("Inner Op:"));
        midAggregation.add(op);
        midAggregation.add(new Label("AppliedOn:"));
        midAggregation.add(ap);
        botAggregation.add(new Label("Outer Op:"));
        botAggregation.add(op2);
        botM.add(tpAggregation);
        botM.add(midAggregation);
        botM.add(botAggregation);

        ArrayList<ArrayList<String>> aData = new ArrayList<ArrayList<String>>();
        ArrayList<String> aCol = new ArrayList<String>(Arrays.asList("sid", "unmae"));
        MyModel m5 = new MyModel(gData, gCol);

        aggregationTable = new JTable(m5);
        aggregationTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        aggregationTable.setShowGrid(true);
        aggregationTable.setGridColor(Color.BLACK);
        JTableHeader h5 = aggregationTable.getTableHeader();
        h5.setBackground(Color.lightGray);
        JScrollPane apane = new JScrollPane(aggregationTable);

        for (int i = 0; i < newCol.size(); i++) {
            c = aggregationTable.getColumnModel().getColumn(i);
            c.setPreferredWidth(50);
        }

        apane.setPreferredSize(new Dimension(300,200));
        apane.setBackground(Color.lightGray);
        botM.add(apane);

        JPanel aggregationFunc = new JPanel();
        JButton aggregationSubmit = new JButton("Submit");
        aggregationSubmit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String groupType = groupOption[group.getSelectedIndex()];
                String operation = operations[op.getSelectedIndex()];
                String operation2 = operations[op2.getSelectedIndex()];
                String apply = appliedField[ap.getSelectedIndex()];
                String select = "";
                String from = "";
                String where = "";
                String gp = "";

                if (op2.getSelectedIndex() == 0) {
                    if (apply.equals("none")) {
                        select = "*";
                    }
                    if (groupType.equals("lesson")) {
                        select = "l.lid, " + operation + "(" + apply + ")";
                        from = "lesson l, students s, users u";
                        where = "l.inid=s.inid AND s.sid=u.uid";
                        gp = "GROUP BY l.lid";
                    } else if (groupType.equals("(non-group) student")) {
                        select = operation + "(" + apply + ")";
                        from = "users, students";
                        where = "users.uid = students.sid";
                    } else if (groupType.equals("(non-group) instructor")) {
                        select = operation + "(" + apply + ")";
                        from = "users, instructors";
                        where = "users.uid = instructors.inid";
                    }
                } else {
                    if (apply.equals("none")) {
                        select = "*";
                    }

                    if (groupType.equals("lesson")) {
                        select = operation2 + "(x.m)";
                        from = "(SELECT " + operation + "(" + apply + ") " +
                                "AS m, r.lid FROM register r, users u WHERE r.sid=u.uid GROUP BY r.lid) x";
                        where = "1=1";
                        gp = "";
                    } else if (groupType.equals("(non-group) student")) {
                        select = operation + "(" + apply + ")";
                        from = "users, students";
                        where = "users.uid = students.sid";
                    } else if (groupType.equals("(non-group) instructor")) {
                        select = operation + "(" + apply + ")";
                        from = "users, instructors";
                        where = "users.uid = instructors.inid";
                    }
                }

                String finalQuery = "SELECT " + select +
                        " FROM " + from + " WHERE "+ where + " " + gp;
                System.out.println("Executing query: ");
                System.out.println(finalQuery);
                MyModel m = querySender.selectGeneral(finalQuery);
                if (m == null) {
                    popUpWarning("Your input combination doesn't make sense","Invalid query");
                }
                else {
                    aggregationTable.setModel(m);
                }

            }

        });

        aggregationFunc.add(aggregationSubmit);
        botM.add(aggregationFunc);


        // Bot R


        bot.add(botL);
        bot.add(botM);


        this.add(bot);

    }

    // Refresh relationship pannel
    public void refresh() {
        studentTable.setModel(querySender.findStudentOf(sharedVariables.getInstance().getUid()));
        TableColumn c = null;
        c = studentTable.getColumnModel().getColumn(0);
        c.setPreferredWidth(30);
        c = studentTable.getColumnModel().getColumn(1);
        c.setPreferredWidth(90);

        lessonTable.setModel(querySender.findLessonOf(sharedVariables.getInstance().getUid()));
        c = lessonTable.getColumnModel().getColumn(0);
        c.setPreferredWidth(50);
        c = lessonTable.getColumnModel().getColumn(1);
        c.setPreferredWidth(50);

        requestTable.setModel(querySender.findRequestRecord(sharedVariables.getInstance().getUid()));
        c = requestTable.getColumnModel().getColumn(0);
        c.setPreferredWidth(50);
        c = requestTable.getColumnModel().getColumn(1);
        c.setPreferredWidth(50);

        x1.setText("Name: "+ sharedVariables.getInstance().getCurrentName());
        x2.setText("Id: " + sharedVariables.getInstance().getUid());
        x3.setText("Email: " + sharedVariables.getInstance().getEmail());
        x4.setText("Age: " + sharedVariables.getInstance().getAge());
        x5.setText("Address: " + sharedVariables.getInstance().getAddress());
        x6.setText("Gender: " + sharedVariables.getInstance().getGender());

    }

    public void popUpWarning(String content, String title) {
        JOptionPane.showMessageDialog(new JFrame(),
                content,
                title,
                JOptionPane.WARNING_MESSAGE);
    }


}
