/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class dbconnection {
    public static Connection getConnectTomovieticket() throws SQLException, ClassNotFoundException
   {
       Class.forName("com.mysql.jdbc.Driver");
       Connection con=null;
       String url="jdbc:mysql://localhost:3306/";
       String dbName="movieticket";
       String userName="root";
       String password="root123";
       con=DriverManager.getConnection(url+dbName,userName, password);
       return con; 
}
}
