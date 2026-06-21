
package javaapplication13;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {
    
    public Connection dbConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
         return DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","Your_password");
    }
    
    public void insert(StudentModal e) throws SQLException, ClassNotFoundException{
        
        Connection con = dbConnection();
        PreparedStatement ps = con.prepareStatement("Insert into student(name,email,course,fee) values(?,?,?,?)");
        ps.setString(1,e.getName());
        ps.setString(2,e.getMail());
        ps.setString(3,e.getCourse());
        ps.setDouble(4,e.getFee());
        
        int rows = ps.executeUpdate();
        
        if(rows>0){
            System.out.println(rows+" Records inserted");
        }
        else{
            System.out.println("Insertion failed!");
        }
    }
    
    public ArrayList<StudentModal> retrieve() throws SQLException, ClassNotFoundException{
        
        ArrayList<StudentModal> list = new ArrayList<>();
        Connection con = dbConnection();
        PreparedStatement ps = con.prepareStatement("Select * from student");
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            StudentModal e = new StudentModal();
            
            e.setId(rs.getInt(1));
            e.setName(rs.getString(2));
            e.setMail(rs.getString(3));
            e.setCourse(rs.getString(4));
            e.setFee(rs.getDouble(5));
            
            list.add(e);
        }
        
        return list;
    }
    
    public void update(StudentModal s) throws SQLException, ClassNotFoundException{
        
        Connection con = dbConnection();
        PreparedStatement ps = con.prepareStatement("Update student set name=?,email=?,course=?,fee=? where id=?");
        ps.setString(1,s.getName());
        ps.setString(2,s.getMail());
        ps.setString(3,s.getCourse());
        ps.setDouble(4,s.getFee());
        ps.setInt(5,s.getId());
        
        int rows = ps.executeUpdate();
        
        if(rows>0){
            System.out.println(rows+" Records Updated");
        }
        else{
            System.out.println("ID not found!");
        }
    }
    
    public void delete(int id) throws SQLException, ClassNotFoundException{
        
        Connection con = dbConnection();
        PreparedStatement ps = con.prepareStatement("Delete from student where id = ?");
        ps.setInt(1,id);
        
        int rows = ps.executeUpdate();
        
        if(rows>0){
            System.out.println("Delete Successfully");
        }
        else{
            System.out.println("ID not found!");
        }
    }
    
    public void search(String mail) throws SQLException, ClassNotFoundException{
        
        
        Connection con = dbConnection();
        
        PreparedStatement ps = con.prepareStatement("select * from student where email=?");
        
        ps.setString(1,mail);
        ResultSet rs = ps.executeQuery();
        
        System.out.println("\nID\tName\t"+"\tEmail\t"+"\tCourse"+"\tFee");
        if(rs.next()){
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+"\t"+
                    rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getDouble(5));
        }
        
    }
            
}
