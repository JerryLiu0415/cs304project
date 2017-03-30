package UI.SubViews;

import BackEnd.QueryAndUpdate;
import UI.sharedVariables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jerry on 2017-03-28.
 */
public class lessonAddPopUp extends JFrame {
    public JTable resultArea;
    public QueryAndUpdate querySender;
    public int row;

    public lessonAddPopUp(JTable result, QueryAndUpdate q, int r){
        super();
        this.resultArea = result;
        this.querySender = q;
        this.row = r;

        JPanel main = new JPanel();
        JPanel upper = new JPanel();
        JPanel upper2 = new JPanel();
        JPanel lower = new JPanel();
        main.setLayout(new GridLayout(3,1));

        upper.add(new Label("StartTime:"));
        final JTextField start = new JTextField();
        start.setPreferredSize(new Dimension(100,30));
        upper.add(start);
        upper.add(new Label("EndTime:"));
        final JTextField end = new JTextField();
        end.setPreferredSize(new Dimension(100,30));
        upper.add(end);
        upper.add(new Label("Date:"));
        final JTextField date = new JTextField();
        date.setPreferredSize(new Dimension(100,30));
        upper.add(date);
        upper.add(new Label("Price:"));
        final JTextField price = new JTextField();
        price.setPreferredSize(new Dimension(100,30));
        upper.add(price);

        upper2.add(new Label("LessonId:"));
        final JTextField id = new JTextField();
        id.setPreferredSize(new Dimension(100,30));
        upper2.add(id);
        upper2.add(new Label("Location:"));
        final JTextField loc = new JTextField();
        loc.setPreferredSize(new Dimension(100,30));
        upper2.add(loc);
        upper2.add(new Label("Capacity:"));
        final JTextField cap = new JTextField();
        cap.setPreferredSize(new Dimension(100,30));
        upper2.add(cap);



        JButton update = new JButton("Update");
        update.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println(row);
                int inid = sharedVariables.getInstance().getUid();
                String s1 = start.getText();
                String s2 = end.getText();
                String s3 = date.getText();
                float s4 = Float.parseFloat(price.getText());
                String s5 = loc.getText();
                int s6 = Integer.parseInt(cap.getText());
                int s7 = Integer.parseInt(id.getText());
                querySender.addLesson(s1,s2,s3,s4,inid,s5,s6,s7);
            }
        });

        lower.add(update);
        main.add(upper);
        main.add(upper2);
        main.add(lower);
        this.setContentPane(main);
    }

}
