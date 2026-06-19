
package javaapplication11;

import java.sql.SQLException;


public class StudentsService {
    
    StudentsDAO dao = new StudentsDAO();
    
    public void addStudents(StudentsModal sm) throws SQLException, ClassNotFoundException{
        
        if(!sm.getEmail().contains("@")){
            System.out.println("Invalid gmail");
            return;
        }
        
        if(sm.getFee()<0){
            System.out.println("Fee can't be negative");
            return;
        }
        dao.insert(sm);
    }
    
    public void viewStudentDetails() throws ClassNotFoundException, SQLException{
        dao.viewAll();
    }
    
    public void updateStudent(StudentsModal sm) throws SQLException, ClassNotFoundException{
        dao.update(sm);
    }
    
    public void deleteStudent(int id) throws SQLException, ClassNotFoundException{
        dao.delete(id);
    }
    
    public void searchStudent(String email) throws ClassNotFoundException, SQLException{
        dao.search(email);
    }
}
