
package javaapplication9;

import java.sql.*;
import java.util.Scanner;


public class Database {
    
    Scanner sc = new Scanner(System.in);
    
    public Connection connection() throws ClassNotFoundException, SQLException{
      Class.forName("org.postgresql.Driver");
      String url = "jdbc:postgresql://localhost:5432/Employee_data";
      String userName = "postgres";
      String pass = "Your_password";
      
      Connection con = DriverManager.getConnection(url,userName,pass);
      
      return con;
    } 
    
    public void insert() throws ClassNotFoundException, SQLException{
        
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        
        Connection con = connection();
        
        String query = "Insert into students1(id,name,age) values(?,?,?)";
        
        PreparedStatement ps = con.prepareStatement(query);
        
        ps.setInt(1,id);
        ps.setString(2,name);
        ps.setInt(3,age);
        
        int rows = ps.executeUpdate();
        
        System.out.println(rows+" Record Inserted");
        
    }
    
    public void display() throws ClassNotFoundException, SQLException{
        
       Connection connect = connection();
        
       String query = "Select * from Students1";
       
       PreparedStatement ps = connect.prepareStatement(query);
       
       ResultSet rs = ps.executeQuery();
       
        System.out.println("\nID\tName\t\tAge");
        
        while(rs.next()){
            System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t"+rs.getInt("age"));
        }
    }
    
    public void update() throws ClassNotFoundException, SQLException{
        
      Connection con = connection();
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Enter New Name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter New Age: ");
        int age = sc.nextInt();
        
      String query = "Update Students1 set name = ?,age=? where id = ?";
      
      PreparedStatement ps = con.prepareStatement(query);
      
      ps.setString(1,name);
      ps.setInt(2, age);
      ps.setInt(3,id);
      
      int rows = ps.executeUpdate();
      
        if(rows>0){
            System.out.println("Record Updated");
        }
        else{
            System.out.println("Id not found");
        }
    }
    
    public void delete() throws ClassNotFoundException, SQLException{
      
        Connection con = connection();
        
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        
        String query = "Delete from Students1 where id = ?";
        
        PreparedStatement ps = con.prepareStatement(query);
        
        ps.setInt(1, id);
        
        int rows = ps.executeUpdate();
        
        System.out.println(rows+" records deleted");
    }
          
    
    
}
