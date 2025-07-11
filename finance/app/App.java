package finance.app;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application
{
   

    public static void main( String[] args )
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
     Parent root = FXMLLoader.load(getClass().getResource("/resource/LogInStage.fxml"));
     Scene scene = new Scene(root,500,400);
     scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
     primaryStage.setScene(scene);
     primaryStage.setTitle("Finance App Demo");
     primaryStage.show();
    }
    
}
