package UI;

/**
 * Created by Jerry on 2017-03-24.
 */
// Class containing informations that
public class sharedVariables {

    private static sharedVariables singleton = new sharedVariables( );
    private String currentName;



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
}
