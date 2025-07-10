package finance.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataBaseController {
    String name = "root";
            String password = "1234567";
            //Name pf your database or host where you runing this project
            String url = "jdbc:mysql://localhost:3306/name_OF_DataBase";
//not sure if use here boid or just return connection as varieble 
    public void getConnection(){
        try{
            // String name = "root";
            // String password = "1234567";
            // //Name pf your database or host where you runing this project
            // String url = "jdbc:mysql://localhost:3306/name_OF_DataBase";
            Connection mainConnection = DriverManager.getConnection(url,name,password);
            System.out.println("connection has been creatd");
        }catch(Exception e ){
            e.printStackTrace();
        }

    }
    public void Add(){
       try{
        Connection AddConnection = getTestConnection(name,password,url);
           if(AddConnection != null){
             String SQL_ADD_COMMAND = "inser into you_dataBase() values (?,?)";
             PreparedStatement ADD_STATMENT = AddConnection.prepareStatement(SQL_ADD_COMMAND);
             int rowsAffected = ADD_STATMENT.executeUpdate();
             if(rowsAffected > 0){
               System.out.println("Rowws affected : " + rowsAffected);
             }
           }else{
            System.out.println("Something went wrong in add method");
           }

       }catch(Exception e){
        e.printStackTrace();
       }
    }
    private Connection getTestConnection(String password,String url,String name){
        Connection testMainConnection = null;
        try{
          testMainConnection = DriverManager.getConnection(url,name,password);
          System.out.println("connection established sucesfully");
        //   return Connection;
        }catch(Exception e){
            e.printStackTrace();
        }
       
       return testMainConnection;
    }
    
}