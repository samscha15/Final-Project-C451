import java.util.Date;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//Appoint Window Layout and setup
public class AppointmentWindow {

    // Constructor
    private String currentLog;
    private String userRole;

    public AppointmentWindow(String username, String role) {
        this.currentLog = username;
        this.userRole = role;
    }

    public void show(Stage primaryStage) {
        Label title = new Label("Appointments");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Tables
        TableView<Appointment> table = new TableView<>();
        TableColumn<Appointment, Integer> idCol = new TableColumn<>("Appointment ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));

        TableColumn<Appointment, String> patientCol = new TableColumn<>("Patient Name");
        patientCol.setCellValueFactory(new PropertyValueFactory<>("patientName"));

        TableColumn<Appointment, String> doctorCol = new TableColumn<>("Doctor");
        doctorCol.setCellValueFactory(new PropertyValueFactory<>("doctor"));

        TableColumn<Appointment, String> issueCol = new TableColumn<>("Issue");
        issueCol.setCellValueFactory(new PropertyValueFactory<>("issue"));

        TableColumn<Appointment, String> dateCol = new TableColumn<>("Date & Time");
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Appointment, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableColumn<Appointment, String> notesCol = new TableColumn<>("Additional Notes:");
        notesCol.setCellValueFactory(new PropertyValueFactory<>("notes"));

        table.getColumns().addAll(idCol, patientCol, doctorCol, issueCol, dateCol, statusCol, notesCol);

        // Hardcoded of some future patients
        table.getItems().addAll(new Appointment(103, "Jacob Stocksdale", "Dr. Dre", "Chronic Pain in left knee",
                "05/01/2026, 8:00 am", "Scheduled", ""), new Appointment(104

                        , "Caitlin Bruce", "Staff Doctor", "Anxiety", "05/01/2026, 10:30 am", "Scheduled", ""),
                new Appointment(105, "Jordan Williams", "Dr. Dre", "Chronic Stomach Issues", "05/02/2026, 2:00 am",
                        "Scheduled", ""),
                new Appointment(101, "Dwight Shrute", "Staff Doctor", "Beet Red Skin", "04/30/2026, 11:00 am",
                        "Completed", ""),
                new Appointment(102, "John Fante", "Kevin Kutts", "Jaundiced Skin", "04/30/2026, 3:30 pm", "Cancelled",
                        ""));

        // Strikethrough code for cancelled or completed appointments
        statusCol.setCellFactory(col -> new TableCell<Appointment, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(item);
                    if (item.equals("Completed")) {
                        setStyle("-fx-text-fill: Green; -fx-font-weight: BOLD");
                    } else if (item.equals("Cancelled")) {
                        setStyle("-fx-text-fill: Red;-fx-strikethrough: true; -fx-font-weight: BOLD");
                    } else {
                        setStyle("");
                    }
                }
            }
        });

        // Buttons
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
        primaryStage.setTitle("Local Hospital - Appointments");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}