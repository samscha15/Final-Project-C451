import java.util.Date;

public class Appointment {

    private int appointmentID;
    private String patientName;
    private String doctor;
    private String issue;
    private String date;
    private String status;
    private String notes;

    // Contructor
    public Appointment(int appointmentID, String patientName, String doctor, String issue, String date, String status,
            String notes) {
        this.appointmentID = appointmentID;
        this.patientName = patientName;
        this.doctor = doctor;
        this.issue = issue;
        this.date = date;
        this.status = status;
        this.notes = notes;

    }

    // Getters
    public int getAppointmentID() {
        return appointmentID;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getIssue() {
        return issue;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getNotes() {
        return notes;
    }

}
