import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserAccount {

    // Constructor
    private String currentLog;
    private String userRole;

    public UserAccount(String username, String role) {
        this.currentLog = username;
        this.userRole = role;

    }

    public void show(Stage primaryStage) {

        // Page title
        Label title = new Label(currentLog + "'s" + " Account");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Admin restrict
        TextField usernameField = new TextField(currentLog);
        usernameField.setMaxWidth(200);
        usernameField.setDisable(!userRole.equals("admin"));

        // Admin Role permissions
        TextField roleField = new TextField(userRole);
        roleField.setMaxWidth(200);
        roleField.setDisable(!userRole.equals("admin"));

        // Dispaly names
        TextField displayNameField = new TextField(currentLog);
        displayNameField.setMaxWidth(200);

        // Save button
        Button saveButton = new Button("Save Changes");
        saveButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        saveButton.setOnAction(e -> currentLog = displayNameField.getText());

        // Back button
        Button backButton = new Button("Back to Dashboard");
        backButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        backButton.setOnAction(e -> {
            Dashboard dashboard = new Dashboard(currentLog, userRole);
            dashboard.show(primaryStage);
        });

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(title, displayNameField, usernameField, roleField, saveButton, backButton);

        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setTitle("User Account");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}