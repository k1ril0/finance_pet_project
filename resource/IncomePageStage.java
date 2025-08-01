package resource;

import java.util.HashMap;

import javax.print.DocFlavor.INPUT_STREAM;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IncomePageStage {
    
    @FXML
    private Button BackToMainStage;
 

    private ObservableList<PieChart.Data> listForPieChart =
    FXCollections.observableArrayList();

    private HashMap<String,Integer>DataOfPieChart = new HashMap<>();

    @FXML
    private Boolean CheckFieldsForAdd(TextField labelField,TextField amountField){
      if(labelField.getText().isEmpty()&&amountField.getText().isEmpty()){
        return false;
      }else{
        return true;
      }
    } 
    @FXML
    private void PieChartInitialize(){
      Stage stage = new Stage();
      PieChart chartForScene = new PieChart(listForPieChart);
            if(!listForPieChart.isEmpty()){
      Button ExitButton = new Button("EXIT");
      chartForScene.setTitle("Spendings Tracker");
      VBox window = new VBox(chartForScene,ExitButton);
      stage.setScene(new Scene(window,600,400));
      stage.show();
      ExitButton.setOnAction(e ->{
        stage.close();
      });
            }else{
              System.out.println("error again");
            }
    }
    @FXML
    private void AddInfoCategory(){
      TextField label = new TextField();
      TextField amount = new TextField();
      Button EnterButton = new Button("ENTER");
      Button ExitButton2 = new Button("EXIT");
      ExitButton2.setOnAction(e ->{
        GoBackToIcomePage(ExitButton2);
      });
      VBox windowForAdd = new VBox(label,amount,EnterButton,ExitButton2);
      Stage AddInfoCategoryStage = new Stage();
      AddInfoCategoryStage.setScene(new Scene(windowForAdd,600,400));
      AddInfoCategoryStage.show();
      
        
        EnterButton.setOnAction(e ->{
          String parsedLabel = label.getText().trim();
          String TextAmount = amount.getText().trim();
          

          if(parsedLabel.isEmpty()){
            System.out.println("please fill label field for contiune");
            return;
          }
          try{
          int parsedAmount = Integer.parseInt(TextAmount);
          if(parsedAmount<=0){
            System.out.println("amount cant be negative,please enter bigger number at least");
          }else{
            AddNewCatg(parsedLabel, parsedAmount);
            AddInfoCategoryStage.close();
            PieChartInitialize();
            // GoBackToIcomePage(EnterButton);
          } 
          }catch(NumberFormatException ex){
            ex.getLocalizedMessage();
          }
        });
    }
    private void AddNewCatg(String name,int amount){
       DataOfPieChart.put(name, DataOfPieChart.getOrDefault(name, 0)+ amount);
      listForPieChart.clear();
            if(DataOfPieChart==null){
       System.out.println("Data Of PieChart is not initialized");
       return;
    }else{
      DataOfPieChart.forEach((key, value)->{
        listForPieChart.add(new PieChart.Data(key,value));
        System.out.println("all good ");
      });
    }
    }
       @FXML
    private void GoBackToIcomePage(Button ExpectedButton){
      try{
        Parent root = FXMLLoader.load(getClass().getResource("/resource/IncomePageStage.fxml"));
        Stage BacckStage = (Stage) ExpectedButton.getScene().getWindow();
        Scene scene = new Scene(root);
        BacckStage.setScene(scene);
        BacckStage.show();
      }catch(Exception e){
         e.printStackTrace();
      }
    }
    @FXML
    private void GoBackToMainStage(){
        BackToMainStage.setOnAction(event ->{
              try{
               Parent root = FXMLLoader.load(getClass().getResource("/resource/MainStage.fxml"));
               Stage BackmainStage = (Stage) BackToMainStage.getScene().getWindow();
               Scene Backscene = new Scene(root);
               BackmainStage.setScene(Backscene);
               BackmainStage.setResizable(false);
               BackmainStage.show();
              }catch(Exception e){

              }
        });
    }





 }
