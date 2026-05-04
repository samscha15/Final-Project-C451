import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.*;

//Class for the login screen for users. Showing the username and password
//As well as the look and feel of the page
public class Login {

    // Setting up user Roles

    private String getRole(String username, String password) {
        if (username.equals("admin") && password.equals("admin123"))
            return "admin";
        if (username.equals("drdre") && password.equals("doctor123"))
            return "doctor";
        if (username.equals("nursejackie") && password.equals("nurse123"))
            return "nurse";
        if (username.equals("jacobstocksdale") && password.equals("patient123"))
            return "patient";
        return null;
    }

    // Setting up user display name based on role/user
    private String getDisplayName(String username) {
        switch (username) {
        case "admin":
            return "Administrator";
        case "drdre":
            return "Doctor Edward Dre";
        case "nursejackie":
            return "Nurse Jackie Hart";
        case "patient1":
            return "Jacob Stocksdale";
        default:
            return username;
        }
    }

    // Style and setting for the overall page
    public void show(Stage primaryStage) {
        Label title = new Label("Local Hospital");
        title.setStyle("-fx-font-size: 35px; -fx-font-weight: bold; -fx-text-fill: #fffDD0;");
        Label logo = new Label("🏥");
        logo.setStyle("-fx-font-size: 75px; -fx-font-weight: bold; -fx-text-fill: #fffDD0;");

        // Username type in section
        Label userName = new Label("Username");
        TextField userNameField = new TextField();
        userNameField.setPromptText("johnsmith@iu.edu");
        userNameField.setMaxWidth(200);
        userName.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        // Password type in section
        Label passWord = new Label("Password");
        PasswordField passField = new PasswordField();
        passField.setPromptText("Password123");
        passField.setMaxWidth(200);
        passWord.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        // Login button
        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-weight: bold;");

        // Error label
        Label error = new Label("");
        error.setStyle("-fx-text-fill: Yellow; -fx-font-size: 14px; -fx-font-weight:BOLD");

        // Login button
        loginButton.setOnAction(e -> {
            String username = userNameField.getText();
            String password = passField.getText();
            String role = getRole(username, password);

            /*
             * Old Login Error if(role != null) { String displayName =
             * getDisplayName(username); Dashboard dashboard = new Dashboard(displayName,
             * role); dashboard.show(primaryStage); } else {
             * error.setText("Invalid username and/or password"); }
             */

            if (role != null) {
                Logger.log("User " + username + " with role: " + role + " logged into system.");
                Dashboard dashboard = new Dashboard(username, role);
                dashboard.show(primaryStage);
            } else {
                Logger.log("Failed login by: " + username);
                error.setText("Invalid username and/or password");
            }
        });

        // Layout and Style
        VBox layout = new VBox(10);

        layout.setStyle("-fx-background-color: #c0392b;");
        layout.setAlignment(Pos.CENTER);

        layout.getChildren().addAll(logo, title, userName, userNameField, passWord, passField, loginButton, error);

        Scene scene = new Scene(layout, 800, 600);

        primaryStage.setTitle("Local Hospital - Login");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
