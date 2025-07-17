package resource;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MothllyBudgetStage {
    @FXML
    private Button BackToMainStage2;


    @FXML
    private void GoBackToMainStage2(){
        BackToMainStage2.setOnAction(event ->{
              try{
               Parent root = FXMLLoader.load(getClass().getResource("/resource/MainStage.fxml"));
               Stage BackmainStage = (Stage) BackToMainStage2.getScene().getWindow();
               Scene Backscene = new Scene(root);
               BackmainStage.setScene(Backscene);
               BackmainStage.setResizable(false);
               BackmainStage.show();
              }catch(Exception e){

              }
        });
    }
}
