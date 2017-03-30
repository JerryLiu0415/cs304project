package UI;

import BackEnd.QueryAndUpdate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jerry on 2017-03-19.
 */
public class AccountPannel extends JPanel {
    public QueryAndUpdate querySender;


    public AccountPannel(final QueryAndUpdate querySender) {
        this.querySender = querySender;
        this.setLayout(new GridLayout(2,0));

        // Upper Pannel =============================================
        JPanel upper = new JPanel();
        upper.setLayout(new GridLayout(5,0));
        upper.add(new JPanel());
        // Lable + idField
        JPanel id = new JPanel();
        id.add(new Label("   UserId: "));
        final JTextField idField = new JTextField();
        idField.setPreferredSize( new Dimension( 100, 24 ) );
        id.add(idField);

        // Lable + passField
        JPanel pass = new JPanel();
        pass.add(new Label("Password:"));
        final JPasswordField passField = new JPasswordField();
        passField.setPreferredSize( new Dimension( 96, 24 ) );
        pass.add(passField);

        // SubmitButton
        final JPanel submit = new JPanel();
        JButton submitBtn = new JButton("Submit");
        submitBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String userId = idField.getText();
                try {
                    int id = Integer.parseInt(idField.getText());
                    int pass = Integer.parseInt(new String(passField.getPassword()));
                    String matchingName = querySender.findIdPassPair(id, pass);
                    if (matchingName.equals("")) {
                        popUpWarning("Invalid Id/Password","LoginFailded");
                    }
                    else {
                        popUpMessage("Successfully log in as: " + matchingName,"LoginSuccessful");
                        String query = "SELECT * FROM USERS WHERE uid="+id;
                        MyModel m = querySender.selectGeneral(query);
                        System.out.println(m.data.get(0).get(3));

                        sharedVariables.getInstance().setGender(m.data.get(0).get(3));
                        System.out.println(sharedVariables.getInstance().getGender());
                        sharedVariables.getInstance().setEmail(m.data.get(0).get(5));
                        sharedVariables.getInstance().setAddress(m.data.get(0).get(4));
                        sharedVariables.getInstance().setAge(m.data.get(0).get(2));
                        sharedVariables.getInstance().setUid(id);
                        sharedVariables.getInstance().setCurrentName(matchingName);
                        System.out.println(m.data.get(0).get(7));
                        if (Integer.parseInt(m.data.get(0).get(7)) == 0) {
                            sharedVariables.getInstance().getMainPanel().setSelectedIndex(2);
                        }
                        else {
                            sharedVariables.getInstance().getMainPanel().setSelectedIndex(1);
                        }
                    }
                }
                catch (NumberFormatException a) {
                    popUpWarning("Id and Password must be integer","Wrong format");
                }
            }
        });
        submit.add(submitBtn);

        upper.add(id);
        upper.add(pass);
        upper.add(submit);
        upper.add(new JPanel());

        // Lower Pannel =============================================
        JPanel lower = new JPanel();
        lower.setLayout(new GridLayout(5,0));
        // Asking for a user id
        JPanel newIdPannel = new JPanel();
        newIdPannel.add(new Label("Enter your new id: "));
        final JTextField newIdField = new JTextField();
        newIdField.setPreferredSize( new Dimension( 96, 24 ) );
        newIdPannel.add(newIdField);
        JButton testId = new JButton("Test");
        testId.setPreferredSize(new Dimension(40,20));
        testId.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    int testIdParse = Integer.parseInt(newIdField.getText());
                    String id = newIdField.getText();
                    if (querySender.checkValueExistGeneral("users", "uid", id, false)) {
                        popUpWarning("Given id already exist", "Constraint Violated");
                    }
                    else {
                        popUpMessage("Given id is valid!", "Success");
                    }
                }
                catch (NumberFormatException a) {
                    popUpWarning("Id must be an integer","Wrong format");
                }
            }
        });
        newIdPannel.add(testId);

        // Asking for a user password
        JPanel newPassPannel = new JPanel();
        newPassPannel.add(new Label("Enter your new password: "));
        final JTextField newPassField = new JTextField();
        newPassField.setPreferredSize( new Dimension( 96, 24 ) );
        newPassPannel.add(newPassField);

        // Asking for name
        JPanel newNameInputs = new JPanel();
        newNameInputs.add(new Label("Enter your name (F,L): "));
        final JTextField newNameField = new JTextField();
        newNameField.setPreferredSize( new Dimension( 96, 24 ) );
        newNameInputs.add(newNameField);

        // Asking for email
        JPanel newEmailInputs = new JPanel();
        newEmailInputs.add(new Label("Enter your email: "));
        final JTextField newEmailField = new JTextField();
        newEmailField.setPreferredSize( new Dimension( 200, 24 ) );
        newEmailInputs.add(newEmailField);
        JButton testEm = new JButton("Test");
        testEm.setPreferredSize(new Dimension(40,20));
        testEm.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String userEm = newEmailField.getText();
                if (querySender.checkValueExistGeneral("users", "email", userEm, true)) {
                    popUpWarning("Given email already exist", "Constraint Violated");
                }
                else {
                    popUpMessage("Given email is valid!", "Success");
                }
            }
        });
        newEmailInputs.add(testEm);

        // Submit
        JPanel newSubmitPannel = new JPanel();
        JButton newSubmit = new JButton("Submit");
        newSubmit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                String newId = newIdField.getText();
                String newPass = newPassField.getText();
                String newEmail = newEmailField.getText();
                String newName = newNameField.getText();

                boolean b = querySender.insertGeneral("users", "uid", "password", "Email", "uname",
                        newId,newPass,newEmail, newName, "INT", "INT", "CHAR", "CHAR");

                if (!b) {
                    popUpWarning("Invalid account info, please test before submit again", "Constraint Violated");
                }
                else {
                    popUpMessage("Account successfully created!", "Success");
                }
            }
        });
        newSubmitPannel.add(newSubmit);


        lower.add(newIdPannel);
        lower.add(newPassPannel);
        lower.add(newNameInputs);
        lower.add(newEmailInputs);
        lower.add(newSubmitPannel);

        upper.setBorder(BorderFactory.createTitledBorder("CurrentUserLogin"));
        lower.setBorder(BorderFactory.createTitledBorder("CreateNewAccount"));
        this.add(upper);
        this.add(lower);
    }

    public void popUpMessage(String content, String title) {
        JOptionPane.showMessageDialog(new JFrame(),
                content,
                title,
                JOptionPane.PLAIN_MESSAGE);
    }

    public void popUpWarning(String content, String title) {
        JOptionPane.showMessageDialog(new JFrame(),
                content,
                title,
                JOptionPane.WARNING_MESSAGE);
    }
}
