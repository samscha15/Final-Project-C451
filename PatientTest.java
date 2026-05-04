import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {
    
    //Stock testing code
    //Test for a new Paitent
    @Test
    public void testPatientCreation() {
        Patient p = new Patient(1001, "John Doe", "01/01/1990", "Flu", "Dr.Hurt", "");
        assertEquals(1001, p.getPatientID());
        assertEquals("John Doe", p.getName());
        assertEquals("01/01/1990", p.getDob());
        assertEquals("Flu", p.getIssue());
    }
    
    //Testing the notes section
    @Test
    public void testPatientNotes() {
        Patient p = new Patient(1001, "John Doe", "01/01/1990", "Flu", "Dr.Jammy", "");
        assertEquals("", p.getNotes());
        p.setNotes("Follow up in 2 weeks");
        assertEquals("Follow up in 2 weeks", p.getNotes());
    }
    
    //Test to make sure the PaitentID is right
    @Test
    public void testPatientID() {
        Patient p = new Patient(9999, "Jane Doe", "05/15/1985", "Diabetes", "Dr.Peanut", "");
        assertEquals(9999, p.getPatientID());
    }
}