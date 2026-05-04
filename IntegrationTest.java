import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.*;

// Integration testing with SQLite calls 
public class IntegrationTest {

    // Initiziling the SQLite database
    @BeforeEach
    public void setup() {
        DatabaseConfig.initializeDatabase();
    }

    // testing connection
    @Test
    public void testDatabaseConnection() {
        Connection conn = Database.connect();
        assertNotNull(conn);
    }

    // Testing Patient table creation and Console error messages
    @Test
    public void testPatientsTableExists() {
        try (Connection conn = Database.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt
                        .executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='patients'")) {
            assertTrue(rs.next());
        } catch (Exception e) {
            fail("Patients table does not exist: " + e.getMessage());
        }
    }

    // Testing Employee table creation and Console error messages
    @Test
    public void testEmployeesTableExists() {
        try (Connection conn = Database.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt
                        .executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='employees'")) {
            assertTrue(rs.next());
        } catch (Exception e) {
            fail("Employees table does not exist: " + e.getMessage());
        }
    }

    // Testing Appointment table creation and Console error messages
    @Test
    public void testAppointmentsTableExists() {
        try (Connection conn = Database.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt
                        .executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='appointments'")) {
            assertTrue(rs.next());
        } catch (Exception e) {
            fail("Appointments table does not exist: " + e.getMessage());
        }
    }
}