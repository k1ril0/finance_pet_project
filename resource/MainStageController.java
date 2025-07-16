package resource;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainStageController {


    @FXML
    private Button incomes_other_button;

    @FXML
    private Button mothly_budget_button;

    @FXML
    private void goToIncomesAndOther(){
        incomes_other_button.setOnAction(event ->{
            try{
                Parent root = FXMLLoader.load(getClass().getResource("/resource/IncomePageStage.fxml"));
                Stage incomeStage = (Stage) incomes_other_button.getScene().getWindow();
                Scene incomeScene = new Scene(root,600,400);
                incomeStage.setScene(incomeScene);
                incomeStage.setTitle("Income Edit Page");
                incomeStage.setResizable(false);
                incomeStage.show();
            }catch(Exception e){
                System.out.println("Spotted error in #goToIncome method " + e.getLocalizedMessage());
            }
        });
    }
    @FXML
    private void goToMonthlyBudget(){
        mothly_budget_button.setOnAction(event ->{
            try{
              Parent root = FXMLLoader.load(getClass().getResource("/resource/MothllyBudgetStage.fxml"));
              Stage budgetStage = (Stage) mothly_budget_button.getScene().getWindow();
              Scene budgetScene = new Scene(root,600,400);
              budgetStage.setScene(budgetScene);
              budgetStage.setResizable(false);
              budgetStage.setTitle("Budget Page");
              budgetStage.show();               
            }catch(Exception e){

                System.out.println("Spotted error in #goToMothllyBudget method " + e.getLocalizedMessage());
            }
        });
    }
}
