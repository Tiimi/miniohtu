package miniohtu.app;

public class App 
{
    public static void main( String[] args )
    {
        // testing...
        try {
            ViiteDB.resetDB("viite.db");
        } catch(ClassNotFoundException e) {
            System.err.println(e);
        }
    }
}
