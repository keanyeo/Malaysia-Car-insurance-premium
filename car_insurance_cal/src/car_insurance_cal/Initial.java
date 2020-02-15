package car_insurance_cal;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Initial extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("car insurance premium calculator");

        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 800, 500);
        // Set the scene in primary stage	
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }


    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        // Add Header
        Label headerLabel = new Label("car insurance premium calculator");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add CC Label
        Label nameLabel = new Label("car CC : ");
        gridPane.add(nameLabel, 0,1);

        
        // Add CC Text Field
        TextField ccField = new TextField();
        ccField.setPrefHeight(40);
        gridPane.add(ccField, 1,1);


        // Add MV Label
        Label mvLabel = new Label("market value : ");
        gridPane.add(mvLabel, 0, 2);

        // Add MV Text Field
        TextField mvField = new TextField();
        mvField.setPrefHeight(40);
        gridPane.add(mvField, 1, 2);

        // Add NCD Label
        Label ncdLabel = new Label("NCD year(1~5) : ");
        gridPane.add(ncdLabel, 0, 3);

        // Add NCD Field
        TextField ncdField = new TextField();
        ncdField.setPrefHeight(40);
        gridPane.add(ncdField, 1, 3);
        
        // Add windscreen_cover Label
        Label wcLabel = new Label("windscreen(1/0) opt : ");
        gridPane.add(wcLabel, 0, 4);
        
        // Add windscreen_cover Text Field
        TextField wcField = new TextField();
        wcField.setPrefHeight(40);
        gridPane.add(wcField, 1, 4);
        
        // Add Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 5, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(ccField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your CC");
                    return;
                }
                if(mvField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your market value");
                    return;
                }
                if(ncdField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a NCD year");
                    return;
                }
                if(wcField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a Windscreen option");
                    return;
                }
                
                Car carObj = new Car(
                		Integer.parseInt(ccField.getText()),
                		Integer.parseInt(mvField.getText()),
                		Integer.parseInt(ncdField.getText()),
                		Integer.parseInt(wcField.getText()));
                
                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "compute successful!","Premium :"+Double.toString(carObj.cal_pay_prm()));
                
            }
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}