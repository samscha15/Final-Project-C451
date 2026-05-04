public class Patient {
    private String name;
    private String dob;
    private String issue;
    private int patientID;
    private String notes;
    private String doctor;

    // Test Patient List Constructor
    public Patient(int patientID, String name, String dob, String issue, String doctor, String notes) {
        this.patientID = patientID;
        this.name = name;
        this.dob = dob;
        this.issue = issue;
        this.doctor = doctor;
        this.notes = "";
    }

    // Getters
    public int getPatientID() {
        return patientID;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getIssue() {
        return issue;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getNotes() {
        return notes;
    }

    // Setter
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
