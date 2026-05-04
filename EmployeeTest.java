import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//Stock JUnit testing code
public class EmployeeTest {

    // int employeeID, String name, String job, String employeeShift, String
    // scheduleDays)
    
    //Test for the Emoployee creation is working
    @Test
    public void testEmployeeCreation() {
        Employee e = new Employee(0001, "The Janitor", "Janitorial Arts", "Whenever",
                "Seemingly never, but also seemingly always");
        assertEquals(0001, e.getEmployeeID());
        assertEquals("The Janitor", e.getName());
        assertEquals("Janitorial Arts", e.getJob());
        assertEquals("Whenever", e.getEmployeeShift());
        assertEquals("Seemingly never, but also seemingly always", e.getScheduleDays());
    }

    //Test Employee ID is correct
    @Test
    public void testEmployeeID() {
        Employee e = new Employee(3333, "Nurse Jackie", "Nurse", "7:00p, - 7:00am", "Monday,Wednesday, Thursday");
        assertNotEquals(-1, e.getEmployeeID());
    }
    
    //Testing Employee's name is correct
    @Test
    public void testEmployeeName() {
        Employee e = new Employee(6858, "Christopher Maltisonti", "Phsician Assistant", "5:00am - 5:00pm",
                "Thursday - Saturday");
        assertNotEquals("", e.getName());
    }
}