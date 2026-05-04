import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//Main Dahsboard page
public class Dashboard {

    private String currentLog;
    private String userRole;

    // Constructor
    public Dashboard(String username, String role) {
        this.currentLog = username;
        this.userRole = role;
    }

    // Stage for formating
    public void show(Stage primaryStage) {
        Label title = new Label("Welcome to Local Hospital");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label logo = new Label("🏥");
        logo.setStyle("-fx-font-size: 75px; -fx-font-weight: bold; -fx-text-fill: #fffDD0;");

        Label optionTitle = new Label("Select Options:");
        optionTitle.setStyle("-fx-font-size: 21px;");

        // Option buttons
        Button patientsButton = new Button("Patients");
        Button employeeButton = new Button("Schedule");
        Button appointmentButton = new Button("Appointments");
        Button billingButton = new Button("Billing");

        // Button style
        // String buttonStyle = "-fx-background-color: #f0ffff; -fx-background-radius:
        // 25px; -fx-text-fill: #b31b1b; -fx-font-weight: bold; -fx-font-size: 21px;
        // -fx-min-width: 200px;";
        patientsButton.getStyleClass().add("navButton");
        employeeButton.getStyleClass().add("navButton");
        appointmentButton.getStyleClass().add("navButton");
        billingButton.getStyleClass().add("navButton");

        // Button functionality
        patientsButton.setOnAction(e -> {
            PatientWindow patientsWindow = new PatientWindow(currentLog, userRole);
            patientsWindow.show(primaryStage);
        });

        employeeButton.setOnAction(e -> {
            EmployeeWindow employeeWindow = new EmployeeWindow(currentLog, userRole);
            employeeWindow.show(primaryStage);
        });

        appointmentButton.setOnAction(e -> {
            AppointmentWindow appointmentWindow = new AppointmentWindow(currentLog, userRole);
            appointmentWindow.show(primaryStage);
        });

        billingButton.setOnAction(e -> {
            Billing billingWindow = new Billing(currentLog, userRole);
            billingWindow.show(primaryStage);
        });

        // LoggedIn as user button
        Button userButton = new Button("👤 " + currentLog);
        userButton.setStyle("-fx-font-size: 16px;-fx-font-weight: bold; -fx-text-fill: gray");
        userButton.setOnAction(e -> {
            UserAccount userAccount = new UserAccount(currentLog, userRole);
            userAccount.show(primaryStage);
        });

        // Center alignments
        VBox centerContent = new VBox(15);
        centerContent.setAlignment(Pos.CENTER);
        centerContent.getChildren().addAll(logo, title, optionTitle);

        // Restricting Roles
        if (userRole.equals("patient")) {
            centerContent.getChildren().add(appointmentButton);
        } else if (userRole.equals("doctor") || userRole.equals("nurse")) {
            centerContent.getChildren().addAll(patientsButton, employeeButton, appointmentButton);
        } else if (userRole.equals("admin")) {
            centerContent.getChildren().addAll(patientsButton, employeeButton, appointmentButton, billingButton);
        }

        // Set user button to top right
        VBox topBar = new VBox(userButton);
        topBar.setAlignment(Pos.TOP_RIGHT);
        topBar.setStyle("-fx-padding: 10px;");

        // BorderPane for UserAccount
        BorderPane pane = new BorderPane();
        pane.setStyle("-fx-background-color: #5d8aa8;");
        pane.setTop(topBar);
        pane.setCenter(centerContent);

        // Adding everything to the scene
        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setTitle("Local Hospital Portal");
        primaryStage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.show();

    }

}
