package finance.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataBaseController {
            String name = "root";
            String password = "1234567";
            //Name of your database or host where you runing this project
            String url = "jdbc:mysql://localhost:3306/finance_log_in_storeg";
            
    public void Add(String USERNAME,String PASSWORD){
       try{
        Connection AddConnection = getTestConnection();
           if(AddConnection != null){
             String SQL_ADD_COMMAND = "insert into users (Username,password) values (?,?)";
             PreparedStatement ADD_STATMENT = AddConnection.prepareStatement(SQL_ADD_COMMAND);
             ADD_STATMENT.setString(1, USERNAME);
             ADD_STATMENT.setString(2, PASSWORD);
             int rowsAffected = ADD_STATMENT.executeUpdate();
             if(rowsAffected > 0){
               System.out.println("Rowws affected : " + rowsAffected);
               AddConnection.close();
             }
           }else{
            System.out.println("Something went wrong in add method");
           }

       }catch(Exception e){
        e.printStackTrace();
       }
    }
    private Connection getTestConnection(){
        Connection testMainConnection = null;
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
          testMainConnection = DriverManager.getConnection(url,name,password);
          System.out.println("connection established sucesfully");
        }catch(Exception e){
            e.printStackTrace();
        }
       
       return testMainConnection;
    }
    private void SearchUserInDataBase(String name,String password){
      try{
      Connection searchTestConnection = (getTestConnection());
      String SQL_COMMAND_SEARCH = "select * from users where username = ? and password = ?" ;
      PreparedStatement serachStatement = searchTestConnection.prepareStatement(SQL_COMMAND_SEARCH);
      serachStatement.setString(1,name);
      serachStatement.setString(2, password);
      }catch(Exception e){
        e.printStackTrace();
      }
    }

    
}