
package javaapplication11;


import java.sql.*;
import java.util.ArrayList;


public class StudentsDAO {
    
    public Connection connection() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/school","postgres","Your Password");
    }
    
    public void insert(StudentsModal sm) throws SQLException, ClassNotFoundException{
        
        Connection con = connection();
        String query = "Insert into student(name,email,course,fee) values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        
        ps.setString(1,sm.getName());
        ps.setString(2,sm.getEmail());
        ps.setString(3,sm.getCname());
        ps.setDouble(4,sm.getFee());
        
        int rows = ps.executeUpdate();
        
        if(rows>0){
            System.out.println(rows+" record inserted");
        }
        else{
            System.out.println("Insertion failed");
        }
        
        con.close();
        
    }
    
    public ArrayList<StudentsModal> viewAll() throws ClassNotFoundException, SQLException{
        
        ArrayList<StudentsModal> list = new ArrayList<>();
        
        Connection con = connection();
        String query = "Select * from student";
        PreparedStatement ps = con.prepareStatement(query);
        
        ResultSet rs = ps.executeQuery();
        
      
        while(rs.next()){
            StudentsModal sm = new StudentsModal();
            
            sm.setId(rs.getInt("id"));
            sm.setName(rs.getString("name"));
            sm.setEmail(rs.getString("email"));
            sm.setCname(rs.getString("course"));
            sm.setFee(rs.getDouble("fee"));
            
            list.add(sm);
        }
        
        con.close();
        
        return list;
        
    }
    
    public void update(StudentsModal sm) throws SQLException, ClassNotFoundException{
        Connection con = connection();
        String query = "Update student set name=?,email=?,course=?,fee=? where id=?";
        PreparedStatement ps = con.prepareStatement(query);
        
        ps.setString(1,sm.getName());
        ps.setString(2,sm.getEmail());
        ps.setString(3,sm.getCname());
        ps.setDouble(4,sm.getFee());
        ps.setInt(5,sm.getId());
        
        int rows = ps.executeUpdate();
        
        if(rows>0){
            System.out.println(rows +" record updated");
        }
        else{
            System.out.println("Id not found!");
        }
    }
    
    public void delete(int id) throws SQLException, ClassNotFoundException{
        
        Connection con = connection();
        String query = "Delete from student where id = ?";
        
        PreparedStatement ps = con.prepareStatement(query);
        
        ps.setInt(1,id);
        
        ps.executeUpdate();
    }
    
    public void search(String email) throws ClassNotFoundException, SQLException{
        Connection con = connection();
        String query = "Select * from student where email = ?";
        
        PreparedStatement ps = con.prepareStatement(query);
        
        ps.setString(1,email);
        
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
            System.out.println("\nID: "+rs.getInt("id"));
            System.out.println("Name: "+rs.getString("name"));
            System.out.println("email: "+rs.getString("email"));
            System.out.println("course: "+rs.getString("course"));
            System.out.println("fees: "+rs.getDouble("fee"));
            
        }
        
        else{
            System.out.println("Students not found!");
        }
        con.close();
    }
}
