
package javaapplication13;

import java.sql.SQLException;
import java.util.ArrayList;


public class StudentService {
    
    StudentDAO dao = new StudentDAO();
    
    public void insertStudent(StudentModal s) throws SQLException, ClassNotFoundException{
        
        
        if(!s.getMail().contains("@")){
            System.out.println("Invalid mail id");
            return;
        }
        
        if(s.getFee()<0){
            System.out.println("Fee can't be negative");
            return;
        }
        dao.insert(s);
    }
    
    public ArrayList<StudentModal> viewAll() throws SQLException, ClassNotFoundException{
        
     return dao.retrieve();
    }
    
    public void updateStudent(StudentModal s) throws SQLException, ClassNotFoundException{
        dao.update(s);
    }
    
    public void deleteStudent(int id) throws SQLException, ClassNotFoundException{
        dao.delete(id);
    }
            
    public void searchStudent(String mail) throws SQLException, ClassNotFoundException{
        dao.search(mail);
    }
            
}
