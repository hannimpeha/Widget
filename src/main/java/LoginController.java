import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    private final LoginViewBuilder viewBuilder;
    private final LoginModel model = new LoginModel();
    private Stage stage;

    public LoginController() {
        viewBuilder = new LoginViewBuilder(model, this::checkAccess);
    }


    private void checkAccess() {
        if (model.getUser().equals("boangisa") && model.getPassword().equals("snuche06")) {
            try {
                loadMainApplication();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            displayErrorMessage();
        }
    }

    private void loadMainApplication() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/LOGINPANNEL.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    private void displayErrorMessage() {
        Alert dialog = new Alert(Alert.AlertType.ERROR);
        dialog.setTitle("Not able to Login");
        dialog.setHeaderText("Incorrect Username or Password");
        dialog.setContentText("You have entered incorrect username or Password.\nPlease try Again");
        dialog.showAndWait();
    }

    public Region getView() {
        return viewBuilder.getView();
    }
}