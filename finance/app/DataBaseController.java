package finance.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataBaseController {
            String name = "root";
            String password = "1234567";
            //Name of your database or host where you runing this project
            String url = "jdbc:mysql://localhost:3306/name_OF_DataBase";
            
    public void Add(String USERNAME,String PASSWORD){
       try{
        Connection AddConnection = getTestConnection(name,password,url);
           if(AddConnection != null){
             String SQL_ADD_COMMAND = "inser into 'table_name' (name,password) values (?,?)";
             PreparedStatement ADD_STATMENT = AddConnection.prepareStatement(SQL_ADD_COMMAND);
             ADD_STATMENT.setString(1, USERNAME);
             ADD_STATMENT.setString(2, PASSWORD);
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
        }catch(Exception e){
            e.printStackTrace();
        }
       
       return testMainConnection;
    }
    
}