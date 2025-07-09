package resource;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerLogInPage {


    @FXML
    private TextField LOGIN_FILED;

    @FXML
    private Button LOG_IN_BUTTON;

    @FXML
    private TextField PASSWORD_FIELD;



    @FXML
    private void LogInButton(ActionEvent actionEvent){
        LOG_IN_BUTTON.setOnAction(event -> {
            
          switch (CheckStatments()) {
            case "BOTH_FIELDS_EMPTHY":
               System.out.println("BOTH FIELDS ARE EMPTHY");                
                break;
            case "LOG_IN_FILED_EMPTHY":
            System.out.println("LOG IN FILED IS EMPTHY");
            break;
            case "PASSWORD_FILE_EMPTHY":
            System.out.println("PASSWORDN FIELD IS EMPTHY");
            break;
            case "ALL_GOOD":
            System.out.println("ALL GOOD");
            break;
          }
        });
    }
    private String CheckStatments(){
        String status;
        if(LOGIN_FILED.getText().isEmpty() && PASSWORD_FIELD.getText().isEmpty()){
             return status = "BOTH_FIELDS_EMPTHY";
        }if(LOGIN_FILED.getText().isEmpty()){
             return status = "LOG_IN_FILED_EMPTHY";  
        }if(PASSWORD_FIELD.getText().isEmpty()){
            return status = "PASSWORD_FILE_EMPTHY";
        }else{
            return status = "ALL_GOOD";
        }
    }
    
}
