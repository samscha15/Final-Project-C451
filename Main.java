import javafx.application.Application;
import javafx.stage.Stage;

//Main class to start the application
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Database load
        DatabaseConfig.initializeDatabase();

        Login loginWindow = new Login();
        loginWindow.show(primaryStage);

    }

    public static void main(String[] args) {
        launch(args);
    }

}
