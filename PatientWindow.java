import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PatientWindow {

    // Constructor
    private String currentLog;
    private String userRole;

    public PatientWindow(String username, String role) {
        this.currentLog = username;
        this.userRole = role;

    }

    public void show(Stage primaryStage) {

        Label title = new Label("Patient List");

        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Table
        TableView<Patient> table = new TableView<>();

        TableColumn<Patient, Integer> idCol = new TableColumn<>("Patient ID");

        idCol.setCellValueFactory(new PropertyValueFactory<>("patientID"));

        TableColumn<Patient, String> nameCol = new TableColumn<>("Name");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Patient, String> dobCol = new TableColumn<>("Date of Birth");

        dobCol.setCellValueFactory(new PropertyValueFactory<>("dob"));

        TableColumn<Patient, String> issueCol = new TableColumn<>("Issue");

        issueCol.setCellValueFactory(new PropertyValueFactory<>("issue"));

        TableColumn<Patient, String> drCol = new TableColumn<>("Assigned Doctor");

        drCol.setCellValueFactory(new PropertyValueFactory<>("doctor"));

        TableColumn<Patient, String> notesCol = new TableColumn<>("Notes");

        notesCol.setCellValueFactory(new PropertyValueFactory<>("notes"));

        table.getColumns().addAll(idCol, nameCol, dobCol, issueCol, drCol, notesCol);

        // List of test users hardcoded into the system for testing
        table.getItems().addAll(

                new Patient(2757150, "Jacob Stocksdale", "01/17/1988", "Torn ACL", "Dr.Kevin Kutt", ""),

                new Patient(1015213, "Caitlin Bruce", "07/21/1991", "Seasonal Checkup", "Dr. Dre", ""),

                new Patient(1943077, "Jordan Williams", "04/30/1990", "Stomach Pain", "", ""),

                new Patient(9000921, "Dwight Shrute", "11/05/1966", "Raw Milk Issues", "Dr.House", ""),

                new Patient(6719033, "John Fante", "02/24/1939", "COPD", "", "")

        );

        // Back button
        Button backButton = new Button("Back to Dashboard");

        backButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");

        backButton.setOnAction(e -> {

            Dashboard dashboard = new Dashboard(currentLog, userRole);

            dashboard.show(primaryStage);

        });

        VBox layout = new VBox(15);

        layout.setAlignment(Pos.CENTER);

        layout.getChildren().addAll(title, table, backButton);

        Scene scene = new Scene(layout, 800, 600);

        primaryStage.setTitle("Local Hospital - Patients");

        primaryStage.setScene(scene);

        primaryStage.show();

    }

}
