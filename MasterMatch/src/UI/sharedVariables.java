package UI;

import javax.swing.*;

/**
 * Created by Jerry on 2017-03-24.
 */
// Class containing informations that
public class sharedVariables {

    private static sharedVariables singleton = new sharedVariables( );
    private String currentName;
    private JTabbedPane MainPanel;
    private int uid = 902;
    private String lastGeneralQueryWherePortion = "";
    private String gender;
    private String email;
    private String Address;
    private String age;





    private sharedVariables() {}

    public static sharedVariables getInstance( ) {
        return singleton;
    }

    protected void demoMethod() {
        System.out.println(this.currentName);
    }

    public void setCurrentName(String s) {
        this.currentName = s;
    }

    public String getCurrentName() {
        return currentName;
    }

    public void setMainPanel(JTabbedPane main) {
        this.MainPanel = main;
    }

    public JTabbedPane getMainPanel() {
        return MainPanel;
    }

    public void setUid(int id) {
        this.uid = id;
    }

    public int getUid() {
        return this.uid;
    }

    public  void setLast(String s) {
        this.lastGeneralQueryWherePortion = s;
    }

    public String getLastWhere() {
        return lastGeneralQueryWherePortion;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static sharedVariables getSingleton() {
        return singleton;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return Address;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }
}
