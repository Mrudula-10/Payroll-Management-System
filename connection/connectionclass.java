package connection;
import java.sql.*;
public class connectionclass {
   Connection con;
   Statement stm;
    connectionclass()
   {
       try
       {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library625?" + "autoReconnect=true&useSSL=false","root","Mrudula@123");
           stm=con.createStatement();
           if(con.isClosed()){
               System.out.println("connection closed");
           }
           else{
               System.out.println("open");
           }
       }
       catch(Exception e){
           e.printStackTrace();
       }
   }
   public static void main(String[]args){
    new connectionclass();   
}
}
