import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//Stock JUnit testing for Billing
public class BillingTest {

    // public BillingInfo(int billID, int patientID, String patientName, String
    // billedFor, double amountOwed,
    // String patientInsurance, String status)
    
    //Billing Creation test
    @Test
    public void testBillingCreation() {
        BillingInfo bill = new BillingInfo(1001, 1245565, "Mr. Operation", "Full Body Cavity Operation",
                1000000000000000.00, "United Health", "Past Due");
        assertEquals(1001, bill.getBillID());
        assertEquals("Mr Operation", bill.getPatientName());
        assertEquals(1000000000000000.00, bill.getAmountOwed());
    }
    
    //Bill paid or unpaid status check
    @Test
    public void testBillingStatus() {
        BillingInfo bill = new BillingInfo(002343, 1015213, "Caitlin Bruce", "General Checkup", 250.00, "Aetna",
                "Paid");
        assertEquals("Paid", bill.getStatus());
        assertNotEquals("Unpaid", bill.getStatus());
    }

    //Testing the correct billing owed amounts
    @Test
    public void testBillingAmount() {
        BillingInfo bill = new BillingInfo(002234, 1943077, "Jordan Williams", "Endoscopy", 3200.00, "United Health",
                "Unpaid");
        assertTrue(bill.getAmountOwed() > 0);
    }
}