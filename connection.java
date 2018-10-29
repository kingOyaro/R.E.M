/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package real.estate.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KID_UNTAMED
 */
public class connection {
    private Connection connection;
    public Connection connect(){
       try {
           Class.forName("com.mysql.jdbc.Driver");
           System.out.println("Connection Success");
       }
       catch(ClassNotFoundException cnfe){
            System.out.println("Connection failed"+cnfe);
       }
       String url ="jdbc:mysql://localhost:3306/login?zeroDateTimeBehavior=convertToNull";
       try{
           connection = (Connection) DriverManager.getConnection(url,"root","");
           System.out.println("Database Connected");
       }
       catch(SQLException se){
         System.out.println("No Database Connected");
       }
       return connection;
       
    }
   public DefaultTableModel getData() throws SQLException{
       DefaultTableModel tblm = new DefaultTableModel();
       tblm.addColumn("FIRST NAME");
       tblm.addColumn("LAST NAME");
       tblm.addColumn("TELEPHONE");
       tblm.addColumn("DATE OF BIRTH");
       tblm.addColumn("GENDER");
       tblm.addColumn("AGE");
       
       String datab = "SELECT * FROM members";
       
       try{
           Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/login_form","root","");
           Statement state = connect.prepareStatement(datab);
           ResultSet rs = state.executeQuery(datab);
           while (rs.next()){
              String fname = rs.getString(1);
              String lname = rs.getString(2);
              String telephone = rs.getString(3);
              String dob = rs.getString(4);
              String gender = rs.getString(5);
              String age = rs.getString(6);
              
              tblm.addRow(new String[]{fname,lname,telephone,dob,gender,age});
           }
           return tblm;
       }catch (SQLException e){
   }
       return null;
}
   public ResultSet pieData() throws SQLException{
       ResultSet rs = null;
       String datab = "SELECT age,Gender FROM members";
       try{           
       Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/login_form","root","");
       Statement state = connect.prepareStatement(datab);
       rs = state.executeQuery(datab);
   }catch(SQLException e){
}
        return rs;
   
   }
}

