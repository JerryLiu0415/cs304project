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

    public String getCurrentName(int a) {
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
}
