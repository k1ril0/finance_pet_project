package resource;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class IncomePageStage {
    
    @FXML
    private Button BackToMainStage;
    @FXML
    public PieChart pie_chart_of_spendings;
    @FXML
    private Button ThisMoth;



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
      Parent root;
      PieChart thisMothChart =  IncomeChart();
      try{
         Stage stage = (Stage) ThisMoth.getScene().getWindow();
         Scene scene = new Scene(thisMothChart,600,400);
         stage.setScene(scene);
         stage.setTitle("This month Chart");
         stage.show();
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
