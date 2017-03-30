package UI.SubViews;

import BackEnd.QueryAndUpdate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jerry on 2017-03-28.
 */
public class lessonTimePopUp extends JFrame {
    public JTable resultArea;
    public QueryAndUpdate querySender;
    public int row;

    public lessonTimePopUp(JTable result, QueryAndUpdate q, int r){
        super();
        this.resultArea = result;
        this.querySender = q;
        this.row = r;

        JPanel main = new JPanel();
        JPanel upper = new JPanel();
        JPanel lower = new JPanel();
        main.setLayout(new GridLayout(2,1));

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

        JButton update = new JButton("Update");
        update.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println(row);
                String lid = resultArea.getValueAt(row, 0).toString();
                String s1 = start.getText();
                String s2 = end.getText();
                String s3 = date.getText();
                float s4 = Float.parseFloat(price.getText());
                querySender.updateLesson(s1,s2,s3,s4,lid);
            }
        });

        lower.add(update);
        main.add(upper);
        main.add(lower);
        this.setContentPane(main);
    }

}
