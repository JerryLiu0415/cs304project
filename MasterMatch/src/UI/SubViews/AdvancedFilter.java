package UI.SubViews;

import BackEnd.QueryAndUpdate;
import UI.MyModel;
import UI.sharedVariables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Jerry on 2017-03-27.
 */
public class AdvancedFilter extends JFrame {
    public QueryAndUpdate querySender;
    public JTable resultTable;
    JTabbedPane tabbedPane;

    public AdvancedFilter(JTable result, final QueryAndUpdate querySender) {
        super();
        this.querySender = querySender;
        this.resultTable = result;
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        tabbedPane = new JTabbedPane();
        JPanel student = new JPanel();
        student.setLayout(new GridLayout(3,1));

        JPanel selectedCol = new JPanel();
        selectedCol.setBorder(BorderFactory.createTitledBorder("Selected Features"));
        JCheckBox ageS = new JCheckBox();
        JCheckBox nameS = new JCheckBox();
        JCheckBox idS = new JCheckBox();
        JCheckBox headS = new JCheckBox();
        JCheckBox phoneS = new JCheckBox();
        JCheckBox addS = new JCheckBox();
        JCheckBox achievementS = new JCheckBox();
        final ArrayList<JCheckBox> studentChecks = new ArrayList<JCheckBox>();
        selectedCol.add(new Label("Age"));
        selectedCol.add(ageS);
        studentChecks.add(ageS);
        selectedCol.add(new Label("Name"));
        selectedCol.add(nameS);
        studentChecks.add(nameS);
        selectedCol.add(new Label("id"));
        selectedCol.add(idS);
        studentChecks.add(idS);
        selectedCol.add(new Label("headline"));
        selectedCol.add(headS);
        studentChecks.add(headS);
        selectedCol.add(new Label("phone"));
        selectedCol.add(phoneS);
        studentChecks.add(phoneS);
        selectedCol.add(new Label("address"));
        selectedCol.add(addS);
        studentChecks.add(addS);
        selectedCol.add(new Label("achievements"));
        selectedCol.add(achievementS);
        studentChecks.add(achievementS);

        student.add(selectedCol);

        JPanel Filter1 = new JPanel();
        Filter1.setBorder(BorderFactory.createTitledBorder("Filter 1"));
        Filter1.setLayout(new BoxLayout(Filter1, BoxLayout.Y_AXIS));
        JPanel use1SPane = new JPanel();
        use1SPane.add(new Label("Chooes to use"));
        final JCheckBox use1S = new JCheckBox();
        use1SPane.add(use1S);
        Filter1.add(use1SPane);
        String[] opt1SData = {"Filter by ID", "Filter by Age"};
        final JComboBox<String> opt1S = new JComboBox(opt1SData);
        Filter1.add(opt1S);
        JPanel Z = new JPanel();
        Z.add(new Label("From"));
        final JTextField from1S = new JTextField();
        from1S.setPreferredSize(new Dimension(50,30));
        Z.add(from1S);
        Z.add(new Label("To"));
        final JTextField to1S = new JTextField();
        to1S.setPreferredSize(new Dimension(50,30));
        Z.add(to1S);
        Filter1.add(Z);
        student.add(Filter1);

        JPanel Filter2 = new JPanel();
        Filter2.setBorder(BorderFactory.createTitledBorder("Filter 2"));
        Filter2.setLayout(new BoxLayout(Filter2, BoxLayout.Y_AXIS));
        JPanel use2SPane = new JPanel();
        use2SPane.add(new Label("Chooes to use"));
        final JCheckBox use2S = new JCheckBox();
        use2SPane.add(use2S);
        Filter2.add(use2SPane);
        String[] opt2SData = {"Filter by Name", "Filter by Address", "Filter by Achievement"};
        final JComboBox<String> opt2S = new JComboBox(opt2SData);
        Filter2.add(opt2S);
        JPanel Z2 = new JPanel();
        Z2.add(new Label("KeyWord"));
        final JTextField from2S = new JTextField();
        from2S.setPreferredSize(new Dimension(50,30));
        Z2.add(from2S);
        Filter2.add(Z2);
        student.add(Filter2);



        // Instructor query
        JPanel instructor = new JPanel();
        instructor.setLayout(new GridLayout(3,1));

        JPanel selectedColI = new JPanel();
        selectedColI.setBorder(BorderFactory.createTitledBorder("Selected Features"));
        JCheckBox ageI = new JCheckBox();
        JCheckBox nameI = new JCheckBox();
        JCheckBox idI = new JCheckBox();
        JCheckBox headI = new JCheckBox();
        JCheckBox phoneI = new JCheckBox();
        JCheckBox addI = new JCheckBox();
        JCheckBox yearI = new JCheckBox();
        JCheckBox styleI = new JCheckBox();
        final ArrayList<JCheckBox> instChecks = new ArrayList<JCheckBox>();
        selectedColI.add(new Label("Age"));
        selectedColI.add(ageI);
        instChecks.add(ageI);
        selectedColI.add(new Label("Name"));
        selectedColI.add(nameI);
        instChecks.add(nameI);
        selectedColI.add(new Label("id"));
        selectedColI.add(idI);
        instChecks.add(idI);
        selectedColI.add(new Label("headline"));
        selectedColI.add(headI);
        instChecks.add(headI);
        selectedColI.add(new Label("phone"));
        selectedColI.add(phoneI);
        instChecks.add(phoneI);
        selectedColI.add(new Label("address"));
        selectedColI.add(addI);
        instChecks.add(addI);
        selectedColI.add(new Label("Year Of Teaching"));
        selectedColI.add(yearI);
        instChecks.add(yearI);
        selectedColI.add(new Label("Style"));
        selectedColI.add(styleI);
        instChecks.add(styleI);

        instructor.add(selectedColI);

        JPanel Filter1I = new JPanel();
        Filter1I.setBorder(BorderFactory.createTitledBorder("Filter 1"));
        Filter1I.setLayout(new BoxLayout(Filter1I, BoxLayout.Y_AXIS));
        JPanel use1IPane = new JPanel();
        use1IPane.add(new Label("Chooes to use"));
        final JCheckBox use1I = new JCheckBox();
        use1IPane.add(use1I);
        Filter1I.add(use1IPane);
        String[] opt1IData = {"Filter by ID", "Filter by Age", "Filter by year"};
        final JComboBox<String> opt1I = new JComboBox(opt1IData);
        Filter1I.add(opt1I);
        JPanel ZI = new JPanel();
        ZI.add(new Label("From"));
        final JTextField from1I = new JTextField();
        from1I.setPreferredSize(new Dimension(50,30));
        ZI.add(from1I);
        ZI.add(new Label("To"));
        final JTextField to1I = new JTextField();
        to1I.setPreferredSize(new Dimension(50,30));
        ZI.add(to1I);
        Filter1I.add(ZI);
        instructor.add(Filter1I);

        JPanel Filter2I = new JPanel();
        Filter2I.setBorder(BorderFactory.createTitledBorder("Filter 2"));
        Filter2I.setLayout(new BoxLayout(Filter2I, BoxLayout.Y_AXIS));
        JPanel use2IPane = new JPanel();
        use2IPane.add(new Label("Chooes to use"));
        final JCheckBox use2I = new JCheckBox();
        use2IPane.add(use2I);
        Filter2I.add(use2IPane);
        String[] opt2IData = {"Filter by Name", "Filter by Address", "Filter by headline", "Filter by style"};
        final JComboBox<String> opt2I = new JComboBox(opt2IData);
        Filter2I.add(opt2I);
        JPanel ZI2 = new JPanel();
        ZI2.add(new Label("KeyWord"));
        final JTextField from2I = new JTextField();
        from2I.setPreferredSize(new Dimension(50,30));
        ZI2.add(from2I);
        Filter2I.add(ZI2);
        instructor.add(Filter2I);

        JPanel martialArtsType = new JPanel();

        JButton submit = new JButton("Submit");
        submit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                switch (tabbedPane.getSelectedIndex()) {
                    case 0:
                        String selectItems = "";
                        String from = "users, students";
                        String where = "users.uid = students.sid";
                        String[] selected = {"age, ","uname, ","uid, ","headline, ","phone, ","address, ","achievements, "};
                        String[] keys1 = {"uid","age"};
                        String[] keys2 = {"uname","address","headline"};
                        for (int i = 0; i < studentChecks.size(); i++) {
                            if (studentChecks.get(i).isSelected()) {
                                selectItems += selected[i];
                            }
                        }
                        selectItems = selectItems.replaceAll(", $", "");
                        if (use1S.isSelected()) {
                            String key1 = keys1[opt1S.getSelectedIndex()];
                            String start = from1S.getText();
                            String end = to1S.getText();
                            where += " AND " + key1 + ">=" + start + " AND " + key1 + "<=" + end;
                            System.out.println(where);
                        }

                        if (use2S.isSelected()) {
                            String key2 = keys2[opt2S.getSelectedIndex()];
                            String start = from2S.getText();
                            where += " AND " + key2 + " LIKE " + "'%" + start + "%'";
                            System.out.println(where);
                        }

                        String finalQuery = "SELECT " + selectItems + " FROM " + from + " WHERE " + where;
                        System.out.println(finalQuery);
                        MyModel m = querySender.selectGeneral(finalQuery);
                        System.out.println(m.data);
                        resultTable.setModel(m);
                        sharedVariables.getInstance().setLast(where);
                        break;
                    case 1:
                        String selectItemsI = "";
                        String fromI = "users, Instructors";
                        String whereI = "users.uid = Instructors.inid";
                        String[] selectedI = {"age, ","uname, ","uid, ","headline, ",
                                "phone, ","address, ","year, ", "style"};
                        String[] keys1I = {"uid","age", "year"};
                        String[] keys2I = {"uname","address","headline", "style"};
                        for (int i = 0; i < instChecks.size(); i++) {
                            if (instChecks.get(i).isSelected()) {
                                selectItemsI += selectedI[i];
                            }
                        }
                        selectItemsI = selectItemsI.replaceAll(", $", "");
                        if (use1I.isSelected()) {
                            String key1 = keys1I[opt1I.getSelectedIndex()];
                            String start = from1I.getText();
                            String end = to1I.getText();
                            whereI += " AND " + key1 + ">=" + start + " AND " + key1 + "<=" + end;
                            System.out.println(whereI);
                        }

                        if (use2I.isSelected()) {
                            String key2 = keys2I[opt2I.getSelectedIndex()];
                            String start = from2I.getText();
                            whereI += " AND " + key2 + " LIKE " + "'%" + start + "%'";
                            System.out.println(whereI);
                        }

                        String finalQueryI = "SELECT " + selectItemsI + " FROM " + fromI + " WHERE " + whereI;
                        System.out.println(finalQueryI);
                        MyModel mI = querySender.selectGeneral(finalQueryI);
                        System.out.println(mI.data);
                        resultTable.setModel(mI);
                        sharedVariables.getInstance().setLast(whereI);
                        break;
                    default:
                        break;
                }

            }
        });

        tabbedPane.addTab("Find Students",student);
        tabbedPane.addTab("Find Instructors",instructor);
        tabbedPane.addTab("Find martialArtsTypes",martialArtsType);
        main.add(tabbedPane);
        main.add(submit);
        this.setContentPane(main);
    }
}
