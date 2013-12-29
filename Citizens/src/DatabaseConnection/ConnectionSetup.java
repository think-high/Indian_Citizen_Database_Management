/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shawn
 */
public class ConnectionSetup {
    
    
   public static Connection getConnection()
   {
      Connection cn=null;
      try
      { 
         Class.forName("com.mysql.jdbc.Driver");
         String connectionParameters ="jdbc:mysql://localhost:3306/Citizens?user=root&password=root";
         cn=DriverManager.getConnection(connectionParameters);
      }
      catch(ClassNotFoundException exp)
      {        
      } 
      catch (SQLException ex) {
           Logger.getLogger(ConnectionSetup.class.getName()).log(Level.SEVERE, null, ex);
       }
      return cn;
   }
   
   public static Statement getStatement(Connection cn)
   {
       Statement st=null;
       try {
           st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
       } catch (SQLException ex) {
           Logger.getLogger(ConnectionSetup.class.getName()).log(Level.SEVERE, null, ex);
       }
       catch(NullPointerException exp)
       {
     //      System.out.println("tes");
              Logger.getLogger(ConnectionSetup.class.getName()).log(Level.SEVERE, null, exp);
       }
       return st;
   }
    
    
}
