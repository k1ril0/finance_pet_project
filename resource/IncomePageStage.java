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
    // @FXML
    // private Button AddIncomesButton = new Button();

    private ObservableList<PieChart.Data> listForPieChart =
    FXCollections.observableArrayList();

    private HashMap<String,Integer>DataOfPieChart;
  //   @FXML
  //   ObservableList<PieChart.Data> listOfDataMoney = 
  //   FXCollections.observableArrayList();



    
  //   @FXML
  //   private void SpendingsOfThisMonth(ActionEvent e){
  //     try{
  //       if(listOfDataMoney.isEmpty()){
  //         System.out.println("plaes add incomes to see piechart then ");
  //       }else{
  //          PieChart piechart = new PieChart(listOfDataMoney);
  //       Button exit_buttton = new Button("EXIT");

  //         exit_buttton.setOnAction(ev ->{
  //         GoBackToIcomePage(exit_buttton);
  //       });
  //       VBox window = new VBox(piechart,exit_buttton);
  //       Scene chartScene = new Scene(window,600,400);
  //       // Stage PieChartStage = (Stage) BackToMainStage.getScene().getWindow();
  //       Stage PieChartStage = (Stage) ((Button) e.getSource()).getScene().getWindow();
  //       PieChartStage.setScene(chartScene);
  //       PieChartStage.setTitle("PIeChart");
  //       PieChartStage.setScene(chartScene);
  //       PieChartStage.show();
  //       }
  //       // PieChart piechart = new PieChart(listOfDataMoney);
  //       // Button exit_buttton = new Button("EXIT");

  //       //   exit_buttton.setOnAction(e ->{
  //       //   GoBackToIcomePage(exit_buttton);
  //       // });
  //       // VBox window = new VBox(piechart,exit_buttton);
  //       // Scene chartScene = new Scene(window,600,400);
  //       // Stage PieChartStage = (Stage) BackToMainStage.getScene().getWindow();
  //       // PieChartStage.setScene(chartScene);
  //       // PieChartStage.setTitle("PIeChart");
  //       // PieChartStage.setScene(chartScene);
  //       // PieChartStage.show();
  //     }catch(Exception ex){
  //       ex.printStackTrace();
  //     }
  //   }
  //   private void AddIncomeChart(String nameOfSection,int number){
  //   //    ObservableList<PieChart.Data> listOfDataMoney = 
  //   // FXCollections.observableArrayList();
  //     listOfDataMoney.add(new PieChart.Data(nameOfSection, number));
  //   }
  // @FXML
  // private void AddValuesToPieChart(){
  //   try{
  //     TextField textFieldForIncomes = new TextField();
  //     TextField textFieldForLabels = new TextField();
  //     Button SubmitButton = new Button("SUBMIT");
  //     Button ExitButton = new Button("EXIT");
  //     VBox WindowOfAdd = new VBox(textFieldForIncomes,textFieldForLabels,SubmitButton,ExitButton);
  //     Stage AddStage =  (Stage) AddIncomesButton.getScene().getWindow();
  //     Scene AddScene = new Scene(WindowOfAdd,600,400);
  //     ExitButton.setOnAction(e ->{
  //       GoBackToIcomePage(ExitButton);
  //     });
  //     SubmitButton.setOnAction(e ->{
  //       if(!CheckFieldsForAdd(textFieldForIncomes, textFieldForLabels)){
  //        System.out.println("Please fill all fields");
  //       }else{
  //         String label = textFieldForLabels.getText();
  //         int integer = Integer.parseInt(textFieldForIncomes.getText().trim());
  //          AddIncomeChart(label,integer);
  //          GoBackToIcomePage(SubmitButton);
  //          System.out.println("all good");
  //       }
  //     });
  //     AddStage.setScene(AddScene);
  //     AddStage.show();
  //     AddStage.setTitle("Add window");

      
  //   }catch(Exception e){

  //   }
  // }
  // private Boolean CheckFieldsForAdd(TextField textFieldForIncomes,TextField textFieldForLabelOfIncomes){
  //  return !textFieldForLabelOfIncomes.getText().isEmpty()&&!textFieldForIncomes.getText().isEmpty();
  // }
//     @FXML
//     private TextField textFieldForIncomes;
//     @FXML
//     private TextField textFieldForLabels;
//     @FXML
//     private PieChart pieChart;
//     @FXML
//     private Button addButton;

//     private static final ObservableList<PieChart.Data> listOfDataMoney = FXCollections.observableArrayList();

//     @FXML
//     public void initialize() {
//         pieChart.setData(listOfDataMoney); // bind chart to shared data
//     }

//     @FXML
//     private void addIncome(ActionEvent e) {
//         String label = textFieldForLabels.getText();
//         String amount = textFieldForIncomes.getText();

//         if (!label.isEmpty() && !amount.isEmpty()) {
//             try {
//                 int value = Integer.parseInt(amount);
//                 listOfDataMoney.add(new PieChart.Data(label, value));
//                 textFieldForLabels.clear();
//                 textFieldForIncomes.clear();
//             } catch (NumberFormatException ex) {
//                 System.out.println("Invalid number");
//             }
//         } else {
//             System.out.println("Please fill all fields");
//         }
//     }
    @FXML
    private Boolean CheckFieldsForAdd(TextField labelField,TextField amountField){
      if(labelField.getText().isEmpty()&&amountField.getText().isEmpty()){
        return false;
      }else{
        return true;
      }
    } 
    @FXML
    private void PieChartInitialize(Stage stage){
      PieChart chartForScene = new PieChart(listForPieChart);
            if(!listForPieChart.isEmpty()){
      Button ExitButton = new Button("EXIT");
      chartForScene.setTitle("Spendings Tracker");

      VBox window = new VBox(chartForScene,ExitButton);
      stage.setScene(new Scene(window,600,400));
      stage.show();
            }else{
              System.out.println("error again");
            }
    }
    @FXML
    private void AddInfoCategory(){
      TextField label = new TextField("Enter name of Category");
      TextField amount = new TextField("Enter value (etc 500$)");
      Button EnterButton = new Button("ENTER");
      Button ExitButton2 = new Button("EXIT");
      ExitButton2.setOnAction(e ->{
        GoBackToIcomePage(ExitButton2);
      });
      VBox windowForAdd = new VBox(label,amount,EnterButton,ExitButton2);
      Stage AddInfoCategoryStage = new Stage();
      AddInfoCategoryStage.setScene(new Scene(windowForAdd,600,400));
      AddInfoCategoryStage.show();
      if(!label.getText().isEmpty()){
        String parsedLabel = label.getText();
        int parsedAmount = Integer.parseInt(amount.getText());
        AddNewCatg(parsedLabel, parsedAmount);
        EnterButton.setOnAction(e ->{
          GoBackToIcomePage(EnterButton);
        });
      }else{
        System.out.println("Something went wrong");
      }
    }
    private void AddNewCatg(String name,int amount){
      DataOfPieChart.put(name, DataOfPieChart.getOrDefault(name, 0)+ amount);
      listForPieChart.clear();
      DataOfPieChart.forEach((key, value)->{
        listForPieChart.add(new PieChart.Data(name,value));
      });

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
