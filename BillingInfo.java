//Billing building
public class BillingInfo {

    private int billID;
    private int patientID;
    private String patientName;
    private String billedFor;
    private double amountOwed;
    private String patientInsurance;
    private String status;

    // constructor
    public BillingInfo(int billID, int patientID, String patientName, String billedFor, double amountOwed,
            String patientInsurance, String status) {
        this.billID = billID;
        this.patientID = patientID;
        this.patientName = patientName;
        this.billedFor = billedFor;
        this.amountOwed = amountOwed;
        this.patientInsurance = patientInsurance;
        this.status = status;
    }

    // Getters
    public int getBillID() {
        return billID;
    }

    public int getPatientID() {
        return patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getBilledFor() {
        return billedFor;
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public String getPatientInsurance() {
        return patientInsurance;
    }

    public String getStatus() {
        return status;
    }

}
