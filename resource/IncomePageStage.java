package resource;

import javax.print.DocFlavor.INPUT_STREAM;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IncomePageStage {
    
    @FXML
    private Button BackToMainStage;
    // @FXML
    // private PieChart SpendingsPieChart;

    @FXML
    private Button exit_buttton = new Button("EXIT");



    @FXML
    private void GoBackToMainStage(){
      // PieChart chart = IncomeChart();
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
    @FXML
    private void SpendingsOfThisMonth(){
      PieChart nowDaysSpendings = IncomeChart();
      try{
        // Parent root = FXMLLoader.load(getClass().getResource("PieChart.fxml"));
        Stage PieChartStage = (Stage) BackToMainStage.getScene().getWindow();
        Scene scene = new Scene(nowDaysSpendings);
        PieChartStage.setScene(scene);
        PieChartStage.setTitle("PIeChart");
        exit_buttton.setOnAction(e ->{
          GoBackToIcomePage();
        });
        VBox window = new VBox(nowDaysSpendings,exit_buttton);
        Scene chartScene = new Scene(window,600,400);
        PieChartStage.setScene(chartScene);
        PieChartStage.show();
      }catch(Exception e){
        e.printStackTrace();
      }
    }


    @FXML
    private void GoBackToIcomePage(){
      try{
        Parent root = FXMLLoader.load(getClass().getResource("IncomePageStage.fxml"));
        Stage BacckStage = (Stage) exit_buttton.getScene().getWindow();
        Scene scene = new Scene(root);
        BacckStage.setScene(scene);
        BacckStage.show();
      }catch(Exception e){
         e.printStackTrace();
      }



    }
    private PieChart IncomeChart(){
      ObservableList<PieChart.Data> listOfDataMoney = 
      FXCollections.observableArrayList();

      PieChart chart = new PieChart();

      listOfDataMoney.add(new PieChart.Data("Appels",50));
      listOfDataMoney.add(new PieChart.Data("Oranges", 40));

      chart.setData(listOfDataMoney);

      return chart; 
    }
}
