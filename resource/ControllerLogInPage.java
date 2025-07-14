package resource;

import finance.app.DataBaseController;
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
    private TextField PASSWORD_FIELD_SIGH_IN;

    @FXML
    private Button SIGH_IN_BUTTON;

    @FXML
    private TextField USERNAME_FIELD_SIGH_IN;

    @FXML
    private TextField LOGIN_FILED_SIGH_IN;




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
    private String CheckStatmentsForSighIn(){
        String status_sigh_in;
        if(PASSWORD_FIELD_SIGH_IN.getText().isEmpty() && LOGIN_FILED_SIGH_IN.getText().isEmpty() && USERNAME_FIELD_SIGH_IN.getText().isEmpty()){
         return status_sigh_in = "ALL_FIELDS_ARE_EMPTHY";
        }if(PASSWORD_FIELD_SIGH_IN.getText().isEmpty() && LOGIN_FILED_SIGH_IN.getText().isEmpty()){
            return status_sigh_in = "USERNAME_FIELD_EMPTHY";
        }if(USERNAME_FIELD_SIGH_IN.getText().isEmpty() && LOGIN_FILED_SIGH_IN.getText().isEmpty()){
            return status_sigh_in = "PASSWORD_FIELD_EMPTHY";
        }if(USERNAME_FIELD_SIGH_IN.getText().isEmpty() && PASSWORD_FIELD_SIGH_IN.getText().isEmpty()){
            return status_sigh_in = "LOGIN_FILED_EMPTHY";
        }else{
            return status_sigh_in = "ALL_GOOD";
        }
    }
    @FXML
    private void SighInButton(){
        switch (CheckStatmentsForSighIn()) {
            case "ALL_FIELDS_ARE_EMPTHY":
                System.out.println("ALL FIELDS ARE EMPTHY");
                break;
            case "USERNAME_FIELD_EMPTHY":
            System.out.println("USERNAME FIELD IS EMPTHY");
            break;
            case "PASSWORD_FIELD_EMPTHY":
            System.out.println("PASSWORD FIELD IS EMPTHY");
            break;
            case "LOGIN_FILED_EMPTHY":
            System.out.println("LOGIN FILED IS EMPTHY");
            break;
            case "ALL_GOOD":
            System.out.println("ALL GOOD");
            DataBaseController controller = new DataBaseController();
            controller.Add(LOGIN_FILED_SIGH_IN.getText(), PASSWORD_FIELD_SIGH_IN.getText());
            break;
        }
    }
    
}
