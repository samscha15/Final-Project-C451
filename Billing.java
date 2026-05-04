import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Billing {

    private String currentLog;
    private String userRole;

    public Billing(String username, String role) {
        this.currentLog = username;
        this.userRole = role;
    }
    
    public void show(Stage primaryStage) {
        Label title = new Label("Billing");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Table build
        TableView<BillingInfo> table = new TableView<>();

        TableColumn<BillingInfo, Integer> idCol = new TableColumn<>("Billing ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("billID"));

        TableColumn<BillingInfo, String> patientIDCol = new TableColumn<>("PatientID");
        patientIDCol.setCellValueFactory(new PropertyValueFactory<>("patientID"));

        TableColumn<BillingInfo, String> patientCol = new TableColumn<>("Patient Name");
        patientCol.setCellValueFactory(new PropertyValueFactory<>("patientName"));

        TableColumn<BillingInfo, String> serviceCol = new TableColumn<>("Service");
        serviceCol.setCellValueFactory(new PropertyValueFactory<>("billedFor"));

        TableColumn<BillingInfo, Double> amountCol = new TableColumn<>("Amount");
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amountOwed"));

        TableColumn<BillingInfo, String> insuranceCol = new TableColumn<>("Insurance");
        insuranceCol.setCellValueFactory(new PropertyValueFactory<>("patientInsurance"));

        TableColumn<BillingInfo, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        table.getColumns().addAll(idCol, patientIDCol, patientCol, serviceCol, amountCol, insuranceCol, statusCol);

        // Shades for different billing statuses
        statusCol.setCellFactory(col -> new TableCell<BillingInfo, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    Label label = new Label(item);
                    if (item.equals("Paid")) {
                        label.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
                    } else if (item.equals("Unpaid")) {
                        label.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
                    } else {
                        label.setStyle("-fx-text-fill: orange; -fx-font-weight: bold;");
                    }
                    setGraphic(label);
                }
            }
        });

        // Hardcoded sample people
        table.getItems().addAll(
                new BillingInfo(006723, 2757150, "Jacob Stocksdale", "ACL Surgery", 15000.00, "Blue Cross", "Pending"),
                new BillingInfo(002343, 1015213, "Caitlin Bruce", "General Checkup", 250.00, "Aetna", "Paid"),
                new BillingInfo(002234, 1943077, "Jordan Williams", "Endoscopy", 3200.00, "United Health", "Unpaid"),
                new BillingInfo(003504, 9000921, "Dwight Shrute", "Emergency Visit", 8500.00, "None", "Unpaid"),
                new BillingInfo(001231, 6719033, "John Fante", "Pulmonology Consult", 450.00, "Medicare", "Paid"));

        // Back button
        Button backButton = new Button("Back to Dashboard");
        backButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        backButton.setOnAction(e -> {
            Dashboard dashboard = new Dashboard(currentLog, userRole);
            dashboard.show(primaryStage);
        });
        
        //Page alignment and layout
        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(title, table, backButton);

        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setTitle("Local Hospital - Billing");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}