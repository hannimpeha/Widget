import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {


    private final LoginModel model = new LoginModel();
    private final LoginViewBuilder viewBuilder;
    private Stage stage;
    // Strings which hold css elements to easily re-use in the application
    protected
    String successMessage = String.format("-fx-text-fill: GREEN;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;");

    // Import the application's controls
    @FXML
    private Label invalidLoginCredentials;
    @FXML
    private Button cancelButton;
    @FXML
    private Button loginButton;
    @FXML
    private TextField loginUsernameTextField;
    @FXML
    private TextField loginPasswordPasswordField;
    


    // Creation of methods which are activated on events in the forms
    @FXML
    protected void onCancelButtonClick() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public HelloController() {
        viewBuilder = new LoginViewBuilder(model, this::onLoginButtonClick);
    }

    @FXML
    protected void onLoginButtonClick() {
        if (loginUsernameTextField.getText().isBlank() || loginPasswordPasswordField.getText().isBlank()) {
            invalidLoginCredentials.setText("The Login fields are required!");
            invalidLoginCredentials.setStyle(errorMessage);

            if (loginUsernameTextField.getText().isBlank()) {
                loginUsernameTextField.setStyle(errorStyle);
            } else if (loginPasswordPasswordField.getText().isBlank()) {
                loginPasswordPasswordField.setStyle(errorStyle);
            }
        } else {
            invalidLoginCredentials.setText("Login Forms are Successful!");
            invalidLoginCredentials.setStyle(successMessage);
            loginUsernameTextField.setStyle(successStyle);
            loginPasswordPasswordField.setStyle(successStyle);
            Stage stage = (Stage) loginButton.getScene().getWindow();
            checkAccess(stage);

        }
    }

    private void checkAccess(Stage stage) {
        if (loginUsernameTextField.getText().equals("boangisa") &&
                loginPasswordPasswordField.getText().equals("snuche06")) {
            loadMainApplication(stage);
        } else {
            displayErrorMessage();
        }
    }



    private void loadMainApplication(Stage stage) {

//        Parent root = FXMLLoader.load(HelloController.class.getResource("fxml/LOGINPANNEL.fxml"));
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
        VBox vBox = new VBox(new ImageView(new Image("/fxml/hannimpeha.png")));
        stage.setScene(new Scene(vBox));

    }


    private void displayErrorMessage() {
        Alert dialog = new Alert(Alert.AlertType.ERROR);
        dialog.setTitle("Not able to Login");
        dialog.setHeaderText("Incorrect Username or Password");
        dialog.setContentText("You have entered incorrect username or Password.\nPlease try Again");
        dialog.showAndWait();
    }

}