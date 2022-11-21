import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    public static Stage stage = null;

    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(App.class.getResource("/fxml/HelloLogin.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
//        Parent root = FXMLLoader.load(getClass().getResource("fxml/LOGINPANNEL.fxml"));
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
        stage.setTitle("Boangisa Study Database");
        stage.show();
    }
}
