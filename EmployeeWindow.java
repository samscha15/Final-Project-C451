import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmployeeWindow {

    // Constructor
    private String currentLog;
    private String userRole;

    public EmployeeWindow(String username, String role) {
        this.currentLog = username;
        this.userRole = role;

    }

    public void show(Stage primaryStage) {
        Label title = new Label("Employee Schedule");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Tables
        TableView<Employee> table = new TableView<>();

        TableColumn<Employee, Integer> idCol = new TableColumn<>("Employee ID: ");
        idCol.setCellValueFactory(new PropertyValueFactory<>("employeeID"));

        TableColumn<Employee, String> nameCol = new TableColumn<>("Name: ");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Employee, String> jobCol = new TableColumn<>("Position: ");
        jobCol.setCellValueFactory(new PropertyValueFactory<>("job"));

        TableColumn<Employee, String> shiftCol = new TableColumn<>("Employee Shift: ");
        shiftCol.setCellValueFactory(new PropertyValueFactory<>("employeeShift"));

        TableColumn<Employee, String> daysCol = new TableColumn<>("Scheduled Work Days: ");
        daysCol.setCellValueFactory(new PropertyValueFactory<>("scheduleDays"));

        table.getColumns().addAll(idCol, nameCol, jobCol, shiftCol, daysCol);

        // Hardcoded Employees for testing
        table.getItems().addAll(
                new Employee(3713, "Dr. Dre", "Musician Phsician", "7:00am - 4:00pm", "Friday, Saturday, Sunday"),
                new Employee(3333, "Nurse Jackie", "Nurse", "7:00p, - 7:00am", "Monday,Wednesday, Thursday"),
                new Employee(6858, "Christopher Maltisonti", "Phsician Assistant", "5:00am - 5:00pm",
                        "Thursday - Saturday"),
                new Employee(1350, "Dr. Kevin Kutt", "Trauma Surgeon", "8:00pm - 6:00am", "Friday - Sunday"),
                new Employee(2346, "Carol Sherral", "Front Desk Receptionist", "9:00am - 6:00pm", "Monday - Friday")

        );

        // More buttons
        Button backButton = new Button("Back to Dashboard");
        backButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        backButton.setOnAction(e -> {
            Dashboard dashboard = new Dashboard(currentLog, userRole);
            dashboard.show(primaryStage);
        });

        // Layout of employee section
        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(title, table, backButton);

        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setTitle("Local Hospital - Schedule");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}