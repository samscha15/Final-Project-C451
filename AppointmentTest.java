import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//Stock JUnit Appointment Testing
public class AppointmentTest {

    // Appointment(int appointmentID, String patientName, String doctor, String
    // issue, String date,
    // String status, String notes)
    
    //Appointment creation testing
    @Test
    public void testAppointmentCreation() {
        Appointment a = new Appointment(1001, "John Doe", "Dr King", "Flu", "01/01/1900", "Scheduled", "");
        assertEquals(1001, a.getAppointmentID());
        assertEquals("John Doe", a.getPatientName());
        assertEquals("Flu", a.getStatus());
    }
    
    //Schedulded vs canncelled status testing
    @Test
    public void testAppointmentStatus() {
        Appointment a = new Appointment(102, "John Fante", "Dr Dre", "COPD", "04/30/2026, 3:30 pm", "Cancelled", "");
        assertEquals("Cancelled", a.getStatus());
        assertNotEquals("Scheduled", a.getStatus());
    }
    
    
    //Testing schedule notes
    @Test
    public void testAppointmentNotes() {
        Appointment a = new Appointment(104, "Caitlin Bruce", "Staff Doctor", "Anxiety", "05/01/2026, 10:30 am",
                "Scheduled", "");
        assertEquals("", a.getNotes());
    }
}