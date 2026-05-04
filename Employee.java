
public class Employee {

    private int employeeID;
    private String name;
    private String job;
    private String employeeShift;
    private String scheduleDays;
    private String notes;
    
    //Constructor
    public Employee(int employeeID, String name, String job, String employeeShift, String scheduleDays) {
        this.employeeID = employeeID;
        this.name = name;
        this.job = job;
        this.employeeShift = employeeShift;
        this.scheduleDays = scheduleDays;
        this.notes = "";
    }

    //Getters
    public int getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getEmployeeShift() {
        return employeeShift;
    }

    public String getScheduleDays() {
        return scheduleDays;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
