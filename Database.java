import java.sql.DriverManager;
import java.sql.Connection;

public class Database {

    public static Connection connect() {
        Connection link = null;
        try {
            Class.forName("org.sqlite.JDBC");
            link = DriverManager.getConnection("jdbc:sqlite:HospitalMGMT.db");
            System.out.println("Connection to Database Successfull");
        } catch (Exception e) {
            System.out.println("ERROR: Connection Failed! " + e.getMessage());
        }
        return link;
    }

    public static void main(String[] args) {
        connect();
    }
}
